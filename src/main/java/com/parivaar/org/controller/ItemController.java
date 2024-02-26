/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.parivaar.org.controller;

import com.parivaar.org.dao.ItemDao;
import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.dao.impl.CountryService;
import com.parivaar.org.hb.entity.Item;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.Country;
import com.parivaar.org.pojo.ItemPojo;
import com.parivaar.org.pojo.SupplierPojo;
import com.parivaar.org.util.SupplierUtil;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Ravinder Singh
 */
@Named(value = "itemController")
@SessionScoped
public class ItemController implements Serializable {

    /**
     * Creates a new instance of SupplierController
     */
    public ItemController() {
    }
    
     private List<ItemPojo> allItems;
     
     private ItemPojo selectedItem;
     
    private List<ItemPojo> selectedItems;
    
    private List<SupplierPojo> suppliers;
    private SupplierPojo supplier;
    
    private Long supplierId;
    
     @Inject
    private ItemDao itemDao;
     
    @Inject
    private SupplierDao supplierDao;
      
    

    
    
    public void openNew() {
        
        selectedItem = new ItemPojo();
        suppliers=getAllSuppliers();
        supplier=new SupplierPojo();
        //supplierId=null;
        PrimeFaces.current().ajax().update("dialogs:manage-product-content");
        PrimeFaces.current().executeScript("PF('manageProductDialog').show()");
        
    }
    
   
    
     public void saveItem() {
         if(this.selectedItem != null){
          Supplier supp = supplierDao.getSupplierById(this.supplierId);
          SupplierPojo supPojo = SupplierUtil.entityToPojo(supp);
          selectedItem.setSupplier(supPojo);
         }
        
        if (this.selectedItem.getId()== null) {
            
            itemDao.saveItem(selectedItem);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Added"));
        }
        else {
            itemDao.saveItem(selectedItem);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Updated"));
        }
        lstItems();
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
     
     public void deleteItem() {
        itemDao.deleteItem(selectedItem);
        lstItems();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
       // PrimeFaces.current().executeScript("PF('deleteProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

   
    
     @PostConstruct
    public void constructData(){
        lstItems();
        selectedItem = new ItemPojo();
         
    }
    
   
    
   
    
    public void lstItems(){
        allItems = itemDao.listItems();
        
    }
    
    public String itemHomeDestination(){
        return "item/itemHome";
    }
    
     public String itemHistoryDestination(){
        return "item/itemHistory";
    }
    
    public String getDeleteButtonMessage() {
        if (hasSelectedItems()) {
            int size = this.selectedItems.size();
            return size > 1 ? size + " item selected" : "1 item selected";
        }

        return "Delete";
    }

    public boolean hasSelectedItems() {
        return this.selectedItems != null && !this.selectedItems.isEmpty();
    }
    
     public void deleteSelectedItems() {
        itemDao.deleteItems(selectedItems);
        lstItems();
        this.selectedItems = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Items Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }
     
   public List<SupplierPojo> getAllSuppliers(){
       return supplierDao.listSuppliers();
   }

    public List<ItemPojo> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<ItemPojo> allItems) {
        this.allItems = allItems;
    }

    public ItemPojo getSelectedItem() {

        return this.selectedItem;
    }

    public void setSelectedItem(ItemPojo selectedItem) {
        //uncomment below code
//                if(selectedItem!=null && selectedItem.getId()!=null){
//            Item item = itemDao.getItemById(selectedItem.getId());
//            Supplier supp=item.getSupplier();
//            this.supplierId=supp.getId();
//            
//        }
//        this.selectedItem = selectedItem;
    }

    public List<ItemPojo> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<ItemPojo> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<SupplierPojo> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierPojo> suppliers) {
        this.suppliers = suppliers;
    }

    public SupplierPojo getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierPojo supplier) {
        this.supplier = supplier;
    }

   

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

   
     
     

    
    
    
}
