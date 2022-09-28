package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.impl.EmployeeDaoImpl;
import com.ideas2it.model.Employee;

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
         return Constants.EMPLOYEE_ID + (++idCount);   
     }

    /**
     * <h1> Add Employee </h1>
     * <p>
     * Adds the Details of Employees 
     * </p>
     *
     * @param employee     - Details of Employee to add 
     * @param password - password to login
     *
     * @return boolean - true if the Details of an employee added otherwise false
     */
    public Employee create(Employee employee, String password) {
        return employeeDao.add(generateId(), employee, password);
    }

    /**
     * <h1> Get Details of Employees </h1>
     * <p>
     * Gets the Details of all Employees
     * </p>
     *
     * @return List - Details of employees
     */
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();

        for (Map.Entry<String, Employee> employeeEntry : employeeDao.getAll().entrySet()) {
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
     * @param id        - Employee's Id to search the Details of Employee
     *
     * @return employee - Details of a Single Employee
     */
    public Employee getById(String id) {
        return employeeDao.getById(id);
    }

    /**
     * <h1> Update Details of Employee </h1>
     * <p>
     * Updates the Details of a Single Employee
     * </p>
     *
     * @param id        - key to update the Details of Employee
     * @param employee  - updated Employee Details
     *
     * @return Employee - Details of a Single Employee
     */
    public Employee updateById(String id, Employee employee) {
        return employeeDao.updateById(id, employee);
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