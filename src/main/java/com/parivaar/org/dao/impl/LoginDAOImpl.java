/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.LoginDAO;
import com.parivaar.org.hb.entity.User;
import com.parivaar.org.util.HibernateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Anish
 */

@Named(value = "loginDao")
@ApplicationScoped
public class LoginDAOImpl implements LoginDAO, Serializable {
    
       private static Transaction transObj;
    private static SessionFactory sessionObj = HibernateUtil.getSessionFactory();

    @Override
    public User getUserById(String id) {
        Transaction transaction = null;
        User user = null;
        
     try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            user = session.byId(User.class).getReference(id);
            

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user; }
    
       public void updateUserLoginTimestamp(String id) {
        Transaction transaction = null;
        User user = null;
        
     try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            user = session.byId(User.class).getReference(id);
            
            user.setLastLoginTs(new Timestamp(System.currentTimeMillis()));

            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        }

         public void updateUserLoginPassword(String id, String nuePass) {
        Transaction transaction = null;
        User user = null;
        
     try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            user = session.byId(User.class).getReference(id);
            
            user.setPassword(nuePass);

            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        }
         
         public Boolean changePass(String user, String oldPass, String nuePass){
             if(login(user, oldPass)){
                 updateUserLoginPassword(user, nuePass);
                 return true;
             }
             else
             return false;
         }

    public Boolean login(String user, String password){
        
 
        FacesMessage message = null;
        boolean loggedIn = false;
       
           if(user != null  && password != null && getUserById(user).getPassword().equals(password)) {
//        if(user != null && user.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
               updateUserLoginTimestamp(user);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        return loggedIn;
      
    }
//           return reqLogin.getPassword().equals(password);

    }
    




 