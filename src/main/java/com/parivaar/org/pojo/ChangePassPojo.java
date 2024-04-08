/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.pojo;

import java.io.Serializable;

/**
 *
 * @author Anish
 */
public class ChangePassPojo implements Serializable{
    
    String oldPassowrd;
    String nuePassowrd;

    public ChangePassPojo(String oldPassowrd, String nuePassowrd) {
        this.oldPassowrd = oldPassowrd;
        this.nuePassowrd = nuePassowrd;
    }

    public ChangePassPojo() {
    }

    public String getOldPassowrd() {
        return oldPassowrd;
    }

    public void setOldPassowrd(String oldPassowrd) {
        this.oldPassowrd = oldPassowrd;
    }

    public String getNuePassowrd() {
        return nuePassowrd;
    }

    public void setNuePassowrd(String nuePassowrd) {
        this.nuePassowrd = nuePassowrd;
    }
    
    
}
