package com.ideas2it.controller;

import java.util.List; 

import com.ideas2it.exception.NotFoundException;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
import com.ideas2it.service.LeadService;
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
    private LeadService leadService;
    private ValidationUtils validationUtils;
    private CustomLogger logger;
    
    public UserController() {
        this.userService = new UserService();
        this.leadService = new LeadService();
        this.validationUtils = new ValidationUtils();
        this.logger = new CustomLogger(UserController.class);
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
    public boolean create(User user, String password) {
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
        try {
            return userService.getAll();
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;
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
    public User getById(int id) {
        try {
            return userService.getById(id);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;
    }

    /**
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of a Single Lead by Id
     * </p>
     *
     * @param id    - Lead's Id to search the Lead
     *
     * @return Lead - Details of a Single Lead
     */
    public Lead getLeadById(int id,int userId) {
        try {
            return leadService.getById(id,userId);
        } catch (NotFoundException leadNotFoundException) {
            logger.error(leadNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;
        
    }

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
     * @return boolean - updated status of given id
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return userService.updateById(id, columnName, columnValue);
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
    public boolean isDeletedById(int id) {
        return userService.isDeletedById(id);
    }

    /**
     * <h1> Valid Name </h1>
     * <p>
     * This method will get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of User  
     * @return boolean - Status of the Name
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
     * @return boolean - Status of the Email Id
     */
    public boolean isValidEmailId(String emailId) {
        if (validationUtils.isValidEmailId(emailId)) {
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
     * @return boolean    - Status of the Phone Number
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
     * @return boolean - Status of the Company Name
     */
    public boolean isValidPassword(String password) {
        if (validationUtils.isValidPassword(password)) {
            return true;
        }
        return false;
    }
}