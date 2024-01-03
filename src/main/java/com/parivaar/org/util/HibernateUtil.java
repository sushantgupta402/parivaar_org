/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Ravinder Singh
 */
public class HibernateUtil {
     public HibernateUtil() {
    }
    
//    private static SessionFactory sessionFactoryObj = buildSessionFactoryObj();
//
//   
//    
// 
//    // Create The SessionFactory Object From Standard (Hibernate.cfg.xml) Configuration File
//    @SuppressWarnings("deprecation")
//    public static SessionFactory buildSessionFactoryObj() {
//        try {
//            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
//        } catch (ExceptionInInitializerError exceptionObj) {
//            exceptionObj.printStackTrace();
//        }
//        return sessionFactoryObj;
//    }
// 
//    public static SessionFactory getSessionFactory() {
//        return sessionFactoryObj;
//    }
     
     private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
