/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parivaar.org.dao;


import com.parivaar.org.hb.entity.TransactionTypes;
import com.parivaar.org.hb.entity.Transactions;
import com.parivaar.org.pojo.ItemPojo;
import com.parivaar.org.pojo.StatesPojo;

import com.parivaar.org.pojo.TransactionPojo;
import com.parivaar.org.pojo.TransactionTypesPojo;
import java.util.List;

/**
 *
 * @author Ravinder Singh
 */
public interface TransactionDao {
    public List<TransactionPojo> listTransactions();
    
    public List<TransactionTypesPojo> getTransactionTypes();
    
     public List<StatesPojo> getStates();
    
    public void saveTransaction(TransactionPojo pojo);
    
    public Transactions getTransactionById(long id);
    
    public TransactionTypes getTransactionTypeById(long id);
    
    public void deleteTransaction(TransactionPojo pojo);
    
    public void deleteTransactions(List<TransactionPojo> pojos);
    
    public TransactionPojo fetchLatestTransactionByItem(long item);
}
