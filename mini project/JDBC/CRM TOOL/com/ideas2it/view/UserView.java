package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.LeadController;
import com.ideas2it.controller.UserController;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Lead;
import com.ideas2it.model.User;

/**
 * <h1> User View </h1>
 * <p>
 * This User View class used to Controll the operation which are 
 * performed by the Manager, like Adding, Viewing, Editing, Deleting
 * the details of User.
 * </p> 
 * 
 * @author  Ajaisharma D
 * @version 1.0  
 * @since   19-09-2022
 */
public class UserView {
    private CustomLogger logger;
    private UserController userController;

    public UserView() {
        this.logger = new CustomLogger(UserView.class);
        this.userController = new UserController();
    }

    /**
     * <h1> Manager Dashboard </h1>
     * <p>
     * This method used to do the operation
     * such as Adding, Printing, Updating and Deleting
     * the Details of User
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    public void openManagerDashboard(Scanner scanner) { 
        boolean isOpen = false;
        String logout;
        String operationChoice;
        printWelcomeMessage();

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

            case Constants.ASSIGN_LEAD:
                //assignLead(scanner);
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
     * <h1> Create User </h1>
     * <p>
     * Ask for the Details of User from the manager
     * and passes the Details to Store
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    public void create(Scanner scanner) {
        System.out.println("\n========== NEW EMPLOYEE ==========");
        boolean isRight = false;
        String name;
        String emailId;
        String phoneNumber;
        String password;
        
        name = getName(scanner);
        emailId = getEmailId(scanner);
        phoneNumber = getPhoneNumber(scanner);
        password = getPassword(scanner);
        System.out.println((userController.create(new User(name, emailId,
                                           phoneNumber), password) != true) 
                                           ? Messages.ADDED_SUCCESSFULLY 
                                           : Messages.FAILED_TO_ADD);   
    }

    /**
     * <h1> Display the Details of  all User </h1>
     * <p>
     * Displys the Details of an user
     * </p>
     */
    public void displayAll() {
        System.out.println("\n========== EMPLOYEE DETAILS ==========\n");
        List<User> users = userController.getAll();

        if (null != users) {
            for (User user : users) {
                System.out.println(user);
                System.out.println("--------------X--------------\n");
            }
        } else {
            logger.info(Messages.USER_NOT_FOUND);
        }
    }

    /**
     * <h1> Display Details of User By Id </h1>
     * <p>
     * Search the User Details by calling the User Id
     * This will print the Details of a Single User
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    public void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH EMPLOYEE ==========\n");  
        System.out.print("Enter the User's Id to Search: ");
        int id = scanner.nextInt();
 
        User user = userController.getById(id);
        
        if (null != user) {
            System.out.println(user);
            System.out.println("--------------X--------------\n");

        } else {
            logger.warn(Messages.USER_NOT_FOUND);
        }
    }

    /**
     * <h1> Update the User </h1>
     * <p>
     * This method will updates the each fields of the User Details 
     * and Prints the Message that the fields are Updated or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    public void updateById(Scanner scanner) {
        System.out.println("\n========== UPDATE EMPLOYEE ==========\n"); 
        System.out.print("Enter the User's Id to Edit: ");
        int id = scanner.nextInt();
        String columnName;
        String updaterChoice;
        boolean isUpdating = false;

        User user = userController.getById(id);

        if (null != user) {
            System.out.println(user);
            System.out.println("--------------X--------------\n");

            while (!isUpdating) {
                printUpdaterMenu();
                updaterChoice = scanner.next();
                                 
                switch (updaterChoice) {
                case Constants.NAME:
                    columnName = "name";
                    printUpdatedStatus(userController.updateById(id, columnName, getName(scanner)));
                    break;
                    
                case Constants.EMAIL:
                    columnName = "email";
                    scanner.skip("\r\n");
                    printUpdatedStatus(userController.updateById(id, columnName, getEmailId(scanner)));
                    break;
                         
                case Constants.PHONE_NUMBER:
                    columnName = "phone_number";
                    scanner.skip("\r\n");
                    printUpdatedStatus(userController.updateById(id, columnName, getPhoneNumber(scanner)));
                    break;

                case Constants.PASSWORD:
                    columnName = "password";
                    scanner.skip("\r\n");
                    printUpdatedStatus(userController.updateById(id, columnName, getPassword(scanner)));
                    break;

                case Constants.EXIT:
                    isUpdating = true;         
                    break;
                                  
                default:
                    logger.warn(Messages.INVALID_CHOICE);  
                } 
            }
        }
    }

    /**
     * <h1> Delete the User </h1>
     * <p>
     * This method will Delete the Details of a User 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE EMPLOYEE ==========\n");
        System.out.print("Enter the ID to User : ");
        int id = scanner.nextInt();
        System.out.println((userController.isDeletedById(id))? Messages.DELETED_SUCCESSFULLY : Messages.FAILED_TO_DELETE);
        logger.info("User Deleted");
    }

    /**
     * <h1> Assign Lead </h1>
     * <p>
     * This method will Assign the Lead to the user
     * </p>
     *
     * @param scanner - object of a Scanner class
 
    private void assignLead(Scanner scanner) {
        LeadController leadController = new LeadController();
        System.out.println("\n========== ASSIGN LEAD ==========\n");

        scanner.skip("\r\n");
        System.out.print("Enter Employee Id : ");
        int userId = scanner.nextInt();
        User user = userController.getById(userId);
        System.out.println(user);

        System.out.print("Enter Lead Id     : ");
        int leadId = scanner.nextInt();
        Lead lead = userController.getLeadById(leadId);
        System.out.println("lead is---------------" +lead);
        
        if (null != user) {
            lead.setUserId(userId);
            leadController.updateById(leadId, lead);
        }

        if (null != lead) {
            user.setLead(lead);
            userController.updateById(userId, user); 
        }
    }
    */

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name of the User and checks whether the Name is Valid or not
     * </p> 
     *
     * @param scanner - object of a Scanner class
     *
     * @return name - a Valid Name of the User
     */
    private String getName(Scanner scanner) {
        String name = "";
        boolean isNotValid = false;

        scanner.skip("\r\n");
        while (!isNotValid) {
            System.out.print("Name                 : ");
            name = scanner.nextLine();

            if (userController.isValidName(name)) {
                isNotValid = true;
            } else { 
                logger.warn(Messages.WRONG_NAME_FORMAT);
            }  
        }
        return name;
    }

    /**
     * <h1> Get Email Id </h1>
     * <p>
     * Gets the Email of the User and checks whether the Email is Valid or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return email - a Valid Email of the User
     */
    private String getEmailId(Scanner scanner) {
        String emailId = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Email ID             : ");
            emailId = scanner.next();

            if (userController.isValidEmailId(emailId)) {
                isNotValid = true;
            } else { 
                logger.error(Messages.WRONG_EMAIL_ID_FORMAT);
            }  
        }
        return emailId;
    }

    /**
     * <h1> Get Phone Number </h1>
     * <p>
     * Gets the Phone Number of the User and checks whether the Phone Number is Valid or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return userPhoneNumber - a Valid Phone Number of the User
     */
    private String getPhoneNumber(Scanner scanner) {
        String phoneNumber = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Phone Number         : ");
            phoneNumber = scanner.next();

            if (userController.isValidPhoneNumber(phoneNumber)) {
                isNotValid = true;
            } else { 
                logger.error(Messages.WRONG_PHONE_NUMBER_FORMAT);
            }  
        }
        return phoneNumber;
    }

    /**
     * <h1> Get Password </h1>
     * <p>
     * Gets the Password of the User and checks whether the Password is Valid or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return password - a Valid Password of the User
     */
    private String getPassword(Scanner scanner) {
        String password = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Password             : ");
            password = scanner.next();

            if (userController.isValidPassword(password)) {
                isNotValid = true;
            } else { 
                logger.error(Messages.WRONG_PASSWORD_FORMAT);
            }  
        }
        return password;
    }

    /**
     * <h1> Print Update Status </h1>
     * <p>
     * Prints the Update Status of the User
     * </p>
     *
     * @param user - Update user
     */
    private void printUpdatedStatus(boolean status) {
        if (status == true) {
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
        StringBuilder OperationPrinter = new StringBuilder();
        OperationPrinter.append("\nPress \" ").append(Constants.ADDER)
                        .append(" \" for New Employee\n")
                        .append("Press \" ").append(Constants.PROJECTOR)
                        .append(" \" for View\n")
                        .append("Press \" ").append(Constants.FINDER)
                        .append(" \" for Search\n")
                        .append("Press \" ").append(Constants.UPDATER)
                        .append(" \" for Update\n")
                        .append("Press \" ").append(Constants.REMOVER)
                        .append(" \" for Delete\n")
                        .append("Press \" ").append(Constants.ASSIGN_LEAD)
                        .append(" \" for Assign Lead\n")
                        .append("Press \" ").append(Constants.EXIT_OPERATION)
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
        choicePrinter.append("\npress \" ").append(Constants.NAME)
                     .append(" \" for Name\n")
                     .append("press \" ").append(Constants.EMAIL)
                     .append(" \" for Email\n")
                     .append("press \" ").append(Constants.PHONE_NUMBER)
                     .append(" \" for Phone Number\n")
                     .append("press \" ").append(Constants.EXIT)
                     .append(" \" for Exit\n")
                     .append("Enter your Updater: "); 
        System.out.println(choicePrinter);
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
                      .append("|            WELCOME MANAGER!            |")
                      .append("========================================");
        System.out.println(welcomePrinter);
    }
}