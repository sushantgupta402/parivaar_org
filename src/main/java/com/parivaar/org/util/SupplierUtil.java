/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.SupplierPojo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ravinder Singh
 */
public class SupplierUtil {

    public static SupplierPojo entityToPojo(Supplier ent) {
        SupplierPojo pojo = new SupplierPojo();
        pojo.setId(ent.getId());
        pojo.setName(ent.getName());

        pojo.setSupplierCode(ent.getSupplierCode());

        pojo.setDescriptionOne(ent.getDescriptionOne());
        pojo.setDescriptionTwo(ent.getDescriptionTwo());
        pojo.setDescriptionThree(ent.getDescriptionThree());

        pojo.setAddressLine1(ent.getAddressLine1());
        pojo.setAddressline2(ent.getAddressline2());
        pojo.setAddressline3(ent.getAddressline3());

        pojo.setPrimaryPhone(ent.getPrimaryPhone());
        pojo.setAlternatePhone(ent.getAlternatePhone());
        pojo.setEmail(ent.getEmail());

        pojo.setContactName1(ent.getContactName1());
        pojo.setContact1Phone(ent.getContact1Phone());
        pojo.setContact1AlternatePhone(ent.getContact1AlternatePhone());

        pojo.setContactName2(ent.getContactName2());
        pojo.setContact2Phone(ent.getContact2Phone());
        pojo.setContact2AlternatePhone(ent.getContact2AlternatePhone());

        pojo.setGstNo(ent.getGstNo());

        pojo.setStatus(ent.getStatus());
        pojo.setActiveFromDate(ent.getActiveFromDate());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        if(ent.getActiveFromDate() != null){
            pojo.setActiveFromDateFormatted(dateFormat.format(ent.getActiveFromDate()));
        }
        if(ent.getActiveTillDate() != null){
            pojo.setActiveTillDateFormatted(dateFormat.format(ent.getActiveTillDate()));
        }
        
        pojo.setActiveTillDate(ent.getActiveTillDate());
      
        pojo.setAddedOn(ent.getAddedOn());
        pojo.setCity(ent.getCity());
        pojo.setState(ent.getState());
        pojo.setPinCode(ent.getPinCode());
        
        

        

        return pojo;

    }

    public static Supplier pojoToEntity(SupplierPojo pojo) {
        Supplier ent = new Supplier();
        if (pojo.getId() != null) {
            ent.setId(pojo.getId());
        }

        ent.setName(pojo.getName());

        ent.setSupplierCode(pojo.getSupplierCode());

        ent.setDescriptionOne(pojo.getDescriptionOne());
        ent.setDescriptionTwo(pojo.getDescriptionTwo());
        ent.setDescriptionThree(pojo.getDescriptionThree());

        ent.setAddressLine1(pojo.getAddressLine1());
        ent.setAddressline2(pojo.getAddressline2());
        ent.setAddressline3(pojo.getAddressline3());

        ent.setPrimaryPhone(pojo.getPrimaryPhone());
        ent.setAlternatePhone(pojo.getAlternatePhone());
        ent.setEmail(pojo.getEmail());

        ent.setContactName1(pojo.getContactName1());
        ent.setContact1Phone(pojo.getContact1Phone());
        ent.setContact1AlternatePhone(pojo.getContact1AlternatePhone());

        ent.setContactName2(pojo.getContactName2());
        ent.setContact2Phone(pojo.getContact2Phone());
        ent.setContact2AlternatePhone(pojo.getContact2AlternatePhone());

        ent.setGstNo(pojo.getGstNo());

        ent.setStatus(pojo.getStatus());
        ent.setActiveFromDate(pojo.getActiveFromDate());
        ent.setActiveTillDate(pojo.getActiveTillDate());
        ent.setAddedOn(pojo.getAddedOn());
         ent.setCity(pojo.getCity());
        ent.setState(pojo.getState());
        ent.setPinCode(pojo.getPinCode());
        return ent;

    }
}
