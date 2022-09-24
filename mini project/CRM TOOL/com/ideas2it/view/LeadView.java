package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.controller.LeadController;
import com.ideas2it.model.Lead;

/**
 * <h1> Lead View </h1>
 * <p> 
 * This Lead view class used to Provide Dashboard of operations 
 * performed by the Employee, like Adding, Updating,
 * Viewing, Searching, Deleting the Details of Lead
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.0 
 * @since   16-09-2022
 */
public class LeadView {
    private Scanner scanner = new Scanner(System.in);
    private LeadController leadController;
        
    public LeadView() {
        this.leadController = new LeadController();
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
        byte logout;   

        printWelcomeMessage();     
                
        while (!isActive) {
            printOperationMenu();
            operation = scanner.nextByte();
                   
            switch (operation) {
            case Constants.ADDER:
                createLead();
                break;
                 
            case Constants.PROJECTOR:
                display();
                break;
                                                
            case Constants.FINDER:
                displayById();
                break;
                       
            case Constants.UPDATER:
                updateById();
                break;

            case Constants.REMOVER:
                deleteById();
                break;
              
            case Constants.EXIT:
                printExitMenu();
                logout = scanner.nextByte();
                isActive = (logout == Constants.LOGOUT) ? true : false; 
                break;
                   
            default:
                printDefaultStatement();
            }        
        }
    }
    
    /**
     * <h1> Create Lead </h1>
     * <p>
     * This method will ask for the Details from the Employee
     * and passes the Details of Lead to store
     * </p>
     */
    private void createLead() {
        String name;
        String email;
        String phoneNumber;
        String stage;
        String companyName;
        String startDate;
        String endDate;
        Double dealCost = 0.00d;

        System.out.print("\nEnter the lead count to add: ");
        int count = scanner.nextInt();

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter Lead 0" + (index + 1) + " Details ======\n");
            scanner.skip("\r\n");
            name = getName();
            email = getEmail();     
            phoneNumber = getPhoneNumber();
            stage = getStage();    
            companyName = getCompanyName();    
            startDate = getStartDate();     
            endDate = getEndDate();    
            dealCost = getDealCost();

            System.out.println(leadController.createLead(new Lead(name, email, 
                                   phoneNumber, stage, companyName,
                                   startDate, endDate, dealCost)));
        }
    }

    /**   
     * <h1> Display Details of lead </h1>
     * <p>
     * This method will Display all the Details of Lead
     * </p>
     */
    private void display() {
        System.out.println("\n========== LEAD DETAILS ==========\n");
        System.out.println(leadController.getLeads());
    }
   
   /**
     * <h1> Disply Single Lead By Id </h1>
     * <p>
     * This method is used to serach the Details of Lead by calling the Lead Id
     * This will Display the Details of a Single Lead
     * </p>
     */
    private void displayById() {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the lead's Id to Search: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println(leadController.getById(id));
    }

    /**
     * <h1> Update the Lead </h1>
     * <p>
     * This method will updates the each fields of the Lead Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     */
    private void updateById() {  
        System.out.println("\n========== UPDATE LEAD  ==========\n");
        System.out.print("Enter the lead's Id to update: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();   
        boolean isUpdating = false;
        byte updater;
        byte logout;

        Lead lead = leadController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updater = scanner.nextByte();
                     
            switch (updater) {
            case Constants.NAME:
                scanner.skip("\r\n");
                lead.setName(getName());
                System.out.println(leadController.updateById(id, lead));
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                lead.setEmailId(getEmail());
                System.out.println(leadController.updateById(id, lead));
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                lead.setPhoneNumber(getPhoneNumber());
                System.out.println(leadController.updateById(id, lead));
                break;
                           
            case Constants.STAGE:
                scanner.skip("\r\n");
                lead.setStage(getStage());
                System.out.println(leadController.updateById(id, lead));
                break;
                           
            case Constants.COMPANY_NAME:
                scanner.skip("\r\n");
                lead.setCompanyName(getCompanyName());
                System.out.println(leadController.updateById(id, lead));
                break;
                            
            case Constants.START_DATE:
                scanner.skip("\r\n");
                lead.setStartDate(getStartDate());
                System.out.println(leadController.updateById(id, lead));
                break;
                           
            case Constants.END_DATE:
                scanner.skip("\r\n");
                lead.setEndDate(getEndDate());
                System.out.println(leadController.updateById(id, lead));
                break;
                           
            case Constants.DEAL_SIZE:
                scanner.skip("\r\n");
                lead.setDealCost(getDealCost());
                System.out.println(leadController.updateById(id, lead));
                break;
                           
            case Constants.EXIT_EMPLOYEE_UPDATER:
                printExitMenu();
                logout = scanner.nextByte();
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
     * @return name - a Valid Name of the Lead
     */
    private String getName() {
        String name = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Name                               : ");
            name = scanner.nextLine();

            if (leadController.isValidName(name)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Name Format, Give the proper Name! <<<<<\n");
            }  
        }
        return name;
    }

    /**
     * <h1> Get Email Id </h1>
     * <p>
     * Gets the Email of the Lead and checks whether the Email is Valid or not
     * </p>
     *
     * @return email - a Valid Email of the Lead
     */
    private String getEmail() {
        String email = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Email ID                           : ");
            email = scanner.nextLine();

            if (leadController.isValidEmail(email)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Email Format, Give the proper Email! <<<<<\n");
            }  
        }
        return email;
    }

    /**
     * <h1> Get Phone Number </h1>
     * <p>
     * Gets the Phone Number of the Lead and checks whether the Phone Number is Valid or not
     * </p>
     *
     * @return phoneNumber - a Valid Phone Number of the Lead
     */
    private String getPhoneNumber() {
        String phoneNumber = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Phone Number                       : ");
            phoneNumber = scanner.nextLine();

            if (leadController.isValidPhoneNumber(phoneNumber)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Phone Number Format, Give the proper Phone Number! <<<<<\n");
            }  
        }
        return phoneNumber;
    }

    /**
     * <h1> Get Stage </h1>
     * <p>
     * Gets the Stage of the Lead
     * </p>
     *
     * @return stage - an updated Stage
     */
    private String getStage() {
        System.out.print("Enter the Lead's Stage                          : ");
        String stage = scanner.nextLine();
        return stage;
    }

    /**
     * <h1> Get Company Name </h1>
     * <p>
     * Gets the Company Name of the Lead and checks whether the Company Name is Valid or not
     * </p> 
     *
     * @return companyName - a Valid Company Name of the Lead
     */
    private String getCompanyName() {
        String companyName = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Company Name                     : ");
            companyName = scanner.nextLine();

            if (leadController.isValidCompanyName(companyName)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Company Name Format, Give the proper Company Name! <<<<<\n");
            }  
        }
        return companyName;
    }
    
    /**
     * <h1> Get Start Date </h1>
     * <p>
     * Gets the Satrt Date of the Lead
     * </p>
     *
     * @return startDate - an updated Start Date
     */
    private String getStartDate() {
        System.out.print("Enter the Start-Date in this Formate DD-MM-YYYY: ");
        String startDate = scanner.nextLine();
        return startDate;
    }

    /**
     * <h1> Get End Date </h1>
     * <p>
     * Gets the End Date of the Lead
     * </p>
     *
     * @return endDate - an updated End Date
     */
    private String getEndDate() {
        System.out.print("Enter the End-Date in this Formate DD-MM-YYYY  : ");
        String endDate = scanner.nextLine();
        return endDate;
    }

    /**
     * <h1> Get Deal Cost </h1>
     * <p>
     * Gets the Deal Cost of the Lead and checks whether the Deal Size is Valid or not
     * </p>
     *
     * @return dealCost - a Valid Deal Cost
     */
    private Double getDealCost() {
        Double dealCost = 0.00d;
        boolean isNotValid = false;
        String costOfDeal = "";

        while (!isNotValid) {
            System.out.print("Enter the Deal Size                            : ");
            dealCost = scanner.nextDouble();
            costOfDeal = Double.toString(dealCost);
            if (leadController.isValidDealSize(costOfDeal)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Deal Size Format, Give the proper Deal Size! <<<<<\n");
            }  
        }
        return dealCost;
    }

    /**
     * <h1> Delate the Lead </h1>
     * <p>
     * This method will Delete the Details of a Lead 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void deleteById() {
        System.out.println("\n========== DELETE LEAD  ==========\n");
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        boolean isRemoved = leadController.deleteById(id);
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
        OperationPrinter.append("Press \" 1 \" for Create New Lead\n")
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
                     .append("press \" 8 \" for Deal Cost\n")
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