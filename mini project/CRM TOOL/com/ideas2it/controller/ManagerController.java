package com.ideas2it.controller;

import java.util.List; 

import com.ideas2it.model.User;
import com.ideas2it.service.ManagerService;

/**
 * <h1> Manager Controller </h1>
 * <p>
 * This class will get request and return the responces
 * like Adding, Updating, Viewing, Searching, Deleting
 * the Details of Employee
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   16-09-2022
 */
public class ManagerController {
    private ManagerService managerService;
    
    public ManagerController() {
        this.managerService = new ManagerService();
    }

    /**
     * <h1> Add Employee </h1>
     * <p>
     * Adds the Details of Employees 
     * </p>
     *
     * @param user     - Details of Employee to add 
     * @param password - password to login
     *
     * @return boolean - true if the Details of an employee added otherwise false
     */
    public boolean isEmployeeAdded(User user, String password) {
        return managerService.isEmployeeAdded(user, password);
    }

    /**
     * <h1> Get Details of Employees </h1>
     * <p>
     * Gets the Employee Details 
     * </p>
     *
     * @return List - Details of Employees
     */
    public List<User> getEmployees() {
        return managerService.getEmployees();
    }

    /**
     * <h1> Get Details of Employees by Id </h1>
     * <p>
     * Gets the Details of a Single Employee by Id
     * </p>
     *
     * @param id    - Employee's Id to search the Employee
     *
     * @return User - Details of a Single Employee
     */
    public User getEmployeeById(String id) {
        return managerService.getEmployeeById(id);
    }

    /**
     * <h1> Update Details of Employee </h1>
     * <p>
     * Updates the Details of a Single Employee
     * </p>
     *
     * @param id       - key to update the Details of Employees
     * @param user     - updated Details of Employees
     *
     * @return boolean - true if the Details of Employee are updated otherwise false
     */
    public boolean isEmployeeUpdated(String id, User user) {
        return managerService.isEmployeeUpdated(id, user);
    }
}
