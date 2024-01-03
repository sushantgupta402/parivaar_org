/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.ItemHistoryDao;
import com.parivaar.org.hb.entity.ItemHistory;
import com.parivaar.org.pojo.ItemHistoryPojo;
import com.parivaar.org.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author hp
 */
public class itemHistoryDaoImpl implements ItemHistoryDao,Serializable {
    
    private static Transaction transObj;
    private static SessionFactory sessionObj = HibernateUtil.getSessionFactory();

    @Override
    public void saveItemHistory(ItemHistoryPojo pojo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ItemHistoryPojo> itemisedHistory(String itemName) {
       List<ItemHistoryPojo> historyPojos = new ArrayList<>();

        try {
            

            List<ItemHistory> itemHistoryList = sessionObj.openSession().createQuery("SELECT op.username, op.email, orders.p_id, orders.o_id, product.listed_price" +
"FROM ItemHistory itemHistory, Item item" +
"WHERE itemHistory.item = item AND item.name = :name").setMaxResults(5).list();

//            for (Item i : itemList) {
//                // load the data
//                ItemPojo pojo = new ItemPojo();
//
//                pojo.setId(i.getId());
//                pojo.setName(i.getName());
//                pojo.setDescription(i.getDescription());
//                pojo.setStatus(i.getStatus());
//                pojo.setCreatedOn(i.getCreatedOn());
//                pojo.setUpdatedOn(i.getUpdatedOn());
//                pojo.setCost(i.getCost());
//                pojo.setStockInGrams(i.getStock());
//                Supplier supp = new Supplier();
//                supp = supplierDao.getSupplierById(i.getSupplier().getId());
//                SupplierPojo suppPojo = new SupplierPojo();
//                if (supp != null) {
//                    suppPojo.setId(supp.getId());
//                    suppPojo.setName(supp.getName());
//                    suppPojo.setAddress(supp.getAddress());
//                    suppPojo.setContactPerson(supp.getContactPerson());
//                    suppPojo.setContact(supp.getContact());
//                    suppPojo.setStatus(supp.getStatus());
//                    suppPojo.setCreatedOn(supp.getCreatedOn());
//                    suppPojo.setUpdatedOn(supp.getUpdatedOn());
//                }
//                pojo.setSupplier(suppPojo);
//                pojos.add(pojo);
//
//            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }

        return null;
    }
    
}
