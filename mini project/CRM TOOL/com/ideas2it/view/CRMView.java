package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.view.LeadView;
import com.ideas2it.view.EmployeeView;
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
    private Scanner scanner = new Scanner(System.in);
    private LeadView leadView;
    private EmployeeView employeeView;

    public CRMView() {
        this.leadView = new LeadView();
        this.employeeView = new EmployeeView();
    }
    
    /**
     * <h1> CRM Dashboard </h1>
     * <p>
     * This method is used to login
     * as Employee and Manager 
     * </p>
     */
    public void startCRM() {
        printWelcomeMessage();
        byte logout;
        boolean isActive = true;
        
        do {
            printUserMenu();
            byte user = scanner.nextByte();
            
            switch (user) {
            case Constants.EMPLOYEE:
                 //loginUser();
                 leadView.openEmployeeDashboard();   // need create login for Employee with validation
                 break;
               
            case Constants.MANAGER:
                 employeeView.openManagerDashboard();
                 break;
             
            case Constants.CRM_EXIT:
                System.out.println(Constants.EXIT_MENU);
                logout = scanner.nextByte();
                isActive = (logout == Constants.LOGOUT) ? false : true;  
                break;
                 
            default:
                System.out.println(Constants.DEFAULT_MESSAGE);
            }  
        } while (isActive);
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
                      .append("========================================\n");
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
        userMenu.append("press \" ").append(Constants.EMPLOYEE)
                .append(" \" for Employee\n")
                .append("press \" ").append(Constants.MANAGER)
                .append(" \" for Manager\n")
                .append("press \" ").append(Constants.CRM_EXIT)
                .append(" \" for EXIT\n")
                .append("Press the Number to Login as: ");
	System.out.print(userMenu);
    }
}