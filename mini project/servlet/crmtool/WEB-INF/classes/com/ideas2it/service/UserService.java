package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.User;
import com.ideas2it.exception.CustomException;

/**
 * <h1> User Service </h1>
 * <p>
 * This class will get the Request and process the operatioin to be done
 * like adding, Viewing, Updating, Deleting
 * the Details of  Users
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.0  
 * @since   19-09-2022
 */
public interface UserService {
    
    /**
     * <h1> Add User </h1>
     * <p>
     * Adds the Details of Users 
     * </p>
     *
     * @param user     - Details of User to add 
     * @param password - password to login
     *
     * @return boolean - status of the user 
     */
    public boolean create(User user);

    /**
     * <h1> Get Details of Users </h1>
     * <p>
     * Gets the Details of all Users
     * </p>
     *
     * @return List - Details of users
     */
    public List<User> getAll(int roleId) throws CustomException;

    /**
     * <h1> Get the User Roles </h1>
     * <p> 
     * Gets the List of the User role
     * </p>
     * 
     * @return List<String> - a List of Role String
     */
    public List<String> getRoles();

    /**
     * <h1> Get the user by Email and password </h1>
     * <p> 
     * Gets the user Details by Email and Password 
     * and passes it to Validate the User is valid or not
     * </p>
     * 
     * @param email - email Id of the User
     * @param password - password of the User
     *
     * @return User - Details of the User
     */
    public User getByEmailAndPassword(String email, String password);

    /**
     * <h1> Get Details of User by Id </h1>
     * <p>
     * Gets the Details of a Single User by Id
     * </p>
     * 
     * @param id    - User's Id to search the Details of User
     *
     * @return user - Details of a Single User
     */
    public User getById(int id) throws CustomException;

    /**
     * <h1> Update Details of User </h1>
     * <p>
     * Updates the Details of a Single User
     * </p>
     *
     * @param id          - User id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return boolean - status of the id
     */
    public boolean updateById(User user);

    /**
     * <h1> Delete Details of User </h1>
     * <p>
     * Deletes the Details of a Single User
     * </p>
     *
     * @param id       - key to Delete the User
     *
     * @return boolean - true if the Details of User are Deleted otherwise false
     */
    public boolean isDeletedById(int id);
}