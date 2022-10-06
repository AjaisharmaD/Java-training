package com.ideas2it.model;

public class Oppertunity {
    private string id;
    private String name;
    private String accountName;
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

    public String getColseDate() {
        return closeDate;
    }

    public String getStage() {
        return stage;
    }
}