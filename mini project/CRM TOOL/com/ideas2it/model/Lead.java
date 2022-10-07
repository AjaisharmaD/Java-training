package com.ideas2it.model;

/**
 * Sets and gets the value for the attributes
 *
 * @author  Ajaisharma 
 * @version 1.3 
 * @since   24-08-2022
 */
public class Lead extends Employee {
    private String startDate;
    private String companyName;
    private Double amount;
    private String status;
    private String accountType;
    private String contactTitle;
    private String opportunityStage;

    public Lead(String name, String emailId, String phoneNumber,
                String status, String accountType, String contactTitle, String companyName, String opportunityStage, Double amount, String startDate) {
        super(name, emailId, phoneNumber);
        this.status =  status;
        this.accountType = accountType;
        this.contactTitle = contactTitle;
        this.companyName = companyName;
        this.opportunityStage = opportunityStage;
        this.amount = amount;
        this.startDate = startDate;
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        StringBuilder lead = new StringBuilder();
        lead.append(super.toString())                                            
            .append("\nCompany Name  : ").append(companyName)
            .append("\nStatus        : ").append(status)     
            .append("\nAccount Type  : ").append(accountType)
            .append("\nContact Title : ").append(contactTitle)
            .append("\nStart Date    : ").append(startDate);
       return lead.toString();
    }
}