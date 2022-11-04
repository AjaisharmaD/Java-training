package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.UserController;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.view.LeadView;
import com.ideas2it.view.UserView;
import com.ideas2it.model.User;

/**
 * <h1> CRM Tool View </h1>
 * <p> 
 * This CRM View class used to provide a dashboard of
 * Login users as Manager and Employee
 * </p>
 *
 * @author  AJAISHARMA 
 * @version 1.0 
 * @since   10-09-2022
 */
public class CRMView {
    private CustomLogger logger;
    private LeadView leadView;
    private UserView userView;
    private UserController userController;

    public CRMView() {
        this.logger = new CustomLogger(CRMView.class);
        this.leadView = new LeadView();
        this.userView = new UserView();
        this.userController = new UserController();
    }
    
    /**
     * <h1> CRM Dashboard </h1>
     * <p>
     * This method is used to login
     * as User and Manager 
     * </p>
     */
    public void startCRM() {
        Scanner scanner = new Scanner(System.in);
        printWelcomeMessage();
        int userId ;
        String logout;
        String loginChoice;
        boolean isActive = false;
        boolean isValid = false;

        while (!isActive) {        
            printUserMenu();
            loginChoice = scanner.next();
	    isValid = false;
                       
            switch (loginChoice) {
            case Constants.EMPLOYEE:
                 while (!isValid) {
                     System.out.print("Enter employee ID: ");
                     userId = scanner.nextInt();
                    
                     if (isValidUser(userId)) {
                         logger.info("Logging in as Employee");
                         leadView.openEmployeeDashboard(scanner, userId);
                         isValid = true;
                     } else {
                         logger.info(Messages.USER_NOT_FOUND);
                         System.out.println(Messages.EXIT_MENU);
                         logout = scanner.next();
                         isValid = (logout.equals(Constants.LOGOUT)) ? true : false;  
                     }
                 }
                 break;
               
            case Constants.MANAGER:
                 logger.info("Logging in as Manager");
                 userView.openManagerDashboard(scanner);
                 break;
             
            case Constants.CRM_EXIT:
                System.out.println(Messages.EXIT_MENU);
                logout = scanner.next();
                isActive = (logout.equals(Constants.LOGOUT)) ? true : false;                     
                break;
                 
            default:
                logger.warn(Messages.INVALID_CHOICE);
            }  
        }
    } 

    /**
     * Validates the login Details
     */
    public boolean isValidUser(int id) {
        boolean isValidUser = false;
        User user = userController.getById(id);

        if (null != user) {
            isValidUser = true;
        } else {
            logger.info("No User Present");
        }
        return isValidUser;
    }

    /**
     * <h1> Print Welcome message </h1>
     * <p>
     * Prints the Welcome Statements
     * </p>
     */
    private void printWelcomeMessage() {
        StringBuilder welcomePrinter = new StringBuilder();
        welcomePrinter.append("\n========================================")
                      .append("|                CRM TOOL                |")
                      .append("========================================");
        System.out.println(welcomePrinter);
    }

    /**
     * <h1> Print User Menu </h1>
     * <p>
     * Prints the User Menu to Login 
     * </p>
     */
    private void printUserMenu() {
        StringBuilder userMenu = new StringBuilder();
        userMenu.append("\npress \" ").append(Constants.EMPLOYEE)
                .append(" \" for Employee\n")
                .append("press \" ").append(Constants.MANAGER)
                .append(" \" for Manager\n")
                .append("press \" ").append(Constants.CRM_EXIT)
                .append(" \" for EXIT\n")
                .append("Press the Number to Login as: ");
	System.out.print(userMenu);
    }
}