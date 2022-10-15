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
    private String id;
    private String name;
    private String accountName;
    private String email;
    private String phoneNumber;
    private String title;
    private String userId;

    List<Opportunity> opportunities = new ArrayList<>(); 

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    } 

    public void setEmailId(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOpportunity(Opportunity opportunity) {
        opportunities.add(opportunity);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getEmailId() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    } 

    public String getTitle() {
        return title;
    }

    public List<Opportunity> getOpportunity() {
        return opportunities;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        StringBuilder contact = new StringBuilder();
        contact.append("\nName             :").append(name)
               .append("\nAccount Name     :").append(accountName)
               .append("\nEmail            :").append(email)
               .append("\nPhone Number     :").append(phoneNumber)
               .append("\nTitle            :").append(title);
        return contact.toString();
    }
}