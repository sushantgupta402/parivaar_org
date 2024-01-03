/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author hp
 */
public class ItemHistoryPojo implements Serializable {
    
    private Long id;
    
    private ItemPojo itemPojo;
    
    private Date createdOn;

    public ItemHistoryPojo() {
    }

    public ItemHistoryPojo(ItemPojo itemPojo, Date createdOn) {
        this.itemPojo = itemPojo;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemPojo getItemPojo() {
        return itemPojo;
    }

    public void setItemPojo(ItemPojo itemPojo) {
        this.itemPojo = itemPojo;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    
    
    
    
}
