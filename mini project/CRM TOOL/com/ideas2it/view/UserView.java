package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.UserController;
import com.ideas2it.logger.CustomLogger;
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
        boolean isActive = false;
        byte logout;
        byte operationChoice;
        printWelcomeMessage();

        while (!isActive) {
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
     * <h1> Create User </h1>
     * <p>
     * Ask for the Details of User from the manager
     * and passes the Details to Store
     * </p>
     *
     * @param scanner - object of a Scanner class
     */
    public void create(Scanner scanner) {
        System.out.println("\n========== NEW EMPLOYEE ==========\n");
        boolean isRight = false;
        String name;
        String emailId;
        String phoneNumber;
        String password;
        int count = 0;

        while (!isRight) {
            try {
                System.out.print("\nEnter the User count to add: ");
                count = scanner.nextInt();
                isRight = true;
            } catch (InputMismatchException e) {
                logger.error("Wrong Input for Count");
                scanner.next();
                continue;
            }
        }
        scanner.skip("\r\n");

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter User 0"+ (index + 1) + " Details ======\n");
            name = getName(scanner);
            emailId = getEmail(scanner);
            phoneNumber = getPhoneNumber(scanner);
            password = getPassword(scanner);
            System.out.println((userController
                                .create(new User(name, emailId, phoneNumber),
                                password) != null) ? Messages.SUCCESS 
                                : Messages.FAILED);
        }
    }

    /**
     * <h1> Display the Details of  all User </h1>
     * <p>
     * Displys the Details of an user
     * </p>
     */
    public void displayAll() {
        System.out.println("\n========== EMPLOYEE DETAILS ==========\n");

        if (null != userController.getAll()) {
            for (User user : userController.getAll()) {
                System.out.println(user);
                System.out.println("--------------X--------------\n");
            }
        } else {
            logger.info(">>>>> No Employee Found! <<<<<");
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
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        
        if (null != userController.getById(id)) {
            System.out.println(userController.getById(id));
            System.out.println("--------------X--------------\n");
        } else {
            logger.warn(">>>>> Employee Not Found! <<<<<");
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
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        byte logout;
        byte updaterChoice;
        boolean isUpdating = false;

        User user = userController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = getChoice(scanner);
                                 
            switch (updaterChoice) {
            case Constants.NAME:
                scanner.skip("\r\n");
                user.setName(getName(scanner));
                printUpdatedStatus(userController.updateById(id, user));
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                user.setEmailId(getEmail(scanner));
                printUpdatedStatus(userController.updateById(id, user));
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                user.setPhoneNumber(getPhoneNumber(scanner));
                printUpdatedStatus(userController.updateById(id, user));
                break;

            case Constants.EXIT_EMPLOYEE_UPDATER:
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
        System.out.print("Enter the ID to User\n \" Format:Employee_01 \" : ");
        String id = scanner.nextLine();
        System.out.println((userController.isDeletedById(id))
                                        ? Messages.SUCCESS : Messages.FAILED);
        logger.info("User Deleted");
    }

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

        while (!isNotValid) {
            System.out.print("Name                 : ");
            name = scanner.nextLine();

            if (userController.isValidName(name)) {
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
     * Gets the Email of the User and checks whether the Email is Valid or not
     * </p>
     *
     * @param scanner - object of a Scanner class
     *
     * @return email - a Valid Email of the User
     */
    private String getEmail(Scanner scanner) {
        String email = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Email ID             : ");
            email = scanner.nextLine();

            if (userController.isValidEmail(email)) {
                break;
            } else { 
                logger.error("\n>>>>> Wrong Email Format, Give the proper Email! <<<<<\n");
            }  
        }
        return email;
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
            phoneNumber = scanner.nextLine();

            if (userController.isValidPhoneNumber(phoneNumber)) {
                break;
            } else { 
                logger.error("\n>>>>> Wrong Phone Number Format, Give the proper Phone Number! <<<<<\n");
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
            password = scanner.nextLine();

            if (userController.isValidPassword(password)) {
                break;
            } else { 
                logger.error("\n>>>>> Wrong Password Format, Give the proper Password! <<<<<\n");
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
    private void printUpdatedStatus(User user) {
        if (user != null) {
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
        StringBuilder OperationPrinter = new StringBuilder();
        OperationPrinter.append("Press \" ").append(Constants.ADDER)
                        .append(" \" for New Employee\n")
                        .append("Press \" ").append(Constants.PROJECTOR)
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
        choicePrinter.append(">>>>> User Id can't be changed <<<<<\n")
                     .append("\npress \" ").append(Constants.NAME)
                     .append(" \" for Name\n")
                     .append("press \" ").append(Constants.EMAIL)
                     .append(" \" for Email\n")
                     .append("press \" ").append(Constants.PHONE_NUMBER)
                     .append(" \" for Phone Number\n")
                     .append("press \" ").append(Constants.EXIT_EMPLOYEE_UPDATER)
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
                      .append("========================================\n");
        System.out.println(welcomePrinter);
    }
}