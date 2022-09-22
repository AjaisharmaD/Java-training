package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.ManagerDao;
import com.ideas2it.model.Lead;
import com.ideas2it.model.User;

/**
 * <h1> Manager DAO Impl </h1>
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
public class ManagerDaoImpl implements ManagerDao {
    private User user;
    private Map<String, String> passwordMap;
    private Map<String, User> employeeMap;

    public ManagerDaoImpl() {
        this.passwordMap = new HashMap<>();
        this.employeeMap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will store the Details of Employee to employeeMap
     * </p>
     */
    @Override
    public User addEmployee(String employeeId, User user, String password) {
        user.setId(employeeId);
        user.setPassword(password);

        passwordMap.put(employeeId, password);
        employeeMap.put(employeeId, user);

        return user;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will fetch the data of Employees from the employeeMap
     * </p>
     */
    @Override
    public Map<String, User> getEmployees() {
        return employeeMap;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will fetch the data of Employee from the employeeMap
     * </p>
     */
    @Override
    public User getEmployeeById(String id) {
        User user = null;

        if (employeeMap.containsKey(id)) {
            user = employeeMap.get(id);
        }
        return user;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will replace the data of Employees in the employeeMap
     * </p>
     */
    @Override
    public User updateEmployee(String id, User user) {
        User updatedEmployee = null;
        if (employeeMap.containsKey(id)) {
            updatedEmployee = employeeMap.replace(id, user); 
        }
        return updatedEmployee;
    }
}
