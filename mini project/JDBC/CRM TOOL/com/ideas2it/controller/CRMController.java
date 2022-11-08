package com.ideas2it.controller;

import com.ideas2it.exception.NotFoundException;
import com.ideas2it.service.CRMService;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.User;
import com.ideas2it.utils.ValidationUtils;

/**
 * <h1> CRM Controller </h1>
 * <p>
 * Controls the operation of the CRM Tool
 * Like validate user, exit
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   16-09-2022
 */
public class CRMController {
    private CRMService crmService;
    private CustomLogger logger;
    private ValidationUtils validationUtils;
    
    public CRMController() {
        this.crmService = new CRMService();
        this.logger = new CustomLogger(CRMController.class);
        this.validationUtils = new ValidationUtils();
    }

    /**
     * Validates the login Details
     */
    public User validUser(String email, String password) {
        User user = null;

        try {
            user = crmService.validUser(email, password);
        } catch(NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return user;
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