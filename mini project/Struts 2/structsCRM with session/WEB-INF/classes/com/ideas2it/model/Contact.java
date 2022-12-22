package com.ideas2it.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1> Contact </h1>
 * <p>
 * Contact details to be setted and getted
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0  
 * @since   05-10-2022
 */   
public class Contact {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private int accountId;
    private String accountName;
    private int userId;

    public Contact(String name, String email, String phoneNumber, String accountName, String role) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountName = accountName;
        this.role = role;
    }
    
    List<Opportunity> opportunities = new ArrayList<>(); 

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setOpportunity(Opportunity opportunity) {
        opportunities.add(opportunity);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    } 

    public String getAccountName() {
        return accountName;
    }

    public String getRole() {
        return role;
    }

    public int getAccountId() {
        return accountId;
    }

    public List<Opportunity> getOpportunity() {
        return opportunities;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        StringBuilder contact = new StringBuilder();
        contact.append("\nName             :").append(name)
               .append("\nEmail            :").append(email)
               .append("\nPhone Number     :").append(phoneNumber)
               .append("\nRole             :").append(role);
        return contact.toString();
    }
}