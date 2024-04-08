/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.hb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;
/**
 *
 * @author Anish
 */
@Entity
@Table(name = "user")
public class User {
    
       
    @Id
    @Column(name = "userid")
	private String userId;
      @Column(name = "password")
	private String password;
      @Column(name = "first_name")
      private String firstName;
      
      @Column(name = "middle_name")
      private String middleName;
      
       @Column(name = "last_name")
       private String lastName;
       
        @Column(name = "gender")
        private String gender;
        
         @Column(name = "dob")
         private Date dateOfBirth;
         
          @Column(name = "branch")
          private String branch;
          
           @Column(name = "department")
           private String department;
           
            @Column(name = "degination")
            private String degination;
            @Column(name = "permanent_address")
            private String permanentAddress;
            
           @Column(name = "current_address")
            private String currentAddress;
            @Column(name = "mailing_address")
            private String mailingAddress;
             @Column(name = "primary_contact")
            private Long primaryContact;
              @Column(name = "secondary_contact")
            private Long secondaryContact;
               @Column(name = "pan_no")
            private String panNo;
                @Column(name = "aadhaar_no")
            private Long aadhaar_no;
                @Column(name = "passport_no")
            private String passportNo;
                
                 @Column(name = "role")
            private String role;
            
                 @Column(name = "active_status")
            private Boolean activeStatus;
      
                  @Column(name = "active_from")
            private Date activeFrom;
                  @Column(name = "active_till")
            private Date activeTill;
       @Column(name = "last_login_ts")
	private Timestamp lastLoginTs; 

    public User(String userId, String password, String firstName, String middleName, String lastName, String gender, Date dateOfBirth, String branch, String department, String degination, String permanentAddress, String currentAddress, String mailingAddress, Long primaryContact, Long secondaryContact, String panNo, Long aadhaar_no, String passportNo, String role, Boolean status, Date activeFrom, Date activeTill, Timestamp lastLoginTs) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.branch = branch;
        this.department = department;
        this.degination = degination;
        this.permanentAddress = permanentAddress;
        this.currentAddress = currentAddress;
        this.mailingAddress = mailingAddress;
        this.primaryContact = primaryContact;
        this.secondaryContact = secondaryContact;
        this.panNo = panNo;
        this.aadhaar_no = aadhaar_no;
        this.passportNo = passportNo;
        this.role = role;
        this.activeStatus = status;
        this.activeFrom = activeFrom;
        this.activeTill = activeTill;
        this.lastLoginTs = lastLoginTs;
    }

    public User() {
    }
    
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegination() {
        return degination;
    }

    public void setDegination(String degination) {
        this.degination = degination;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Long getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(Long primaryContact) {
        this.primaryContact = primaryContact;
    }

    public Long getSecondaryContact() {
        return secondaryContact;
    }

    public void setSecondaryContact(Long secondaryContact) {
        this.secondaryContact = secondaryContact;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public Long getAadhaar_no() {
        return aadhaar_no;
    }

    public void setAadhaar_no(Long aadhaar_no) {
        this.aadhaar_no = aadhaar_no;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    public Date getActiveTill() {
        return activeTill;
    }

    public void setActiveTill(Date activeTill) {
        this.activeTill = activeTill;
    }

    public Timestamp getLastLoginTs() {
        return lastLoginTs;
    }

    public void setLastLoginTs(Timestamp lastLoginTs) {
        this.lastLoginTs = lastLoginTs;
    }
       
       
}
