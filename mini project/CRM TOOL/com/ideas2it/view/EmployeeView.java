package com.ideas2it.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;

import com.ideas2it.model.Lead;

/**
 * Controls all the operations performed by the employee
 * Like adding, updating, searching the leads
 *
 * @author Ajaisharma D
 * @version 1.0 24-08-2022
 */
public class EmployeeView {
    private static Scanner scanner = new Scanner(System.in);
    private final static byte ADDER = 1;
    private final static byte PROJECTOR = 2;
    private final static byte FINDER = 3;
    private final static byte EDITOR = 4;
    private final static byte EXIT = 5;

    private final static byte LOGOUT = 1;
    private final static byte ALL_LEAD = 1;
    private final static byte ONE_LEAD = 2;

    private final static byte NAME = 1;
    private final static byte EMAIL = 2;
    private final static byte PHONE_NUMBER = 3;
    private final static byte STAGE = 4;
    private final static byte COMPANY_NAME = 5;
    private final static byte START_DATE = 6;
    private final static byte END_DATE = 7;
    private final static byte DEAL_SIZE = 8;
    private final static byte EXIT_UPDATER = 9;

    private String leadId;
    private String leadName;
    private String leadEmail;
    private String leadPhone;
    private String leadStage;
    private String leadCompanyName;
    private String leadStartDate;
    private String leadEndDate;
    private int leadDealSize;
    
    private int count;
    private int idCount = 0;
    private Lead lead; 
    private Map<String, Lead> leadMap = new HashMap<>();
    private boolean isActive = true;
    private byte choice;
    private String id;
    
    /**
     * Employee's operation goes here
     * @param no parameter
     */
    public void performEmployeeOperation() {
        EmployeeView employeeView = new EmployeeView();
        employeeView.printWelcomeMessage();     
                
        while (isActive) {
            employeeView.printChoiceMenu();
            choice = scanner.nextByte();
                   
            switch (choice) {
            case ADDER:
                System.out.print("\nEnter the lead count to add: ");
                count = scanner.nextInt();
                addLead(count);
                break;
                      
            case PROJECTOR:
                System.out.println("\n========== LEAD DATA ==========\n");
                viewLead();
                break;
                                            
            case FINDER:
                System.out.println("\n========== SEARCH LEAD ==========\n");  
                System.out.print("Enter the lead's Id to Search: ");
                scanner.nextLine();
                id = scanner.nextLine();
                printLeadById(id);
                break;
                       
            case EDITOR:
                System.out.println("\n========== EDIT LEAD  ==========\n");
                System.out.print("Enter the lead's Id to Update: ");
                scanner.nextLine();
                id = scanner.nextLine();
                editLead(id);
                break;
                   
            case EXIT:
                employeeView.printExitMenu();
                byte logout = scanner.nextByte();
                isActive = (logout == LOGOUT) ? false : true ; 
                System.out.println("Logging Out from Employee ......");
                break;
                   
            default:
                employeeView.printDefaultStatement();
                employeeView.printChoiceMenu();
                choice = scanner.nextByte();
                break;
            }        
        }
    }

    /**
     * Prints the Menu for Employee to do operations
     */
    void printChoiceMenu() {
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append("press \" 1 \" for Add New Lead\n")
                     .append("press \" 2 \" for View\n")
                     .append("press \" 3 \" for Search\n")
                     .append("press \" 4 \" for Update\n")
                     .append("press \" 5 \" for EXIT\n")
                     .append("Enter your choice: ");
        System.out.println(choicePrinter);
    }

    /**
     * Prints the choice for Employee to exit
     */
    void printExitMenu() {
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("press \" 1 \" for Yes\n")
                   .append("press \" Any Number \" for No");
        System.out.println(exitPrinter);
    }

    /**
     * Prints the Default Statements
     */
    void printDefaultStatement() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the")
                      .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
    }

    /**
     * Prints the Welcome Statements
     */
    void printWelcomeMessage() {
        StringBuilder welcomePrinter = new StringBuilder();
        welcomePrinter.append("========================================")
                      .append("|          WELCOME EMPLOYEE!           |")
                      .append("========================================");
        System.out.println(welcomePrinter);
    }

    
}                                          
