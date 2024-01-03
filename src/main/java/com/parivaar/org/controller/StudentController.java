/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.parivaar.org.controller;

import com.parivaar.org.dao.StudentDao;
import com.parivaar.org.pojo.StudentPojo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Ravinder Singh
 */
@Named(value = "studentController")
@SessionScoped
public class StudentController implements Serializable {

    /**
     * Creates a new instance of StudentController
     */
    
    public StudentController() {
        
    }
    
    @PostConstruct
    public void constructData(){
        lstStudents();
    }
    
    private List<StudentPojo> allStudent;
    
    @Inject
    private StudentDao studentDao;
    
    public void lstStudents(){
        allStudent = studentDao.listStudents();
        //return "studentsList";
    }
    
    public String studentHomeDestination(){
        return "student/studentHome";
    }

    public List<StudentPojo> getAllStudent() {
        return allStudent;
    }

    public void setAllStudent(List<StudentPojo> allStudent) {
        this.allStudent = allStudent;
    }
    
    
    
}
