package com.ideas2it.model;

/**
 * Common details are set and get from here
 *
 * @author Ajaisharma D
 * @version 1.0  07-09-2022
 *
 */   
public class User { 
    private String id;
    private String name;
    private String phoneNumber;
    private String emailId;
    private String password;

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
     
    @Override
    public String toString() {
         StringBuilder commonResponder = new StringBuilder();
         commonResponder.append("\nID            : ").append(id)
                        .append("\nName          : ").append(name)
                        .append("\nEmail ID      : ").append(emailId) 
                        .append("\nPhone Number  : ").append(phoneNumber);
         return commonResponder.toString();
    }
}
