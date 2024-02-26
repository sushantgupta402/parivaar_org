/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import com.parivaar.org.hb.entity.Item;

import com.parivaar.org.pojo.ItemPojo;


/**
 *
 * @author Ravinder Singh
 */
public class ItemUtil {

    public static ItemPojo entityToPojo(Item ent) {
        ItemPojo pojo = new ItemPojo();
        pojo.setId(ent.getId());
         pojo.setItemCode(ent.getCode());
         pojo.setItemName(ent.getName());

        pojo.setDescriptionOne(ent.getDescriptionOne());

        pojo.setDescriptionTwo(ent.getDescriptionTwo());

        pojo.setDescriptionThree(ent.getDescriptionThree());
        pojo.setCurrentInventoryQuantity(ent.getCurrentInventoryQuantity());

        pojo.setCurrentInventoryUnit(ent.getCurrentInventoryUnit());
        pojo.setStatus(ent.getStatus());
        pojo.setActiveFromDate(ent.getActiveFromDate());
        pojo.setActiveTillDate(ent.getActiveTillDate());
          pojo.setQuantityMeasuredIn(ent.getQuantityMeasuredIn());
       
       

        return pojo;

    }

    public static Item pojoToEntity(ItemPojo pojo) {
        Item ent = new Item();
        if (pojo.getId() != null) {
            ent.setId(pojo.getId());
        }

        ent.setName(pojo.getItemName());

        ent.setCode(pojo.getItemCode());
        ent.setDescriptionOne(pojo.getDescriptionOne());
        ent.setDescriptionTwo(pojo.getDescriptionTwo());
        ent.setDescriptionThree(pojo.getDescriptionThree());

        ent.setStatus(pojo.getStatus());
        ent.setCurrentInventoryQuantity(pojo.getCurrentInventoryQuantity());
        ent.setCurrentInventoryUnit(pojo.getCurrentInventoryUnit());
        ent.setActiveFromDate(pojo.getActiveFromDate());
        ent.setActiveTillDate(pojo.getActiveTillDate());
         ent.setQuantityMeasuredIn(pojo.getQuantityMeasuredIn());
       
        return ent;

    }
}
