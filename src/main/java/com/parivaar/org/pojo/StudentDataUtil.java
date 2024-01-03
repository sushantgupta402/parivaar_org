/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.parivaar.org.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Ravinder Singh
 */

@Named(value = "studentDataUtil")

@ApplicationScoped
public class StudentDataUtil {

  private String user;
	private String password;

	private List<StudentPojo> students;
	
	public StudentDataUtil() {
		loadSampleData();
	}
	
	public void loadSampleData() {
		students = new ArrayList<>();
		
		students.add(new StudentPojo("Mary", "Public", 1,"A"));
		students.add(new StudentPojo("John", "Doe", 1,"A"));
		students.add(new StudentPojo("Ajay", "Rao", 1,"A"));
	}

	public List<StudentPojo> getStudents() {
		return students;
	}
	
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String doLogin() {
		return "newTemplateClient";
	}

	public void loadStudents() {
		System.out.println("Load student clicked");
		//return "";
	}
	
	public void primefacesButton(){
		System.out.println("Primefaces Button clicked");
		//return "";
	}
}
