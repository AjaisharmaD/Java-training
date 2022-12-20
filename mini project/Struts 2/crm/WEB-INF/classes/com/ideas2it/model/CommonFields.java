package com.ideas2it.model;

/**
 * <h1> User </h1>
 * <p>
 * User details to be setted and getted
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0  25-11-2022  
 * @since   25-11-2022
 */   
public class CommonFields {
    private int id;
    private String name;
    private String createdDate;

    public void setId(int id) {
        this.id = id;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public void setcreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    @override
    public String toString() {
        StringBuilder common = new StringBuilder();
        common.append(id).append(name).append(createdDate);
        return common.toString();
    }
}