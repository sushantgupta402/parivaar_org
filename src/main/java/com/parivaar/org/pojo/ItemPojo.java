/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named
@Dependent
public class ItemPojo implements Serializable {
    
        private Long id;
        //private SupplierPojo supplier;
	private String itemName;
        private String itemCode;
	private String descriptionOne;
        private String descriptionTwo;
        private String descriptionThree;
        private Double currentInventoryQuantity;
         private Double currentInventoryUnit;
        private int status;
        private Date activeFromDate;
        private Date activeTillDate;
        private String quantityMeasuredIn;
       

    public ItemPojo() {
    }

    public ItemPojo(String itemName, String itemCode, String descriptionOne, String descriptionTwo, String descriptionThree, Double currentInventoryQuantity, Double currentInventoryUnit, int status) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.descriptionOne = descriptionOne;
        this.descriptionTwo = descriptionTwo;
        this.descriptionThree = descriptionThree;
        this.currentInventoryQuantity = currentInventoryQuantity;
        this.currentInventoryUnit = currentInventoryUnit;
        this.status = status;
    }

    @Override
    public String toString() {
        return itemName+ " " + itemCode ;
    }



    

   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPojo other = (ItemPojo) obj;
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemCode, other.itemCode)) {
            return false;
        }
        if (!Objects.equals(this.descriptionOne, other.descriptionOne)) {
            return false;
        }
        if (!Objects.equals(this.descriptionTwo, other.descriptionTwo)) {
            return false;
        }
        if (!Objects.equals(this.descriptionThree, other.descriptionThree)) {
            return false;
        }
        if (!Objects.equals(this.currentInventoryQuantity, other.currentInventoryQuantity)) {
            return false;
        }
        if (!Objects.equals(this.currentInventoryUnit, other.currentInventoryUnit)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.activeFromDate, other.activeFromDate)) {
            return false;
        }
        return Objects.equals(this.activeTillDate, other.activeTillDate);
    }

   
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescriptionOne() {
        return descriptionOne;
    }

    public void setDescriptionOne(String descriptionOne) {
        this.descriptionOne = descriptionOne;
    }

    public String getDescriptionTwo() {
        return descriptionTwo;
    }

    public void setDescriptionTwo(String descriptionTwo) {
        this.descriptionTwo = descriptionTwo;
    }

    public String getDescriptionThree() {
        return descriptionThree;
    }

    public void setDescriptionThree(String descriptionThree) {
        this.descriptionThree = descriptionThree;
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

    public Date getActiveFromDate() {
        return activeFromDate;
    }

    public void setActiveFromDate(Date activeFromDate) {
        this.activeFromDate = activeFromDate;
    }

    public Date getActiveTillDate() {
        return activeTillDate;
    }

    public void setActiveTillDate(Date activeTillDate) {
        this.activeTillDate = activeTillDate;
    }

    public String getQuantityMeasuredIn() {
        return quantityMeasuredIn;
    }

    public void setQuantityMeasuredIn(String quantityMeasuredIn) {
        this.quantityMeasuredIn = quantityMeasuredIn;
    }

   
        
    
}
