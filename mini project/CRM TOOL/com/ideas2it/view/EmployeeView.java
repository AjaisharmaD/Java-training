package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.model.Lead;

public class EmployeeView {
private static Scanner scanner = new Scanner(System.in);
    private final static byte ADDER = 1;
    private final static byte PROJECTOR = 2;
    private final static byte FINDER = 3;
    private final static byte EDITOR = 4;
    private final static byte EXIT = 5;

    private final static byte NAME = 1;
    private final static byte EMAIL = 2;
    private final static byte PHONE_NUMBER = 3;
    private final static byte STAGE = 4;
    private final static byte COMPANY_NAME = 5;
    private final static byte START_DATE = 6;
    private final static byte END_DATE = 7;
    private final static byte DEAL_SIZE = 8;
    private final static byte EXIT_UPDATER = 9;


    private EmployeeController employeeController = new EmployeeController();
        
    /**
     * Employee's operation goes here
     */
    public void openEmployeeDashboard() {
        String id;
        boolean isActive = true;
        byte operation;    

        printWelcomeMessage();     
                
        while (isActive) {
            printOperationMenu();
            operation = scanner.nextByte();
                   
            switch (operation) {
            case ADDER:
                createLead();
                break;
                 
            case PROJECTOR:
                viewLeads();
                break;
                                                
            case FINDER:
                findLead();
                break;
                       
            case EDITOR:
                modifyLead();
                break;
                 
            case EXIT:
                printExitMenu();
                byte logout = scanner.nextByte();
                isActive = employeeController.closeEmployee(logout); 
                break;
                   
            default:
                printDefaultStatement();
            }        
        }
    }
    
    /**
     * Creates the Lead
     */
    public void createLead() {
        System.out.print("\nEnter the lead count to add: ");
        int count = scanner.nextInt();
        addLead(count);
    }

    /**
     * Prints the Lead Details
     */
    public void viewLeads() {
        System.out.println("\n========== LEAD DETAILS ==========\n");
        printLeads();
    }

    /**
     * Finds the Lead
     */
    public void findLead() {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the lead's Id to Search: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        printLeadById(id);
    }

    /**
     * Modifies the Lead
     */
    public void modifyLead() {
        System.out.println("\n========== EDIT LEAD  ==========\n");
        System.out.print("Enter the lead's Id to Update: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        editLead(id);
    }

    /**
     * Adds the Lead's detail 
     *
     * @param count - count of the lead to add 
     */
    public void addLead(int count) {
        Lead lead;
        String leadName;
        String leadEmail;
        String leadPhone;
        String leadStage;
        String leadCompanyName;
        String leadStartDate;
        String leadEndDate;
        int leadDealSize = 0;

        for (int index = 0; index < count; index++) {
            System.out.println("\n======Enter Lead 0" + (index + 1) + " Details ======\n");
            System.out.print("Enter the Lead's Name      :  ");
            scanner.nextLine();
            leadName = scanner.nextLine();
            System.out.print("Enter the Lead's Email ID  :  ");
            leadEmail = scanner.nextLine();
            System.out.print("Enter the Lead's Phone     :  ");
            leadPhone = scanner.nextLine();
            System.out.print("Enter the Lead's Stage     :  ");
            leadStage = scanner.nextLine();
            System.out.print("Enter the Lead's Company   :  ");
            leadCompanyName = scanner.nextLine();
            System.out.print("Enter the Start-Date       :  ");
            leadStartDate = scanner.nextLine(); 
            System.out.print("Enter the End-Date         :  ");
            leadEndDate = scanner.nextLine();
            System.out.print("Enter the Deal-Size        :  ");
            leadDealSize = scanner.nextInt();

            lead = new Lead(leadName, leadEmail, 
                                   leadPhone, leadStage, leadCompanyName,
                                   leadStartDate, leadEndDate, leadDealSize);
            boolean isAdded = employeeController.addLead(lead);
           
            if (isAdded) {
                System.out.println("\n>>>>>> Lead Details Added Successfully <<<<<<\n");
            } else {
                System.out.println("Error: Details Not Added");
            }
           
        }
    }

    /**   
     * Prints all the lead's details 
     *
     * @return returns nothing
     */
    public void printLeads() {
        System.out.println(employeeController.printLeads());
    }
   
    /**
     * Prints the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     */
    public void printLeadById(String id) {
        System.out.println(employeeController.printLeadById(id));
    }

    /**
     * Updates the lead's details 
     *
     * @param id - key to update the Values
     * @return returns nothing
     */
    public void editLead(String id) {      
        boolean isUpdating = true;

        while (isUpdating) {
            printUpdaterMenu();
            byte update = scanner.nextByte();
                     
            switch (update) {
            case NAME:
                editName(id);
                break;
                    
            case EMAIL:
                editEmail(id);
                break;
                         
            case PHONE_NUMBER:
                editPhone(id);
                break;
                           
            case STAGE:
                editStage(id);
                break;
                           
            case COMPANY_NAME:
                editCompanyName(id);
                break;
                            
            case START_DATE:
                editStartDate(id);
                break;
                           
            case END_DATE:
                editEndDate(id);
                break;
                           
            case DEAL_SIZE:
                editDealSize(id);
                break;
                           
            case EXIT_UPDATER:
                printExitMenu();
                byte logout = scanner.nextByte();
                isUpdating = employeeController.closeEmployee(logout); 
                break;
                                  
            default:
                printDefaultStatement();  
            }            
        }         
    }             

    /**
     * Updates the Name of the Lead
     *
     * @param id - key to update the name
     */
    public void editName(String id) {
        System.out.print("Enter the Name: ");
        scanner.nextLine();
        String leadName = scanner.nextLine();
        employeeController.editName(id, leadName);
    }

    /**
     * Updates the Email Id of the Lead
     *
     * @param id - key to update the Email id
     */
    public void editEmail(String id) {
        System.out.print("Enter the Email: ");
        scanner.nextLine();
        String leadEmail = scanner.nextLine();
        employeeController.editEmail(id, leadEmail);
    }

    /**
     * Updates the Phone Number of the Lead
     *
     * @param id - key to update the Phone number
     */
    public void editPhone(String id) {
         System.out.print("Enter the Phone Number: ");
         scanner.nextLine();
         String leadPhone = scanner.nextLine();
         employeeController.editPhone(id, leadPhone);
    }

    /**
     * Updates the Stage of the Lead
     *
     * @param id - key to update the Stage
     */
    public void editStage(String id) {
        System.out.print("Enter the Stage: ");
        scanner.nextLine();
        String leadStage = scanner.nextLine();
        employeeController.editStage(id, leadStage);
    }

    /**
     * Updates the Company Name of the Lead
     *
     * @param id - key to update the Company Name
     */
    public void editCompanyName(String id) {
        System.out.print("Enter the Company Name: ");
        scanner.nextLine();
        String leadCompanyName = scanner.nextLine();
        employeeController.editCompanyName(id, leadCompanyName);
    } 
    
    /**
     * Updates the Start Date of the Lead
     *
     * @param id - key to update the Start Date
     */
    public void editStartDate(String id) {
        System.out.print("Enter the Start Date: ");
        scanner.nextLine();
        String leadStartDate = scanner.nextLine();
        employeeController.editStartDate(id, leadStartDate);
    }

    /**
     * Updates the End Date of the Lead
     *
     * @param id - key to update the End Date
     */
    public void editEndDate(String id) {
        System.out.print("Enter the End Date: ");
        scanner.nextLine();
        String leadEndDate = scanner.nextLine();
        employeeController.editEndDate(id, leadEndDate);
    }

    /**
     * Updates the Deal Size of the Lead
     *
     * @param id - key to update the Deal Size
     */
    public void editDealSize(String id) {
        System.out.print("Enter the Deal Size: ");
        int leadDealSize = scanner.nextInt();
        employeeController.editDealSize(id, leadDealSize);
    }

    /**
     * Prints the Menu for Employee to do operations
     */
    private void printOperationMenu() {
        StringBuilder OperationPrinter = new StringBuilder();
        OperationPrinter.append("Press \" 1 \" for Add New Lead\n")
                     .append("Press \" 2 \" for View\n")
                     .append("Press \" 3 \" for Search\n")
                     .append("Press \" 4 \" for Update\n")
                     .append("Press \" 5 \" for EXIT\n")
                     .append("Enter your Operation: ");
        System.out.print(OperationPrinter);
    }

    /**
     * Prints the choice for Employee to exit
     */
    private void printExitMenu() {
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("Press \" 1 \" for Yes\n")
                   .append("Press \" Any Number \" for No");
        System.out.println(exitPrinter);
    }

    /**
     * Prints the Default Statements
     */
    private void printDefaultStatement() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the ")
                      .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
    }

    /**
     * Prints the Welcome Statements
     */
    private void printWelcomeMessage() {
        StringBuilder welcomePrinter = new StringBuilder();
        welcomePrinter.append("\n========================================")
                      .append("|          WELCOME EMPLOYEE!           |")
                      .append("========================================\n");
        System.out.println(welcomePrinter);
    }

    /**
     * Prints the Menu for Employee to do updation
     */
    private void printUpdaterMenu() {
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append("\nLead Id can't be changed\n")
                     .append("\npress \" 1 \" for Name\n")
                     .append("press \" 2 \" for Email\n")
                     .append("press \" 3 \" for Phone Number\n")
                     .append("press \" 4 \" for Stage\n")
                     .append("press \" 5 \" for Company Name\n")
                     .append("press \" 6 \" for Start date\n")
                     .append("press \" 7 \" for End date\n")
                     .append("press \" 8 \" for Deal Size\n")
                     .append("press \" 9 \" for Exit\n")
                     .append("Enter your Updater: "); 
        System.out.println(choicePrinter);
    } 
}                                          
