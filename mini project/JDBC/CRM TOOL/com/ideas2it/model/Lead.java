package com.ideas2it.model;

/**
 * <h1> Lead </h1>
 * <p>
 * Lead details to be setted and getted
 * </p>
 *
 * @author  Ajaisharma 
 * @version 1.3 
 * @since   24-08-2022
 */
public class Lead {
    private String id;
    private String name;
    private String phoneNumber;
    private String emailId;
    private String createdDate;
    private String companyName;
    private String status;
    private String userId;

    public Lead(String name, String emailId, String phoneNumber,
                       String companyName, String status, String createdDate, String userId) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.status = status;
        this.createdDate = createdDate;
        this.userId = userId;
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
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName; 
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getStatus() {
        return status;
    }

    public String getCompanyName() {
        return companyName; 
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        StringBuilder lead = new StringBuilder();
        lead.append("ID            : ").append(id)
            .append("\nName          : ").append(name)
            .append("\nEmail ID      : ").append(emailId) 
            .append("\nPhone Number  : ").append(phoneNumber)
            .append("\nCompany Name  : ").append(companyName)
            .append("\nStatus        : ").append(status)
            .append("\nCreated Date  : ").append(createdDate);
       return lead.toString();
    }
}