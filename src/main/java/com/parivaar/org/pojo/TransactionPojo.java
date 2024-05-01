/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.pojo;

import com.parivaar.org.hb.entity.Item;
import com.parivaar.org.hb.entity.States;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.hb.entity.TransactionTypes;
import jakarta.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named
@SessionScoped
public class TransactionPojo implements Serializable {
    
     private Long id;
    
    
    private String transactionId;

    
    private String itemName;

   
    private TransactionTypes transactionType;
    
   
    private States Branch;
    
   
    private Date transactionDate;
    
     
    private String time;

  
    private Double openingBalance;
    
    
    private Double closingBalance;
      
      
    private String details1;

       
    private String details2;
       
   
    private String details3;
    
    
    private Supplier supplier;
    
     
     
    private Double perUnitCost;
    
      
      
    private Double totalCost;
       
      
    private Item item;
    
    private String formattedDate;
    
    private Double itemQuantity;
    
      
      
    private Double dayUsage;
    
      
     
    private Double nightUsage;
    
    private String transactionBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypes transactionType) {
        this.transactionType = transactionType;
    }

    public States getBranch() {
        return Branch;
    }

    public void setBranch(States Branch) {
        this.Branch = Branch;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Double closingBalance) {
        this.closingBalance = closingBalance;
    }
    

    public String getDetails1() {
        return details1;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    public String getDetails3() {
        return details3;
    }

    public void setDetails3(String details3) {
        this.details3 = details3;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Double getPerUnitCost() {
        return perUnitCost;
    }

    public void setPerUnitCost(Double perUnitCost) {
        this.perUnitCost = perUnitCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public Double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getDayUsage() {
        return dayUsage;
    }

    public void setDayUsage(Double dayUsage) {
        this.dayUsage = dayUsage;
    }

    public Double getNightUsage() {
        return nightUsage;
    }

    public void setNightUsage(Double nightUsage) {
        this.nightUsage = nightUsage;
    }

    public String getTransactionBy() {
        return transactionBy;
    }

    public void setTransactionBy(String transactionBy) {
        this.transactionBy = transactionBy;
    }
    
    
    
    
    
}
