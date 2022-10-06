package com.ideas2it.model;

public class Contact {
    private String id;
    private String name;
    private String accountName;
    private String email;
    private String phoneNumber;
    private String title;

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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    } 

    public String getTitle() {
        return title;
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