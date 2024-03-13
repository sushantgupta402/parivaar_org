/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;


import com.parivaar.org.hb.entity.States;
import com.parivaar.org.hb.entity.TransactionTypes;
import com.parivaar.org.hb.entity.Transactions;
import com.parivaar.org.pojo.StatesPojo;


import com.parivaar.org.pojo.TransactionPojo;
import com.parivaar.org.pojo.TransactionTypesPojo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author Ravinder Singh
 */
public class TransactionUtil {

    public static TransactionPojo entityToPojo(Transactions ent) {
        TransactionPojo pojo = new TransactionPojo();
        pojo.setId(ent.getId());
        pojo.setTransactionId(ent.getTransactionId());

        pojo.setItemName(ent.getItemName());

        pojo.setTransactionType(ent.getTransactionType());
        pojo.setBranch(ent.getBranch());
        pojo.setTransactionDate(ent.getTransactionDate());

        pojo.setTime(ent.getTimeStr());
        pojo.setOpeningBalance(ent.getOpeningBalance());
        pojo.setClosingBalance(ent.getClosingBalance());

        pojo.setDetails1(ent.getDetails1());
        pojo.setDetails2(ent.getDetails2());
        pojo.setDetails3(ent.getDetails3());

        pojo.setSupplier(ent.getSupplier());
        pojo.setPerUnitCost(ent.getPerUnitCost());
        pojo.setTotalCost(ent.getTotalCost());

        pojo.setItem(ent.getItem());
        pojo.setItemQuantity(ent.getItemQuantity());
        pojo.setDayUsage(ent.getDayUsage());
        pojo.setNightUsage(ent.getNightUsage());
       
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        if(ent.getTransactionDate()!= null){
            pojo.setFormattedDate(dateFormat.format(ent.getTransactionDate()));
        }
        
       
        return pojo;

    }

    public static Transactions pojoToEntity(TransactionPojo pojo) {
        Transactions ent = new Transactions();
        if (pojo.getId() != null) {
            ent.setId(pojo.getId());
        }

       ent.setTransactionId(pojo.getTransactionId());

        ent.setItemName(pojo.getItemName());

        ent.setTransactionType(pojo.getTransactionType());
        ent.setBranch(pojo.getBranch());
        ent.setTransactionDate(pojo.getTransactionDate());

        ent.setTimeStr(pojo.getTime());
        ent.setOpeningBalance(pojo.getOpeningBalance());
        ent.setClosingBalance(pojo.getClosingBalance());

        ent.setDetails1(pojo.getDetails1());
        ent.setDetails2(pojo.getDetails2());
        ent.setDetails3(pojo.getDetails3());

        ent.setSupplier(pojo.getSupplier());
        ent.setPerUnitCost(pojo.getPerUnitCost());
        ent.setTotalCost(pojo.getTotalCost());

        ent.setItem(pojo.getItem());
        ent.setItemQuantity(pojo.getItemQuantity());
        ent.setDayUsage(pojo.getDayUsage());
        ent.setNightUsage(pojo.getNightUsage());
        return ent;

    }
    
    public static TransactionTypesPojo entityToPojo(TransactionTypes ent) {
        TransactionTypesPojo pojo = new TransactionTypesPojo();
        pojo.setId(ent.getId());
        pojo.setName(ent.getName());

        pojo.setCode(ent.getCode());

       
       
        return pojo;

    }
    
     public static StatesPojo entityToPojo(States ent) {
        StatesPojo pojo = new StatesPojo();
        pojo.setId(ent.getId());
        pojo.setName(ent.getName());

       
        return pojo;

    }
}
