/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.parivaar.org.controller;

import com.parivaar.org.dao.ItemDao;
import com.parivaar.org.dao.StateDao;
import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.dao.TransactionDao;
import com.parivaar.org.hb.entity.Item;
import com.parivaar.org.hb.entity.States;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.hb.entity.TransactionTypes;
import com.parivaar.org.hb.entity.Transactions;
import com.parivaar.org.pojo.ItemPojo;
import com.parivaar.org.pojo.StatesPojo;
import com.parivaar.org.pojo.SupplierPojo;

import com.parivaar.org.pojo.TransactionPojo;
import com.parivaar.org.pojo.TransactionTypesPojo;
import com.parivaar.org.util.TransactionUtil;
import com.parivaar.org.util.ULIDGenerator;
import java.io.IOException;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Ravinder Singh
 */
@Named(value = "transactionController")
@SessionScoped
public class TransactionController implements Serializable {

    /**
     * Creates a new instance of TransactionController
     */
    public TransactionController() {
    }

    private List<TransactionPojo> allTransactions;

    private TransactionPojo selectedTransaction;

    private List<TransactionPojo> selectedTransactions;

    private long item;

    private List<ItemPojo> items;

    private long transactionType;

    private List<TransactionTypesPojo> transactionTypes;

    private Long state;

    private List<StatesPojo> states;

    private Double quantity;

    private String errorMessage;

    private Boolean usageFieldAvailable = false;

    private Long selectedSupplier;

    private List<SupplierPojo> suppliers;

    public TransactionPojo getSelectedTransaction() {
        return selectedTransaction;
    }

    public void setSelectedTransaction(TransactionPojo selectedTransaction) {
        this.selectedTransaction = selectedTransaction;
    }

    public List<TransactionPojo> getSelectedTransactions() {
        return selectedTransactions;
    }

    public void setSelectedTransactions(List<TransactionPojo> selectedTransactions) {
        this.selectedTransactions = selectedTransactions;
    }

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    public List<ItemPojo> getItems() {
        return items;
    }

    public void setItems(List<ItemPojo> items) {
        this.items = items;
    }

    public long getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(long transactionType) {
        this.transactionType = transactionType;
    }

    public List<TransactionTypesPojo> getTransactionTypes() {
        return transactionTypes;
    }

    public void setTransactionTypes(List<TransactionTypesPojo> transactionTypes) {
        this.transactionTypes = transactionTypes;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public List<StatesPojo> getStates() {
        return states;
    }

    public void setStates(List<StatesPojo> states) {
        this.states = states;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getUsageFieldAvailable() {
        return usageFieldAvailable;
    }

    public void setUsageFieldAvailable(Boolean usageFieldAvailable) {
        this.usageFieldAvailable = usageFieldAvailable;
    }

    public Long getSelectedSupplier() {
        return selectedSupplier;
    }

    public void setSelectedSupplier(Long selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

    public List<SupplierPojo> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierPojo> suppliers) {
        this.suppliers = suppliers;
    }

    public void openNew() {

        selectedTransaction = new TransactionPojo();
        this.item = 0;
        String transactionId = generateTransactionId();
        selectedTransaction.setTransactionId(transactionId);
        selectedTransaction.setItemQuantity(0.0);
        quantity = 0.0;
        if (items == null || items.isEmpty()) {
            items = itemDao.listItems();
        }
        if (transactionTypes == null || transactionTypes.isEmpty()) {
            transactionTypes = transactionDao.getTransactionTypes();
        }

        if (states == null || states.isEmpty()) {
            states = transactionDao.getStates();
        }

        if (suppliers == null || suppliers.isEmpty()) {
            suppliers = supplierDao.listSuppliers();
        }

        PrimeFaces.current().ajax().update("dialogs:manage-product-content");
        PrimeFaces.current().executeScript("PF('manageProductDialog').show()");

    }

    public void onItemSelection() {
        TransactionPojo latestTransaction = transactionDao.fetchLatestTransactionByItem(item);
        Item itm = itemDao.getItemById(item);
        if (itm != null) {
            selectedTransaction.setItem(itm);
            selectedTransaction.setItemName(itm.getName());
        }
        if (latestTransaction == null) {
            selectedTransaction.setOpeningBalance(0.0);
            selectedTransaction.setClosingBalance(0.0);
        } else {
            selectedTransaction.setOpeningBalance(latestTransaction.getClosingBalance());
            selectedTransaction.setClosingBalance(latestTransaction.getClosingBalance());
        }
    }

    public void handleQuantityEvent() {

        TransactionTypes txn = transactionDao.getTransactionTypeById(transactionType);
        TransactionTypesPojo txnPojo = null;
        if (txn != null) {
            txnPojo = TransactionUtil.entityToPojo(txn);
        }

        if (selectedTransaction.getItemQuantity() != null) {
            switch (txnPojo.getCode()) {
                case "AOS" ->
                    selectedTransaction.setClosingBalance(selectedTransaction.getOpeningBalance() + selectedTransaction.getItemQuantity());
                case "CON" ->
                    selectedTransaction.setClosingBalance(selectedTransaction.getOpeningBalance() - selectedTransaction.getItemQuantity());

                case "PUR" ->
                    selectedTransaction.setClosingBalance(selectedTransaction.getOpeningBalance() + selectedTransaction.getItemQuantity());

                case "WLD" ->
                    selectedTransaction.setClosingBalance(selectedTransaction.getOpeningBalance() - selectedTransaction.getItemQuantity());
                case "REC" ->
                    selectedTransaction.setClosingBalance(selectedTransaction.getOpeningBalance() + selectedTransaction.getItemQuantity());
                case "RET" ->
                    selectedTransaction.setClosingBalance(selectedTransaction.getOpeningBalance() - selectedTransaction.getItemQuantity());
                default ->
                    selectedTransaction.setClosingBalance(selectedTransaction.getOpeningBalance());

            }

        }

    }

    public void handlePerUnitCostEvent() {

        if (selectedTransaction.getPerUnitCost() != null && selectedTransaction.getItemQuantity() != null) {

            selectedTransaction.setTotalCost(selectedTransaction.getPerUnitCost() * selectedTransaction.getItemQuantity());

        } else {
            selectedTransaction.setTotalCost(0.0);
        }

    }

    public void onTransactionSelection() {
        TransactionTypes txn = transactionDao.getTransactionTypeById(transactionType);
        TransactionTypesPojo txnPojo = null;
        if (txn != null) {
            txnPojo = TransactionUtil.entityToPojo(txn);
            this.selectedTransaction.setTransactionType(txn);
        }
        switch (txnPojo.getCode()) {
            case "AOS":
                this.usageFieldAvailable = false;
                break;
            case "CON":
                this.usageFieldAvailable = true;
                break;
            case "PUR":
                this.usageFieldAvailable = false;
                break;
            case "WLD":
                this.usageFieldAvailable = true;
                break;
            case "REC":
                this.usageFieldAvailable = false;
                break;
            case "RET":
                this.usageFieldAvailable = true;
                break;
            default:
                this.usageFieldAvailable = false;

        }
    }

    public void handleDayNightUsageEvent() {
        if (selectedTransaction != null && selectedTransaction.getDayUsage() != null && selectedTransaction.getNightUsage() != null && selectedTransaction.getItemQuantity() != null) {
            if (selectedTransaction.getItemQuantity() != (selectedTransaction.getDayUsage() + selectedTransaction.getNightUsage())) {
                this.errorMessage = "The Sum of DayUsage and NightUsage should match the Item Quantity";

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(this.errorMessage));
                PrimeFaces.current().ajax().update("dialogs:messagesDialog");
            }
        }
    }

    public void saveTransaction() {
        if (this.selectedSupplier != null) {
            Supplier supp = supplierDao.getSupplierById(this.selectedSupplier);
            if (supp != null) {
                this.selectedTransaction.setSupplier(supp);
            }
        }
        if (this.state != null) {
            States state = stateDao.getStateById(this.state);
            if (state != null) {
                this.selectedTransaction.setBranch(state);
            }
        }
        if (this.selectedTransaction.getId() == null) {
            transactionDao.saveTransaction(selectedTransaction);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transaction Added"));
        } else {
            transactionDao.saveTransaction(selectedTransaction);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transaction Updated"));
        }
        lstTransactions();
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteSupplier() {
        transactionDao.deleteTransaction(selectedTransaction);
        lstTransactions();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transaction Removed"));
        // PrimeFaces.current().executeScript("PF('deleteProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public List<TransactionPojo> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<TransactionPojo> allTransactions) {
        this.allTransactions = allTransactions;
    }

    @PostConstruct
    public void constructData() {
        lstTransactions();
        selectedTransaction = new TransactionPojo();
    }

    @Inject
    private TransactionDao transactionDao;

    @Inject
    private ItemDao itemDao;

    @Inject
    private SupplierDao supplierDao;

    @Inject
    private StateDao stateDao;

    public void lstTransactions() {
        allTransactions = transactionDao.listTransactions();

    }

    public void transactionHomeDestination() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

                  ec.redirect(ec.getRequestContextPath()+"/faces/transaction/transactionList.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedTransactions()) {
            int size = this.selectedTransactions.size();
            return size > 1 ? size + " transactions selected" : "1 transaction selected";
        }

        return "Delete";
    }

    public boolean hasSelectedTransactions() {
        return this.selectedTransactions != null && !this.selectedTransactions.isEmpty();
    }

    public void deleteSelectedTransactions() {
        transactionDao.deleteTransactions(selectedTransactions);
        lstTransactions();
        this.selectedTransactions = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("transactions Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

    private String generateTransactionId() {
        String ulid = ULIDGenerator.getULID();
        return ulid;
    }

}
