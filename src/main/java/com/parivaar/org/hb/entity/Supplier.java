/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.hb.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ravinder Singh
 */
@Entity(name = "Supplier")
@Table(name = "supplier")
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "suppliername")
    private String name;

    @Column(name = "suppliercode")
    private String supplierCode;

    @Column(name = "description1")
    private String descriptionOne;
    
    @Column(name = "description2")
    private String descriptionTwo;
    
    @Column(name = "description3")
    private String descriptionThree;
    
     @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressline2;
    
      @Column(name = "address_line3")
    private String addressline3;
      
       @Column(name = "primary_phone")
    private String primaryPhone;

    @Column(name = "alternate_phone")
    private String alternatePhone;
    
    @Column(name = "email")
    private String email;
    
     @Column(name = "contact_name1")
    private String contactName1;
     
       @Column(name = "contact1_phone")
    private String contact1Phone;
       
         @Column(name = "contact1_alternate_phone")
    private String contact1AlternatePhone;
         
          @Column(name = "contact_name2")
    private String contactName2;

   @Column(name = "contact2_phone")
    private String contact2Phone;
   
           @Column(name = "contact2_alternate_phone")
    private String contact2AlternatePhone;
           
            @Column(name = "gst_no")
    private String gstNo;
   

    @Column(name = "status")
    private int status;

    @Column(name = "active_from_date")
    private Date activeFromDate;
    
     @Column(name = "active_till_date")
    private Date activeTillDate;

    @Column(name = "added_on")
    private Date addedOn;
    
     @Column(name = "city")
    private String city;
     
      @Column(name = "state")
    private String state;
      
       @Column(name = "pincode")
    private String pinCode;
       
        @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "supplier")
     private List<Transactions> transactions =new ArrayList<>();

    public Supplier() {
    }



    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getAddressline3() {
        return addressline3;
    }

    public void setAddressline3(String addressline3) {
        this.addressline3 = addressline3;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName1() {
        return contactName1;
    }

    public void setContactName1(String contactName1) {
        this.contactName1 = contactName1;
    }

    public String getContact1Phone() {
        return contact1Phone;
    }

    public void setContact1Phone(String contact1Phone) {
        this.contact1Phone = contact1Phone;
    }

    public String getContact1AlternatePhone() {
        return contact1AlternatePhone;
    }

    public void setContact1AlternatePhone(String contact1AlternatePhone) {
        this.contact1AlternatePhone = contact1AlternatePhone;
    }

    public String getContactName2() {
        return contactName2;
    }

    public void setContactName2(String contactName2) {
        this.contactName2 = contactName2;
    }

    public String getContact2Phone() {
        return contact2Phone;
    }

    public void setContact2Phone(String contact2Phone) {
        this.contact2Phone = contact2Phone;
    }

    public String getContact2AlternatePhone() {
        return contact2AlternatePhone;
    }

    public void setContact2AlternatePhone(String contact2AlternatePhone) {
        this.contact2AlternatePhone = contact2AlternatePhone;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
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

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
    
    

  

}
