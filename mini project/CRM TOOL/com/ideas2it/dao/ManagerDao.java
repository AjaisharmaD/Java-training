package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.User;

/**
 * Contains all the methods to be Implemented
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 19-09-2022
 */
public interface ManagerDao {

    /**
     * Adds the Employee's detail 
     *
     * @param employeeId - Id of a employee 
     * @param user - user Object to add 
     * @param password - password to login
     *
     * @return returns boolean
     */
    public boolean addEmployee(String employeeId, User user, String password);

    /**
     * Gets the Employee Details 
     *
     * @return List of Employee details
     */
    public Map<String, User> getEmployees();

    /**
     * Gets the Employee's Details by Id
     * 
     * @param id - Employee's Id to search the Employee
     *
     * @return Employee object
     */
    public User getEmployeeById(String id);

    /**
     * Updates the Name of the Employee
     *
     * @param id - key to update the name
     * @param employeeName - updated name
     *
     * @return boolean
     */
    public boolean updateName(String id, String employeeName);

    /**
     * Updates the Email id of the Employee
     *
     * @param id - key to update the Email id
     * @param leadEmail - updated mail id
     *
     * @return boolean
     */
    public boolean updateEmail(String id, String employeeEmail);

    /**
     * Updates the Phone Number of the Employee
     *
     * @param id - key to update the Phone Number
     * @param leadPhone - updated Phone Number
     *
     * @return boolean
     */
    public boolean updatePhoneNumber(String id, String employeePhone);

}
