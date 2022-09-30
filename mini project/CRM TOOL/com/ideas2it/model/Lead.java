package com.ideas2it.model;

/**
 * Sets and gets the value for the attributes
 *
 * @author Ajaisharma 
 * @version 1.0 
 * @since 24-08-2022
 */
public class Lead extends Employee {
    private Double dealCost;
    private String startDate;
    private String endDate;
    private String companyName;
    private String status;

    public Lead(String name, String emailId, 
                    String phoneNumber, String status, String companyName, 
                    String startDate, String endDate, Double dealCost) {
        super(name, emailId, phoneNumber);
        this.status =  status;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealCost = dealCost;
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

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;
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

    public String getEndDate() {
        return endDate;
    }

    public Double getDealCost() {
        return dealCost;
    }
    
    @Override
    public String toString() {
        StringBuilder leadResponder = new StringBuilder();
        leadResponder.append(super.toString())
                     .append("\nStatus         : ").append(status)                                            
                     .append("\nCompany Name  : ").append(companyName)
                     .append("\nStart Date    : ").append(startDate)
                     .append("\nEnd Date      : ").append(endDate)
                     .append("\nDeal Size     : ").append(dealCost)
                     .append("\n----------------------------------------\n");
       return leadResponder.toString();
    }
}