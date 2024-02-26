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
        private SupplierPojo supplier;
	private String name;
	private String description;
        private Double cost;
        private Byte status;
        private Date createdOn;
        private Date updatedOn;
        private Double stockInGrams;

    public ItemPojo() {
    }



    public ItemPojo(SupplierPojo supplier, String name, String description, Double cost, Byte status, Date createdOn, Date updatedOn, Double stockInGrams) {
        this.supplier = supplier;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.stockInGrams = stockInGrams;
    }

    @Override
    public String toString() {
        return "ItemPojo{" + "supplier=" + supplier + ", name=" + name + ", description=" + description + ", status=" + status + '}';
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.supplier, other.supplier)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.createdOn, other.createdOn)) {
            return false;
        }
        return Objects.equals(this.updatedOn, other.updatedOn);
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupplierPojo getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierPojo supplier) {
        this.supplier = supplier;
    }

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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Double getStockInGrams() {
        return stockInGrams;
    }

    public void setStockInGrams(Double stockInGrams) {
        this.stockInGrams = stockInGrams;
    }
        
        
    
}
