package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
import com.ideas2it.dao.ManagerDao;
import com.ideas2it.dao.impl.ManagerDaoImpl;

/**
 * controlls all the operation performed by the Manager
 * like adding employee, updating Employee, viewing lead, searching leads
 * 
 * @author Ajaisharma D
 * @version 1.0  
 * @since 19-09-2022
 */
public class ManagerService {
    private static int idCount = 0;
    private ManagerDao managerDao;

    public ManagerService() {
        this.managerDao = new ManagerDaoImpl();
    }

    /**
     * generates the Id for Employee
     * 
     * @return returns the generated Id
     */
    private String generateId() {
         String prefixId = "Employee_0";
         return prefixId + (++idCount);
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
        String id = generateId();
        return managerDao.addEmployee(id, user, password);
    }

    /**
     * Gets the Employee Details 
     *
     * @return List of Employee details
     */
    public List<User> getEmployees() {
        List<User> employeeList = new ArrayList<>();

        for (Map.Entry<String, User> employeeEntry : managerDao.getEmployees().entrySet()) {
            employeeList.add(employeeEntry.getValue());
        } 
        return employeeList;
    }

    /**
     * Gets the Employee's Details by Id
     * 
     * @param id - Employee's Id to search the Employee
     *
     * @return Employee object
     */
    public User getEmployeeById(String id) {
        return managerDao.getEmployeeById(id);
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
        return managerDao.updateName(id, employeeName);
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
        return managerDao.updateEmail(id, employeeEmail);
    }

    /**
     * Updates the Phone Number of the Employee
     *
     * @param id - key to update the Phone Number
     * @param leadPhone - updated Phone Number
     *
     * @return boolean
     */
    public boolean updatePhone(String id, String employeePhone) {
        return managerDao.updatePhone(id, employeePhone);
    }
}
