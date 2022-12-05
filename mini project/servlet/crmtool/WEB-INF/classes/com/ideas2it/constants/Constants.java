package com.ideas2it.constants;

/**
 * <h1> Constants </h1>
 * <p>
 * Constants of the CRMTool are declared in here
 * </p>
 * 
 * @author  AJAISHARMA
 * @version 1.0 
 * @since   19-09-2022
 */
public class Constants {
    public final static String EMPLOYEE_ROLE = "employee";
    public final static String MANAGER_ROLE = "manager";
    public final static String ADMIN_ROLE = "admin";

    public final static int ADMIN_ROLE_ID = 1;
    public final static int MANAGER_ROLE_ID = 2;
    public final static int EMPLOYEE_ROLE_ID = 3;

    public final static String NAME_PATTERN = "^([\\D]{0,20}[\s.]?){2}[\\D]{0,20}$";
    public final static String EMAIL_ID_PATTERN = "^([a-z0-9]([._-]?){1}){1,20}[@]{1}[a-z0-9]{1,20}([.]([a-z]{2,3})){1,2}$";
    public final static String PHONE_NUMBER_PATTERN = "^[6-9]{1}[\\d]{9}$";    
    //public final static String ZERO_PATTERN = "^";
    public final static String AMOUNT_PATTERN = "^[\\d]{1,}[.]{1}[\\d]{1,2}$";
    public final static String COMPANY_NAME_PATTERN = "^[a-zA-Z0-9\s]{1,}$"; 
    public final static String WEBSITE_PATTERN = "(^$|(www.)?[a-z0-9]+([.][a-z]{2,3}){1,2}$)";
    public final static String PASSWORD_PATTERN = "^[A-Za-z0-9@#$*]{8,15}$";
    public final static String ID_PATTERN = "^(Lead_0|Employee_0|Contact_0){1}[\\d]{1,5}$";

    public final static String URL = "jdbc:mysql://localhost:3306/samplecrm";
    public final static String USERNAME = "root";
    public final static String SQL_PASSWORD = "8940134223";
}