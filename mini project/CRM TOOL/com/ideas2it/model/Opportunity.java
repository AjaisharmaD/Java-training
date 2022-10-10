package com.ideas2it.model;

public class Opportunity {
    private String id;
    private String name;
    private String accountName;
    private Double amount;
    private String closedDate;
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

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
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

    public String getColsedDate() {
        return closedDate;
    }

    public String getStage() {
        return stage;
    }

    @Override
    public String toString() {
        StringBuilder opportunity = new StringBuilder();
        opportunity.append("Id                : ").append(id)
                   .append("\nName              : ").append(name)
                   .append("\nAccount Name      : ").append(accountName)
                   .append("\nAmount            : ").append(amount)
                   .append("\nStage             : ").append(stage)
                   .append("\nClosed Date       : ").append(closedDate);
        return opportunity.toString();
    }
}