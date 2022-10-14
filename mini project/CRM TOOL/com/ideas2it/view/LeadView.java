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
    public void openEmployeeDashboard(Scanner scanner, String userId) {
        boolean isActive = false;
        byte operationChoice; 
        byte logout;   
        printWelcomeMessage();     

        while (!isActive) {
            printLeadMenu();
            operationChoice = getChoice(scanner);
                   
            switch (operationChoice) {
            case Constants.LEAD:
                openLeadOperations(scanner, userId);
                break;
                 
            case Constants.ACCOUNT:
                accountView.showAccountDashboard(scanner, contactView, opportunityView);
                break;
                              
            case Constants.CONTACT:
                contactView.showContactDashboard(scanner);
                break;

            case Constants.OPPORTUNITY:
                opportunityView.showOpportunityDashboard(scanner);
                break;
                  
            case Constants.EXIT:
                while (!isActive) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isActive = (logout == Constants.LOGOUT) ? true : false;        
                } 
                break;
                   
            default:
                logger.warn(Messages.DEFAULT_MESSAGE); 
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
    private void openLeadOperations(Scanner scanner, String userId) {
        boolean isOpened = false;
        byte operationChoice; 
        byte logout;   
        printLeadTitle();     
                
        while (!isOpened) {
            printOperationMenu();
            operationChoice = getChoice(scanner);
                   
            switch (operationChoice) {
            case Constants.ADDER:
                create(scanner, userId);
                break;
                 
            case Constants.PROJECTOR:
                displayAll(scanner);
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
            
            case Constants.EXIT_LEAD:
                while (!isOpened) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isOpened = (logout == Constants.LOGOUT) ? true : false;        
                } 
                break;
                   
            default:
                logger.warn(Messages.DEFAULT_MESSAGE); 
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
    private void create(Scanner scanner, String userId) {
        Lead lead = null;
        String name;
        String email;
        String phoneNumber;
        String companyName;
        String status;
        String createdDate;

        int count = 0;
        boolean isRight = false;

        while (!isRight) {
            try {
                System.out.print("\nEnter the Lead count to add: ");
                count = scanner.nextInt();
                isRight = true;
            } catch (InputMismatchException e) {
                logger.warn("\n>>>>> Please Enter Numbers only! <<<<<\n");
                scanner.next();
                continue;
            }
        }
        scanner.skip("\r\n");

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter Lead 0" + (index + 1) 
                                                       + " Details ======\n");
            name = getName(scanner);
            email = getEmailId(scanner);     
            phoneNumber = getPhoneNumber(scanner); 
            companyName = getCompanyName(scanner);
            status = getStatus(scanner, lead);
            createdDate = getCreatedDate();
            scanner.skip("\r\n");
            lead = new Lead(name, email, phoneNumber,companyName, status,
                                          createdDate);
            lead.setEmployeeId(userId);
            System.out.println((leadController.create(lead) != null) 
                                          ? Messages.SUCCESS 
                                          : Messages.FAILED);
        }
    }

    /**   
     * <h1> Display Details of lead </h1>
     * <p>
     * Method will Display all the Details of Lead
     * </p>
     */
    private void displayAll(Scanner scanner) {
        System.out.println("\n========== LEAD DETAILS ==========\n");
        
        scanner.skip("\r\n");
        String userId;

        if (null != leadController.getAll()) {
            for (Lead lead : leadController.getAll()) {
                System.out.println(lead);
                userId = getId(scanner);
                if (lead.getEmployeeId().equals(userId)) {
                    System.out.println(lead);
                    System.out.println("\n--------------X---------------\n");
                }
            }
        } else {
            logger.info(">>>>> No Lead Found! <<<<<");
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
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = getId(scanner);

        if (null != leadController.getById(id)) {
            System.out.println("\n" + leadController.getById(id));
            System.out.println("\n--------------X---------------\n");
        } else {
            logger.warn(">>>>> Lead Not Found! <<<<<");
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
    private void updateById(Scanner scanner) {  
        System.out.println("\n========== UPDATE LEAD  ==========\n");
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = getId(scanner);   
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
                printUpdatedStatus(leadController.updateById(id, lead));
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                lead.setEmailId(getEmailId(scanner));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                lead.setPhoneNumber(getPhoneNumber(scanner));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;
                        
            case Constants.COMPANY_NAME:
                scanner.skip("\r\n");
                lead.setCompanyName(getCompanyName(scanner));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;
   
            case Constants.STATUS:
                scanner.skip("\r\n");
                lead.setStatus(getStatus(scanner, lead));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;

            case Constants.EXIT_LEAD:
                while (!isUpdating) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isUpdating = (logout == Constants.LOGOUT) ? true : false;                    
                } 
                break;
                                  
            default:
                logger.warn(Messages.DEFAULT_MESSAGE);  
            }            
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
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE LEAD  ==========\n");
        System.out.print("Enter the ID to Delete Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = getId(scanner);

        if (leadController.isDeletedById(id)) { 
            logger.info("Lead Deleted");
        } else {
            logger.warn(Messages.FAILED);
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

        while (!isNotValid) {
            System.out.print("Name                 : ");
            name = scanner.nextLine();

            if (leadController.isValidName(name)) {
                break;
            } else { 
                logger.warn("\n>>>>> Wrong Name Format, Give the proper Name! <<<<<\n");
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
                logger.warn("\n>>>>> Wrong Email Format, Give the proper Email! <<<<<\n");
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
                logger.warn("\n>>>>> Wrong Phone Number Format, Give the proper Phone Number! <<<<<\n");
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
                logger.warn("\n>>>>> Wrong Company Name Format, Give the proper Company Name! <<<<<\n");
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
    private String getStatus(Scanner scanner, Lead lead) {
        boolean isSelecting = false;
        byte logout;
        String status = "";
        byte statusChoice;

        while (!isSelecting) {
            printStatusMenu();
            statusChoice = getChoice(scanner);

            switch (statusChoice) {
            case Constants.NEW:
                status = Status.New.toString();
                isSelecting = true;
                break;

            case Constants.CONTACTED:
                status = Status.Contacted.toString();
                isSelecting = true;
                break;

            case Constants.WORKING:
                status = Status.Working.toString();
                isSelecting = true;
                break;

            case Constants.QUALIFIED:
                status = Status.Qualified.toString();
                isSelecting = true;
                break;

            case Constants.UNQUALIFIED:
                status = Status.Unqualified.toString();
                isSelecting = true; 
                break;

            case Constants.CONVERTED:               
                if (lead != null) {
                    status = contactView.createFromLead(scanner, lead);
                    isSelecting = true; 
                } else {
                    logger.warn("Tried to convert the lead which not present");
                } 
                break;

            default:
                logger.warn(Messages.DEFAULT_MESSAGE);
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
     */
    private String getId(Scanner scanner) {
        String id = " ";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter Id             : ");
            id = scanner.nextLine();

            if (leadController.isValidId(id)) {
                isNotValid = true;
                logger.info("emp id generated");
            } else { 
                logger.error("\n>>>>> Wrong Id Format, Give the proper Id! <<<<<\n");
            }  
        }
        return id; 
    }

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
    private void printUpdatedStatus(Lead lead) {
        if (lead != null) {
            logger.info("Lead Updated");
        } else {
            logger.info(Messages.FAILED);
        }
    }

    /**
     * <h1> Get choice </h1>
     * <p>
     * Gets the choice from the user
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return choice - choice of the User
     */
    private byte getChoice(Scanner scanner) {
        byte choice = 0;

        try {
            choice = scanner.nextByte();
        } catch (InputMismatchException e) {
            logger.error("Input Mismatch Exception");
            scanner.next();  // clears the scanner buffer
        }
        return choice;
    }

    /**
     * <h1> Print Lead Menu </h1>
     * <p>
     * Prints the Lead Menu
     * </p>
     */
    private void printLeadMenu() {
        StringBuilder leadMenu = new StringBuilder();
        leadMenu.append("Press \" ").append(Constants.LEAD)
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
        operationMenu.append("Press \" ").append(Constants.ADDER)
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
        updaterMenu.append(">>>>> Lead Id can't be changed <<<<<\n")
                   .append("\npress \" ").append(Constants.NAME)
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
     * <h1> Print Type Menu </h1>
     * <p>
     * Prints the Menu for Account Type
     * </p>
     */
    private void printTypeMenu() {
        StringBuilder typeMenu = new StringBuilder();
        typeMenu.append("+=============================+")
                .append("\n|           \"TYPE\"            |")
                .append("\n| press \" ").append(Constants.CUSTOMER)
                .append(" \" for Customer    |\n")
                .append("| press \" ").append(Constants.RESELLER)
                .append(" \" for Reseller    |\n")
                .append("| press \" ").append(Constants.INVESTOR)
                .append(" \" for Investor    |\n")
                .append("| press \" ").append(Constants.PARTNER)
                .append(" \" for Partner     |\n")
                .append("+=============================+\n")
                .append("Enter your Choice: ");
        System.out.print(typeMenu);
    }

    /**
     * <h1> Print Stage Menu </h1>
     * <p>
     * Prints the Menu for opportunity Stage
     * </p>
     */
    private void printStageMenu() {
        StringBuilder stageMenu = new StringBuilder();
        stageMenu.append("+======================================+")
                 .append("\n|               \"STAGE\"                |")
                 .append("\n| press \" ").append(Constants.MEETING_SCHEDULED)
                 .append(" \" for Meeting Scheduled    |\n")
                 .append("| press \" ").append(Constants.PROPOSAL)
                 .append(" \" for Proposal             |\n")
                 .append("| press \" ").append(Constants.NEGOTIATION)
                 .append(" \" for Negotiation          |\n")
                 .append("| press \" ").append(Constants.QUALIFIED)
                 .append(" \" for Qualified            |\n")
                 .append("| press \" ").append(Constants.CLOSED)
                 .append(" \" for Closed               |\n")
                 .append("+======================================+\n")
                 .append("Enter your Choice: ");
        System.out.print(stageMenu);
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
                      .append("========================================\n");
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
             .append("========================================\n");
        System.out.println(title);
    }
}                                          