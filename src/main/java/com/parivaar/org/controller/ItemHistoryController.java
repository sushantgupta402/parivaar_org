/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.parivaar.org.controller;

import com.parivaar.org.dao.ItemHistoryDao;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author hp
 */
@Named(value = "itemHistoryController")
@SessionScoped
public class ItemHistoryController implements Serializable {

    /**
     * Creates a new instance of ItemHistoryController
     */
    public ItemHistoryController() {
    }
    
     @Inject
    private ItemHistoryDao itemHistoryDao;
     
      public void testQuery(){
        itemHistoryDao.itemisedHistory("Fish");
        
    }
    
}
