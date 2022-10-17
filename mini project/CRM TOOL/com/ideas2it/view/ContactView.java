package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.AccountController;
import com.ideas2it.controller.ContactController;
import com.ideas2it.controller.LeadController;
import com.ideas2it.enums.Status;
import com.ideas2it.enums.Title;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Account;
import com.ideas2it.model.Lead;
import com.ideas2it.model.Contact;
import com.ideas2it.view.AccountView;
import com.ideas2it.view.OpportunityView;

/**
 * <h1> Contact View </h1>
 * <p>
 * Creats the Contact for Lead
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   06-10-2022
 */
public class ContactView {
    private CustomLogger logger;
    private ContactController contactController;
    private LeadController leadController;
    private AccountView accountView;
    private OpportunityView opportunityView;
    private AccountController accountController;

    ContactView() {
        this.logger = new CustomLogger(ContactView.class);
        this.contactController = new ContactController();
        this.leadController = new LeadController();
        this.accountController = new AccountController();
        this.accountView = new AccountView();
        this.opportunityView =  new OpportunityView();
    }

    /**
     * <h1> Contact Dashboard </h1>
     * <p>
     * Method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Contact
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    public void showContactDashboard(Scanner scanner, String userId) {
        boolean isOpened = false;
        String operationChoice; 
        String logout;
        printContactTitle();
                
        while (!isOpened) {
            printOperationMenu();
            operationChoice = scanner.next();
                   
            switch (operationChoice) {
            case Constants.ADDER:
                create(scanner, userId);
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
              
            case Constants.EXIT_LEAD:
                System.out.println(Messages.EXIT_MENU);
                logout = scanner.next();
                isOpened = (logout.equals(Constants.LOGOUT)) ? true : false;        
                break;
                   
            default:
                logger.warn(Messages.INVALID_CHOICE); 
            }        
        }
    }

    /**
     * <h1> Create Contact </h1>
     * <p>
     * Creates a Contact newly
     * </p>
     *
     * @param scanner - scanner to get input from console
     */
    public void create(Scanner scanner, String userId) {
        Contact contact = new Contact();
        contact.setName(getName(scanner));
        contact.setAccountName(getAccountName(scanner));
        contact.setEmailId(getEmailId(scanner));
        contact.setPhoneNumber(getPhoneNumber(scanner));
        contact.setTitle(getTitle(scanner));
        createAccountOrAddContact(scanner, contact);
        opportunityView.createFromContact(scanner, contact, userId);
        System.out.println(contactController.create(contact) != null 
                                            ? Messages.ADDED_SUCCESSFULLY
                                            : Messages.FAILED_TO_ADD);
    }

    /**
     * <h1> Create Contact From Lead </h1>
     * <p>
     * Creates a Contact from the Lead
     * </p>
     *
     * @param scanner - scanner to get input from console
     * @param lead    - lead to create Contact  
     *
     * @return status - Status of the Lead
     */
    public String createFromLead(Scanner scanner, Lead lead, String userId) {
        Contact contact = new Contact();
        contact.setName(lead.getName());
        contact.setAccountName(lead.getCompanyName());
        contact.setEmailId(lead.getEmailId());
        contact.setPhoneNumber(lead.getPhoneNumber());
        contact.setTitle(getTitle(scanner));
        contact.setUserId(lead.getUserId());
        createAccountOrAddContact(scanner, contact);
        opportunityView.createFromContact(scanner, contact, userId);
        return contactController.create(contact) != null 
                                ? Status.Converted.toString()
                                : Messages.FAILED_TO_ADD;
    }

    /**
     * <h1> Create Account Or Add Contact </h1>
     * <p>
     * Creates the Account or adds the Contact to the Exisiting Account
     * </p>
     *
     * @param scanner - scanner to get input from console
     * @param lead    - lead to convert as Account 
     *
     * @return status - status of the Lead 
     */
    public void createAccountOrAddContact(Scanner scanner, Contact contact) {
        List<Account> accounts = accountController.getAll();
        String accountName = "";

        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                accountName = account.getName();

                if (accountName.equals(contact.getAccountName())) {
                    System.out.println("Adding contact to account");
                    account.setContact(contact);
                }
            }
        } else {
            System.out.println("Account creation");
            accountView.createFromContact(scanner, contact);
        }
    }

    /**   
     * <h1> Display Details of Contact </h1>
     * <p>
     * Method will Display all the Details of Contact
     * </p>
     */
    private void displayAll() {
        System.out.println("\n========== CONTACT DETAILS ==========\n");
        List<Contact> contacts = contactController.getAll();

        if (!contacts.isEmpty()) {
            for (Contact contact : contacts) {
                System.out.println(contact);
                System.out.println("\n-----------------X-----------------");
            }
        } else {
            logger.info(Messages.CONTACT_NOT_FOUND);
        }
    }

   /**
     * <h1> Display Contact By Id </h1>
     * <p>
     * Method is used to serach the Details of contact by calling the contact Id
     * This will Display the Details of a contact
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH contact ==========\n");  
        System.out.print("Enter the ID to contact\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        Contact contact = contactController.getById(id);

        if (null != contact) {
            System.out.println(contact);
            System.out.println("\n-----------------X-----------------");
        } else {
            logger.info(Messages.CONTACT_NOT_FOUND);
        }
    }

    /**
     * <h1> Update the Contact </h1>
     * <p>
     * Updates the each fields of the Contact Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void updateById(Scanner scanner) {  
        System.out.println("\n========== UPDATE CONTACT  ==========\n");
        System.out.print("Enter the ID to Contact\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();   
        boolean isUpdating = false;
        String updaterChoice;
        String logout;
        Contact contact = contactController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = scanner.next();
                     
            switch (updaterChoice) {
            case Constants.NAME:
                scanner.skip("\r\n");
                contact.setName(getName(scanner));
                printUpdatedStatus(contactController.updateById(id, contact));
                break;
                    
            case Constants.ACCOUNT_NAME:
                scanner.skip("\r\n");
                contact.setAccountName(getAccountName(scanner));
                printUpdatedStatus(contactController.updateById(id, contact));
                break;

            case Constants.EMAIL:
                scanner.skip("\r\n");
                contact.setEmailId(getEmailId(scanner));
                printUpdatedStatus(contactController.updateById(id, contact));
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                contact.setPhoneNumber(getPhoneNumber(scanner));
                printUpdatedStatus(contactController.updateById(id, contact));
                break;
                           
            case Constants.TITLE:
                scanner.skip("\r\n");
                contact.setTitle(getTitle(scanner));
                printUpdatedStatus(contactController.updateById(id, contact));
                break;
                           
            case Constants.EXIT_LEAD:
                isUpdating = true;
                break;
                                  
            default:
                logger.warn(Messages.INVALID_CHOICE);  
            }            
        }         
    }


    /**
     * <h1> Delete the Contact </h1>
     * <p>
     * Method will Delete the Details of a Contact 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE CONTACT  ==========\n");
        System.out.print("Enter the ID to Delete Contact\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println((contactController.isDeletedById(id)) 
                                   ? Messages.DELETED_SUCCESSFULLY : Messages.FAILED_TO_DELETE);
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

            if (leadController.isValidName(name)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_NAME_FORMAT);
            }  
        }
        return name;
    }

    /**
     * <h1> Get Account Name </h1>
     * <p>
     * Gets the Account Name and checks whether the Account Name is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
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
                logger.warn(Messages.WRONG_COMPANY_NAME_FORMAT);
            }  
        }
        return name;
    }

    /**
     * <h1> Get Email Id </h1>
     * <p>
     * Gets the Email and checks whether the Email is Valid or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return email - a Valid Email
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
        System.out.print("Title               : ");
        String title = "";
        printTitleMenu();
        String titleChoice = scanner.next();

        switch (titleChoice) {
        case Constants.CEO:
            title = Title.CEO.toString();
            break;

        case Constants.FOUNDER:
            title = Title.Founder.toString();
            break;

        case Constants.PRESIDENT:
            title = Title.President.toString();
            break;

        case Constants.VICE_PRESIDENT:
            title = Title.VicePresident.toString();
            break;

        case Constants.DIRECTOR:
            title = Title.Director.toString();
            break;

        default:
            logger.warn(Messages.INVALID_CHOICE);
        }
        return title;
    }

    /**
     * <h1> Print Update Status </h1>
     * <p>
     * Prints the Update Status of the contact
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return contact - Update contact
     */
    private void printUpdatedStatus(Contact contact) {
        if (contact != null) {
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
                   .append("press \" ").append(Constants.EMAIL)
                   .append(" \" for Email\n")
                   .append("press \" ").append(Constants.PHONE_NUMBER)
                   .append(" \" for Phone Number\n")
                   .append("press \" ").append(Constants.TITLE)
                   .append(" \" for Type\n")
                   .append("press \" ").append(Constants.ACCOUNT_NAME)
                   .append(" \" for Owner Name\n")
                   .append("press \" ").append(Constants.EXIT_LEAD)
                   .append(" \" for Exit\n")
                   .append("Enter your Updater: "); 
        System.out.print(updaterMenu);
    }

    /**
     * <h1> Print Title Menu </h1>
     * <p>
     * Prints the Menu for Contact Title
     * </p>
     */
    private void printTitleMenu() {
        StringBuilder titleMenu = new StringBuilder();
        titleMenu.append("\n+------------------------------------+")
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
                 .append("+------------------------------------+\n")
                 .append("Enter your Choice: ");
        System.out.print(titleMenu);
    }

    /**
     * <h1> Print Contact Title  </h1>
     * <p>
     * Prints the Title of Contact
     * </p>
     */
    private void printContactTitle() {
        StringBuilder title = new StringBuilder();
        title.append("\n========================================")
             .append("|                 CONTACT                |")
             .append("========================================");
        System.out.println(title);
    }
}