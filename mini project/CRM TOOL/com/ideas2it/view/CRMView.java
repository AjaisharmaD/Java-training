package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.view.LeadView;
import com.ideas2it.view.UserView;
//import com.ideas2it.controller.CRMController;

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

    public CRMView() {
        this.logger = new CustomLogger(CRMView.class);
        this.leadView = new LeadView();
        this.userView = new UserView();
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
        byte logout;
        boolean isActive = false;
        byte loginChoice;

        while (!isActive) {
            printUserMenu();
            loginChoice = getChoice(scanner);
                       
            switch (loginChoice) {
            case Constants.EMPLOYEE:
                 //loginUser();
                 logger.info("Logging in as Employee");
                 leadView.openEmployeeDashboard(scanner);
                 break;
               
            case Constants.MANAGER:
                 logger.info("Logging in as Manager");
                 userView.openManagerDashboard(scanner);
                 break;
             
            case Constants.CRM_EXIT:
                while (!isActive){
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isActive = (logout == Constants.LOGOUT) ? true : false; 
                } 
                break;
                 
            default:
                logger.warn(Messages.DEFAULT_MESSAGE);
            }  
        }
    } 

    /**
     * <h1> Get Choice </h1>
     * <p>
     * Gets the Choice From the user
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return byte - choice to perform
     */
    private byte getChoice(Scanner scanner) {
        byte choice = 0;

        try {
            choice = scanner.nextByte();
        } catch (InputMismatchException e) {
            logger.error("Wrong Input for Choice");
            scanner.next();
        }
        return choice;
    }

    /**
     * Validates the login Details
    
    public void loginUser() {
        String emailId = scanner.nextLine();
        char[10] password = scanner.next();
        boolean isValidUser = crmController.loginUser(emailID, password);
    } */

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