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
    private String id;
    private String name;
    private String phoneNumber;
    private String emailId;
    private String password;

    private List<Lead> leads;

    public User(String name, String emailId, String phoneNumber) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public void setId(String id) {
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

    public void setLead(Lead lead) {
        leads.add(lead);
    }
   
    public String getId() {
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

    public List<Lead> getLead() {
        return leads;
    }
     
    @Override
    public String toString() {
         StringBuilder user = new StringBuilder();
         user.append("ID            : ").append(id)
             .append("\nName          : ").append(name)
             .append("\nEmail ID      : ").append(emailId) 
             .append("\nPhone Number  : ").append(phoneNumber);
         return user.toString();
    }
}