package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.controller.EmployeeController;
import com.ideas2it.model.Lead;

/**
 * <h1> Employee View </h1>
 * <p> 
 * This Employee view class used to Provide Dashboard of operations 
 * performed by the Employee, like Adding, Updating,
 * Viewing, Searching, Deleting the Details of Lead
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.0 
 * @since   16-09-2022
 */
public class EmployeeView {
    private Scanner scanner = new Scanner(System.in);

    private EmployeeController employeeController;
        
    public EmployeeView() {
        this.employeeController = new EmployeeController();
    }

    /**
     * <h1> Employee Dashboard </h1>
     * <p>
     * This method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Lead
     * </p>
     */
    public void openEmployeeDashboard() {
        String id;
        boolean isActive = false;
        byte operation;    

        printWelcomeMessage();     
                
        while (!isActive) {
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
                isActive = (logout == Constants.LOGOUT) ? true : false; 
                break;
                   
            default:
                printDefaultStatement();
            }        
        }
    }
    
    /**
     * <h1> Add Lead </h1>
     * <p>
     * This method will ask for the Details from the Employee
     * and passes the Details of Lead to store
     * </p>
     */
    private void addLead() {
        String leadName;
        String leadEmail;
        String leadPhone;
        String leadStage;
        String leadCompanyName;
        String leadStartDate;
        String leadEndDate;
        Double leadDealSize = 0.0d;

        System.out.print("\nEnter the lead count to add: ");
        int count = scanner.nextInt();

        for (int index = 0; index < count; index++) {
            System.out.println("\n======Enter Lead 0" + (index + 1) + " Details ======\n");
            System.out.print("Enter the Lead's Name      :  ");
            scanner.skip("\r\n");
            leadName = scanner.nextLine();
            System.out.print("Enter the Lead's Email ID                      :  ");
            leadEmail = scanner.nextLine();
            System.out.print("Enter the Lead's Phone                         :  ");
            leadPhone = scanner.nextLine();
            System.out.print("Enter the Lead's Stage                         :  ");
            leadStage = scanner.nextLine();
            System.out.print("Enter the Lead's Company                       :  ");
            leadCompanyName = scanner.nextLine();
            System.out.print("Enter the Start-Date in this Formate DD-MM-YYYY:  ");
            leadStartDate = scanner.nextLine(); 
            System.out.print("Enter the End-Date in this Formate DD-MM-YYYY  :  ");
            leadEndDate = scanner.nextLine();
            System.out.print("Enter the Deal-Size                            :  ");
            leadDealSize = scanner.nextDouble();

            boolean isAdded = employeeController.isLeadAdded(new Lead(leadName, leadEmail, 
                                   leadPhone, leadStage, leadCompanyName,
                                   leadStartDate, leadEndDate, leadDealSize));
           
            printSuccessMessage(isAdded);
        }
    }

    /**   
     * <h1> Print Details of lead </h1>
     * <p>
     * This method will Display all the Details of Lead
     * </p>
     */
    private void printLeads() {
        System.out.println("\n========== LEAD DETAILS ==========\n");
        System.out.println(employeeController.getLeads());
    }
   
   /**
     * <h1> Print Single Lead </h1>
     * <p>
     * This method is used to serach the Details of Lead by calling the Lead Id
     * This will print the Details of a Single Lead
     * </p>
     */
    private void printLeadById() {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the lead's Id to Search: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println(employeeController.getLeadById(id));
    }

    /**
     * <h1> Update the Lead </h1>
     * <p>
     * This method will updates the each fields of the Lead Details 
     * and Prints the Message that the fields are Updated or not
     * </p>
     */
    private void updateLead() {  
        System.out.println("\n========== UPDATE LEAD  ==========\n");
        System.out.print("Enter the lead's Id to update: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine(); 
        boolean isUpdated = false;   
        boolean isUpdating = false;
        byte updater;

        Lead lead = employeeController.getLeadById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updater = scanner.nextByte();
                     
            switch (updater) {
            case Constants.NAME:
                lead.setName(getName());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                    
            case Constants.EMAIL:
                lead.setEmailId(getEmail());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                         
            case Constants.PHONE_NUMBER:
                lead.setPhoneNumber(getPhoneNumber());
                isUpdated = employeeController.isLeadUpdated(id, lead);    
                printSuccessMessage(isUpdated);            
                break;
                           
            case Constants.STAGE:
                lead.setStage(getStage());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                           
            case Constants.COMPANY_NAME:
                lead.setCompanyName(getCompanyName());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                            
            case Constants.START_DATE:
                lead.setStartDate(getStartDate());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                           
            case Constants.END_DATE:
                lead.setEndDate(getEndDate());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                           
            case Constants.DEAL_SIZE:
                lead.setDealSize(getDealSize());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                           
            case Constants.EXIT_EMPLOYEE_UPDATER:
                printExitMenu();
                byte logout = scanner.nextByte();
                isUpdating = (logout == Constants.LOGOUT) ? true : false; 
                break;
                                  
            default:
                printDefaultStatement();  
            }            
        }         
    }             

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name of the Lead to be updated
     * </p> 
     *
     * @return leadName - an updated Name
     */
    private String getName() {
        System.out.print("Enter the Name: ");
        scanner.skip("\r\n");
        String leadName = scanner.nextLine();
        return leadName;
    }

    /**
     * <h1> Get Email Id </h1>
     * <p>
     * Gets the Email Id of the Lead to be updated
     * </p>
     *
     * @return leadEmail - an updated Email Id
     */
    private String getEmail() {
        System.out.print("Enter the Email: ");
        scanner.skip("\r\n");
        String leadEmail = scanner.nextLine();
        return leadEmail;
    }

    /**
     * <h1> Get Phone Number </h1>
     * <p>
     * Gets the Phone Number of the Lead to be updated
     * </p>
     *
     * @return leadPhoneNumber - an updated Phone number
     */
    private String getPhoneNumber() {
        System.out.print("Enter the Phone Number: ");
        scanner.skip("\r\n");
        String leadPhoneNumber = scanner.nextLine();
        return leadPhoneNumber;
    }

    /**
     * <h1> Get Stage </h1>
     * <p>
     * Gets the Stage of the Lead to be updated
     * </p>
     *
     * @return leadStage - an updated Stage
     */
    private String getStage() {
        System.out.print("Enter the Stage: ");
        scanner.skip("\r\n");
        String leadStage = scanner.nextLine();
        return leadStage;
    }

    /**
     * <h1> Get Company Name </h1>
     * <p>
     * Gets the Company Name of the Lead to be updated
     * </p>
     *
     * @return leadCompanyName - an Updated Company Name
     */
    private String getCompanyName() {
        System.out.print("Enter the Company Name: ");
        scanner.skip("\r\n");
        String leadCompanyName = scanner.nextLine();
        return leadCompanyName;
    } 
    
    /**
     * <h1> Get Start Date </h1>
     * <p>
     * Gets the Satrt Date of the Lead to be updated
     * </p>
     *
     * @return leadStartDate - an updated Start Date
     */
    private String getStartDate() {
        System.out.print("Enter the Start Date: ");
        scanner.skip("\r\n");
        String leadStartDate = scanner.nextLine();
        return leadStartDate;
    }

    /**
     * <h1> Get End Date </h1>
     * <p>
     * Gets the End Date of the Lead to be updated
     * </p>
     *
     * @return leadEndDate - an updated End Date
     */
    private String getEndDate() {
        System.out.print("Enter the End Date: ");
        scanner.skip("\r\n");
        String leadEndDate = scanner.nextLine();
        return leadEndDate;
    }

    /**
     * <h1> Get Deal Size </h1>
     * <p>
     * Gets the Deal Size of the Lead to be updated
     * </p>
     *
     * @return leadDealSize - an updated Deal Size
     */
    private Double getDealSize() {
        System.out.print("Enter the Deal Size: ");
        scanner.skip("\r\n");
        Double leadDealSize = scanner.nextDouble();
        return leadDealSize;
    }

    /**
     * <h1> Delate the Lead </h1>
     * <p>
     * This method will Delete the Details of a Lead 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void deleteLead() {
        System.out.print("Enter the ID to Lead: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        boolean isDeleted = employeeController.isLeadDeletedById(id);
        printSuccessMessage(isDeleted);
    }

    /**
     * <h1> Print Success Message </h1>
     * <p>
     * Prints the Message that the Operation completed Success or not
     * </p>
     */
    private void printSuccessMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("Successfully finished the operation......");
        } else {
            System.out.println("Error: Please check something went wrong");
        }
    }

    /**
     * <h1> Print Operation Menu </h1>
     * <p>
     * Prints the Operation Menu
     * </p>
     */
    private void printOperationMenu() {
        StringBuilder OperationPrinter = new StringBuilder();
        OperationPrinter.append("Press \" 1 \" for Add New Lead\n")
                     .append("Press \" 2 \" for View\n")
                     .append("Press \" 3 \" for Search\n")
                     .append("Press \" 4 \" for get\n")
                     .append("Press \" 5 \" for Delete\n")
                     .append("Press \" 6 \" for EXIT\n")
                     .append("Enter your Operation: ");
        System.out.print(OperationPrinter);
    }

    /**
     * <h1> Print Updation Menu </h1>
     * <p>
     * Prints the Menu for Updating the Details of Lead
     * </p>
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
                     .append("Enter your getr: "); 
        System.out.println(choicePrinter);
    } 

    /**
     * <h1> Print Exit Menu </h1>
     * <p>
     * Prints the choice for Employee to exit
     * </p>
     */
    private void printExitMenu() {
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("Press \" 1 \" for Yes\n")
                   .append("Press \" Any Number \" for No");
        System.out.println(exitPrinter);
    }

    /**
     * <h1> Print Default Statement </h1>
     * <p>
     * Prints the Default Statements
     * </p>
     */
    private void printDefaultStatement() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the ")
                      .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
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
                      .append("|          WELCOME EMPLOYEE!           |")
                      .append("========================================\n");
        System.out.println(welcomePrinter);
    }
}                                          
