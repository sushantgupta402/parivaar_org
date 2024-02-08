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
            

            Query query = sessionObj.openSession().createNativeQuery("select ih.id,ih.item_id, i.name,i.stock_grams from item_history ih, item_list i where ih.item_id=i.id and i.name=?").setParameter(1, itemName);
            List<Object[]> rows = query.list();
            rows.stream().forEach(objects -> {
			Integer historyId = (Integer) objects[0];
                        Integer itemId = (Integer) objects[1];
			String name = (String) objects[2];
                        Double stock = (Double) objects[3];
			System.out.println(String.format("Info: Items[ %d, %d,%s,%f ]", historyId,itemId, name,stock));
		});
						

        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }

        return null;
    }
    
}
