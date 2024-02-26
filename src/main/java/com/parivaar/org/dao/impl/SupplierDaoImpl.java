/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.SupplierPojo;
import com.parivaar.org.util.HibernateUtil;
import com.parivaar.org.util.SupplierUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@Named(value = "supplierDao")
@ApplicationScoped
public class SupplierDaoImpl implements SupplierDao, Serializable {

    private static Transaction transObj;
    private static SessionFactory sessionObj = HibernateUtil.getSessionFactory();

    @Override
    public List<SupplierPojo> listSuppliers() {
        List<SupplierPojo> pojos = new ArrayList<>();

        try {

            List<Supplier> supplierList = sessionObj.openSession().createQuery("from Supplier", Supplier.class).list();

            for (Supplier s : supplierList) {
                // load the data
                SupplierPojo pojo = new SupplierPojo();
                pojo = SupplierUtil.entityToPojo(s);
               
                pojos.add(pojo);

            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }

        return pojos;

    }

    @Override
    public void saveSupplier(SupplierPojo pojo) {

        if (null == pojo.getId()) {
            Supplier ent = new Supplier();
            pojo.setAddedOn(new Date());
            ent = SupplierUtil.pojoToEntity(pojo);
            

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
                Supplier ent = session.load(Supplier.class, pojo.getId());
                if(ent != null){
                     ent = SupplierUtil.pojoToEntity(pojo);
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
    public Supplier getSupplierById(long id) {
        Transaction transaction = null;
        Supplier supplier = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            supplier = session.byId(Supplier.class).getReference(id);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return supplier;
    }

    @Override
    public void deleteSupplier(SupplierPojo pojo) {

        Transaction transaction = null;
        try (Session session = sessionObj.openSession()) {
            Supplier ent = session.get(Supplier.class, pojo.getId());

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
    public void deleteSuppliers(List<SupplierPojo> pojos) {
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
                Supplier supp = (Supplier) session.get(Supplier.class, Long.valueOf(pojos.get(i).getId()));
                session.delete(supp);
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
