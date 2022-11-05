package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.UserController;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.view.LeadView;
import com.ideas2it.view.UserView;
import com.ideas2it.model.User;

/**
 * <h1> CRM Tool View </h1>
 * <p> 
 * Provides the Dashboard for Login and
 * validates the user's credential to login and
 * takes them to Employee Dashboard where they can do Operations
 * helps the manager to Login and go to the Manager Dashboard
 * </p>
 *
 * @author  AJAISHARMA 
 * @version 1.0 
 * @since   10-09-2022
 */
public class CRMView {
    private CustomLogger logger;
    private LeadView leadView;
    private UserView userView;
    private UserController userController;

    public CRMView() {
        this.logger = new CustomLogger(CRMView.class);
        this.leadView = new LeadView();
        this.userView = new UserView();
        this.userController = new UserController();
    }
    
    /**
     * <h1> CRM Dashboard </h1>
     * <p>
     * Contains the login option for the Employees and manager 
     * </p>
     */
    public void startCRM() {
        Scanner scanner = new Scanner(System.in);
        printWelcomeMessage();
        String logout;
        String loginChoice;
        boolean isActive = false;

        while (!isActive) {        
            printUserMenu();
            loginChoice = scanner.next();
                       
            switch (loginChoice) {
            case Constants.EMPLOYEE:
                 login(scanner);
                 break;
               
            case Constants.MANAGER:
                 logger.info("Logging in as Manager");
                 userView.openManagerDashboard(scanner);
                 break;
             
            case Constants.CRM_EXIT:
                System.out.println(Messages.EXIT_MENU);
                logout = scanner.next();
                isActive = (logout.equals(Constants.LOGOUT)) ? true : false;                     
                break;
                 
            default:
                logger.warn(Messages.INVALID_CHOICE);
            }  
        }
    } 

    private void login(Scanner scanner) {
        User user;
        String logout;
        boolean isValid = false;

        while (!isValid) {
            user = validUser(scanner);

            if (null != user) {
                logger.info("Logging in as Employee");
                leadView.openEmployeeDashboard(scanner, user);
                isValid = true;
            } else {
                logger.info(Messages.USER_NOT_FOUND);
                System.out.println(Messages.EXIT_MENU);
                logout = scanner.next();
                isValid = (logout.equals(Constants.LOGOUT)) ? true : false;  
            }
        }
    }

    /**
     * Validates the login Details
     */
    private User validUser(Scanner scanner) {
        List<User> users = userController.getAll();
        boolean isValidEmail = false;
        boolean isValidPassword = false;

        if (!users.isEmpty()) {
            for (User user : users) {
                while (!isValidEmail) {
                    if (getEmailId(scanner).equals(user.getEmailId())) {
                        while(!isValidPassword) {
                            if (getPassword(scanner).equals(user.getPassword())) {
                                isValidEmail = true;
                                isValidPassword = true;
                                return user;
                            } else {
                                logger.info("Wrong password");
                            }
                        }    
                    } else {
                        logger.info("wrong mail Id");
                    }
                }
            }
        }
        return null;
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
        
        scanner.skip("\r\n");
        while (!isNotValid) {
            System.out.print("Email ID             : ");
            emailId = scanner.nextLine();

            if (userController.isValidEmailId(emailId)) {
                break;
            } else { 
                logger.warn(Messages.WRONG_EMAIL_ID_FORMAT);
            }  
        }
        return emailId;
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
     * <h1> Print Welcome message </h1>
     * <p>
     * Prints the Welcome Statements
     * </p>
     */
    private void printWelcomeMessage() {
        StringBuilder welcomePrinter = new StringBuilder();
        welcomePrinter.append("\n========================================")
                      .append("|                CRM TOOL                |")
                      .append("========================================");
        System.out.println(welcomePrinter);
    }

    /**
     * <h1> Print User Menu </h1>
     * <p>
     * Prints the User Menu to Login 
     * </p>
     */
    private void printUserMenu() {
        StringBuilder userMenu = new StringBuilder();
        userMenu.append("\npress \" ").append(Constants.EMPLOYEE)
                .append(" \" for Employee\n")
                .append("press \" ").append(Constants.MANAGER)
                .append(" \" for Manager\n")
                .append("press \" ").append(Constants.CRM_EXIT)
                .append(" \" for EXIT\n")
                .append("Press the Number to Login as: ");
	System.out.print(userMenu);
    }
}