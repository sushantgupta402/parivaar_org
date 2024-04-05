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
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.inject.Inject;
 
@Named(value = "loginBean")
@SessionScoped
public class LoginController implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Inject
    private LoginDAOImpl loginDao;
    private String password;
    private String message, uname;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String loginProject() {
        boolean result = loginDao.login(uname, password);
        
          if (result) {

            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname); 
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Login Successfull",
                    "Welcome"));
            
            return "home";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            
             // invalidate session, and redirect to other pages
            
            return "login";
        }

    }
     
    
 
    
    public String cancle(){
        return "home";
    }
 
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "login";
   }
}
