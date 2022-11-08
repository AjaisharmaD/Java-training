package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.AccountController;
import com.ideas2it.controller.LeadController;
import com.ideas2it.enums.Status;
import com.ideas2it.enums.Type;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Account;
import com.ideas2it.model.Contact;

/**
 * <h1> Account View </h1>
 * <p>
 * Converts the Contact into Account who are qualified
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.1 06-10-2022
 * @since   03-10-2022
 */
public class AccountView {
    private CustomLogger logger;
    private AccountController accountController;
    private LeadController leadController;

    public AccountView() {
        this.logger = new CustomLogger(AccountView.class);
        this.accountController = new AccountController();
        this.leadController = new LeadController();
    }

    /**
     * <h1> Account Dashboard </h1>
     * <p>
     * Method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Account
     * </p>
     *
     * @param scanner         - object of a Scanner class
     * @param contactView     - object of a Contact View class
     * @param opportunityView - object of a Opportunity View Class
     */
    public void showAccountDashboard(Scanner scanner) {
        boolean isOpened = false;
        String operationChoice; 
        String logout;   
        String status;
        printAccountTitle();
                
        while (!isOpened) {
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
                isOpened = (logout.equals(Constants.LOGOUT)) ? true : false;        
                break;
                   
            default:
                System.out.println(Messages.INVALID_CHOICE); 
            }        
        }
    }


    /**
     * <h1> Create Account from Contact </h1>
     * <p>
     * Converts the contact into Account
     * </p>
     *
     * @param scanner - scanner to get input from console
     */
    public void create(Scanner scanner) {
        Account account = new Account(getName(scanner), getWebsite(scanner),
                                                          getType(scanner));
        System.out.println((accountController.create(account)) != 0
                                            ? Messages.ADDED_SUCCESSFULLY
                                            : Messages.FAILED_TO_ADD);
    }

    /**
     * <h1> Create Account from Contact </h1>
     * <p>
     * Converts the contact into Account
     * </p>
     *
     * @param scanner - scanner to get input from console
     * @param contact - contact to convert as Account 
     */
    public int createFromContact(Scanner scanner, Contact contact) {
        logger.info("creating Account.....");
        Account account = new Account(contact.getAccountName(),
                                      getWebsite(scanner), getType(scanner));
        int id = accountController.create(account);
        System.out.println("account id " + id);
        System.out.println(0 != id ? Messages.ADDED_SUCCESSFULLY
                                   : Messages.FAILED_TO_ADD);
        return id;
    }

    /**   
     * <h1> Display Details of account </h1>
     * <p>
     * Method will Display all the Details of Account
     * </p>
     */
    private void displayAll() {
        System.out.println("\n========== ACCOUNTS DETAILS ==========\n"); 

        List<Account> accounts = accountController.getAll();

        if (null != accounts) {
            for (Account account : accounts) {
                System.out.println(account);
                System.out.println("\n-------------X-------------");
            }
        } else {
            logger.info(Messages.ACCOUNT_NOT_FOUND);
        }
    }

   /**
     * <h1> Display Account By Id </h1>
     * <p>
     * Method is used to serach the Details of Account 
     * by calling the Account Id
     * This will Display the Details of a Account
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH ACCOUNT ==========\n");  
        System.out.print("Enter the Account Id to search : ");
        scanner.skip("\r\n");
        int id = scanner.nextInt(); 
        Account account = accountController.getById(id);   
   
        if (null != account) {
            System.out.println(account);
            System.out.println("\n-------------X-------------");
        } else {
            logger.info(Messages.ACCOUNT_NOT_FOUND);
        }
    }

    /**
     * <h1> Update the Account </h1>
     * <p>
     * Method will updates the each fields of the Account Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void updateById(Scanner scanner) {  
        System.out.println("\n========== UPDATE ACCOUNT  ==========\n");
        System.out.print("Enter the Account Id to update : ");
        scanner.skip("\r\n");
        int id = scanner.nextInt();    //change to acc name  
        String columnName;
        boolean isUpdating = false;
        String updaterChoice;
        String logout;
        Account account = accountController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = scanner.next();
                     
            switch (updaterChoice) {
            case Constants.NAME:
                columnName = "name";
                printUpdatedStatus(accountController.updateById(id, columnName, getName(scanner)));
                break;
                    
            case Constants.WEBSITE:
                columnName = "website";                              
                printUpdatedStatus(accountController.updateById(id, columnName, getWebsite(scanner)));
                break;
                           
            case Constants.TYPE:
                columnName = "type";
                printUpdatedStatus(accountController.updateById(id, columnName, getType(scanner)));
                break;
                           
            case Constants.EXIT_ACCOUNT_UPDATER:
                isUpdating = true;
                break;
                                  
            default:
                logger.warn(Messages.INVALID_CHOICE);  
            }            
        }         
    }

    /**
     * <h1> Delete the Account </h1>
     * <p>
     * Method will Delete the Details of a Account 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE ACCOUNT  ==========\n");
        System.out.print("Enter the ID to delete : ");
        scanner.skip("\r\n");
        int id = scanner.nextInt();
        System.out.println((accountController.isDeletedById(id)) 
                                             ? Messages.DELETED_SUCCESSFULLY
                                             : Messages.FAILED_TO_DELETE);
        logger.info("Account Deleted");
    }       

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name and checks whether the Name is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
     *
     * @return name - a Valid Name
     */
    private String getName(Scanner scanner) {
        String name = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Name                 : ");
            name = scanner.nextLine();

            if (leadController.isValidCompanyName(name)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_NAME_FORMAT);
            }  
        }
        return name;
    }

    /**
     * <h1> Get Webite  </h1>
     * <p>
     * Gets the Website and checks whether the Website is Valid or not
     * </p> 
     *
     * @param scanner  - object of a Scanner class
     *
     * @return website - a Valid Website
     */
    private String getWebsite(Scanner scanner) {
        String website = "";
        boolean isNotValid = false;

        scanner.skip("\r\n");
        while (!isNotValid) {
            System.out.print("Website              : ");
            website = scanner.nextLine();

            if (leadController.isValidWebsite(website)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_WEBSITE_FORMAT);
            }  
        }
        return website;
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
        System.out.print("Type               : ");
        String type = "";
        printTypeMenu();
        String typeChoice = scanner.next();

        switch (typeChoice) {
        case Constants.CUSTOMER:
            type = Type.Customer.toString();
            break;

        case Constants.RESELLER:
            type = Type.Reseller.toString();
            break;

        case Constants.INVESTOR:
            type = Type.Investor.toString();
            break;

        case Constants.PARTNER:
            type = Type.Partner.toString();
            break;

        default:
            logger.warn(Messages.INVALID_CHOICE);
        }
        return type;
    }

    /**
     * <h1> Print Update Status </h1>
     * <p>
     * Prints the Update Status of the Account
     * </p>
     *
     * @param account - Updated account
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
        OperationMenu.append("\nPress \" ").append(Constants.ADDER)
                     .append(" \" for Create\n")
                     .append("\nPress \" ").append(Constants.PROJECTOR)
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
                   .append("press \" ").append(Constants.WEBSITE)
                   .append(" \" for Website\n")
                   .append("press \" ").append(Constants.TYPE)
                   .append(" \" for Type\n")
                   .append("press \" ").append(Constants.EXIT_ACCOUNT_UPDATER)
                   .append(" \" for Exit\n")
                   .append("Enter your Updater: "); 
        System.out.print(updaterMenu);
    }

    /**
     * <h1> Print Type Menu </h1>
     * <p>
     * Prints the Menu for Account Type
     * </p>
     */
    private void printTypeMenu() {
        StringBuilder typeMenu = new StringBuilder();
        typeMenu.append("\n+=============================+ ")
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
     * <h1> Print Account Title  </h1>
     * <p>
     * Prints the Title of Account
     * </p>
     */
    private void printAccountTitle() {
        StringBuilder title = new StringBuilder();
        title.append("\n========================================")
             .append("|                 ACCOUNT                |")
             .append("========================================");
        System.out.println(title);
    }
}