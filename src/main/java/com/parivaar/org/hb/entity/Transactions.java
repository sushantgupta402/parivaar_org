/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.hb.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@jakarta.persistence.Entity(name = "Transactions")
@jakarta.persistence.Table(name = "transactions")
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "itemname")
    private String itemName;

    @ManyToOne(cascade = CascadeType.MERGE)
       @JoinColumn(name = "transactionType")
    private TransactionTypes transactionType;
    
       @ManyToOne(cascade = CascadeType.MERGE)
       @JoinColumn(name = "branch")
    private States Branch;
    
    @Column(name = "date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;
    
     @Column(name = "time")
    private String timeStr;

    @Column(name = "openingbalance")
    private Double openingBalance;
    
      @Column(name = "closingbalance")
    private Double closingBalance;
      
       @Column(name = "details1")
    private String details1;

       @Column(name = "details2")
    private String details2;
       
    @Column(name = "details3")
    private String details3;
    
   @ManyToOne(cascade = CascadeType.MERGE)
       @JoinColumn(name = "supplier")
    private Supplier supplier;
    
     
      @Column(name = "perunitcost")
    private Double perUnitCost;
    
      
       @Column(name = "totalcost")
    private Double totalCost;
       
        @Column(name = "dayusage")
    private Double dayUsage;
    
      
       @Column(name = "nightusage")
    private Double nightUsage;
       
       
       @ManyToOne(cascade = CascadeType.MERGE)
       @JoinColumn(name = "itemid")
      private Item item;
       
         @Column(name = "itemquantity")
    private Double itemQuantity;
       
       
       
    
    
    
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

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
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
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.parivaar.org.hb.entity.Transaction[ id=" + id + " ]";
    }
    
}
