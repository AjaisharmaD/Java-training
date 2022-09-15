package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.view.EmployeeView;

/**
 * Contains the user Dashbord to switch from one user to another
 * 
 * @author AJAISHARMA 
 * @version 1.0 10-09-2022
 */
public class CRMView {
    private final static byte EMPLOYEE = 1;
    private final static byte MANAGER = 2;
    private final static byte EXIT = 3;
    private final static byte LOGOUT = 1;

    private Scanner scanner = new Scanner(System.in);

    /**
     * Starting the CRM Tool
     * and provide the user dashboard  
     */
    public void startCRM() {
        CRMView crmView = new CRMView();
        EmployeeView employeeView = new EmployeeView();
        boolean isActive = true;
        
        do {
            printUserMenu();
            byte choice = scanner.nextByte();
            
            switch (choice) {
            case EMPLOYEE:
                 employeeView.openEmployeeDashboard();
                 break;
               
            case MANAGER:
                 
                 break;
             
            case EXIT:
                printExitMenu();
                byte logout = scanner.nextByte();
                isActive = closeCRM(logout); 
                break;
                 
            default:
                printDefaultStatement();
                printUserMenu();
                choice = scanner.nextByte();
            }  
        } while (isActive);
    } 

   
    /**
     * Check the user's input to logout from the CRM Tool
     *
     * @param logout - key to logout
     * @return returns exit a boolean value 
     */
    public boolean closeCRM(byte logout) {
        boolean exit = (logout == LOGOUT) ? false : true ; 
        return exit;
    }

    /**
     * Prints the User Menu
     */
    private void printUserMenu() {
        StringBuilder userMenu = new StringBuilder();
        userMenu.append(">>>>> Enter your Choice for ")
                .append("following Operations <<<<<\n")
                .append("press \" 1 \" for Employee\n")
                .append("press \" 2 \" for Manager\n")
                .append("press \" 3 \" for EXIT");
	System.out.println(userMenu);
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
                  .append("Please enter any of the")
                  .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
    }
}