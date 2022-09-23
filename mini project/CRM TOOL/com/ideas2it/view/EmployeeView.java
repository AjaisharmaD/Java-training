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

            case Constants.REMOVER:
                removeLead();
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
            scanner.skip("\r\n");
            leadName = getName();
            leadEmail = getEmail();     
            leadPhone = getPhoneNumber();
            leadStage = getStage();    
            leadCompanyName = getCompanyName();    
            leadStartDate = getStartDate();     
            leadEndDate = getEndDate();    
            leadDealSize = getDealSize();

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
                scanner.skip("\r\n");
                lead.setName(getName());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                lead.setEmailId(getEmail());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                lead.setPhoneNumber(getPhoneNumber());
                isUpdated = employeeController.isLeadUpdated(id, lead);    
                printSuccessMessage(isUpdated);            
                break;
                           
            case Constants.STAGE:
                scanner.skip("\r\n");
                lead.setStage(getStage());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                           
            case Constants.COMPANY_NAME:
                scanner.skip("\r\n");
                lead.setCompanyName(getCompanyName());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                            
            case Constants.START_DATE:
                scanner.skip("\r\n");
                lead.setStartDate(getStartDate());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                           
            case Constants.END_DATE:
                scanner.skip("\r\n");
                lead.setEndDate(getEndDate());
                isUpdated = employeeController.isLeadUpdated(id, lead);
                printSuccessMessage(isUpdated);
                break;
                           
            case Constants.DEAL_SIZE:
                scanner.skip("\r\n");
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
     * Gets the Name of the Lead and checks whether the Name is Valid or not
     * </p> 
     *
     * @return leadName - a Valid Name of the Lead
     */
    private String getName() {
        String leadName = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Lead's Name                          : ");
            leadName = scanner.nextLine();

            if (employeeController.isValidName(leadName)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Name Format, Give the proper Name! <<<<<\n");
            }  
        }
        return leadName;
    }

    /**
     * <h1> Get Email Id </h1>
     * <p>
     * Gets the Email of the Lead and checks whether the Email is Valid or not
     * </p>
     *
     * @return leadEmail - a Valid Email of the Lead
     */
    private String getEmail() {
        String leadEmail = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Lead's Email ID                      : ");
            leadEmail = scanner.nextLine();

            if (employeeController.isValidEmail(leadEmail)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Email Format, Give the proper Email! <<<<<\n");
            }  
        }
        return leadEmail;
    }

    /**
     * <h1> Get Phone Number </h1>
     * <p>
     * Gets the Phone Number of the Lead and checks whether the Phone Number is Valid or not
     * </p>
     *
     * @return leadPhoneNumber - a Valid Phone Number of the Lead
     */
    private String getPhoneNumber() {
        String leadPhoneNumber = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Lead's Phone Number                  : ");
            leadPhoneNumber = scanner.nextLine();

            if (employeeController.isValidPhoneNumber(leadPhoneNumber)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Phone Number Format, Give the proper Phone Number! <<<<<\n");
            }  
        }
        return leadPhoneNumber;
    }

    /**
     * <h1> Get Stage </h1>
     * <p>
     * Gets the Stage of the Lead
     * </p>
     *
     * @return leadStage - an updated Stage
     */
    private String getStage() {
        System.out.print("Enter the Lead's Stage                         : ");
        String leadStage = scanner.nextLine();
        return leadStage;
    }

    /**
     * <h1> Get Company Name </h1>
     * <p>
     * Gets the Company Name of the Lead and checks whether the Company Name is Valid or not
     * </p> 
     *
     * @return leadName - a Valid Company Name of the Lead
     */
    private String getCompanyName() {
        String leadCompanyName = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Lead's Company Name                  : ");
            leadCompanyName = scanner.nextLine();

            if (employeeController.isValidCompanyName(leadCompanyName)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Company Name Format, Give the proper Company Name! <<<<<\n");
            }  
        }
        return leadCompanyName;
    }
    
    /**
     * <h1> Get Start Date </h1>
     * <p>
     * Gets the Satrt Date of the Lead
     * </p>
     *
     * @return leadStartDate - an updated Start Date
     */
    private String getStartDate() {
        System.out.print("Enter the Start-Date in this Formate DD-MM-YYYY: ");
        String leadStartDate = scanner.nextLine();
        return leadStartDate;
    }

    /**
     * <h1> Get End Date </h1>
     * <p>
     * Gets the End Date of the Lead
     * </p>
     *
     * @return leadEndDate - an updated End Date
     */
    private String getEndDate() {
        System.out.print("Enter the End-Date in this Formate DD-MM-YYYY  : ");
        String leadEndDate = scanner.nextLine();
        return leadEndDate;
    }

    /**
     * <h1> Get Deal Size </h1>
     * <p>
     * Gets the Deal Size of the Lead and checks whether the Deal Size is Valid or not
     * </p>
     *
     * @return leadDealSize - a Valid Deal Size 
     */
    private Double getDealSize() {
        Double leadDealSize = 0.00d;
        boolean isNotValid = false;
        String dealSize = "";

        while (!isNotValid) {
            System.out.print("Enter the Deal Size                            : ");
            leadDealSize = scanner.nextDouble();
            dealSize = Double.toString(leadDealSize);
            if (employeeController.isValidDealSize(dealSize)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Deal Size Format, Give the proper Deal Size! <<<<<\n");
            }  
        }
        return leadDealSize;
    }

    /**
     * <h1> Delate the Lead </h1>
     * <p>
     * This method will Delete the Details of a Lead 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void removeLead() {
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        boolean isRemoved = employeeController.isLeadRemovedById(id);
        printSuccessMessage(isRemoved);
    }

    /**
     * <h1> Print Success Message </h1>
     * <p>
     * Prints the Message that the Operation completed Successfully or not
     * </p>
     *
     * @param isSuccess - boolean value of Operation performed
     */
    private void printSuccessMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("\n>>>>> Successfully finished the operation <<<<<\n");
        } else {
            System.out.println("\n>>>>> Error: Please check something went wrong <<<<<\n");
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
                        .append("Press \" 4 \" for Update\n")
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
        choicePrinter.append(">>>>> Lead Id can't be changed <<<<<\n")
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
        System.out.print(choicePrinter);
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
                      .append("|           WELCOME EMPLOYEE!            |")
                      .append("========================================\n");
        System.out.println(welcomePrinter);
    }
}                                          
