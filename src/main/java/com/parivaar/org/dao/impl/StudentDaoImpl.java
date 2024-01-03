/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.dao.impl;

import com.parivaar.org.dao.StudentDao;
import com.parivaar.org.pojo.StudentPojo;
import com.parivaar.org.util.HibernateUtil;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.parivaar.org.hb.entity.Student;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.inject.Named;


/**
 *
 * @author Ravinder Singh
 */
@Named(value = "studentDao")
@Dependent
public class StudentDaoImpl implements StudentDao,Serializable {

    private static Transaction transObj;
    private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<StudentPojo> listStudents() {

        List<StudentPojo> pojos = new ArrayList<>();

        try {
           
            List<Student> studentList = sessionObj.createQuery("from Student", Student.class).list();
          
            for (Student s : studentList) {
                // load the data
                StudentPojo pojo = new StudentPojo();
                pojo.setId(s.getId());
                pojo.setCls(s.getStClass());
                pojo.setSec(s.getStSection());
                pojo.setFirstName(s.getFirstName());
                pojo.setLastName(s.getLastName());
                pojos.add(pojo);

            }
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        }

        return pojos;

    }

}
