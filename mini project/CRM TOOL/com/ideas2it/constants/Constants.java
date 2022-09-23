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
    public final static byte EMPLOYEE = 1;
    public final static byte MANAGER = 2;
    public final static byte CRM_EXIT = 3;

    public final static byte ADDER = 1;
    public final static byte PROJECTOR = 2;
    public final static byte FINDER = 3;
    public final static byte UPDATER = 4;
    public final static byte REMOVER = 5;
    public final static byte EXIT = 6;

    public final static byte NAME = 1;
    public final static byte EMAIL = 2;
    public final static byte PHONE_NUMBER = 3;
    public final static byte STAGE = 4;
    public final static byte COMPANY_NAME = 5;
    public final static byte START_DATE = 6;
    public final static byte END_DATE = 7;
    public final static byte DEAL_SIZE = 8;
    public final static byte EXIT_EMPLOYEE_UPDATER = 9; 

    public final static byte EXIT_MANAGER_UPDATER = 4;

    public final static byte LOGOUT = 1;
    
    public final static String NAME_PATTERN = "^([a-zA-Z]{0,20}[\s.]?){2}[a-zA-Z]{0,20}$";
    public final static String EMAIL_PATTERN = "^([a-z0-9]([._-]?){1}){1,20}[@]{1}[a-z0-9]{1,20}(.[a-z]{2,3}){1,2}$";
    public final static String PHONENUMBER_PATTERN = "^[6789]{1}[0-9]{9}$";
    public final static String DEALSIZE_PATTERN = "^[0-9]{1,}[.]{1}[0-9]{1,}$";
    public final static String COMPANYNAME_PATTERN = "^[a-zA-Z0-9\s]{1,}$"; 
    public final static String PASSWORD_PATTERN = "^[A-Za-z0-9@#$*]{8,15}$";
}
