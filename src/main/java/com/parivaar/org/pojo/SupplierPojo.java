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
    
    private String address;
    
   
    private String contactPerson;
    
   
    private String contact;
    
   
    private int status;
    
  
    private Date createdOn;
      
  
    private Date updatedOn;

    public SupplierPojo() {
    }

    public SupplierPojo(Long id, String name, String address, String contactPerson, String contact, int status, Date createdOn, Date updatedOn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contact = contact;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
    
    
    
}
