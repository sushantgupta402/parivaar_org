/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.parivaar.org.pojo;

import java.io.Serializable;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Ravinder Singh
 */
@Named(value = "student")
@Dependent
public class StudentPojo implements Serializable {

    /**
     * Creates a new instance of Student
     */
    public StudentPojo() {
        
    }
        private long id;
        private String firstName;
	private String lastName;
	private int cls;
        private String sec;

    public StudentPojo(String firstName, String lastName, int cls, String sec) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cls = cls;
        this.sec = sec;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + Objects.hashCode(this.firstName);
        hash = 19 * hash + Objects.hashCode(this.lastName);
        hash = 19 * hash + Objects.hashCode(this.cls);
        hash = 19 * hash + Objects.hashCode(this.sec);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentPojo other = (StudentPojo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.cls, other.cls)) {
            return false;
        }
        return Objects.equals(this.sec, other.sec);
    }
        
        

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCls() {
        return cls;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }
        
        
	
	
	
}
