/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.ItemDao;
import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.hb.entity.Item;
import com.parivaar.org.hb.entity.ItemHistory;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.ItemHistoryPojo;
import com.parivaar.org.pojo.ItemPojo;
import com.parivaar.org.pojo.SupplierPojo;
import com.parivaar.org.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ravinder
 */
@Named(value = "itemDao")
@Dependent
public class ItemDaoImpl implements ItemDao,Serializable {

    private static Transaction transObj;
    private static SessionFactory sessionObj = HibernateUtil.getSessionFactory();

    @Inject
    private SupplierDao supplierDao;

    @Override
    public List<ItemPojo> listItems() {
        List<ItemPojo> pojos = new ArrayList<>();

        try {

            List<Item> itemList = sessionObj.openSession().createQuery("from Item where status=1", Item.class).list();

            for (Item i : itemList) {
                // load the data
                ItemPojo pojo = new ItemPojo();

                pojo.setId(i.getId());
                pojo.setName(i.getName());
                pojo.setDescription(i.getDescription());
                pojo.setStatus(i.getStatus());
                pojo.setCreatedOn(i.getCreatedOn());
                pojo.setUpdatedOn(i.getUpdatedOn());
                pojo.setCost(i.getCost());
                pojo.setStockInGrams(i.getStock());
                Supplier supp = new Supplier();
                supp = supplierDao.getSupplierById(i.getSupplier().getId());
                SupplierPojo suppPojo = new SupplierPojo();
                if (supp != null) {
                    suppPojo.setId(supp.getId());
                    suppPojo.setName(supp.getName());
                    suppPojo.setAddress(supp.getAddress());
                    suppPojo.setContactPerson(supp.getContactPerson());
                    suppPojo.setContact(supp.getContact());
                    suppPojo.setStatus(supp.getStatus());
                    suppPojo.setCreatedOn(supp.getCreatedOn());
                    suppPojo.setUpdatedOn(supp.getUpdatedOn());
                }
                pojo.setSupplier(suppPojo);
                pojos.add(pojo);

            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }

        return pojos;
    }

    @Override
    public void saveItem(ItemPojo pojo) {
        Date now = new java.util.Date();
        if (null == pojo.getId()) {

            Item ent = new Item();

            ent.setName(pojo.getName());
            ent.setDescription(pojo.getDescription());
            ent.setStatus(pojo.getStatus());
            ent.setCreatedOn(now);
            ent.setUpdatedOn(now);
            ent.setCost(pojo.getCost());
            ent.setStock(pojo.getStockInGrams());
            Supplier supp = new Supplier();
            supp = supplierDao.getSupplierById(pojo.getSupplier().getId());

            if (pojo.getSupplier() != null) {
                ent.setSupplier(supp);
            }
            Transaction transaction = null;
            try (Session session = sessionObj.openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                session.merge(ent);

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } else {

            Transaction transaction = null;
            try (Session session = sessionObj.openSession()) {
                Item ent = session.load(Item.class, pojo.getId());
                ent.setStatus(Byte.valueOf("0"));
                ent.setUpdatedOn(now);
                
                 Item ent1 = new Item();

            ent1.setName(pojo.getName());
            ent1.setDescription(pojo.getDescription());
            ent1.setStatus(pojo.getStatus());
            ent1.setCreatedOn(ent.getCreatedOn());
            ent1.setUpdatedOn(now);
            ent1.setCost(pojo.getCost());
            ent1.setStock(pojo.getStockInGrams());
            Supplier supp = new Supplier();
            supp = supplierDao.getSupplierById(pojo.getSupplier().getId());
       
            ItemHistory history = new ItemHistory();
            history.setCreatedOn(now);
            history.setItem(ent);
            

            if (pojo.getSupplier() != null) {
                ent1.setSupplier(supp);
            }
               
                // start a transaction
                transaction = session.beginTransaction();

                session.merge(ent);
                 session.merge(ent1);
                 session.merge(history);

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }

        }
    }

    @Override
    public Item getItemById(Long id) {
        Transaction transaction = null;
        Item item = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            item = session.byId(Item.class).getReference(id);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void deleteItem(ItemPojo pojo) {
          Transaction transaction = null;
        try (Session session = sessionObj.openSession()) {
            Item ent = session.get(Item.class, pojo.getId());

            // start a transaction
            transaction = session.beginTransaction();
            if (ent != null) {
                session.delete(ent);

            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItems(List<ItemPojo> pojos) {
         Transaction transaction = null;
        try (Session session = sessionObj.openSession()) {
           int len=pojos.size();
      //<----------------
     transaction = session.beginTransaction();

    Configuration configuration=new Configuration();
    configuration.setProperty("hibernate.jdbc.batch_size", "50");

    for(int i=0;i<len;i++)
    {
        if(i%49==0)
        {
            session.flush();
            session.clear();
        }
        Item item=(Item)session.get(Item.class, Long.valueOf(pojos.get(i).getId()));
        session.delete(item);
    }
    transaction.commit();
    
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

   

}
