/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import com.parivaar.org.dao.SupplierDao;
import com.parivaar.org.dao.impl.CountryService;
import com.parivaar.org.dao.impl.SupplierDaoImpl;
import com.parivaar.org.hb.entity.Supplier;
import com.parivaar.org.pojo.Country;
import com.parivaar.org.pojo.SupplierPojo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named
@FacesConverter(value = "supplierConverter", managed = true)
public class SupplierConverter implements Converter<Long>,Serializable {
 
   
   

    @Override
    public Long getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                
                return Long.parseLong(value);
            }
            catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid country."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Long value) {
        if (value != null) {
            return String.valueOf(value);
        }
        else {
            return null;
        }
    }

//    @Override
//    public SupplierPojo getAsObject(FacesContext fc, UIComponent uic, String string) {
//        SupplierDaoImpl supplierDao =  CDI.current().select(SupplierDaoImpl.class).get();
//        Supplier supplier=supplierDao.getSupplierById(Long.parseLong(string));
//        SupplierPojo pojo = SupplierUtil.entityToPojo(supplier);
//        return pojo;
//    }
//
//    @Override
//    public String getAsString(FacesContext fc, UIComponent uic, SupplierPojo t) {
//       return ((SupplierPojo)t).getId().toString();
//    }

  
    
}
