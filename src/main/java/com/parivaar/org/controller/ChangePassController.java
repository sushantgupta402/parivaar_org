/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.controller;


/**
 *
 * @author Anish
 */
import com.parivaar.org.Util;
import com.parivaar.org.dao.impl.LoginDAOImpl;
import com.parivaar.org.pojo.ChangePassPojo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
 
@Named(value = "changePass")
@SessionScoped
public class ChangePassController implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Inject
    private LoginDAOImpl loginDao;
    private String password1 , password2;
    private ChangePassPojo changePassObj;

     private String message, uname;

    public ChangePassController(ChangePassPojo changePassObj) {
        this.changePassObj = changePassObj;
    }
    public ChangePassController() {
    }

    public ChangePassPojo getChangePassObj() {
        return changePassObj;
    }

    public void setChangePassObj(ChangePassPojo changePassObj) {
        this.changePassObj = changePassObj;
    }

    public ChangePassController(LoginDAOImpl loginDao, String password1, String password2, ChangePassPojo changePassObj, String message, String uname) {
        this.loginDao = loginDao;
        this.password1 = password1;
        this.password2 = password2;
        this.changePassObj = changePassObj;
        this.message = message;
        this.uname = uname;
    }
   

  

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    
     public void openNew() {
        
        changePassObj = new ChangePassPojo();
      
        PrimeFaces.current().ajax().update("dialogs:manage-product-content");
        PrimeFaces.current().executeScript("PF('manageProductDialog').show()");
        
    }
    
     public String changePass(){
    
         HttpSession session = Util.getSession();
         
         Boolean result = loginDao.changePass(session.getAttribute("username").toString(), changePassObj.getOldPassowrd(), changePassObj.getNuePassowrd());
          if (result) {

           
            
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Password Change Successfull",
                    "Password changed"));
            
            return "home";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Password!",
                    "Please Try Again!"));
            
             // invalidate session, and redirect to other pages
             //message = "Invalid Login. Please Try Again!";
            return "login";
        }
     
    }
    
    public String cancle(){
        return "home";
    }
}
