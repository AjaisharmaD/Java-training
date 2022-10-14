package com.ideas2it.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.ContactController;
import com.ideas2it.controller.OpportunityController;
import com.ideas2it.controller.LeadController;
import com.ideas2it.enums.Stage;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Contact;
import com.ideas2it.model.Lead;
import com.ideas2it.model.Opportunity;

/**
 * <h1> Opportunity View </h1>
 * <p>
 * Converts the Lead into Account who are qualified
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0 
 * @since   07-10-2022
 */
public class OpportunityView {
    private OpportunityController opportunityController;
    private ContactController contactController;
    private LeadController leadController;
    private CustomLogger logger;

    public OpportunityView() {
        this.logger = new CustomLogger(OpportunityView.class);
        this.opportunityController = new OpportunityController();
        this.contactController = new ContactController();
        this.leadController = new LeadController();
    }

    /**
     * <h1> Opportunity Dashboard </h1>
     * <p>
     * Method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Account
     *
     * @param scanner - object of a Scanner class
     * </p>
     */
    public void showOpportunityDashboard(Scanner scanner) {
        boolean isOpened = false;
        byte operationChoice; 
        byte logout;   
        printOpportunityTitle();
                
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
              
            case Constants.EXIT_OPERATION:
                while (!isOpened) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isOpened = (logout == Constants.LOGOUT) ? true : false;        
                } 
                break;
                   
            default:
                logger.warn(Messages.INVALID_CHOICE); 
            }        
        }
    }

    /**
     * <h1> Creates Opportunity </h1>
     * <p>
     * Creates the Opportunity of the contact
     * </p>
     *
     * @param scanner - object of a Scanner class 
     */
    public void create(Scanner scanner) {
        Opportunity opportunity = new Opportunity();
        opportunity.setAccountName(getAccountName(scanner));
        opportunity.setName(getName(scanner));
        opportunity.setAmount(getAmount(scanner));
        opportunity.setStage(getStage(scanner));
        String closedDate = getClosedDate(opportunity.getStage());
        opportunity.setClosedDate(closedDate);
        System.out.println(opportunityController.create(opportunity) != null 
                                 ? Messages.ADDED_SUCCESSFULLY
                                 : Messages.FAILED_TO_ADD);
    }

    /**
     * <h1> Creates Opportunity </h1>
     * <p>
     * Creates the Opportunity of the contact
     * </p>
     *
     * @param scanner - object of a Scanner class
     * @param contact    - contact to create Opportunity 
     */
    public void createFromContact(Scanner scanner, Contact contact) {
        Opportunity opportunity = new Opportunity();
        opportunity.setAccountName(contact.getAccountName());
        opportunity.setName(contact.getName());
        opportunity.setAmount(getAmount(scanner));
        opportunity.setStage(getStage(scanner));
        String closedDate = getClosedDate(opportunity.getStage());
        opportunity.setClosedDate(closedDate);
        System.out.println(opportunityController.create(opportunity) != null 
                                 ? Messages.ADDED_SUCCESSFULLY
                                 : Messages.FAILED_TO_ADD);
    }

    /**   
     * <h1> Display Details of opportunity </h1>
     * <p>
     * Method will Display all the Details of opportunity
     * </p>
     */
    private void displayAll() {
        System.out.println("\n========== OPPORTUNITY DETAILS ==========\n");

        if (opportunityController.getAll() != null) {
            for (Opportunity opportunity : opportunityController.getAll()) {
                System.out.println(opportunity);
                System.out.println("\n------------------X------------------");
            }
        } else {
            logger.info(Messages.OPPORTUNITY_NOT_FOUND);
        }
    }

   /**
     * <h1> Display opportunity By Id </h1>
     * <p>
     * Method is used to serach the Details of opportunity by calling the opportunity Id
     * This will Display the Details of a opportunity
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH OPPORTUNITY ==========\n");  
        System.out.print("Enter the ID to opportunity\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = getId(scanner);

        if (opportunityController.getById(id) != null) {
            System.out.println(opportunityController.getById(id));
            System.out.println("\n------------------X------------------");
        } else {
            logger.info(Messages.OPPORTUNITY_NOT_FOUND);
        }
    }

    /**
     * <h1> Update the Opportunity </h1>
     * <p>
     * Method will updates the each fields of the Lead Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void updateById(Scanner scanner) {  
        System.out.println("\n========== UPDATE OPPORTUNITY  ==========\n");
        System.out.print("Enter the ID to opportunity\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = getId(scanner);   
        boolean isUpdating = false;
        byte updaterChoice;
        byte logout;
        Opportunity opportunity = opportunityController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = getChoice(scanner);
                     
            switch (updaterChoice) {
            case Constants.NAME:
                scanner.skip("\r\n");
                opportunity.setName(getName(scanner));
                printUpdatedStatus(opportunityController.updateById(id, opportunity));
                break;
                    
            case Constants.OPPORTUNITY_ACCOUNT_NAME:
                scanner.skip("\r\n");
                opportunity.setAccountName(getAccountName(scanner));
                printUpdatedStatus(opportunityController.updateById(id, opportunity));
                break;
                           
            case Constants.STAGE:
                scanner.skip("\r\n");
                String stage = getStage(scanner);
                opportunity.setStage(stage);
                opportunity.setClosedDate(getClosedDate(stage));
                printUpdatedStatus(opportunityController.updateById(id, opportunity));
                break;

            case Constants.AMOUNT:
                scanner.skip("\r\n");
                opportunity.setAmount(getAmount(scanner));
                printUpdatedStatus(opportunityController.updateById(id, opportunity));
                break;
                           
            case Constants.EXIT:
                while (!isUpdating) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isUpdating = (logout == Constants.LOGOUT) ? true : false;                    
                } 
                break;
                                  
            default:
                logger.warn(Messages.INVALID_CHOICE);  
            }            
        }         
    }

    /**
     * <h1> Delete the opportunity </h1>
     * <p>
     * Method will Delete the Details of a opportunity 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE opportunity  ==========\n");
        System.out.print("Enter the ID to Delete opportunity\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = getId(scanner);
        System.out.println((opportunityController.isDeletedById(id)) 
                                   ? Messages.DELETED_SUCCESSFULLY : Messages.FAILED_TO_DELETE);
        logger.info("Lead Deleted");
    }          

    /**
     * <h1> Get Account Name </h1>
     * <p>
     * Gets the Name and checks whether the Name is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
     *
     * @return name   - a Valid Name
     */
    private String getAccountName(Scanner scanner) {
        String name = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Name                 : ");
            name = scanner.nextLine();

            if (leadController.isValidCompanyName(name)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_COMPANY_NAME_FORMAT);
            }  
        }
        return name;
    }

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name and checks whether the Name is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
     *
     * @return name   - a Valid Name
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
                logger.warn(Messages.WRONG_NAME_FORMAT);
            }  
        }
        return name;
    }

    /**
     * <h1> Get Stage </h1>
     * <p>
     * Gets the Stage of the opportunity
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return stage  - stage of a opportunity
     */
    private String getStage(Scanner scanner) {
        System.out.print("Stage               : ");
        String stage = "";
        printStageMenu();
        byte stageChoice = getChoice(scanner);

        switch (stageChoice) {
        case Constants.MEETING_SCHEDULED:
            stage = Stage.MeetingScheduled.toString();
            break;

        case Constants.PROPOSAL:
            stage = Stage.Proposal.toString();
            break;

        case Constants.NEGOTIATION:
            stage = Stage.Negotiation.toString();
            break;

        case Constants.QUALIFIED:
            stage = Stage.Qualified.toString();
            break;

        case Constants.CLOSED:
            stage = Stage.Closed.toString();
            break;

        default:
            logger.warn(Messages.INVALID_CHOICE);
        }
        return stage;
    }

    /**
     * <h1> Get Closed Date </h1>
     * <p>
     * Gets the Date for Closed date
     * </p>
     *  
     * @param stage - Stage of the Opportunity
     *
     * @return date - a Valid Closed Date
     */
    private String getClosedDate(String stage) {
        String closedDate = "Not Closed Yet";

        if (stage.equals(Stage.Closed.toString())) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
            closedDate = formatter.format(date); 
        }
        return closedDate;
    }

    /**
     * <h1> Get Amount </h1>
     * <p>
     * Gets the Amount for Deal
     * </p>
     *  
     * @param scanner - Object of a Scanner class
     *
     * @return amount - valid Amount
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
                logger.warn(Messages.WRONG_AMOUNT_FORMAT);
            }  
        }
        return amount;
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
            } else { 
                logger.error(Messages.WRONG_ID_FORMAT);
            }  
        }
        return id; 
    }

    /**
     * <h1> Print Update Status </h1>
     * <p>
     * Prints the Update Status of the opportunity
     * </p>
     *
     * @return opportunity - Update opportunity
     */
    private void printUpdatedStatus(Opportunity opportunity) {
        if (opportunity != null) {
            logger.info(Messages.UPDATED_SUCCESSFULLY);
        } else {
            logger.info(Messages.FAILED_TO_UPDATE);
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
     * @return choice - choice of the user
     */
    private byte getChoice(Scanner scanner) {
        byte choice = 0;

        try {
            choice = scanner.nextByte();
        } catch (InputMismatchException e) {
            logger.error(Messages.INVALID_INPUT);
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
        StringBuilder OperationMenu = new StringBuilder();
        OperationMenu.append("\nPress \" ").append(Constants.PROJECTOR)
                     .append(" \" for View\n")
                     .append("Press \" ").append(Constants.FINDER)
                     .append(" \" for Search\n")
                     .append("Press \" ").append(Constants.UPDATER)
                     .append(" \" for Update\n")
                     .append("Press \" ").append(Constants.REMOVER)
                     .append(" \" for Delete\n")
                     .append("Press \" ").append(Constants.EXIT_OPERATION)
                     .append(" \" for EXIT\n")
                     .append("Enter your Operation: ");
        System.out.print(OperationMenu);
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
                   .append("press \" ").append(Constants.OPPORTUNITY_ACCOUNT_NAME)
                   .append(" \" for Account Name\n")
                   .append("press \" ").append(Constants.STAGE)
                   .append(" \" for Stage\n")
                   .append("press \" ").append(Constants.AMOUNT)
                   .append(" \" for Amount\n")
                   .append("press \" ").append(Constants.EXIT)
                   .append(" \" for Exit\n")
                   .append("Enter your Updater: "); 
        System.out.print(updaterMenu);
    }

    /**
     * <h1> Print Stage Menu </h1>
     * <p>
     * Prints the Menu for opportunity Stage
     * </p>
     */
    private void printStageMenu() {
        StringBuilder stageMenu = new StringBuilder();
        stageMenu.append("\n+=======================================+ ")
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
                 .append("+=======================================+\n")
                 .append("Enter your Choice: ");
        System.out.print(stageMenu);
    }

    /**
     * <h1> Print Opportunity Title  </h1>
     * <p>
     * Prints the Title of Opportunity
     * </p>
     */
    private void printOpportunityTitle() {
        StringBuilder title = new StringBuilder();
        title.append("\n========================================")
             .append("|               OPPORTUNITY              |")
             .append("========================================");
        System.out.println(title);
    }
}