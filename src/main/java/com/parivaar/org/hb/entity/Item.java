/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.hb.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 *
 * @author Ravinder
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},fetch = FetchType.EAGER)
//    @JoinColumn(name = "supplier_id")
//    private Supplier supplier;
    
     @Column(name = "item_name")
	private String name;
      @Column(name = "item_code")
	private String code;
     @Column(name = "description")
	private String description;
     @Column(name = "current_inventory_quantity")
        private Double currentInventoryQuantity;
     @Column(name = "current_inventory_unit")
        private Double currentInventoryUnit;
     @Column(name = "status")
        private int status;
     @Column(name = "last_status_date")
     private Date lastStatusDate;
     @Column(name = "item_initiated_by")
     private String itemInitiatedBy;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getCurrentInventoryQuantity() {
        return currentInventoryQuantity;
    }

    public void setCurrentInventoryQuantity(Double currentInventoryQuantity) {
        this.currentInventoryQuantity = currentInventoryQuantity;
    }

    public Double getCurrentInventoryUnit() {
        return currentInventoryUnit;
    }

    public void setCurrentInventoryUnit(Double currentInventoryUnit) {
        this.currentInventoryUnit = currentInventoryUnit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Date lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public String getItemInitiatedBy() {
        return itemInitiatedBy;
    }

    public void setItemInitiatedBy(String itemInitiatedBy) {
        this.itemInitiatedBy = itemInitiatedBy;
    }

   

   


//    public Item(Supplier supplier, String name, String description, Double cost, Byte status, Date createdOn, Date updatedOn, Double stock) {
//        this.supplier = supplier;
//        this.name = name;
//        this.description = description;
//        this.cost = cost;
//        this.status = status;
//        this.createdOn = createdOn;
//        this.updatedOn = updatedOn;
//        this.stock = stock;
//    }

    public Item() {
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parivaar.org.hb.entity.Item[ id=" + id + " ]";
    }

    public Item(String name, String description, Double currentInventoryQuantity, Double currentInventoryUnit, int status, String itemInitiatedBy) {
        this.name = name;
        this.description = description;
        this.currentInventoryQuantity = currentInventoryQuantity;
        this.currentInventoryUnit = currentInventoryUnit;
        this.status = status;
        this.itemInitiatedBy = itemInitiatedBy;
    }
    
    
    
}
