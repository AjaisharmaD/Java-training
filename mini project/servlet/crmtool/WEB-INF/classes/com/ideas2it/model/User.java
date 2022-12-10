package com.ideas2it.model;

import java.util.List;
import java.util.ArrayList;

/**
 * <h1> User </h1>
 * <p>
 * User details to be setted and getted
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.1  11-10-2022  
 * @since   07-09-2022
 */   
public class User { 
    private int id;
    private String name;
    private String phoneNumber;
    private String emailId;
    private String password;
    private int roleId;
    private String createdDate;

    private List<Lead> leads = new ArrayList<>();

    public User(String name, String emailId, String phoneNumber) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
 
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setLead(Lead lead) {
        leads.add(lead);
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }
    
    public String getPassword() {
        return password;
    }
 
    public int getRoleId() {
        return roleId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public List<Lead> getLead() {
        return leads;
    }
     
    @Override
    public String toString() {
         StringBuilder user = new StringBuilder();
         user.append(id).append(name).append(emailId)
             .append(phoneNumber).append(createdDate);
         return user.toString();
    }
}