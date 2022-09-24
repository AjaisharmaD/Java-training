package com.ideas2it.utils;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.ideas2it.constants.Constants;

/**
 * <h1> Validation Utils </h1>
 * <p>
 * This class will get the Input values and check them with a predefined
 * Patterns to validate that the given value is correct.
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   22-09-2022
 */
public class ValidationUtils {
    
    /**
     * <h1> Valid Name </h1>
     * <p>
     * This method will checks the input for Name is valid or not.
     * </p>
     *
     * @param name     - Name of Employee or Lead
     * @return boolean - true if the given Name Matches 
     *                   the Name pattern otherwise false
     */
    public boolean isValidName(String name) {
        return Pattern.matches(Constants.NAME_PATTERN, name);        
    }

    /**
     * <h1> Valid Email </h1>
     * <p>
     * This method will checks the input for Email is valid or not.
     * </p>
     *
     * @param email     - Email of Employee or Lead
     * @return boolean  - true if the given Email Matches 
     *                    the Email pattern otherwise false 
     */
    public boolean isValidEmail(String email) {
        return Pattern.matches(Constants.EMAIL_PATTERN, email);
    }

    /**
     * <h1> Valid Phone Number </h1>
     * <p>
     * This method will checks the input for Phone Number is valid or not
     * </p>
     *
     * @param phoneNumber - Phone Number of Employee or Lead
     * @return boolean    - true if the given Phone Number Matches
     *                      the Phone Number pattern 
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(Constants.PHONENUMBER_PATTERN, phoneNumber);
    }

    /**
     * <h1> Valid Deal Size </h1>
     * <p>
     * This method will checks the input for Deal Size is valid or not
     * </p>
     *
     * @param dealSize - Deal Size of Employee or Lead
     * @return boolean - true if the given Deal Size Matches 
     *                   the Deal Size pattern 
     */
    public boolean isValidDealSize(String dealSize) {
        return Pattern.matches(Constants.DEALSIZE_PATTERN, dealSize);
    }

    /**
     * <h1> Valid Company Name </h1>
     * <p>
     * This method will checks the input for Company Name is valid or not.
     * </p>
     *
     * @param companyName - Company Name of Lead
     * @return boolean    - true if the given Company Name 
     *                      Matches the Company Name pattern otherwise false
     */
    public boolean isValidCompanyName(String companyName) {
        return Pattern.matches(Constants.COMPANYNAME_PATTERN, companyName);        
    }

    /**
     * <h1> Valid Password </h1>
     * <p>
     * This method will checks the input for Password is valid or not.
     * </p>
     *
     * @param password - Password of Employee
     * @return boolean - true if the given Password 
     *                      Matches the Password pattern otherwise false
     */
    public boolean isValidPassword(String password) {
        return Pattern.matches(Constants.PASSWORD_PATTERN, password);        
    }

    /**
     * <h1> Valid Stage </h1>
     * <p>
     * This method will checks the input for Stage is valid or not.
     * </p>
     *
     * @param password - Password of Employee
     * @return boolean - true if the given Password 
     *                      Matches the Password pattern otherwise false
     */
    public boolean isValidStage(String stage) {
        return Pattern.matches(Constants.STAGE_PATTERN, stage);        
    }
}