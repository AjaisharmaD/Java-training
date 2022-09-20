package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.controller.EmployeeController;
import com.ideas2it.model.Lead;

/**
 * Contains All the operation performed by the Employee
 * like Adding Lead, Updating Lead, Viewing Lead, Searching Leads, Delete Lead
 * 
 * @author Ajaisharma D
 * @version 1.0 
 * @since 16-09-2022
 */
public class EmployeeView {
    private static Scanner scanner = new Scanner(System.in);

    private EmployeeController employeeController;
        
    public EmployeeView() {
        this.employeeController = new EmployeeController();
    }

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
            case Constants.ADDER:
                addLead();
                break;
                 
            case Constants.PROJECTOR:
                printLeads();
                break;
                                                
            case Constants.FINDER:
                printLeadById();
                break;
                       
            case Constants.UPDATER:
                updateLead();
                break;

            case Constants.DELETOR:
                deleteLead();
                break;
              
            case Constants.EXIT:
                printExitMenu();
                byte logout = scanner.nextByte();
                isActive = (logout == Constants.LOGOUT) ? false : true; 
                break;
                   
            default:
                printDefaultStatement();
            }        
        }
    }
    
    /**
     * Adds the Lead's detail 
     *
     * @param count - count of the lead to add 
     */
    public void addLead() {
        String leadName;
        String leadEmail;
        String leadPhone;
        String leadStage;
        String leadCompanyName;
        String leadStartDate;
        String leadEndDate;
        int leadDealSize = 0;

        System.out.print("\nEnter the lead count to add: ");
        int count = scanner.nextInt();

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

            boolean isAdded = employeeController.addLead(new Lead(leadName, leadEmail, 
                                   leadPhone, leadStage, leadCompanyName,
                                   leadStartDate, leadEndDate, leadDealSize));
           
            printSuccessMessage(isAdded);
        }
    }

    /**   
     * Prints all the lead's details
     */
    public void printLeads() {
        System.out.println("\n========== LEAD DETAILS ==========\n");
        System.out.println(employeeController.getLeads());
    }
   
    /**
     * Prints the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     */
    public void printLeadById() {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the lead's Id to Search: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        System.out.println(employeeController.getLeadById(id));
    }

    /**
     * Updates the lead's details 
     *
     * @param id - key to update the Values
     * @return returns nothing
     */
    public void updateLead() {  
        System.out.println("\n========== update LEAD  ==========\n");
        System.out.print("Enter the lead's Id to Update: ");
        scanner.nextLine();
        String id = scanner.nextLine();    
        boolean isUpdating = true;

        while (isUpdating) {
            printUpdaterMenu();
            byte updator = scanner.nextByte();
                     
            switch (updator) {
            case Constants.NAME:
                updateName(id);
                break;
                    
            case Constants.EMAIL:
                updateEmail(id);
                break;
                         
            case Constants.PHONE_NUMBER:
                updatePhoneNumber(id);
                break;
                           
            case Constants.STAGE:
                updateStage(id);
                break;
                           
            case Constants.COMPANY_NAME:
                updateCompanyName(id);
                break;
                            
            case Constants.START_DATE:
                updateStartDate(id);
                break;
                           
            case Constants.END_DATE:
                updateEndDate(id);
                break;
                           
            case Constants.DEAL_SIZE:
                updateDealSize(id);
                break;
                           
            case Constants.EXIT_EMPLOYEE_UPDATER:
                printExitMenu();
                byte logout = scanner.nextByte();
                isUpdating = (logout == Constants.LOGOUT) ? false : true; 
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
    public void updateName(String id) {
        System.out.print("Enter the Name: ");
        scanner.nextLine();
        String leadName = scanner.nextLine();
        employeeController.updateName(id, leadName);
    }

    /**
     * Updates the Email Id of the Lead
     *
     * @param id - key to update the Email id
     */
    public void updateEmail(String id) {
        System.out.print("Enter the Email: ");
        scanner.nextLine();
        String leadEmail = scanner.nextLine();
        employeeController.updateEmail(id, leadEmail);
    }

    /**
     * Updates the Phone Number of the Lead
     *
     * @param id - key to update the Phone number
     */
    public void updatePhoneNumber(String id) {
         System.out.print("Enter the Phone Number: ");
         scanner.nextLine();
         String leadPhone = scanner.nextLine();
         employeeController.updatePhoneNumber(id, leadPhone);
    }

    /**
     * Updates the Stage of the Lead
     *
     * @param id - key to update the Stage
     */
    public void updateStage(String id) {
        System.out.print("Enter the Stage: ");
        scanner.nextLine();
        String leadStage = scanner.nextLine();
        employeeController.updateStage(id, leadStage);
    }

    /**
     * Updates the Company Name of the Lead
     *
     * @param id - key to update the Company Name
     */
    public void updateCompanyName(String id) {
        System.out.print("Enter the Company Name: ");
        scanner.nextLine();
        String leadCompanyName = scanner.nextLine();
        employeeController.updateCompanyName(id, leadCompanyName);
    } 
    
    /**
     * Updates the Start Date of the Lead
     *
     * @param id - key to update the Start Date
     */
    public void updateStartDate(String id) {
        System.out.print("Enter the Start Date: ");
        scanner.nextLine();
        String leadStartDate = scanner.nextLine();
        employeeController.updateStartDate(id, leadStartDate);
    }

    /**
     * Updates the End Date of the Lead
     *
     * @param id - key to update the End Date
     */
    public void updateEndDate(String id) {
        System.out.print("Enter the End Date: ");
        scanner.nextLine();
        String leadEndDate = scanner.nextLine();
        employeeController.updateEndDate(id, leadEndDate);
    }

    /**
     * Updates the Deal Size of the Lead
     *
     * @param id - key to update the Deal Size
     */
    public void updateDealSize(String id) {
        System.out.print("Enter the Deal Size: ");
        int leadDealSize = scanner.nextInt();
        employeeController.updateDealSize(id, leadDealSize);
    }

    /**
     * Deletes the Lead by id
     *
     * @param id- key to delete the Lead
     * @return boolean
     */
    public void deleteLead() {
        System.out.print("Enter the ID to Lead: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        boolean isDeleted = employeeController.deleteLeadById(id);
        printSuccessMessage(isDeleted);
    }

    /**
     * Prints the Success message
     */
    public void printSuccessMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("Successfully finished the operation......");
        } else {
            System.out.println("Error: Please check something went wrong");
        }
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
                     .append("Press \" 5 \" for Delete\n")
                     .append("Press \" 6 \" for EXIT\n")
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
