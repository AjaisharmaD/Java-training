package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
import com.ideas2it.dao.ManagerDao;
import com.ideas2it.dao.impl.ManagerDaoImpl;

/**
 * <h1> Manager Service </h1>
 * <p>
 * This class will get the Request and process the operatioin to be done
 * like adding, Viewing, Updating, Deleting
 * the Details of  Employees
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.0  
 * @since   19-09-2022
 */
public class ManagerService {
    private static int idCount = 0;
    private ManagerDao managerDao;

    public ManagerService() {
        this.managerDao = new ManagerDaoImpl();
    }

    /**
     * <h1> Id generator </h1>
     * <p>
     * Generates the Id for Employee
     * </p>
     * 
     * @return String - generated Id
     */
    private String generateId() {
         String prefixId = "Employee_0";
         return prefixId + (++idCount);
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
        String id = generateId();

        if (managerDao.addEmployee(id, user, password) != null) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Get Details of Employees </h1>
     * <p>
     * Gets the Details of all Employees
     * </p>
     *
     * @return List - Details of employees
     */
    public List<User> getEmployees() {
        List<User> employeeList = new ArrayList<>();

        for (Map.Entry<String, User> employeeEntry : managerDao.getEmployees().entrySet()) {
            employeeList.add(employeeEntry.getValue());
        } 
        return employeeList;
    }

    /**
     * <h1> Get Details of Employee by Id </h1>
     * <p>
     * Gets the Details of a Single Employee by Id
     * </p>
     * 
     * @param id    - Employee's Id to search the Details of Employee
     *
     * @return User - Details of a Single Employee
     */
    public User getEmployeeById(String id) {
        return managerDao.getEmployeeById(id);
    }

    /**
     * <h1> Update Details of Employee </h1>
     * <p>
     * Updates the Details of a Single Employee
     * </p>
     *
     * @param id       - key to update the Details of Employee
     * @param user     - updated Employee Details
     *
     * @return boolean - true if the Details of Employee are updated otherwise false
     */
    public boolean isEmployeeUpdated(String id, User user) {
        if (managerDao.updateEmployee(id, user) != null) {
            return true;
        }
        return false;
    }
}
