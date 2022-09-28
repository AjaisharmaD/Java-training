package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.model.Employee;

/**
 * <h1> Employee DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Employees
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   19-09-2022
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private Map<String, String> passwordMap;
    private Map<String, Employee> employeeMap;

    public EmployeeDaoImpl() {
        this.passwordMap = new HashMap<>();
        this.employeeMap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee add(String employeeId, Employee employee, String password) {
        employee.setId(employeeId);
        employee.setPassword(password);
        passwordMap.put(employeeId, password);
        employeeMap.put(employeeId, employee);
        return employeeMap.get(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Employee> getAll() {
        return employeeMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee getById(String id) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.get(id);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee updateById(String id, Employee employee) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.replace(id, employee); 
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee deleteById(String id) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.remove(id);
        }
        return null;
    }
}