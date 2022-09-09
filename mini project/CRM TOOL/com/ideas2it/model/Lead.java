package com.ideas2it.model;

/**
 * sets and gets the value for the attributes
 *
 * @author Ajaisharma 
 * @version 1.0 24-08-2022
 */
public class Lead extends Employee {
    private String id;
    private int dealSize;
    private String startDate;
    private String endDate;
    private String companyName;
    private String stage;

    public Lead(String id, String name, String emailId, 
                    String phoneNumber, String stage, String companyName, 
                    String startDate, String endDate, int dealSize) {
        super(name, emailId, phoneNumber);
        this.id = id;
        this.stage =  stage;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealSize = dealSize;
    }
    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setStage(String stage) {
        this.stage = stage;
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

    public void setDealSize(int dealSize) {
        this.dealSize = dealSize;
    }
    // getter
    public String getId() {
        return id;
    }

    public String getStage() {
        return stage;
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

    public int getDealSize() {
        return dealSize;
    }
    
    @Override
    public String toString() {
        String leadResponder = "ID            : " + id
                                + super.toString()
                                + "\nStage         : " + stage                                            
                                + "\nCompany Name  : " + companyName
                                + "\nStart Date    : " + startDate
                                + "\nEnd Date      : " + endDate
                                + "\nDeal Size     : " + dealSize
                                + "\n----------------------------------------\n";
       return leadResponder;
    }
}
