package com.ideas2it.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.OpportunityController;
import com.ideas2it.controller.LeadController;
import com.ideas2it.enums.Stage;
import com.ideas2it.logger.CustomLogger;
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
    private LeadController leadController;
    private CustomLogger logger;

    public OpportunityView() {
        this.logger = CustomLogger(OpportunityView.class);
        this.opportunityController = new OpportunityController();
        this.leadController = new LeadController();
    }

    /**
     * <h1> Opportunity Dashboard </h1>
     * <p>
     * Method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Account
     * </p>
     */
    public void showOpportunityDashboard(Scanner scanner) {
        boolean isOpened = false;
        byte operationChoice; 
        byte logout;   
                
        while (!isOpened) {
            printOperationMenu();
            operationChoice = getChoice(scanner);
                   
            switch (operationChoice) {
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
                logger.warn(Messages.DEFAULT_MESSAGE); 
            }        
        }
    }

    /**
     * <h1> Creates Opportunity </h1>
     * <p>
     * Creates the Opportunity of the lead
     * </p>
     *
     * @param scanner - scanner to get input from console
     * @param lead    - lead to create Opportunity 
     */
    public void create(Scanner scanner, Lead lead) {
        Opportunity opportunity = new Opportunity();
        opportunity.setId(lead.getId());
        opportunity.setAccountName(lead.getCompanyName());
        opportunity.setName(lead.getName());
        opportunity.setAmount(lead.getAmount());
        opportunity.setStage(lead.getOpportunityStage());
        opportunity.setClosedDate(getDate(opportunity.getStage()));
        System.out.println(opportunityController.create(opportunity) != null 
                                 ? Messages.SUCCESS
                                 : Messages.FAILED);
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
            logger.info(">>>>> No opportunitys Found! <<<<<");
        }
    }

   /**
     * <h1> Display opportunity By Id </h1>
     * <p>
     * Method is used to serach the Details of opportunity by calling the opportunity Id
     * This will Display the Details of a opportunity
     * </p>
     */
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH OPPORTUNITY ==========\n");  
        System.out.print("Enter the ID to opportunity\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        if (opportunityController.getById(id) != null) {
            System.out.println(opportunityController.getById(id));
            System.out.println("\n------------------X------------------");
        } else {
            logger.info(">>>>> No opportunitys Found! <<<<<");
        }
    }

    /**
     * <h1> Update the Opportunity </h1>
     * <p>
     * Method will updates the each fields of the Lead Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     */
    private void updateById(Scanner scanner) {  
        System.out.println("\n========== UPDATE OPPORTUNITY  ==========\n");
        System.out.print("Enter the ID to opportunity\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();   
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
                opportunity.setClosedDate(getDate(stage));
                printUpdatedStatus(opportunityController.updateById(id, opportunity));
                break;

            case Constants.AMOUNT:
                scanner.skip("\r\n");
                opportunity.setStage(getStage(scanner));
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
                logger.warn(Messages.DEFAULT_MESSAGE);  
            }            
        }         
    }

    /**
     * <h1> Delete the opportunity </h1>
     * <p>
     * Method will Delete the Details of a opportunity 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE opportunity  ==========\n");
        System.out.print("Enter the ID to Delete opportunity\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println((opportunityController.isDeletedById(id)) 
                                   ? Messages.SUCCESS : Messages.FAILED);
        logger.info("Lead Deleted");
    }          

    /**
     * <h1> Get Account Name </h1>
     * <p>
     * Gets the Name and checks whether the Name is Valid or not
     * </p> 
     *
     * @return name - a Valid Name
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
                logger.warn("\n>>>>> Wrong Name Format, Give the proper Name! <<<<<\n");
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
     * @return name - a Valid Name
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
     * <h1> Get Stage </h1>
     * <p>
     * Gets the Stage of the opportunity
     * </p>
     *
     * @return stage - stage of a opportunity
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
            logger.warn(Messages.DEFAULT_MESSAGE);
        }
        return stage;
    }

    /**
     * <h1> Get Date </h1>
     * <p>
     * Gets the Date for Close date
     * </p>
     *
     * @return date - a Valid Close Date
     */
    private String getDate(String stage) {
        if (stage.equals(Stage.Closed)) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
            String closedDate = formatter.format(date); 

            logger.info("Closed Date Created");
            return closedDate;
        }
        return "Not Closed Yet";
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
     */
    private byte getChoice(Scanner scanner) {
        byte choice = 0;

        try {
            choice = scanner.nextByte();
        } catch (InputMismatchException e) {
            logger.error("Wrong Input for Choice");
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
        updaterMenu.append(">>>>> Id can't be changed <<<<<\n")
                   .append("\npress \" ").append(Constants.NAME)
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
}