/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Ravinder Singh
 */
@Named
@SessionScoped
public class SupplierPojo implements Serializable {

   
    private Long id;


    private String name;

    
    private String supplierCode;

   
    private String descriptionOne;
    
  
    private String descriptionTwo;
    
  
    private String descriptionThree;
    
   
    private String addressLine1;


    private String addressline2;
    

    private String addressline3;
      

    private String primaryPhone;

   
    private String alternatePhone;
    
  
    private String email;
    
 
    private String contactName1;
     
    
    private String contact1Phone;
       
     
    private String contact1AlternatePhone;
         
      
    private String contactName2;


    private String contact2Phone;
   
         
    private String contact2AlternatePhone;
           
          
    private String gstNo;
   

  
    private int status;

   
    private Date activeFromDate;
    
     
    private Date activeTillDate;


    private Date addedOn;
    
     private String city;
     
      private String state;
      
       private String pinCode;
       
       private String activeFromDateFormatted;
       private String activeTillDateFormatted;

    public SupplierPojo() {
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

    public String getActiveFromDateFormatted() {
        return activeFromDateFormatted;
    }

    public String getActiveTillDateFormatted() {
        return activeTillDateFormatted;
    }

    public void setActiveFromDateFormatted(String activeFromDateFormatted) {
        this.activeFromDateFormatted = activeFromDateFormatted;
    }

    public void setActiveTillDateFormatted(String activeTillDateFormatted) {
        this.activeTillDateFormatted = activeTillDateFormatted;
    }


   

}
