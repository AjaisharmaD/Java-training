package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
import com.ideas2it.dao.ManagerDaoImpl;

/**
 * controlls all the operation performed by the Manager
 * like adding employee, updating Employee, viewing lead, searching leads
 * 
 * @author Ajaisharma D
 * @version 1.0  
 * @since 19-09-2022
 */
public class ManagerService {
    private ManagerDaoImpl managerDaoImpl;

    public ManagerService() {
        this.managerDaoImpl = new ManagerDaoImpl();
    }

    /**
     * generates the Id for Employee
     * 
     * @return returns the generated Id
     */
    public String generateId() {
         String prefixId = "Employee_0";
         return prefixId + (++idCount);
     }

    /**
     * Adds the Employee's detail 
     *
     * @param user - user Object to add 
     * @param password - password to login
     * @return returns boolean
     */
    public boolean addEmployee(User user, String password) {
        String id = generateId();
        return managerDaoImpl.addEmployee(id, user, password);
    }

    /**
     * Prints the Employee Details 
     * @return List of Employee details
     */
    public List<User> printEmployee() {
        return managerDaoImpl.printEmployee();
    }

    /**
     * Prints the Employee's Details by Id
     * 
     * @param id - Employee's Id to search the Employee
     * @return Employee object
     */
    public User printEmployeeById(String id) {
        return managerDaoImpl.printEmployeeById(id);
    }

    /**
     * Updates the Name of the Employee
     *
     * @param id - key to update the name
     * @param employeeName - updated name
     * @return boolean
     */
    public boolean editName(String id, String employeeName) {
        return managerDaoImpl.editName(id, employeeName);
    }

    /**
     * Updates the Email id of the Employee
     *
     * @param id - key to update the Email id
     * @param leadEmail - updated mail id
     * @return boolean
     */
    public boolean editEmail(String id, String employeeEmail) {
        return managerDaoImpl.editEmail(id, employeeEmail);
    }

    /**
     * Updates the Phone Number of the Employee
     *
     * @param id - key to update the Phone Number
     * @param leadPhone - updated Phone Number
     * @return boolean
     */
    public boolean editPhone(String id, String employeePhone) {
        return managerDaoImpl.editPhone(id, employeePhone);
    }
}
