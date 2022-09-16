package com.ideas2it.controller;

import java.util.List; 

import com.ideas2it.model.User;
import com.ideas2it.service.ManagerService;

/**
 * controlls all the operation performed by the Manager
 * like adding employee, updating Employee, viewing lead, searching leads
 * 
 * @author Ajaisharma D
 * @version 1.0  16-09-2022
 */
public class ManagerController {
    ManagerService managerService = new ManagerService();
    
    /**
     * Adds the Employee's detail 
     *
     * @param user - user Object to add 
     * @param password - password to login
     * @return returns boolean
     */
    public boolean addEmployee(User user, String password) {
        return managerService.addEmployee(user, password);
    }

    /**
     * Prints the Employee Details 
     * @return List of Employee details
     */
    public List<User> printEmployee() {
        return managerService.printEmployee();
    }

    /**
     * Prints the Employee's Details by Id
     * 
     * @param id - Employee's Id to search the Employee
     * @return Employee object
     */
    public User printEmployeeById(String id) {
        return managerService.printEmployeeById(id);
    }

    /**
     * Updates the Name of the Employee
     *
     * @param id - key to update the name
     * @param employeeName - updated name
     * @return boolean
     */
    public boolean editName(String id, String employeeName) {
        return managerService.editName(id, employeeName);
    }

    /**
     * Updates the Email id of the Employee
     *
     * @param id - key to update the Email id
     * @param employeeEmail - updated mail id
     * @return boolean
     */
    public boolean editEmail(String id, String employeeEmail) {
        return managerService.editEmail(id, employeeEmail);
    }

    /**
     * Updates the Phone Number of the Employee
     *
     * @param id - key to update the Phone Number
     * @param employeePhone - updated Phone Number
     * @return boolean
     */
    public boolean editPhone(String id, String employeePhone) {
        return managerService.editPhone(id, employeePhone);
    }

    /**
     * Check the user's input to logout from the Manager Dashboard
     *
     * @param logout - key to logout
     * @return returns exit a boolean value 
     */
    public boolean closeManager(byte logout) {
       return managerService.closeManager(logout);
    }
}