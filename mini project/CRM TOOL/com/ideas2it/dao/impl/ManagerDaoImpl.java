package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.ManagerDao;
import com.ideas2it.model.Lead;
import com.ideas2it.model.User;

/**
 * Stores and fetch the data from the Collection Storage
 * and the Implementation of abstract Methods goes here
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 19-09-2022
 */
public class ManagerDaoImpl implements ManagerDao {
    private User user;
    private int idCount = 0;
    private Map<String, String> passwordMap;
    private Map<String, User> employeeMap;

    public ManagerDaoImpl() {
        this.passwordMap = new HashMap<>();
        this.employeeMap = new HashMap<>();
    }

    /**
     * Adds the Employee's detail 
     *
     * @param user - user Object to add 
     * @param password - password to login
     *
     * @return returns boolean
     */
    public boolean addEmployee(String employeeId, User user, String password) {
        user.setId(employeeId);
        user.setPassword(password);

        passwordMap.put(employeeId, password);
        employeeMap.put(employeeId, user);

        if (employeeMap.containsKey(employeeId)) {
            return true;
        }
        return false;
    }

    /**
     * Gets the Employees Details 
     *
     * @return List of Employee details
     */
    public Map<String, User> getEmployees() {
        return employeeMap;
    }

    /**
     * Gets the Employee's Details by Id
     * 
     * @param id - Employee's Id to search the Employee
     *
     * @return Employee object
     */
    public User getEmployeeById(String id) {
        User user = null;

        if (employeeMap.containsKey(id)) {
            user = employeeMap.get(id);
        }
        return user;
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
        if (employeeMap.containsKey(id)) {
            employeeMap.get(id).setName(employeeName);
            return true;
        }
        return false;
    }

    /**
     * Updates the Email id of the Employee
     *
     * @param id - key to update the Email id
     * @param leadEmail - updated mail id
     *
     * @return boolean
     */
    public boolean updateEmail(String id, String employeeEmail) {
        if (employeeMap.containsKey(id)) {
            employeeMap.get(id).setEmailId(employeeEmail);
            return true;
        }
        return false;
    }

    /**
     * Updates the Phone Number of the Employee
     *
     * @param id - key to update the Phone Number
     * @param leadPhoneNumber - updated Phone Number
     *
     * @return boolean
     */
    public boolean updatePhoneNumber(String id, String employeePhoneNumber) {
        if (employeeMap.containsKey(id)) {
            employeeMap.get(id).setPhoneNumber(employeePhoneNumber);
            return true;
        }
        return false;
    }
}