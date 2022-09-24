package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.impl.EmployeeDaoImpl;

/**
 * <h1> Employee Service </h1>
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
public class EmployeeService {
    private static int idCount = 0;
    private EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDaoImpl();
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
         return "Employee_0" + (++idCount);   // string only in constants
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
    public boolean createEmployee(User user, String password) {
        String id = generateId();

        if (employeeDao.addEmployee(id, user, password) != null) {
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
    public List<User> displayAll() {
        List<User> employeeList = new ArrayList<>();

        for (Map.Entry<String, User> employeeEntry : managerDao.getAll().entrySet()) {
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
    public User displayById(String id) {
        return employeeeDao.getById(id);
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
     * @return User - Details of a Single Employee
     */
    public User updatedById(String id, User user) {
        if (employeeDao.updateById(id, user) != null) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Delete Details of Employee </h1>
     * <p>
     * Deletes the Details of a Single Employee
     * </p>
     *
     * @param id       - key to Delete the Employee
     *
     * @return boolean - true if the Details of Employee are Deleted otherwise false
     */
    public boolean deleteById(String id) {
        if (employeeDao.deleteById(id) != null) {
            return true;
        }
        return false;
    }
}