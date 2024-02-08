/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.SupplierPojo;

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

        pojo.setDescription(ent.getDescription());

        pojo.setLastStatusDate(ent.getLastStatusDate());
        pojo.setSupplierAddedBy(ent.getSupplierAddedBy());

        pojo.setStatus(ent.getStatus());
        pojo.setPrimaryAddress(ent.getPrimaryAddress());
        pojo.setSecondaryAddress(ent.getSecondaryAddress());
        pojo.setContactName1(ent.getContactName1());
        pojo.setContactName2(ent.getContactName2());
        pojo.setContact1Phone(ent.getContact1Phone());
        pojo.setContact2Phone(ent.getContact2Phone());
        pojo.setGstNo(ent.getGstNo());
        pojo.setRemarks(ent.getRemarks());
        pojo.setAddedOn(ent.getAddedOn());

        return pojo;

    }

    public static Supplier pojoToEntity(SupplierPojo pojo) {
        Supplier ent = new Supplier();
        if (pojo.getId() != null) {
            ent.setId(pojo.getId());
        }

        ent.setName(pojo.getName());

        ent.setSupplierCode(pojo.getSupplierCode());
        ent.setDescription(pojo.getDescription());
        ent.setLastStatusDate(new java.util.Date());
        ent.setSupplierAddedBy(pojo.getSupplierAddedBy());

        ent.setStatus(pojo.getStatus());
        ent.setPrimaryAddress(pojo.getPrimaryAddress());
        ent.setSecondaryAddress(pojo.getSecondaryAddress());
        ent.setContactName1(pojo.getContactName1());
        ent.setContactName2(pojo.getContactName2());
        ent.setContact1Phone(pojo.getContact1Phone());
        ent.setContact2Phone(pojo.getContact2Phone());
        ent.setGstNo(pojo.getGstNo());
        ent.setRemarks(pojo.getRemarks());
        ent.setAddedOn(new java.util.Date());

        return ent;

    }
}
