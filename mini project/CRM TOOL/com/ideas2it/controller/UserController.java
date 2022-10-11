package com.ideas2it.controller;

import java.util.List; 

import com.ideas2it.model.User;
import com.ideas2it.service.UserService;
import com.ideas2it.utils.ValidationUtils;

/**
 * <h1> User Controller </h1>
 * <p>
 * This class will get request and return the responces
 * like Adding, Updating, Viewing, Searching, Deleting
 * the Details of User
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   16-09-2022
 */
public class UserController {
    private UserService userService;
    private ValidationUtils validationUtils;
    
    public UserController() {
        this.userService = new UserService();
        this.validationUtils = new ValidationUtils();
    }

    /**
     * <h1> Create User </h1>
     * <p>
     * Adds the Details of Users 
     * </p>
     *
     * @param user     - Details of User to add 
     * @param password - password to login
     *
     * @return User - Details of a Single User
     */
    public User create(User user, String password) {
        return userService.create(user, password);
    }

    /**
     * <h1> Get Details of Users </h1>
     * <p>
     * Gets the User Details 
     * </p>
     *
     * @return List - Details of Users
     */
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * <h1> Get Details of Users by Id </h1>
     * <p>
     * Gets the Details of a Single User by Id
     * </p>
     *
     * @param id    - User's Id to search the User
     *
     * @return User - Details of a Single User
     */
    public User getById(String id) {
        return userService.getById(id);
    }

    /**
     * <h1> Update Details of User </h1>
     * <p>
     * Updates the Details of a Single User
     * </p>
     *
     * @param id        - key to update the Details of Users
     * @param user  - updated Details of Users
     *
     * @return User - Updated details of a Single User
     */
    public User updateById(String id, User user) {
        return userService.updateById(id, user);
    }

    /**
     * <h1> Remove Details of User by Id</h1>
     * <p>
     * Removes the Details of a Single User
     * </p>
     *
     * @param id       - key to remove the User
     *
     * @return boolean - true if the Details of User are Removed otherwise false
     */
    public boolean isDeletedById(String id) {
        return userService.isDeletedById(id);
    }

    /**
     * <h1> Valid Name </h1>
     * <p>
     * This method will get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of User  
     * @return boolean - true if the Name is valid otherwise false
     */
    public boolean isValidName(String name) {
        if (validationUtils.isValidName(name)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Email </h1>
     * <p>
     * This method will get the Email and checks whether the given Email is valid or not
     * </p>
     *
     * @param email    - Email of User 
     * @return boolean - true if the Email is valid otherwise false
     */
    public boolean isValidEmail(String email) {
        if (validationUtils.isValidEmail(email)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Phone Number </h1>
     * <p>
     * This method will get the Phone Number and checks whether the given Phone Number is valid or not
     * </p>
     *
     * @param phoneNumber - Phone Number of User  
     * @return boolean    - true if the Phone Number is valid otherwise false
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        if (validationUtils.isValidPhoneNumber(phoneNumber)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Password </h1>
     * <p>
     * This method will get the Password and checks whether the given Password is valid or not
     * </p>
     *
     * @param password - Company Name of User  
     * @return boolean - true if the Company Name is valid otherwise false
     */
    public boolean isValidPassword(String password) {
        if (validationUtils.isValidPassword(password)) {
            return true;
        }
        return false;
    }
}