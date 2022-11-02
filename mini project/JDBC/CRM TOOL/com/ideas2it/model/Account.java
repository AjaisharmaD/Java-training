package com.ideas2it.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1> Account </h1>
 * <p>
 * Account details to be setted and getted
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0  
 * @since   03-10-2022
 */   
public class Account {
    private int id;
    private String name;
    private String website;
    private String type;
    private int userId;

    public Account(String name, String website, String type) {
        this.name = name;
        this.website = website;
        this.type = type;
    }

    private List<Contact> contacts = new ArrayList<>(); 
    private List<Opportunity> opportunities = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunities.add(opportunity);
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

    public String getWebsite() {
        return website;
    }

    public String getType() {
        return type;
    }

    public List<Contact> getContact() {
        return contacts;
    }

    public List<Opportunity> getOpportunity() {
        return opportunities;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        StringBuilder account = new StringBuilder();
        account.append("\nId           :").append(id)
               .append("\nName         :").append(name)
               .append("\nWebsite      :").append(website)
               .append("\nType         :").append(type);
        return account.toString();
    }
}