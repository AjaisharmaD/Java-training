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
import com.ideas2it.enums.Stage;
import com.ideas2it.enums.Status;
import com.ideas2it.enums.Title;
import com.ideas2it.enums.Type;
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
    public void openEmployeeDashboard(Scanner scanner) {
        boolean isActive = false;
        byte operationChoice; 
        byte logout;   
        printWelcomeMessage();     

        while (!isActive) {
            printLeadMenu();
            operationChoice = getChoice(scanner);
                   
            switch (operationChoice) {
            case Constants.LEAD:
                openLeadOperations(scanner);
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
    private void openLeadOperations(Scanner scanner) {
        boolean isOpened = false;
        byte operationChoice; 
        byte logout;   
        printLeadTitle();     
                
        while (!isOpened) {
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
            
            case Constants.EXIT_LEAD_OPERATION:
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
    private void create(Scanner scanner) {
        Lead lead = null;
        String name;
        String email;
        String phoneNumber;
        String companyName;
        String status;
        String accountType;
        String contactTitle;
        String opportunityStage;
        Double amount = 0.00d;
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
            email = getEmail(scanner);     
            phoneNumber = getPhoneNumber(scanner); 
            companyName = getCompanyName(scanner);
            status = getStatus(scanner, lead);   
            accountType = getType(scanner);
            contactTitle = getTitle(scanner);  
            opportunityStage = getStage(scanner);   
            amount = getAmount(scanner); 
            createdDate = getCreatedDate();
            scanner.skip("\r\n");
            System.out.println((leadController.create(new Lead(name, email, 
                                          phoneNumber,companyName, status, accountType, 
                                          contactTitle, opportunityStage, amount,
                                          createdDate)) != null) 
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

        if (null != leadController.getAll() ) {
            for (Lead lead : leadController.getAll()) {
                System.out.println(lead);
                System.out.println("\n--------------X---------------\n");
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
        String id = scanner.nextLine();

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
                printUpdatedStatus(leadController.updateById(id, lead));
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                lead.setEmailId(getEmail(scanner));
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

            case Constants.ACCOUNT_TYPE:
                scanner.skip("\r\n");
                lead.setAccountType(getType(scanner));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;

            case Constants.CONTACT_TITLE:
                scanner.skip("\r\n");
                lead.setContactTitle(getTitle(scanner));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;

            case Constants.OPPORTUNITY_STAGE:
                scanner.skip("\r\n");
                lead.setOpportunityStage(getStage(scanner));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;

            case Constants.DEAL_AMOUNT:
                scanner.skip("\r\n");
                lead.setAmount(getAmount(scanner));
                printUpdatedStatus(leadController.updateById(id, lead));
                break;

            case Constants.EXIT_LEAD_UPDATER:
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
        String id = scanner.nextLine();

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
     * @return name - a Valid Name of the Lead
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
    private String getEmail(Scanner scanner) {
        String email = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Email ID             : ");
            email = scanner.nextLine();

            if (leadController.isValidEmail(email)) {
                break;
            } else { 
                logger.warn("\n>>>>> Wrong Email Format, Give the proper Email! <<<<<\n");
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
                    status = accountView.toAccount(scanner, lead);
                    contactView.create(scanner, lead);
                    opportunityView.create(scanner, lead);
                    isSelecting = true; 
                } else {
                    logger.warn("Tried to convert the lead which not present");
                } 
                break;

            case Constants.EXIT_STATUS:
                isSelecting = true; 
                break;

            default:
                logger.warn(Messages.DEFAULT_MESSAGE);
            }
        }
        return status;
    }

    /**
     * <h1> Get type </h1>
     * <p>
     * Gets the Type of the Account
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return type - type of a Account
     */
    private String getType(Scanner scanner) {
        boolean isSelecting = false;
        String type = "";
        byte typeChoice;

        while (!isSelecting) {
            printTypeMenu();
            typeChoice = getChoice(scanner);

            switch (typeChoice) {
            case Constants.CUSTOMER:
                type = Type.Customer.toString();
                isSelecting = true;
                break;

            case Constants.RESELLER:
                type = Type.Reseller.toString();
                isSelecting = true;
                break;

            case Constants.INVESTOR:
                type = Type.Investor.toString();
                isSelecting = true;
                break;
 
            case Constants.PARTNER:
                type = Type.Partner.toString();
                isSelecting = true;
                break;

            default:
                logger.warn(Messages.DEFAULT_MESSAGE);
            }
        }
        return type;
    }

    /**
     * <h1> Get Title </h1>
     * <p>
     * Gets the Title of the Contact
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return title - title of a Contact
     */
    private String getTitle(Scanner scanner) {
        boolean isSelecting = false;
        byte titleChoice;
        String title = "";

        while (!isSelecting) {
            printTitleMenu();
            titleChoice = getChoice(scanner);

            switch (titleChoice) {
            case Constants.CEO:
                title = Title.CEO.toString();
                isSelecting = true;
                break;

            case Constants.FOUNDER:
                title = Title.Founder.toString();
                isSelecting = true;
                break;

            case Constants.PRESIDENT:
                title = Title.President.toString();
                isSelecting = true;
                break;

            case Constants.VICE_PRESIDENT:
                title = Title.VicePresident.toString();
                isSelecting = true;
                break;

            case Constants.DIRECTOR:
                title = Title.Director.toString();
                isSelecting = true;
                break;

            default:
                logger.warn(Messages.DEFAULT_MESSAGE);
            }
        }
        return title;
    }

    /**
     * <h1> Get Stage </h1>
     * <p>
     * Gets the Stage of the opportunity
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return stage - stage of a opportunity
     */
    private String getStage(Scanner scanner) {
        boolean isSelecting = false;
        String stage = "";
        byte stageChoice;

        while (!isSelecting) {
            printStageMenu();
            stageChoice = getChoice(scanner);

            switch (stageChoice) {
            case Constants.MEETING_SCHEDULED:
                stage = Stage.MeetingScheduled.toString();
                isSelecting = true;
                break;

            case Constants.PROPOSAL:
                stage = Stage.Proposal.toString();
                isSelecting = true;
                break;

            case Constants.NEGOTIATION:
                stage = Stage.Negotiation.toString();
                isSelecting = true;
                break;
 
            case Constants.QUALIFIED:
                stage = Stage.Qualified.toString();
                isSelecting = true;
                break;

            case Constants.CLOSED:
                stage = Stage.Closed.toString();
                isSelecting = true;
                break;

            default:
                logger.warn(Messages.DEFAULT_MESSAGE);
            }
        }
        return stage;
    }

    /**
     * <h1> Get Amount </h1>
     * <p>
     * Gets the Amount of the Deal and checks whether the Amount is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
     *
     * @return amount - a Valid Amount for deal
     */
    private Double getAmount(Scanner scanner) {
        Double amount = 0.00d;
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Amount                 : ");
            amount = scanner.nextDouble();

            if (leadController.isValidAmount(amount.toString())) {
                break;
            } else { 
                logger.warn("\n>>>>> Wrong Amount Format, Give the proper Amount! <<<<<\n");
            }
        }
        return amount;
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
                        .append("Press \" ").append(Constants.EXIT_LEAD_OPERATION)
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
                   .append("press \" ").append(Constants.ACCOUNT_TYPE)
                   .append(" \" for Account type\n")
                   .append("press \" ").append(Constants.CONTACT_TITLE)
                   .append(" \" for Contact Title\n")
                   .append("press \" ").append(Constants.STAGE)
                   .append(" \" for Stage\n")
                   .append("press \" ").append(Constants.DEAL_AMOUNT)
                   .append(" \" for Deal Amount\n")
                   .append("press \" ").append(Constants.EXIT_LEAD_UPDATER)
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
                  .append("| press \" ").append(Constants.EXIT_STATUS)
                  .append(" \" for Exit        |\n")
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
     * <h1> Print Title Menu </h1>
     * <p>
     * Prints the Menu for Contact Title
     * </p>
     */
    private void printTitleMenu() {
        StringBuilder titleMenu = new StringBuilder();
        titleMenu.append("+====================================+")
                 .append("\n|               \"TITLE\"              |")
                 .append("\n| press \" ").append(Constants.CEO)
                 .append(" \" for CEO                |\n")
                 .append("| press \" ").append(Constants.FOUNDER)
                 .append(" \" for Founder            |\n")
                 .append("| press \" ").append(Constants.PRESIDENT)
                 .append(" \" for President          |\n")
                 .append("| press \" ").append(Constants.VICE_PRESIDENT)
                 .append(" \" for Vice President     |\n")
                 .append("| press \" ").append(Constants.DIRECTOR)
                 .append(" \" for Director           |\n")
                 .append("+====================================+\n")
                 .append("Enter your Choice: ");
        System.out.print(titleMenu);
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