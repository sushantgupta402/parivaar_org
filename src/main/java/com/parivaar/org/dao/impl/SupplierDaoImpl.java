/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.SupplierPojo;
import com.parivaar.org.util.HibernateUtil;
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
                pojo.setId(s.getId());
                pojo.setSupplierCode(s.getSupplierCode());
                pojo.setName(s.getName());
                pojo.setDescription(s.getDescription());
                pojo.setStatus(s.getStatus());
                pojo.setLastStatusDate(s.getLastStatusDate());
                pojo.setSupplierAddedBy(s.getSupplierAddedBy());
                pojo.setPrimaryAddress(s.getPrimaryAddress());
                pojo.setSecondaryAddress(s.getSecondaryAddress());
                pojo.setContactName1(s.getContactName1());
                pojo.setContactName2(s.getContactName2());
                pojo.setContact1Phone(s.getContact1Phone());
                pojo.setContact2Phone(s.getContact2Phone());
                pojo.setGstNo(s.getGstNo());
                pojo.setRemarks(s.getRemarks());
                pojo.setAddedOn(s.getAddedOn());
                pojo.setFormattedLastStatusDate(new SimpleDateFormat("dd-MM-yyyy").format(s.getLastStatusDate()));
                pojo.setFormattedaddedOn(new SimpleDateFormat("dd-MM-yyyy").format(s.getAddedOn()));
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
            ent.setName(pojo.getName());
            ent.setSupplierCode(pojo.getSupplierCode());
            ent.setDescription(pojo.getDescription());
            ent.setLastStatusDate(new java.util.Date());
            ent.setSupplierAddedBy(pojo.getSupplierAddedBy());
            ent.setPrimaryAddress(pojo.getPrimaryAddress());
            ent.setSecondaryAddress(pojo.getSecondaryAddress());
            ent.setContactName1(pojo.getContactName1());
            ent.setContactName2(pojo.getContactName2());
            ent.setContact1Phone(pojo.getContact1Phone());
            ent.setContact2Phone(pojo.getContact2Phone());
            ent.setGstNo(pojo.getGstNo());
            ent.setRemarks(pojo.getRemarks());
            ent.setAddedOn(new java.util.Date());

            ent.setStatus(pojo.getStatus());

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
                ent.setName(pojo.getName());
                ent.setSupplierCode(pojo.getSupplierCode());
                ent.setDescription(pojo.getDescription());
                ent.setLastStatusDate(new java.util.Date());
                ent.setSupplierAddedBy(pojo.getSupplierAddedBy());
                ent.setPrimaryAddress(pojo.getPrimaryAddress());
                ent.setSecondaryAddress(pojo.getSecondaryAddress());
                ent.setContactName1(pojo.getContactName1());
                ent.setContactName2(pojo.getContactName2());
                ent.setContact1Phone(pojo.getContact1Phone());
                ent.setContact2Phone(pojo.getContact2Phone());
                ent.setGstNo(pojo.getGstNo());
                ent.setRemarks(pojo.getRemarks());
                ent.setAddedOn(new java.util.Date());

                ent.setStatus(pojo.getStatus());

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
