package com.ideas2it.model;

public class Opportunity {
    private String id;
    private String name;
    private String accountName;
    private Double amount;
    private String closeDate;
    private String stage;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    } 

    public void setAmount(Double amount) {
       this.amount = amount;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public void setStage(String stage) {
        this.stage = stage;
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

    public Double getAmount(Double amount) {
       return amount;
    }

    public String getColseDate() {
        return closeDate;
    }

    public String getStage() {
        return stage;
    }

    @Override
    public String toString() {
        StringBuilder opportunity = new StringBuilder();
        opportunity.append("\nId                : ").append(id)
                   .append("\nName              : ").append(name)
                   .append("\nAccount Name      : ").append(accountName)
                   .append("\nAmount            : ").append(amount)
                   .append("\nStage             : ").append(stage)
                   .append("\nClosed Date       : ").append(closeDate);
        return opportunity.toString();
    }
}