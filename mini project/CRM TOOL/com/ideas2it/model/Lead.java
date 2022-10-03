package com.ideas2it.model;

/**
 * Sets and gets the value for the attributes
 *
 * @author Ajaisharma 
 * @version 1.2 
 * @since 24-08-2022
 */
public class Lead extends Employee {
    private String startDate;
    private String companyName;
    private String status;

    public Lead(String name, String emailId, String phoneNumber,
                String status, String companyName, String startDate) {
        super(name, emailId, phoneNumber);
        this.status =  status;
        this.companyName = companyName;
        this.startDate = startDate;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName; 
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }
    
    public String getCompanyName() {
        return companyName; 
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        StringBuilder leadResponder = new StringBuilder();
        leadResponder.append(super.toString())
                     .append("\nStatus        : ").append(status)                                            
                     .append("\nCompany Name  : ").append(companyName)
                     .append("\nStart Date    : ").append(startDate)
                     .append("\n----------------------------------------\n");
       return leadResponder.toString();
    }
}