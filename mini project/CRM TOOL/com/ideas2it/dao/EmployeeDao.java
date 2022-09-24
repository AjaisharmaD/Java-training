package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.User;

/**
 * <h1> Employee DAO </h1>
 * <p>
 * This class will get the request and performs the operations
 * like Adding, Viewing, Updating, Deleting the Details of Employees
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   19-09-2022
 */
public interface EmployeeDao {

    /**
     * <h1> Add Employee </h1>
     * <p>
     * Adds the Details of Employees 
     * <p>
     *
     * @param employeeId - ID of an employee
     * @param user       - user Details to add 
     * @param password   - password to login
     *
     * @return User      - Details of an Employee
     */
    public User addEmployee(String employeeId, User user, String password);

    /**
     * <h1> Get Details of Employees </h1>
     * <p>
     * Gets the Details of Employees  
     * </p>
     *
     * @return Map - Details of Employees
     */
    public Map<String, User> getAll();

    /**
     * <h1> Get Details of Employee by Id </h1>
     * <p>
     * Gets the Details of Employees by Id
     * </p>
     * 
     * @param id    - Employee's Id to search the Details of Employee
     *
     * @return User - Details of a Single Employee
     */
    public User getById(String id);

    /**
     * <h1> Update Details of Employee </h1>
     * <p>
     * Updates the Details of Employees 
     * </p>
     *
     * @param id    - key to store the Updated Details of Employee
     * @param user  - updated Details of Employee
     *
     * @return User - updated Details of Employee
     */
    public User updateById(String id, User user);

    /**
     * <h1> Delete Details of Employee </h1>
     * <p>
     * Deletes the Details of Employee 
     * </p>
     *
     * @param id    - key to Delete the Details of Employee
     *
     * @return User - Deleted Details of Employee
     */
    public User deleteById(String id);
}