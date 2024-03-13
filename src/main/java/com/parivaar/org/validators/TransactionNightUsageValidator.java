/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.validators;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.primefaces.validate.ClientValidator;

/**
 *
 * @author hp
 */
@FacesConverter("transactionNightUsageValidator")
public class TransactionNightUsageValidator implements Validator,ClientValidator  {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
       String nightUsageValue = (String) value;
       
       java.util.regex.Pattern pattern = Pattern.compile("(\\-?\\d*\\.?\\d+)");
       Matcher matcher = pattern.matcher(nightUsageValue);
       System.out.println(matcher.matches());
      
//        if (usernameExists(username)) {
//            throw new ValidatorException(new FacesMessage("User Name already exists."));
//        }
    }
    
    @Override
    public String getValidatorId() {
        return "custom.transactionNightUsageValidator";
    }

    @Override
    public Map<String, Object> getMetadata() {
        return null;
    }
    
}
