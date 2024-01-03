/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parivaar.org.dao;

import com.parivaar.org.pojo.StudentPojo;
import java.util.List;

/**
 *
 * @author Ravinder Singh
 */
public interface StudentDao {
   
    public List<StudentPojo> listStudents();
}
