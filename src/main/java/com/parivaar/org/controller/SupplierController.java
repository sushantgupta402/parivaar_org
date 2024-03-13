/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.parivaar.org.controller;

import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.pojo.SupplierPojo;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
@Named(value = "supplierController")
@SessionScoped
public class SupplierController implements Serializable {

    /**
     * Creates a new instance of SupplierController
     */
    public SupplierController() {
    }
    
     private List<SupplierPojo> allSuppliers;
     
     private SupplierPojo selectedSupplier;
  
    private List<SupplierPojo> selectedSuppliers;

    public SupplierPojo getSelectedSupplier() {
        return selectedSupplier;
    }

    public void setSelectedSupplier(SupplierPojo selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

    public List<SupplierPojo> getSelectedSuppliers() {
        return selectedSuppliers;
    }

    public void setSelectedSuppliers(List<SupplierPojo> selectedSuppliers) {
        this.selectedSuppliers = selectedSuppliers;
    }
    
    public void openNew() {
        
        selectedSupplier = new SupplierPojo();
      
        PrimeFaces.current().ajax().update("dialogs:manage-product-content");
        PrimeFaces.current().executeScript("PF('manageProductDialog').show()");
        
    }
    
   
    
     public void saveSupplier() {
        if (this.selectedSupplier.getId()== null) {
            supplierDao.saveSupplier(selectedSupplier);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Supplier Added"));
        }
        else {
            supplierDao.saveSupplier(selectedSupplier);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Supplier Updated"));
        }
        lstSuppliers();
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
     
     public void deleteSupplier() {
        supplierDao.deleteSupplier(selectedSupplier);
        lstSuppliers();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Supplier Removed"));
       // PrimeFaces.current().executeScript("PF('deleteProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public List<SupplierPojo> getAllSuppliers() {
        return allSuppliers;
    }

    public void setAllSuppliers(List<SupplierPojo> allSuppliers) {
        this.allSuppliers = allSuppliers;
    }
    
     @PostConstruct
    public void constructData(){
        lstSuppliers();
        selectedSupplier = new SupplierPojo();
    }
    
   
    
    @Inject
    private SupplierDao supplierDao;
    
    public void lstSuppliers(){
        allSuppliers = supplierDao.listSuppliers();
        //return "studentsList";
    }
    
    public String supplierHomeDestination(){
        return "supplier/supplierHome";
    }
    
    public String getDeleteButtonMessage() {
        if (hasSelectedSuppliers()) {
            int size = this.selectedSuppliers.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }

    public boolean hasSelectedSuppliers() {
        return this.selectedSuppliers != null && !this.selectedSuppliers.isEmpty();
    }
    
     public void deleteSelectedSuppliers() {
        supplierDao.deleteSuppliers(selectedSuppliers);
        lstSuppliers();
        this.selectedSuppliers = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

    
    
    
}
