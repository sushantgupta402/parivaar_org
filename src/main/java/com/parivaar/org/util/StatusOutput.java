/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import static com.sun.faces.util.MessageUtils.CONVERSION_ERROR_MESSAGE_ID;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author hp
 */
@FacesConverter("statusOutput")
public class StatusOutput implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String inputval = string;
    if(inputval.equalsIgnoreCase("active")){
        return new Byte("1");
    }else 
        return new Byte("0");
            
    }

    @Override
    public String getAsString(FacesContext context,
        UIComponent component, Object value) {
        Byte inputVal = null;
    if ( value == null ) {
        return "";
    }
    // value must be of a type that can be cast to a String.
    try {
        inputVal = (Byte)value;
    } catch (ClassCastException ce) {
        FacesMessage errMsg = new FacesMessage(CONVERSION_ERROR_MESSAGE_ID);
        FacesContext.getCurrentInstance().addMessage(null, errMsg);
            throw new ConverterException(errMsg.getSummary());
    }
    
  if(inputVal == 0){
      return "InActive";
  }else
      return "Active";
    
  }
    
}
