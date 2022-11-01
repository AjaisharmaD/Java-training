package com.ideas2it.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.LeadController;
import com.ideas2it.controller.UserController;
import com.ideas2it.enums.Status;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
import com.ideas2it.view.AccountView;
import com.ideas2it.view.ContactView;
import com.ideas2it.view.OpportunityView;

/**
 * <h1> Lead View </h1>
 * <p> 
 * Lead view class used to Provide Dashboard of operations 
 * performed by the Employee, like Adding, Updating,
 * Viewing, Searching, Deleting the Details of Lead
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.5 06-10-2022
 * @since   16-09-2022
 */
public class LeadView {
    private CustomLogger logger;
    private LeadController leadController;
    private AccountView accountView;
    private ContactView contactView;
    private OpportunityView opportunityView;
        
    public LeadView() {
        this.logger = new CustomLogger(LeadView.class);
        this.leadController = new LeadController();
        this.accountView = new AccountView();
        this.contactView = new ContactView();
        this.opportunityView = new OpportunityView();
    }

    /**
     * <h1> Employee Dashboard </h1>
     * <p>
     * Provides the choice to go to the Dashboards of Lead,
     * Account, Contact, Opportunity
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    public void openEmployeeDashboard(Scanner scanner, int userId) {
        boolean isOpen = false;
        String operationChoice; 
        String logout;   
        printWelcomeMessage();     

        while (!isOpen) {
            printLeadMenu();
            operationChoice = scanner.next();
                   
            switch (operationChoice) {
            case Constants.LEAD:
                openLeadOperations(scanner, userId);
                break;
                 
            case Constants.ACCOUNT:
                accountView.showAccountDashboard(scanner);
                break;
                              
            case Constants.CONTACT:
                contactView.showContactDashboard(scanner, userId);
                break;

            case Constants.OPPORTUNITY:
                opportunityView.showOpportunityDashboard(scanner);
                break;
                  
            case Constants.EXIT:
                System.out.println(Messages.EXIT_MENU);
                logout = scanner.next();
                isOpen = (logout.equals(Constants.LOGOUT)) ? true : false;        
                break;
                   
            default:
                logger.warn(Messages.INVALID_CHOICE); 
            }        
        }
    }

    /**
     * <h1> Lead Dashboard </h1>
     * <p>
     * Method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Lead
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void openLeadOperations(Scanner scanner, int userId) {
        boolean isOpen = false;
        String operationChoice; 
        String logout;   
        printLeadTitle();     
                
        while (!isOpen) {
            printOperationMenu();
            operationChoice = scanner.next();
                   
            switch (operationChoice) {
            case Constants.ADDER:
                create(scanner, userId);
                break;
                 
            case Constants.PROJECTOR:
                displayAll(scanner, userId);
                break;
                                                
            case Constants.FINDER:
                displayById(scanner, userId);
                break;
                       
            case Constants.UPDATER:
                updateById(scanner, userId);
                break;

            case Constants.REMOVER:
                deleteById(scanner, userId);
                break;
            
            case Constants.EXIT_LEAD:  
                System.out.println(Messages.EXIT_MENU);
                logout = scanner.next();
                isOpen = (logout.equals(Constants.LOGOUT)) ? true : false;        
                break;
                   
            default:
                logger.warn(Messages.INVALID_CHOICE); 
            }        
        }
    }
    
    /**
     * <h1> Create Lead </h1>
     * <p>
     * Method will ask for the Details from the Employee
     * and passes the Details of Lead to store
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void create(Scanner scanner, int userId) {
        Lead lead = null;
        String name;
        String email;
        String phoneNumber;
        String companyName;
        String status;
        String createdDate;

        name = getName(scanner);
        email = getEmailId(scanner);     
        phoneNumber = getPhoneNumber(scanner); 
        companyName = getCompanyName(scanner);
        status = getStatus(scanner, lead, userId);
        createdDate = getCreatedDate();
        lead = new Lead(name, email, phoneNumber,companyName, status,
                                                              userId);
        lead.setCreatedDate(createdDate);
        System.out.println((leadController.create(lead)) != true 
                                          ? Messages.ADDED_SUCCESSFULLY 
                                          : Messages.FAILED_TO_ADD);
    }

    /**   
     * <h1> Display Details of lead </h1>
     * <p>
     * Method will Display all the Details of Lead
     * </p>
     */
    private void displayAll(Scanner scanner, int userId) {
        System.out.println("\n========== LEAD DETAILS ==========\n");
        List<Lead> leads = leadController.getAll(userId);

        if (!leads.isEmpty()) {
            for (Lead lead : leads) {
                System.out.println(lead);
                System.out.println("\n--------------X---------------\n");
            } 
        } else {
            logger.info(Messages.LEAD_NOT_FOUND);
        }
    }
   
   /**
     * <h1> Display Lead By Id </h1>
     * <p>
     * Method is used to serach the Details of Lead by calling the Lead Id
     * This will Display the Details of a Single Lead
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void displayById(Scanner scanner, int userId) {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the ID to Lead: ");

        int id = scanner.nextInt();
        Lead lead = leadController.getById(id);

        if (null != lead) {
            System.out.println("\n" + lead);
            System.out.println("\n--------------X---------------");
        } else {
            logger.warn(Messages.LEAD_NOT_FOUND);
        }
    }

    /**
     * <h1> Update the Lead </h1>
     * <p>
     * Method will updates the each fields of the Lead Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void updateById(Scanner scanner, int userId) {  
        System.out.println("\n========== UPDATE LEAD  ==========\n");
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        int id = scanner.nextInt();
        String columnName = ""; 
        boolean isUpdating = false;
        String updaterChoice;
        String logout;
        Lead lead = leadController.getById(id);
        System.out.println("\n" + lead);
        System.out.println("\n--------------X---------------");

        if (lead != null) {
            while (!isUpdating) {
                printUpdaterMenu();
                updaterChoice = scanner.next();
                  
                switch (updaterChoice) {
                case Constants.NAME:
                    columnName = "name";
                    printUpdatedStatus(leadController.updateById(id, columnName, getName(scanner)));
                    break;
                    
                case Constants.EMAIL:
                    columnName = "email";
                    scanner.skip("\r\n");
                    printUpdatedStatus(leadController.updateById(id, columnName, getEmailId(scanner)));
                    break;
                         
                case Constants.PHONE_NUMBER:
                    columnName = "phone_number";
                    scanner.skip("\r\n");
                    printUpdatedStatus(leadController.updateById(id, columnName, getPhoneNumber(scanner)));
                    break;
                        
                case Constants.COMPANY_NAME:
                    columnName = "company_name";
                    scanner.skip("\r\n");
                    printUpdatedStatus(leadController.updateById(id, columnName, getCompanyName(scanner)));
                    break;
   
                case Constants.STATUS:
                    columnName = "status";
                    printUpdatedStatus(leadController.updateById(id, columnName, getStatus(scanner, lead, userId)));
                    break;

                case Constants.EXIT_LEAD:
                    isUpdating = true;
                    break;
                                  
                default:
                    logger.warn(Messages.INVALID_CHOICE);  
                }                
            }  
        } else  {
            logger.warn(Messages.LEAD_NOT_FOUND);
        }  
    }   

    /**
     * <h1> Delete the Lead </h1>
     * <p>
     * Method will Delete the Details of a Lead 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void deleteById(Scanner scanner, int userId) {
        System.out.println("\n========== DELETE LEAD  ==========\n");
        System.out.print("Enter the ID to Delete Lead\n \" Format:Lead_01 \" : ");
        int id = scanner.nextInt(); 
        Lead lead = leadController.getById(id);

        if (null != lead) {
            if (lead.getUserId() == userId) {
                if (leadController.isDeletedById(id)) { 
                    logger.info(Messages.DELETED_SUCCESSFULLY);
                } else {
                    logger.warn(Messages.FAILED_TO_DELETE);
                }
            } else {
                logger.warn(Messages.NOT_ASSIGNED);
            }             
        } else  {
            logger.warn(Messages.LEAD_NOT_FOUND);
        }
    }       

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name of the Lead and checks whether the Name is Valid or not
     * </p> 
     *     
     * @param scanner - object of a Scanner class
     *
     * @return name   - a Valid Name of the Lead
     */
    private String getName(Scanner scanner) {
        String name = "";
        boolean isNotValid = false;
   
        scanner.skip("\r\n");
        while (!isNotValid) {
            System.out.print("Name                 : ");
            name = scanner.nextLine();

            if (leadController.isValidName(name)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_NAME_FORMAT);
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
     * @param scanner - object of a Scanner class
     *
     * @return email - a Valid Email of the Lead
     */
    private String getEmailId(Scanner scanner) {
        String emailId = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Email ID             : ");
            emailId = scanner.nextLine();

            if (leadController.isValidEmailId(emailId)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_EMAIL_ID_FORMAT);
            }  
        }
        return emailId;
    }

    /**
     * <h1> Get Phone Number </h1>
     * <p>
     * Gets the Phone Number of the Lead and checks whether the Phone Number is Valid or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return phoneNumber - a Valid Phone Number of the Lead
     */
    private String getPhoneNumber(Scanner scanner) {
        String phoneNumber = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Phone Number         : ");
            phoneNumber = scanner.nextLine();

            if (leadController.isValidPhoneNumber(phoneNumber)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_PHONE_NUMBER_FORMAT);
            }  
        }
        return phoneNumber;
    }

    /**
     * <h1> Get Company Name </h1>
     * <p>
     * Gets the Company Name of the Lead and checks whether the Company Name is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
     *
     * @return companyName - a Valid Company Name of the Lead
     */
    private String getCompanyName(Scanner scanner) {
        String companyName = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Company Name         : ");
            companyName = scanner.nextLine();

            if (leadController.isValidCompanyName(companyName)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_COMPANY_NAME_FORMAT);
            }  
        }
        return companyName;
    }

    /**
     * <h1> Get Status </h1>
     * <p>
     * Gets the Status of the Lead
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return status - Status of a Lead
     */
    private String getStatus(Scanner scanner, Lead lead, int userId) {
        boolean isSelected = false;
        String logout;
        String status = "";
        String statusChoice;

        while (!isSelected) {
            printStatusMenu();
            statusChoice = scanner.next();

            switch (statusChoice) {
            case Constants.NEW:
                status = Status.New.toString();
                isSelected = true;
                break;

            case Constants.CONTACTED:
                status = Status.Contacted.toString();
                isSelected = true;
                break;

            case Constants.WORKING:
                status = Status.Working.toString();
                isSelected = true;
                break;

            case Constants.QUALIFIED:
                status = Status.Qualified.toString();
                isSelected = true;
                break;

            case Constants.UNQUALIFIED:
                status = Status.Unqualified.toString();
                isSelected = true; 
                break;

            case Constants.CONVERTED:               
                if (lead != null) {
                    status = contactView.createFromLead(scanner, lead, userId);
                    isSelected = true; 
                } else {
                    logger.warn("Tried to convert the lead which not present");
                } 
                break;

            default:
                logger.warn(Messages.INVALID_CHOICE);
            }
        }
        return status;
    }

    /**
     * <h1> Get ID </h1>
     * <p>
     * Gets the Id of the user
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return id     - a valid Id 

    private String getId(Scanner scanner) {
        String id = " ";
        boolean isNotValid = false;

        while (!isNotValid) {
            id = scanner.nextLine();

            if (leadController.isValidId(id)) {
                isNotValid = true;
            } else { 
                logger.error(Messages.WRONG_ID_FORMAT);
            }  
        }
        return id; 
    }
     */

    /**
     * <h1> Get Created Date </h1>
     * <p>
     * Gets the Created Date of the Lead
     * </p>
     *
     * @return date - a Valid Start Date
     */
    private String getCreatedDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        String createdDate = formatter.format(date); 
        logger.info("Date created successfully");
        return createdDate;
    }

    /**
     * <h1> Print Update Status </h1>
     * <p>
     * Prints the Update Status of the Lead
     * </p>
     *
     * @param lead - Update lead
     */
    private void printUpdatedStatus(boolean status) {
        if (status) {
            logger.info(Messages.UPDATED_SUCCESSFULLY);
        } else {
            logger.info(Messages.FAILED_TO_UPDATE);
        }
    }

    /**
     * <h1> Print Lead Menu </h1>
     * <p>
     * Prints the Lead Menu
     * </p>
     */
    private void printLeadMenu() {
        StringBuilder leadMenu = new StringBuilder();
        leadMenu.append("\nPress \" ").append(Constants.LEAD)
                .append(" \" for Lead\n")
                .append("Press \" ").append(Constants.ACCOUNT)
                .append(" \" for Account\n")
                .append("Press \" ").append(Constants.CONTACT)
                .append(" \" for Contact\n")
                .append("Press \" ").append(Constants.OPPORTUNITY)
                .append(" \" for Opportunity\n")
                .append("Press \" ").append(Constants.EXIT)
                .append(" \" for EXIT\n")
                .append("Enter your Operation: ");
        System.out.print(leadMenu);
    }
    /**
     * <h1> Print Operation Menu </h1>
     * <p>
     * Prints the Operation Menu
     * </p>
     */
    private void printOperationMenu() {
        StringBuilder operationMenu = new StringBuilder();
        operationMenu.append("\nPress \" ").append(Constants.ADDER)
                     .append(" \" for Create New Lead\n")
                     .append("Press \" ").append(Constants.PROJECTOR)
                     .append(" \" for View\n")
                     .append("Press \" ").append(Constants.FINDER)
                     .append(" \" for Search\n")
                     .append("Press \" ").append(Constants.UPDATER)
                     .append(" \" for Update\n")
                     .append("Press \" ").append(Constants.REMOVER)
                     .append(" \" for Delete\n")
                     .append("Press \" ").append(Constants.EXIT_LEAD)
                     .append(" \" for EXIT\n")
                     .append("Enter your Operation: ");
        System.out.print(operationMenu);
    }

    /**
     * <h1> Print Updation Menu </h1>
     * <p>
     * Prints the Menu for Updating the Details of Lead
     * </p>
     */
    private void printUpdaterMenu() {
        StringBuilder updaterMenu = new StringBuilder();
        updaterMenu.append("\npress \" ").append(Constants.NAME)
                   .append(" \" for Name\n")
                   .append("press \" ").append(Constants.EMAIL)
                   .append(" \" for Email\n")
                   .append("press \" ").append(Constants.PHONE_NUMBER)
                   .append(" \" for Phone Number\n")
                   .append("press \" ").append(Constants.COMPANY_NAME)
                   .append(" \" for Company Name\n")
                   .append("press \" ").append(Constants.STATUS)
                   .append(" \" for Status\n")
                   .append("press \" ").append(Constants.EXIT_LEAD)
                   .append(" \" for Exit\n")
                   .append("Enter your Updater: "); 
        System.out.print(updaterMenu);
    }

    /**
     * <h1> Print Status Menu </h1>
     * <p>
     * Prints the Menu for Lead Status
     * </p>
     */
    private void printStatusMenu() {
        StringBuilder statusMenu = new StringBuilder();
        statusMenu.append("+=============================+")
                  .append("\n|           \"STATUS\"          |")
                  .append("\n| press \" ").append(Constants.NEW)
                  .append(" \" for New         |\n")
                  .append("| press \" ").append(Constants.CONTACTED)
                  .append(" \" for Contacted   |\n")
                  .append("| press \" ").append(Constants.WORKING)
                  .append(" \" for Working     |\n")
                  .append("| press \" ").append(Constants.QUALIFIED)
                  .append(" \" for Qualified   |\n")
                  .append("| press \" ").append(Constants.UNQUALIFIED)
                  .append(" \" for Unqualified |\n")
                  .append("| press \" ").append(Constants.CONVERTED)
                  .append(" \" for Converted   |\n")
                  .append("+=============================+\n")
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
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("\n========================================")
                      .append("|           WELCOME EMPLOYEE!            |")
                      .append("========================================");
        System.out.println(welcomeMessage);
    }

    /**
     * <h1> Print Lead Title  </h1>
     * <p>
     * Prints the Title of Lead
     * </p>
     */
    private void printLeadTitle() {
        StringBuilder title = new StringBuilder();
        title.append("\n========================================")
             .append("|                 LEAD!                  |")
             .append("========================================");
        System.out.println(title);
    }
}                                          