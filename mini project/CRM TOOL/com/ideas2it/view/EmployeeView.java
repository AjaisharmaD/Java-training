package com.ideas2it.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.EmployeeController;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Employee;

/**
 * <h1> Employee View </h1>
 * <p>
 * This Employee View class used to Controll the operation which are 
 * performed by the Manager, like Adding, Viewing, Editing, Deleting
 * the details of Employee.
 * </p> 
 * 
 * @author  Ajaisharma D
 * @version 1.0  
 * @since   19-09-2022
 */
public class EmployeeView {
    private CustomLogger logger;
    private EmployeeController employeeController;

    public EmployeeView() {
        this.logger = CustomLogger(EmployeeView.class);
        this.employeeController = new EmployeeController();
    }

    /**
     * <h1> Manager Dashboard </h1>
     * <p>
     * This method used to do the operation
     * such as Adding, Printing, Updating and Deleting
     * the Details of Employee
     * </p>
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
                editById(scanner);
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
     * <h1> Create Employee </h1>
     * <p>
     * Ask for the Details of Employee from the manager
     * and passes the Details to Store
     * </p>
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
                System.out.print("\nEnter the Employee count to add: ");
                count = scanner.nextInt();
                isRight = true;
            } catch (InputMismatchException e) {
                logger.error("Wrong Input for Count");
                scanner.next();
                continue;
            }
        }

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter Employee 0"+ (index + 1) + " Details ======\n");
            scanner.skip("\r\n");
            name = getName(scanner);
            emailId = getEmail(scanner);
            phoneNumber = getPhoneNumber(scanner);
            password = getPassword(scanner);
            System.out.println((employeeController
                                .create(new Employee(name, emailId, phoneNumber),
                                password) != null) ? Messages.SUCCESS 
                                : Messages.FAILED);
        }
    }

    /**
     * <h1> Display the Details of  all Employee </h1>
     * <p>
     * Displys the Details of an employee
     * </p>
     */
    public void displayAll() {
        System.out.println("\n========== EMPLOYEE DETAILS ==========\n");

        for (Employee employee : employeeController.getAll()) {
            System.out.println(employee);
        }
    }

    /**
     * <h1> Display Details of Employee By Id </h1>
     * <p>
     * Search the Employee Details by calling the Employee Id
     * This will print the Details of a Single Employee
     * </p>
     */
    public void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH EMPLOYEE ==========\n");  
        System.out.print("Enter the Employee's Id to Search: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println(employeeController.getById(id));
    }

    /**
     * <h1> Update the Employee </h1>
     * <p>
     * This method will updates the each fields of the Employee Details 
     * and Prints the Message that the fields are Updated or not
     * </p>
     */
    public void editById(Scanner scanner) {
        System.out.println("\n========== EDIT EMPLOYEE ==========\n"); 
        System.out.print("Enter the Employee's Id to Edit: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        byte logout;
        byte updaterChoice;
        boolean isUpdating = false;

        Employee employee = employeeController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = getChoice(scanner);
                                 
            switch (updaterChoice) {
            case Constants.NAME:
                scanner.skip("\r\n");
                employee.setName(getName(scanner));
                printUpdatedStatus(employeeController.updateById(id, employee));
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                employee.setEmailId(getEmail(scanner));
                printUpdatedStatus(employeeController.updateById(id, employee));
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                employee.setPhoneNumber(getPhoneNumber(scanner));
                printUpdatedStatus(employeeController.updateById(id, employee));
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
     * <h1> Delete the Employee </h1>
     * <p>
     * This method will Delete the Details of a Employee 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE EMPLOYEE ==========\n");
        System.out.print("Enter the ID to Employee\n \" Format:Employee_01 \" : ");
        String id = scanner.nextLine();
        System.out.println((employeeController.isDeletedById(id))
                                        ? Messages.SUCCESS : Messages.FAILED);

        logger.info("Employee Deleted");
    }

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name of the Employee and checks whether the Name is Valid or not
     * </p> 
     *
     * @return name - a Valid Name of the Employee
     */
    private String getName(Scanner scanner) {
        String name = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Name                          : ");
            name = scanner.nextLine();

            if (employeeController.isValidName(name)) {
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
     * Gets the Email of the Employee and checks whether the Email is Valid or not
     * </p>
     *
     * @return email - a Valid Email of the Employee
     */
    private String getEmail(Scanner scanner) {
        String email = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Email ID                      : ");
            email = scanner.nextLine();

            if (employeeController.isValidEmail(email)) {
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
     * Gets the Phone Number of the Employee and checks whether the Phone Number is Valid or not
     * </p>
     *
     * @return employeePhoneNumber - a Valid Phone Number of the Employee
     */
    private String getPhoneNumber(Scanner scanner) {
        String phoneNumber = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Phone Number                  : ");
            phoneNumber = scanner.nextLine();

            if (employeeController.isValidPhoneNumber(phoneNumber)) {
                break;
            } else { 
                logger.warn("\n>>>>> Wrong Phone Number Format, Give the proper Phone Number! <<<<<\n");
            }  
        }
        return phoneNumber;
    }

    /**
     * <h1> Get Password </h1>
     * <p>
     * Gets the Password of the Employee and checks whether the Password is Valid or not
     * </p>
     *
     * @return password - a Valid Password of the Employee
     */
    private String getPassword(Scanner scanner) {
        String password = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Password                     : ");
            password = scanner.nextLine();

            if (employeeController.isValidPassword(password)) {
                break;
            } else { 
                logger.warn("\n>>>>> Wrong Password Format, Give the proper Password! <<<<<\n");
            }  
        }
        return password;
    }

    /**
     * <h1> Print Update Status </h1>
     * <p>
     * Prints the Update Status of the Employee
     * </p>
     *
     * @return employee - Update employee
     */
    private void printUpdatedStatus(Employee employee) {
        if (employee != null) {
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
        StringBuilder OperationPrinter = new StringBuilder();
        OperationPrinter.append("Press \" ").append(Constants.ADDER)
                        .append(" \" for Create New Lead\n")
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
        choicePrinter.append(">>>>> Employee Id can't be changed <<<<<\n")
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