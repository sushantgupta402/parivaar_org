/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.ItemDao;
import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.hb.entity.Item;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.ItemPojo;
import com.parivaar.org.pojo.SupplierPojo;
import com.parivaar.org.util.HibernateUtil;
import com.parivaar.org.util.ItemUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ravinder Singh
 */
@Named(value = "itemDao")
@ApplicationScoped
public class ItemDaoImpl implements ItemDao, Serializable {

    private static Transaction transObj;
    private static SessionFactory sessionObj = HibernateUtil.getSessionFactory();

    

    @Override
    public List<ItemPojo> listItems() {
         List<ItemPojo> pojos = new ArrayList<>();

        try {

            List<Item> itemList = sessionObj.openSession().createQuery("from Item", Item.class).list();

            for (Item i : itemList) {
                // load the data
                ItemPojo pojo = new ItemPojo();
                pojo = ItemUtil.entityToPojo(i);
               
                pojos.add(pojo);

            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }

        return pojos;
    }

    @Override
    public void saveItem(ItemPojo pojo) {
       if (null == pojo.getId()) {
            Item ent = new Item();
            ent = ItemUtil.pojoToEntity(pojo);
            

            Transaction transaction = null;
            try (Session session = sessionObj.openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                session.persist(ent);

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
                if(ent != null){
                     ent = ItemUtil.pojoToEntity(pojo);
                }
               
                

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
            int len = pojos.size();
            //<----------------
            transaction = session.beginTransaction();

            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.jdbc.batch_size", "50");

            for (int i = 0; i < len; i++) {
                if (i % 49 == 0) {
                    session.flush();
                    session.clear();
                }
                Item item = (Item) session.get(Item.class, Long.valueOf(pojos.get(i).getId()));
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
