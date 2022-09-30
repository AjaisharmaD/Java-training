package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.LeadController;
import com.ideas2it.enums.Status;
import com.ideas2it.model.Lead;

/**
 * <h1> Lead View </h1>
 * <p> 
 * Lead view class used to Provide Dashboard of operations 
 * performed by the Employee, like Adding, Updating,
 * Viewing, Searching, Deleting the Details of Lead
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.0 
 * @since   16-09-2022
 */
public class LeadView {
    private LeadController leadController;
        
    public LeadView() {
        this.leadController = new LeadController();
    }

    /**
     * <h1> Employee Dashboard </h1>
     * <p>
     * Method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Lead
     * </p>
     */
    public void openEmployeeDashboard(Scanner scanner) {
        boolean isActive = false;
        byte operationChoice; 
        byte logout;   
        printWelcomeMessage();     
                
        while (!isActive) {
            printOperationMenu();
            operationChoice = getChoice(scanner);
                   
            switch (operationChoice) {
            case Constants.ADDER:
                create(scanner);
                break;
                 
            case Constants.PROJECTOR:
                displayAll();
                break;
                                                
            case Constants.FINDER:
                displayById(scanner);
                break;
                       
            case Constants.UPDATER:
                updateById(scanner);
                break;

            case Constants.REMOVER:
                deleteById(scanner);
                break;
              
            case Constants.EXIT:
                while (!isActive) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isActive = (logout == Constants.LOGOUT) ? true : false;                    
                } 
                break;
                   
            default:
                System.out.println(Messages.DEFAULT_MESSAGE); 
            }        
        }
    }
    
    /**
     * <h1> Create Lead </h1>
     * <p>
     * Method will ask for the Details from the Employee
     * and passes the Details of Lead to store
     * </p>
     */
    private void create(Scanner scanner) {
        String name;
        String email;
        String phoneNumber;
        String status;
        String companyName;
        String startDate;
        String endDate;
        Double dealCost = 0.00d;

        int count = 0;
        boolean isRight = false;

        while (!isRight) {
            try {
                System.out.print("\nEnter the Employee count to add: ");
                count = scanner.nextInt();
                isRight = true;
            } catch (InputMismatchException e) {
                System.out.println("\n>>>>> Please Enter Numbers only! <<<<<\n");
                scanner.next();
                continue;
            }
        }

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter Lead 0" + (index + 1) 
                                                       + " Details ======\n");
            scanner.skip("\r\n");
            name = getName(scanner);
            email = getEmail(scanner);     
            phoneNumber = getPhoneNumber(scanner);
            status = getStatus(scanner);    
            companyName = getCompanyName(scanner);    
            startDate = getStartDate(scanner);     
            endDate = getEndDate(scanner);    
            dealCost = getDealCost(scanner);
            System.out.println((leadController.create(new Lead(name, email, 
                                   phoneNumber, status, companyName,
                                   startDate, endDate, dealCost)) != null) 
                                   ? Messages.SUCCESS : Messages.FAILED);
        }
    }

    /**   
     * <h1> Display Details of lead </h1>
     * <p>
     * Method will Display all the Details of Lead
     * </p>
     */
    private void displayAll() {
        System.out.println("\n========== LEAD DETAILS ==========\n");

        for (Lead lead : leadController.getAll()) {
            System.out.println(lead);
        }
    }
   
   /**
     * <h1> Disply Lead By Id </h1>
     * <p>
     * Method is used to serach the Details of Lead by calling the Lead Id
     * This will Display the Details of a Single Lead
     * </p>
     */
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println(leadController.getById(id));
    }

    /**
     * <h1> Update the Lead </h1>
     * <p>
     * Method will updates the each fields of the Lead Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     */
    private void updateById(Scanner scanner) {  
        System.out.println("\n========== UPDATE LEAD  ==========\n");
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();   
        boolean isUpdating = false;
        byte updaterChoice;
        byte logout;
        Lead lead = leadController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = getChoice(scanner);
                     
            switch (updaterChoice) {
            case Constants.NAME:
                scanner.skip("\r\n");
                lead.setName(getName(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                lead.setEmailId(getEmail(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                lead.setPhoneNumber(getPhoneNumber(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                           
            case Constants.STATUS:
                scanner.skip("\r\n");
                lead.setStatus(getStatus(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                           
            case Constants.COMPANY_NAME:
                scanner.skip("\r\n");
                lead.setCompanyName(getCompanyName(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                            
            case Constants.START_DATE:
                scanner.skip("\r\n");
                lead.setStartDate(getStartDate(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                           
            case Constants.END_DATE:
                scanner.skip("\r\n");
                lead.setEndDate(getEndDate(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                           
            case Constants.DEAL_COST:
                scanner.skip("\r\n");
                lead.setDealCost(getDealCost(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                           
            case Constants.EXIT_LEAD_UPDATER:
                while (!isUpdating) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isUpdating = (logout == Constants.LOGOUT) ? true : false;                    
                } 
                break;
                                  
            default:
                System.out.println(Messages.DEFAULT_MESSAGE);  
            }            
        }         
    }   

    /**
     * <h1> Delete the Lead </h1>
     * <p>
     * Method will Delete the Details of a Lead 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE LEAD  ==========\n");
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println((leadController.isDeletedById(id)) 
                                   ? Messages.SUCCESS : Messages.FAILED);
    }          

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name of the Lead and checks whether the Name is Valid or not
     * </p> 
     *
     * @return name - a Valid Name of the Lead
     */
    private String getName(Scanner scanner) {
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
    private String getEmail(Scanner scanner) {
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
    private String getPhoneNumber(Scanner scanner) {
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
     * <h1> Get Status </h1>
     * <p>
     * Gets the Status of the Lead
     * </p>
     *
     * @return status - Status of a Lead
     */
    private String getStatus(Scanner scanner) {
        System.out.print("Enter the Lead's Status                      : ");
        boolean isSelecting = false;
        String status = "";
        printStatusMenu();
        byte statusChoice = getChoice(scanner);

        switch (statusChoice) {
        case Constants.NEW:
            status = Status.New.toString();
            break;

        case Constants.WORKING:
            status = Status.Working.toString();
            break;

        case Constants.NURTURING:
            status = Status.Nurturing.toString();
            break;

        case Constants.QUALIFIED:
            status = Status.Qualified.toString();
            break;

        default:
            System.out.println(Messages.DEFAULT_MESSAGE);
        }
        return status;
    }

    /**
     * <h1> Get Company Name </h1>
     * <p>
     * Gets the Company Name of the Lead and checks whether the Company Name is Valid or not
     * </p> 
     *
     * @return companyName - a Valid Company Name of the Lead
     */
    private String getCompanyName(Scanner scanner) {
        String companyName = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Company Name                       : ");
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
     * Gets the Start Date of the Lead
     * </p>
     *
     * @return date - a Valid Start Date
     */
    private String getStartDate(Scanner scanner) {
        String date = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Start Date [format: dd/mm/yyyy]    : ");
            date = scanner.nextLine();

            if (leadController.isValidDate(date)) {
                break;
            } else {
                System.out.println("\n>>>>> Wrong Date Format! <<<<<\n");
            }
        }
        return date;
    }
    
    /**
     * <h1> Get End Date </h1>
     * <p>
     * Gets the End Date of the Lead
     * </p>
     *
     * @return date - a Valid End Date
     */
    private String getEndDate(Scanner scanner) {
        String date = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the End Date [format: dd/mm/yyyy]      : ");
            date = scanner.nextLine();

            if (leadController.isValidDate(date)) {
                break;
            } else {
                System.out.println("\n>>>>> Wrong Date Format! <<<<<\n");
            }
        }
        return date;
    }

    /**
     * <h1> Get Deal Cost </h1>
     * <p>
     * Gets the Deal Cost of the Lead and checks whether the Deal Size is Valid or not
     * </p>
     *
     * @return dealCost - a Valid Deal Cost
     */
    private Double getDealCost(Scanner scanner) {
        Double dealCost = 0.00d;
        boolean isNotValid = false;
        String costOfDeal = "";

        while (!isNotValid) {
            System.out.print("Enter the Deal Size                          : ");
            dealCost = scanner.nextDouble();
            costOfDeal = Double.toString(dealCost);
            if (leadController.isValidDealCost(costOfDeal)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Deal Cost Format, Give the proper Deal Cost! <<<<<\n");
            }  
        }
        return dealCost;
    }

    /**
     * <h1> Get choice </h1>
     * <p>
     * Gets the choice from the user
     * </p>
     */
    private byte getChoice(Scanner scanner) {
        byte choice = 0;
        try {
            choice = scanner.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("\n>>>>> Please Enter Numbers only! <<<<<\n");
            scanner.next();  // clears the scanner buffer
        }
        return choice;
    }

    /**
     * <h1> Print Operation Menu </h1>
     * <p>
     * Prints the Operation Menu
     * </p>
     */
    private void printOperationMenu() {
        StringBuilder OperationPrinter = new StringBuilder();
        OperationPrinter.append("Press \" ").append(Constants.ADDER)
                        .append(" \" for Create New Lead\n")
                        .append("Press \" ").append(Constants.PROJECTOR)
                        .append(" \" for View\n")
                        .append("Press \" ").append(Constants.FINDER)
                        .append(" \" for Search\n")
                        .append("Press \" ").append(Constants.UPDATER)
                        .append(" \" for Update\n")
                        .append("Press \" ").append(Constants.REMOVER)
                        .append(" \" for Delete\n")
                        .append("Press \" ").append(Constants.EXIT)
                        .append(" \" for EXIT\n")
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
                     .append("\npress \" ").append(Constants.NAME)
                     .append(" \" for Name\n")
                     .append("press \" ").append(Constants.EMAIL)
                     .append(" \" for Email\n")
                     .append("press \" ").append(Constants.PHONE_NUMBER)
                     .append(" \" for Phone Number\n")
                     .append("press \" ").append(Constants.STATUS)
                     .append(" \" for Status\n")
                     .append("press \" ").append(Constants.COMPANY_NAME)
                     .append(" \" for Company Name\n")
                     .append("press \" ").append(Constants.START_DATE)
                     .append(" \" for Start date\n")
                     .append("press \" ").append(Constants.END_DATE)
                     .append(" \" for End date\n")
                     .append("press \" ").append(Constants.DEAL_COST)
                     .append(" \" for Deal Cost\n")
                     .append("press \" ").append(Constants.EXIT_LEAD_UPDATER)
                     .append(" \" for Exit\n")
                     .append("Enter your Updater: "); 
        System.out.print(choicePrinter);
    }

    /**
     * <h1> Print Status Menu </h1>
     * <p>
     * Prints the Menu for Lead Status
     * </p>
     */
    private void printStatusMenu() {
        StringBuilder statusMenu = new StringBuilder();
        statusMenu.append("\npress \" ").append(Constants.NEW)
                     .append(" \" for New\n")
                     .append("press \" ").append(Constants.WORKING)
                     .append(" \" for Working\n")
                     .append("press \" ").append(Constants.NURTURING)
                     .append(" \" for Nurturing\n")
                     .append("press \" ").append(Constants.QUALIFIED)
                     .append(" \" for Qualified\n")
                     .append("press \" ").append(Constants.CLOSE)
                     .append(" \" for Close\n")
                     .append("Enter your Choice: ");
        System.out.print(statusMenu);

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