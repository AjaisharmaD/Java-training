package com.ideas2it.model;

import com.ideas2it.model.User;

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
    private Double amount;
    private String status;
    private String accountType;
    private String contactTitle;
    private String opportunityStage;
    private String employeeId = "";

    public Lead(String name, String emailId, String phoneNumber,
                       String companyName, String status, String accountType,
                       String contactTitle, String opportunityStage, 
                       Double amount, String createdDate) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.status = status;
        this.accountType = accountType;
        this.contactTitle = contactTitle;
        this.opportunityStage = opportunityStage;
        this.amount = amount;
        this.createdDate = createdDate;
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
    
    public void setStatus(String status) {
        this.status = status;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public void setOpportunityStage(String opportunityStage) {
        this.opportunityStage = opportunityStage;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName; 
    }

    public void setAmount(Double amount) {
       this.amount = amount;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setEmployeeId(String id) {
        this.employeeId = id;
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

    public String getAccountType() {
        return accountType;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getOpportunityStage() {
        return opportunityStage;
    }

    public String getCompanyName() {
        return companyName; 
    }

    public Double getAmount() {
       return amount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getEmployeeId() {
        return employeeId;
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
            .append("\nAccount Type  : ").append(accountType)
            .append("\nContact Title : ").append(contactTitle)
            .append("\nCreated Date  : ").append(createdDate);
       return lead.toString();
    }
}