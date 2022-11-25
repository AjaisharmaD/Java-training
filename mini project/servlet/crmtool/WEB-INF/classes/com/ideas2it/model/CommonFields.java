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
    private boolean isDeleted;

    public void setId(int id) {
        this.id = id;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @override
    public String toString() {
        StringBuilder common = new StringBuilder();
        common.append(id).append(name).append(isDeleted);
        return common.toString();
    }
}