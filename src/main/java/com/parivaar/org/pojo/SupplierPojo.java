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

    private String description;
    private int status;

    private String supplierAddedBy;

    private Date lastStatusDate;
    
    private String formattedLastStatusDate;
    
    private String primaryAddress;
    
    private String secondaryAddress;
    
    private String contactName1;
    
    private String contactName2;
    
    private String contact1Phone;
    
    private String contact2Phone;
    
    private String gstNo;
    
    private String remarks;
    
    private Date addedOn;
    
    private String formattedaddedOn;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplierAddedBy() {
        return supplierAddedBy;
    }

    public void setSupplierAddedBy(String supplierAddedBy) {
        this.supplierAddedBy = supplierAddedBy;
    }

    public Date getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Date lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public String getFormattedLastStatusDate() {
        return formattedLastStatusDate;
    }

    public void setFormattedLastStatusDate(String formattedLastStatusDate) {
        this.formattedLastStatusDate = formattedLastStatusDate;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

    public String getContactName1() {
        return contactName1;
    }

    public void setContactName1(String contactName1) {
        this.contactName1 = contactName1;
    }

    public String getContactName2() {
        return contactName2;
    }

    public void setContactName2(String contactName2) {
        this.contactName2 = contactName2;
    }

    public String getContact1Phone() {
        return contact1Phone;
    }

    public void setContact1Phone(String contact1Phone) {
        this.contact1Phone = contact1Phone;
    }

    public String getContact2Phone() {
        return contact2Phone;
    }

    public void setContact2Phone(String contact2Phone) {
        this.contact2Phone = contact2Phone;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public String getFormattedaddedOn() {
        return formattedaddedOn;
    }

    public void setFormattedaddedOn(String formattedaddedOn) {
        this.formattedaddedOn = formattedaddedOn;
    }
    
    

}
