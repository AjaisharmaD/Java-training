package com.ideas2it.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
import com.ideas2it.model.User;

/**
 * controlls all the operation performed by the Manager
 * like adding employee, updating Employee, viewing lead, searching leads
 * 
 * @author Ajaisharma D
 * @version 1.0  16-09-2022
 */
public class ManagerService {
    private final static byte LOGOUT = 1;
    private User user;
    private Lead lead;
    private int idCount = 0;
    private Map<String, String> passwordMap = new HashMap<>();
    private Map<String, User> employeeMap = new HashMap<>();

    /**
     * generates the Id for Lead
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
        String employeeId =  generateId();
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
     * Prints the Employee Details 
     * @return List of Employee details
     */
    public List<User> printEmployee() {
        List<User> employeeList = new ArrayList<>();
        for (Map.Entry<String, User> employeeEntry : employeeMap.entrySet()) {
            employeeList.add(employeeEntry.getValue());
        } 
        return employeeList;
    }

    /**
     * Prints the Employee's Details by Id
     * 
     * @param id - Employee's Id to search the Employee
     * @return Employee object
     */
    public User printEmployeeById(String id) {
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
     * @return boolean
     */
    public boolean editName(String id, String employeeName) {
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
     * @return boolean
     */
    public boolean editEmail(String id, String employeeEmail) {
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
     * @param leadPhone - updated Phone Number
     * @return boolean
     */
    public boolean editPhone(String id, String employeePhone) {
        if (employeeMap.containsKey(id)) {
            employeeMap.get(id).setPhoneNumber(employeePhone);
            return true;
        }
        return false;
    }

    /**
     * Check the user's input to logout from the Manager Dashboard
     *
     * @param logout - key to logout
     * @return returns exit a boolean value 
     */
    public boolean closeManager(byte logout) {
        boolean exit = (logout == LOGOUT) ? false : true ; 
        return exit;
    }
}