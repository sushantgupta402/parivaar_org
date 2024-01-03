/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parivaar.org.dao;

import com.parivaar.org.hb.entity.Item;
import com.parivaar.org.pojo.ItemHistoryPojo;
import com.parivaar.org.pojo.ItemPojo;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ItemDao {
    
     public List<ItemPojo> listItems();
    
    public void saveItem(ItemPojo pojo);
    
    public Item getItemById(Long id);
    
    public void deleteItem(ItemPojo pojo);
    
    public void deleteItems(List<ItemPojo> pojos);
    
   
    
}
