/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.StateDao;
import com.parivaar.org.hb.entity.States;
import com.parivaar.org.util.HibernateUtil;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
@Named(value = "stateDao")
@ApplicationScoped
public class StateDaoImpl implements StateDao,Serializable {
 
    
    private static Transaction transObj;
    private static SessionFactory sessionObj = HibernateUtil.getSessionFactory();
    
    
    @Override
    public States getStateById(Long id) {
         Transaction transaction = null;
        States state = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            state = session.byId(States.class).getReference(id);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return state;
    }
    
}
