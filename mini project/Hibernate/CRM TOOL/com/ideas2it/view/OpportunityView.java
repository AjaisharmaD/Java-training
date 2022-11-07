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
        boolean isOpen = false;
        String operationChoice; 
        String logout;   
        printOpportunityTitle();
                
        while (!isOpen) {
            printOperationMenu();
            operationChoice = scanner.next();
                   
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
     * <h1> Creates Opportunity </h1>
     * <p>
     * Creates the Opportunity of the contact
     * </p>
     *
     * @param scanner - object of a Scanner class 
     */
    public void create(Scanner scanner) {
        Opportunity opportunity = new Opportunity(getName(scanner), 
                                                  getAmount(scanner), 
                                                  getStage(scanner));
        //String closedDate = getClosedDate(opportunity.getStage());
        //opportunity.setClosedDate(closedDate);
        System.out.println(opportunityController
                                 .create(opportunity) != false
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
    public void createFromContact(Scanner scanner, Contact contact,
                                                         int userId) {
        logger.info("creating Opportunity.....");
        Opportunity opportunity = new Opportunity(contact.getName(), 
                                                  getAmount(scanner), 
                                                  getStage(scanner));
        opportunity.setAccountId(contact.getAccountId());
        //String closedDate = getClosedDate(opportunity.getStage());
        //opportunity.setClosedDate(closedDate);
        System.out.println(opportunityController.create(opportunity) != false
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
        List<Opportunity> opportunities = opportunityController.getAll();

        if (null != opportunities) {
            for (Opportunity opportunity : opportunities) {
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
     * Method is used to serach the Details of opportunity 
     * by calling the opportunity Id
     * This will Display the Details of a opportunity
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH OPPORTUNITY ==========\n");  
        System.out.print("Enter the ID to opportunity : ");
        int id = scanner.nextInt();
        Opportunity opportunity = opportunityController.getById(id);

        if (null != opportunity) {
            System.out.println(opportunity);
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
        System.out.print("Enter the ID to opportunity : ");
        int id = scanner.nextInt();  
        boolean isUpdating = false;
        String updaterChoice;
        String columnName;
        String logout;
        Opportunity opportunity = opportunityController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = scanner.next();
                     
            switch (updaterChoice) {
            case Constants.NAME:
                columnName = "name";
                scanner.skip("\r\n");
                printUpdatedStatus(opportunityController.updateById(id, 
                                   columnName, getName(scanner)));
                break;

            case Constants.AMOUNT:
                columnName = "amount";
                scanner.skip("\r\n");
                printUpdatedStatus(opportunityController.updateById(id, 
                                   columnName, getAmount(scanner).toString()));
                break;
                           
            case Constants.STAGE:
                columnName = "stage";
                scanner.skip("\r\n");
                printUpdatedStatus(opportunityController.updateById(id, 
                                   columnName, getStage(scanner)));
                break;
                           
            case Constants.EXIT:
                isUpdating = true;
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
        System.out.print("Enter the ID to Delete opportunity : ");
        int id = scanner.nextInt();
        System.out.println((opportunityController.isDeletedById(id)) 
                                          ? Messages.DELETED_SUCCESSFULLY 
                                          : Messages.FAILED_TO_DELETE);
        logger.info("Lead Deleted");
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
        String stageChoice = scanner.next();

        switch (stageChoice) {
        case Constants.MEETING_SCHEDULED:
            stage = Stage.Meeting_Scheduled.toString();
            break;

        case Constants.CLOSED_WON:
            stage = Stage.Closed_won.toString();
            break;

        case Constants.CLOSED_LOST:
            stage = Stage.Closed_lost.toString();
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
     
    private String getClosedDate(String stage) {
        String closedDate = "Not Closed Yet";

        if (stage.equals(Stage.Closed_won.toString()) || stage.equals(Stage.Closed_lost.toString() )) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
            closedDate = formatter.format(date); 
        }
        return closedDate;
    } */

    /**
     * <h1> Print Update Status </h1>
     * <p>
     * Prints the Update Status of the opportunity
     * </p>
     *
     * @return opportunity - Update opportunity
     */
    private void printUpdatedStatus(boolean status) {
        if (status) {
            logger.info(Messages.UPDATED_SUCCESSFULLY);
        } else {
            logger.info(Messages.FAILED_TO_UPDATE);
        }
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
                   .append("press \" ").append(Constants.AMOUNT)
                   .append(" \" for Amount\n")
                   .append("press \" ").append(Constants.STAGE)
                   .append(" \" for Stage\n")
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
                 .append("| press \" ").append(Constants.CLOSED_WON)
                 .append(" \" for Closed Won           |\n")
                 .append("| press \" ").append(Constants.CLOSED_LOST)
                 .append(" \" for Closed Lost          |\n")
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