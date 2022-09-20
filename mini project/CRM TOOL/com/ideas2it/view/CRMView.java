package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.view.EmployeeView;
import com.ideas2it.view.ManagerView;
//import com.ideas2it.controller.CRMController;

/**
 * Contains the user Dashbord to switch from one user to another
 * 
 * @author AJAISHARMA 
 * @version 1.0 
 * @since 10-09-2022
 */
public class CRMView {
    private Scanner scanner = new Scanner(System.in);
    private EmployeeView employeeView;
    private ManagerView managerView;

    public CRMView() {
        this.employeeView = new EmployeeView();
        this.managerView = new ManagerView();
    }
    
    /**
     * Starting the CRM Tool
     * and provide the user dashboard  
     */
    public void startCRM() {
        printWelcomeMessage();
        boolean isActive = true;
        
        do {
            printUserMenu();
            byte user = scanner.nextByte();
            
            switch (user) {
            case Constants.EMPLOYEE:
                 //loginUser();
                 employeeView.openEmployeeDashboard();   // need create login for Employee with validation
                 break;
               
            case Constants.MANAGER:
                 managerView.openManagerDashboard();
                 break;
             
            case Constants.CRM_EXIT:
                printExitMenu();
                byte logout = scanner.nextByte();
                isActive = (logout == Constants.LOGOUT) ? false : true;  
                break;
                 
            default:
                printDefaultStatement();
                
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
     * Prints the Welcome Statements
     */
    private void printWelcomeMessage() {
        StringBuilder welcomePrinter = new StringBuilder();
        welcomePrinter.append("\n========================================")
                      .append("|               CRM TOOL               |")
                      .append("========================================\n");
        System.out.println(welcomePrinter);
    }

    /**
     * Prints the User Menu
     */
    private void printUserMenu() {
        StringBuilder userMenu = new StringBuilder();
        userMenu.append("press \" 1 \" for Employee\n")
                .append("press \" 2 \" for Manager\n")
                .append("press \" 3 \" for EXIT\n")
                .append("Press the Number to Login as: ");
	System.out.print(userMenu);
    }

    /**
     * Printes the Exit menu
     */
    private void printExitMenu() {
	StringBuilder exitMenu = new StringBuilder();
        exitMenu.append(">>>>> Are you sure want to Exit? <<<<<\n")
                .append("press \" 1 \" for Yes\n")
                .append("press \" Any Number \" for No");
	System.out.println(exitMenu);
    }

    /**
     * Printes the Default statement 
     */
    private void printDefaultStatement() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append(">>>>> You have entered wrong Choice <<<<<\n")
                  .append("Please enter any of the ")
                  .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
    }
}
