/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.Util;
import com.parivaar.org.dao.ItemDao;
import com.parivaar.org.dao.TransactionDao;
import com.parivaar.org.hb.entity.Item;
import com.parivaar.org.hb.entity.States;
import com.parivaar.org.hb.entity.TransactionTypes;
import com.parivaar.org.hb.entity.Transactions;
import com.parivaar.org.pojo.ItemPojo;
import com.parivaar.org.pojo.StatesPojo;

import com.parivaar.org.pojo.TransactionPojo;
import com.parivaar.org.pojo.TransactionTypesPojo;
import com.parivaar.org.util.HibernateUtil;
import com.parivaar.org.util.TransactionUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author hp
 */
@Named(value = "transactionDao")
@ApplicationScoped
public class TransactionDaoImpl implements TransactionDao {
    
    private static org.hibernate.Transaction transObj;
    private static SessionFactory sessionObj = HibernateUtil.getSessionFactory();
    
    @Inject
    private ItemDao itemDao;

    @Override
    public List<TransactionPojo> listTransactions() {
        List<TransactionPojo> pojos = new ArrayList<>();

        try {

            List<Transactions> transactionList = sessionObj.openSession().createQuery("from Transactions", Transactions.class).list();

            for (Transactions t : transactionList) {
                // load the data
                TransactionPojo pojo = new TransactionPojo();
                pojo = TransactionUtil.entityToPojo(t);
               
                pojos.add(pojo);

            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }
         return pojos;
    }

    @Override
    public void saveTransaction(TransactionPojo pojo) {
        String loggedUser = Util.getUserName();
       if (null == pojo.getId()) {
            Transactions ent = new Transactions();
            pojo.setTransactionDate(new Date());
            pojo.setTransactionBy(loggedUser);
            ent = TransactionUtil.pojoToEntity(pojo);
            

             org.hibernate.Transaction transaction = null;
            try (Session session = sessionObj.openSession()) {
                // start a transaction
                transaction = session.beginTransaction();

                session.persist(ent);

                // commit transaction
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
                
            }
        } else {

             org.hibernate.Transaction transaction = null;
            try (Session session = sessionObj.openSession()) {
                Transactions ent = session.load(Transactions.class, pojo.getId());
                if(ent != null){
                     ent = TransactionUtil.pojoToEntity(pojo);
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
    public Transactions getTransactionById(long id) {
        org.hibernate.Transaction transaction = null;
        Transactions ent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            ent = session.byId(Transactions.class).getReference(id);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return ent;
    }

    @Override
    public void deleteTransaction(TransactionPojo pojo) {
        org.hibernate.Transaction transaction = null;
        try (Session session = sessionObj.openSession()) {
            Transactions ent = session.get(Transactions.class, pojo.getId());

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
    public void deleteTransactions(List<TransactionPojo> pojos) {
         org.hibernate.Transaction transaction = null;
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
                Transactions txn = (Transactions) session.get(Transactions.class, Long.valueOf(pojos.get(i).getId()));
                session.delete(txn);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<TransactionTypesPojo> getTransactionTypes() {
         List<TransactionTypesPojo> pojos = new ArrayList<>();

        try {

            List<TransactionTypes> transactionTtypeList = sessionObj.openSession().createQuery("from TransactionTypes", TransactionTypes.class).list();

            for (TransactionTypes t : transactionTtypeList) {
                // load the data
                TransactionTypesPojo pojo = new TransactionTypesPojo();
                pojo = TransactionUtil.entityToPojo(t);
               
                pojos.add(pojo);

            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }
         return pojos;
    }

    @Override
    public List<StatesPojo> getStates() {
         List<StatesPojo> pojos = new ArrayList<>();

        try {

            List<States> stateList = sessionObj.openSession().createQuery("from States", States.class).list();

            for (States t : stateList) {
                // load the data
                StatesPojo pojo = new StatesPojo();
                pojo = TransactionUtil.entityToPojo(t);
               
                pojos.add(pojo);

            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }
         return pojos;
    }

    @Override
    public TransactionPojo fetchLatestTransactionByItem(long item) {
        
         org.hibernate.Transaction transaction = null;
        TransactionPojo pojo = null;
        Item itm = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            itm = session.byId(Item.class).getReference(item);
            
            List<Transactions> itemTransactions = itm.getTransactions();
            if(!itemTransactions.isEmpty()){
                itemTransactions = itemTransactions.stream().sorted((p1,p2)->p2.getTransactionDate().compareTo(p1.getTransactionDate())).collect(Collectors.toList());
                Transactions ent = itemTransactions.get(0);
                pojo = TransactionUtil.entityToPojo(ent);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return pojo;
    }

    @Override
    public TransactionTypes getTransactionTypeById(long id) {
        org.hibernate.Transaction transaction = null;
        TransactionTypes ent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            ent = session.byId(TransactionTypes.class).getReference(id);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return ent;
    }
    
}
