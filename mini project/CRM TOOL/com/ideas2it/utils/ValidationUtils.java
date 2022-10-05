package com.ideas2it.utils;

import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;
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
 * @version 1.2
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
     * @return boolean - Status of Name
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
     * @return boolean  - Status of Email
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
     * @return boolean    - Status of Phone Number 
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(Constants.PHONENUMBER_PATTERN, phoneNumber);
    }

    /**
     * <h1> Valid Company Name </h1>
     * <p>
     * This method will checks the input for Company Name is valid or not.
     * </p>
     *
     * @param companyName - Company Name of Lead
     * @return boolean    - Status of Company Name
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
     * @return boolean - Status of Password
     */
    public boolean isValidPassword(String password) {
        return Pattern.matches(Constants.PASSWORD_PATTERN, password);        
    }
}