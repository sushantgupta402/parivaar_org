/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parivaar.org.dao;

import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.SupplierPojo;
import java.util.List;

/**
 *
 * @author Ravinder Singh
 */
public interface SupplierDao {
    public List<SupplierPojo> listSuppliers();
    
    public void saveSupplier(SupplierPojo pojo);
    
    public Supplier getSupplierById(long id);
    
    public void deleteSupplier(SupplierPojo pojo);
    
    public void deleteSuppliers(List<SupplierPojo> pojos);
}
