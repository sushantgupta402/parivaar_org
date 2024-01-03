/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parivaar.org.dao;

import com.parivaar.org.hb.entity.ItemHistory;
import com.parivaar.org.pojo.ItemHistoryPojo;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ItemHistoryDao {
   // public List<ItemHistoryPojo> listItemsHistory();
    
    public void saveItemHistory(ItemHistoryPojo pojo);
    
   // public ItemHistory getItemHistoryById(Long id);
    
   // public void deleteItemHistory(ItemHistoryPojo pojo);
    
    //public void deleteItemHistories(List<ItemHistoryPojo> pojos);
    
     public List<ItemHistoryPojo> itemisedHistory(String itemName); 
}
