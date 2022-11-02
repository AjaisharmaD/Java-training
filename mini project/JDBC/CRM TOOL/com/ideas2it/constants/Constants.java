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
    public final static String EMPLOYEE_ID = "Employee_0";
    public final static String LEAD_ID = "Lead_0";
    public final static String ACCOUNT_ID = "ACCOUNT_0";

    public final static String LOGOUT = "1";

    public final static String EMPLOYEE = "1";
    public final static String MANAGER = "2";
    public final static String CRM_EXIT = "3";

    public final static String LEAD = "1";
    public final static String ACCOUNT = "2";
    public final static String CONTACT = "3";
    public final static String OPPORTUNITY = "4";
    public final static String EXIT = "5";

    public final static String ADDER = "1";
    public final static String PROJECTOR = "2";
    public final static String FINDER = "3";
    public final static String UPDATER = "4";
    public final static String REMOVER = "5";
    public final static String ASSIGN_LEAD = "6";
    public final static String EXIT_OPERATION = "7";

    public final static String NAME = "1";
    public final static String EMAIL = "2";
    public final static String PHONE_NUMBER = "3";
    public final static String COMPANY_NAME = "4";
    public final static String STATUS = "5";
    public final static String EXIT_LEAD = "6";

    public final static String PASSWORD = "4";

    public final static String TYPE = "3";
    public final static String WEBSITE = "2";
    public final static String EXIT_ACCOUNT_UPDATER = "4";

    public final static String ROLE = "4";
    public final static String ACCOUNT_NAME = "5";

    public final static String NEW = "1";
    public final static String CONTACTED = "2";
    public final static String WORKING = "3";
    public final static String QUALIFIED = "4";
    public final static String UNQUALIFIED = "5";
    public final static String CONVERTED = "6";

    public final static String CUSTOMER = "1";
    public final static String RESELLER = "2";
    public final static String INVESTOR = "3";
    public final static String PARTNER = "4";

    public final static String CEO = "1";
    public final static String FOUNDER = "2";
    public final static String PRESIDENT = "3";
    public final static String VICE_PRESIDENT = "4";
    public final static String DIRECTOR = "5";

    public final static String MEETING_SCHEDULED = "1";
    public final static String CLOSED_WON = "2";
    public final static String CLOSED_LOST = "3";

    public final static String STAGE = "3";
    public final static String AMOUNT = "2";

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