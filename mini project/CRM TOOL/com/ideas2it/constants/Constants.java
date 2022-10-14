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

    public final static byte LOGOUT = 1;

    public final static byte EMPLOYEE = 1;
    public final static byte MANAGER = 2;
    public final static byte CRM_EXIT = 3;

    public final static byte LEAD = 1;
    public final static byte ACCOUNT = 2;
    public final static byte CONTACT = 3;
    public final static byte OPPORTUNITY = 4;
    public final static byte EXIT = 5;

    public final static byte ADDER = 1;
    public final static byte PROJECTOR = 2;
    public final static byte FINDER = 3;
    public final static byte UPDATER = 4;
    public final static byte REMOVER = 5;
    public final static byte ASSIGN_LEAD = 6;
    public final static byte EXIT_OPERATION = 7;

    public final static byte NAME = 1;
    public final static byte EMAIL = 2;
    public final static byte PHONE_NUMBER = 3;
    public final static byte COMPANY_NAME = 4;
    public final static byte STATUS = 5;
    public final static byte EXIT_LEAD = 6;

    public final static byte TYPE = 4;
    public final static byte WEBSITE = 5;

    public final static byte TITLE = 4;
    public final static byte ACCOUNT_NAME = 5;

    public final static byte EXIT_EMPLOYEE_UPDATER = 4;

    public final static byte NEW = 1;
    public final static byte CONTACTED = 2;
    public final static byte WORKING = 3;
    public final static byte QUALIFIED = 4;
    public final static byte UNQUALIFIED = 5;
    public final static byte CONVERTED = 6;

    public final static byte CUSTOMER = 1;
    public final static byte RESELLER = 2;
    public final static byte INVESTOR = 3;
    public final static byte PARTNER = 4;

    public final static byte CEO = 1;
    public final static byte FOUNDER = 2;
    public final static byte PRESIDENT = 3;
    public final static byte VICE_PRESIDENT = 4;
    public final static byte DIRECTOR = 5;

    public final static byte MEETING_SCHEDULED = 1;
    public final static byte PROPOSAL = 2;
    public final static byte NEGOTIATION = 3;
    public final static byte CLOSED = 5;

    public final static byte OPPORTUNITY_ACCOUNT_NAME = 2;
    public final static byte STAGE = 3;
    public final static byte AMOUNT = 4;

    public final static String NAME_PATTERN = "^([\\w\\D]{0,20}[\s.]?){2}[\\w\\D]{0,20}$";
    public final static String EMAIL_ID_PATTERN = "^([a-z0-9]([._-]?){1}){1,20}[@]{1}[a-z0-9]{1,20}([.]([a-z]{2,3})){1,2}$";
    public final static String PHONE_NUMBER_PATTERN = "^[6-9]{1}[\\d]{9}$";    
    //public final static String ZERO_PATTERN = "^";
    public final static String AMOUNT_PATTERN = "^[\\d]{1,}[.]{1}[\\d]{1,2}$";
    public final static String COMPANY_NAME_PATTERN = "^[a-zA-Z0-9\s]{1,}$"; 
    public final static String WEBSITE_PATTERN = "(^$|(www.)?[a-z0-9]+([.][a-z]{2,3}){1,2}$)";
    public final static String PASSWORD_PATTERN = "^[A-Za-z0-9@#$*]{8,15}$";
    public final static String ID_PATTERN = "^(Lead_0|Employee_0|Contact_0){1}[\\d]{1,5}$";
}