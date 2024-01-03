/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.SupplierPojo;

/**
 *
 * @author hp
 */
public class SupplierUtil {
    
   public static SupplierPojo entityToPojo(Supplier ent){
       SupplierPojo pojo = new SupplierPojo();
       pojo.setId(ent.getId());
       pojo.setName(ent.getName());
       pojo.setAddress(ent.getAddress());
       pojo.setContactPerson(ent.getContactPerson());
       pojo.setContact(ent.getContact());
       pojo.setStatus(ent.getStatus());
//       pojo.setCreatedOn(ent.getCreatedOn());
//       pojo.setUpdatedOn(ent.getUpdatedOn());
       return pojo;
       
   } 
   
    public static Supplier pojoToEntity(SupplierPojo pojo){
       Supplier ent = new Supplier();
       if(pojo.getId()!= null){
            ent.setId(pojo.getId());
       }
      
       ent.setName(pojo.getName());
       ent.setAddress(pojo.getAddress());
       ent.setContactPerson(pojo.getContactPerson());
       ent.setContact(pojo.getContact());
       ent.setStatus(pojo.getStatus());
       ent.setCreatedOn(pojo.getCreatedOn());
       ent.setUpdatedOn(pojo.getUpdatedOn());
       return ent;
       
   } 
}
