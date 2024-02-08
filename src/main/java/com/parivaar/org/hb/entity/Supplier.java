/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.hb.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    @Column(name = "laststausdate")
    private Date lastStatusDate;

    @Column(name = "supplieraddedby")
    private String supplierAddedBy;

    @Column(name = "primary_address")
    private String primaryAddress;

    @Column(name = "secondary_address")
    private String secondaryAddress;

    @Column(name = "contact_name1")
    private String contactName1;

    @Column(name = "contact_name2")
    private String contactName2;

    @Column(name = "contact1_phone")
    private String contact1Phone;

    @Column(name = "contact2_phone")
    private String contact2Phone;

    @Column(name = "gst_no")
    private String gstNo;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "added_on")
    private Date addedOn;

    public Supplier() {
    }



    public Supplier(String name, String supplierCode, String supplierAddedBy, String primaryAddress, String secondaryAddress, String contactName1, String contactName2, String contact1Phone, String contact2Phone, String gstNo, String remarks) {
        this.name = name;
        this.supplierCode = supplierCode;
        this.supplierAddedBy = supplierAddedBy;
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
        this.contactName1 = contactName1;
        this.contactName2 = contactName2;
        this.contact1Phone = contact1Phone;
        this.contact2Phone = contact2Phone;
        this.gstNo = gstNo;
        this.remarks = remarks;
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

    public String getDescription() {
        return description;
    }

    public Date getLastStatusDate() {
        return lastStatusDate;
    }

    public String getSupplierAddedBy() {
        return supplierAddedBy;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastStatusDate(Date lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public void setSupplierAddedBy(String supplierAddedBy) {
        this.supplierAddedBy = supplierAddedBy;
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

}
