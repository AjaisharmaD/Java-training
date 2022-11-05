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
import com.ideas2it.enums.Role;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Account;
import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
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
    public void showContactDashboard(Scanner scanner, User user) {
        int userId = user.getId();
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
    public void create(Scanner scanner, int userId) {
        Contact contact = new Contact(getName(scanner), getEmailId(scanner), 
                                                        getPhoneNumber(scanner),
                                                        getAccountName(scanner), 
                                                        getRole(scanner));
        int accountId = createAccountOrAddContact(scanner, contact);
        contact.setAccountId(accountId);
        opportunityView.createFromContact(scanner, contact, userId);
        System.out.println((contactController.create(contact)) != false 
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
    public String createFromLead(Scanner scanner, Lead lead, int userId) {
        logger.info("creating Contact.....");
        Contact contact = new Contact(lead.getName(), lead.getEmailId(), 
                                                      lead.getPhoneNumber(), 
                                                      getAccountName(scanner),
                                                      getRole(scanner));
        int accountId = createAccountOrAddContact(scanner, contact);
        contact.setAccountId(accountId);
        opportunityView.createFromContact(scanner, contact, userId);
        return (contactController.create(contact)) != false 
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
    public int createAccountOrAddContact(Scanner scanner, Contact contact) {
        List<Account> accounts = accountController.getAll();
        String accountName = "";
        int id = 0;

        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                accountName = account.getName();

                if (accountName.equals(contact.getAccountName())) {
                    account.setContact(contact);
                    id = account.getId();
                    break;
                } 
            }
        } else if (0 == id) {
            System.out.println("Account creation");
            id = accountView.createFromContact(scanner, contact);
        }
        return id;
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

        if (null != contacts) {
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
        System.out.print("Enter the ID to search contact : ");
        int id = scanner.nextInt();
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
        System.out.print("Enter the ID to update Contact : ");
        int id = scanner.nextInt(); 
        String columnName;
        boolean isUpdating = false;
        String updaterChoice;
        String logout;
        Contact contact = contactController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = scanner.next();
                     
            switch (updaterChoice) {
            case Constants.NAME:
                columnName = "name";
                scanner.skip("\r\n");
                printUpdatedStatus(contactController.updateById(id, columnName,getName(scanner)));
                break;

            case Constants.EMAIL:
                columnName = "email";
                scanner.skip("\r\n");
                printUpdatedStatus(contactController.updateById(id, columnName, getEmailId(scanner)));
                break;
                         
            case Constants.PHONE_NUMBER:
                columnName = "phone_number";
                scanner.skip("\r\n");
                printUpdatedStatus(contactController.updateById(id, columnName, getPhoneNumber(scanner)));
                break;

            case Constants.ACCOUNT_NAME:
                columnName = "account_name";
                scanner.skip("\r\n");
                printUpdatedStatus(contactController.updateById(id, columnName, getAccountName(scanner)));
                break;
 
                           
            case Constants.ROLE:
                columnName = "role";
                scanner.skip("\r\n");
                printUpdatedStatus(contactController.updateById(id, columnName, getRole(scanner)));
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
        System.out.print("Enter the ID to Delete Contact : ");
        int id = scanner.nextInt();
        System.out.println((contactController.isDeletedById(id)) 
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
     * Gets the Phone Number of the Lead and 
     * checks whether the Phone Number is Valid or not
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
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name and checks whether the Name is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
     *
     * @return name - a Valid Name
     */
    private String getAccountName(Scanner scanner) {
        String name = "";
        boolean isNotValid = false;

        scanner.skip("\r\n");
        while (!isNotValid) {
            System.out.print("\nAccount Name         : ");
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
     * <h1> Get Title </h1>
     * <p>
     * Gets the Title of the Contact
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return title - title of a Contact
     */
    private String getRole(Scanner scanner) {
        System.out.print("Role                : ");
        String role = "";
        printRoleMenu();
        String roleChoice = scanner.next();

        switch (roleChoice) {
        case Constants.CEO:
            role = Role.CEO.toString();
            break;

        case Constants.FOUNDER:
            role = Role.Founder.toString();
            break;

        case Constants.PRESIDENT:
            role = Role.President.toString();
            break;

        case Constants.VICE_PRESIDENT:
            role = Role.VicePresident.toString();
            break;

        case Constants.DIRECTOR:
            role = Role.Director.toString();
            break;

        default:
            logger.warn(Messages.INVALID_CHOICE);
        }
        return role;
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
                   .append("press \" ").append(Constants.ROLE)
                   .append(" \" for Role\n")
                   .append("press \" ").append(Constants.EXIT_LEAD)
                   .append(" \" for Exit\n")
                   .append("Enter your Updater: "); 
        System.out.print(updaterMenu);
    }

    /**
     * <h1> Print Role Menu </h1>
     * <p>
     * Prints the Menu for Contact Role
     * </p>
     */
    private void printRoleMenu() {
        StringBuilder roleMenu = new StringBuilder();
        roleMenu.append("\n+------------------------------------+")
                .append("\n|               \"ROLE\"              |")
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
        System.out.print(roleMenu);
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