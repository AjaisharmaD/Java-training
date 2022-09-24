package com.ideas2it.controller;

import java.util.List; 

import com.ideas2it.model.User;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.utils.ValidationUtils;

/**
 * <h1> Employee Controller </h1>
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
public class EmployeeController {
    private EmployeeService employeeService;
    private ValidationUtils validationUtils;
    
    public ManagerController() {
        this.employeeService = new EmployeeService();
        this.validationUtils = new ValidationUtils();
    }

    /**
     * <h1> Create Employee </h1>
     * <p>
     * Adds the Details of Employees 
     * </p>
     *
     * @param user     - Details of Employee to add 
     * @param password - password to login
     *
     * @return User - Details of a Single Employee
     */
    public User createEmployee(User user, String password) {
        return employeeService.createEmployee(user, password);
    }

    /**
     * <h1> Get Details of Employees </h1>
     * <p>
     * Gets the Employee Details 
     * </p>
     *
     * @return List - Details of Employees
     */
    public List<User> displayAll() {
        return employeeService.display();
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
    public User displayById(String id) {
        return employeeService.displayById(id);
    }

    /**
     * <h1> Update Details of Employee </h1>
     * <p>
     * Updates the Details of a Single Employee
     * </p>
     *
     * @param id    - key to update the Details of Employees
     * @param user  - updated Details of Employees
     *
     * @return User - Updated details of a Single Employee
     */
    public User updateById(String id, User user) {
        return employeeService.updateById(id, user);
    }

    /**
     * <h1> Remove Details of Employee by Id</h1>
     * <p>
     * Removes the Details of a Single Employee
     * </p>
     *
     * @param id       - key to remove the Employee
     *
     * @return boolean - true if the Details of Employee are Removed otherwise false
     */
    public boolean deleteById(String id) {
        return employeeService.deleteById(id);
    }

    /**
     * <h1> Valid Name </h1>
     * <p>
     * This method will get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of Employee  
     * @return boolean - true if the Name is valid otherwise false
     */
    public boolean isValidName(String name) {
        if (validationUtils.isValidName(name)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Email </h1>
     * <p>
     * This method will get the Email and checks whether the given Email is valid or not
     * </p>
     *
     * @param email    - Email of Employee 
     * @return boolean - true if the Email is valid otherwise false
     */
    public boolean isValidEmail(String email) {
        if (validationUtils.isValidEmail(email)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Phone Number </h1>
     * <p>
     * This method will get the Phone Number and checks whether the given Phone Number is valid or not
     * </p>
     *
     * @param phoneNumber - Phone Number of Employee  
     * @return boolean    - true if the Phone Number is valid otherwise false
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        if (validationUtils.isValidPhoneNumber(phoneNumber)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Password </h1>
     * <p>
     * This method will get the Password and checks whether the given Password is valid or not
     * </p>
     *
     * @param password - Company Name of Employee  
     * @return boolean - true if the Company Name is valid otherwise false
     */
    public boolean isValidPassword(String password) {
        if (validationUtils.isValidPassword(password)) {
            return true;
        }
        return false;
    }
}