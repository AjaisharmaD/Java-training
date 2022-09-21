package com.ideas2it.controller;

import java.util.List; 

import com.ideas2it.model.User;
import com.ideas2it.service.ManagerService;

/**
 * Controlls all the operation performed by the Manager
 * like adding employee, updating Employee, viewing lead, searching leads
 * 
 * @author AJAISHARMA
 * @version 1.0
 * @since 16-09-2022
 */
public class ManagerController {
    private ManagerService managerService;
    
    public ManagerController() {
        this.managerService = new ManagerService();
    }

    /**
     * Adds the Employee's detail 
     *
     * @param user - user Object to add 
     * @param password - password to login
     *
     * @return returns boolean
     */
    public boolean addEmployee(User user, String password) {
        return managerService.addEmployee(user, password);
    }

    /**
     * Prints the Employee Details 
     *
     * @return List of Employee details
     */
    public List<User> getEmployees() {
        return managerService.getEmployees();
    }

    /**
     * Prints the Employee's Details by Id
     * 
     * @param id - Employee's Id to search the Employee
     *
     * @return Employee object
     */
    public User getEmployeeById(String id) {
        return managerService.getEmployeeById(id);
    }

    /**
     * Updates the Name of the Employee
     *
     * @param id - key to update the name
     * @param employeeName - updated name
     *
     * @return boolean
     */
    public boolean updateName(String id, String employeeName) {
        return managerService.updateName(id, employeeName);
    }

    /**
     * Updates the Email id of the Employee
     *
     * @param id - key to update the Email id
     * @param employeeEmail - updated mail id
     *
     * @return boolean
     */
    public boolean updateEmail(String id, String employeeEmail) {
        return managerService.updateEmail(id, employeeEmail);
    }

    /**
     * Updates the Phone Number of the Employee
     *
     * @param id - key to update the Phone Number
     * @param employeePhone - updated Phone Number
     *
     * @return boolean
     */
    public boolean updatePhoneNumber(String id, String employeePhoneNumber) {
        return managerService.updatePhoneNumber(id, employeePhoneNumber);
    }
}
