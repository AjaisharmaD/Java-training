package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.model.Lead;
import com.ideas2it.model.User;

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
    private Map<String, User> employeeMap;

    public EmployeeDaoImpl() {
        this.passwordMap = new HashMap<>();
        this.employeeMap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User addEmployee(String employeeId, User user, String password) {
        user.setId(employeeId);
        user.setPassword(password);
        passwordMap.put(employeeId, password);
        employeeMap.put(employeeId, user);
        return employeeMap.get(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, User> getAll() {
        return employeeMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getById(String id) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.get(id);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateById(String id, User user) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.replace(id, user); 
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User deleteById(String id) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.remove(id);
        }
        return null;
    }
}
