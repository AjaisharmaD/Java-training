package com.ideas2it.model;

import java.util.List;

//import com.ideas2it.model.Contact;
//import com.ideas2it.model.Opportunity;

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
    private String id;
    private String name;
    private String ownerName;
    private String email;
    private String phoneNumber;
    private String type;

    private List<Contact> contacts; 
    private List<Opportunity> opportunities;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setEmailId(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getEmailId() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    @Override
    public String toString() {
        StringBuilder account = new StringBuilder();
        account.append("Id           :").append(id)
               .append("\nName         :").append(name)
               .append("\nOwner Name   :").append(ownerName)
               .append("\nEmail        :").append(email)
               .append("\nPhone Number :").append(phoneNumber)
               .append("\nType         :").append(type);
        return account.toString();
    }
}