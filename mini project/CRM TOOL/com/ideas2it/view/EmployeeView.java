package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.controller.EmployeeController;
import com.ideas2it.model.User;

/**
 * <h1> Employee View </h1>
 * <p>
 * This manager View class used to Controll the operation which are 
 * performed by the Manager, like Adding, Viewing, Editing, Deleting
 * the details of Employee.
 * </p> 
 * 
 * @author  Ajaisharma D
 * @version 1.0  
 * @since   19-09-2022
 */
public class EmployeeView {
    private Scanner scanner = new Scanner(System.in);
    private EmployeeController employeeController;

    public EmployeeView() {
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
    public void openManagerDashboard() {
        boolean isActive = false;
        byte logout;
        byte operation;

        printWelcomeMessage();

        while (!isActive) {
            printOperationMenu();
            operation = scanner.nextByte();
                   
            switch (operation) {
            case Constants.ADDER:
                createEmployee();
                break;
               
            case Constants.PROJECTOR:
                displayAll();
                break;
                                                
            case Constants.FINDER:
                displayById();
                break;
                       
            case Constants.UPDATER:
                updateById();
                break;
               
            case Constants.REMOVER:
                deleteById();
                break;

            case Constants.EXIT:
                System.out.println(Constants.EXIT_MENU);
                logout = scanner.nextByte();
                isActive = (logout == Constants.LOGOUT) ? true : false; 
                break;
                   
            default:
                System.out.println(Constants.DEFAULT_MESSAGE);
            }        
        }
    }

    /**
     * <h1> Add Employee </h1>
     * <p>
     * Ask for the Details of Employee from the manager
     * and passes the Details to Store
     * </p>
     */
    public void createEmployee() {
        System.out.print("\nEnter the Employee count to add: ");
        int count = scanner.nextInt();
        String name;
        String emailId;
        String phoneNumber;
        String password;

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter Employee 0"+ (index + 1) + " Details ======\n");
            scanner.skip("\r\n");
            name = getName();
            emailId = getEmail();
            phoneNumber = getPhoneNumber();
            password = getPassword();
            System.out.println((employeeController
                                .createEmployee(new User(name, emailId, phoneNumber),
                                password) != null) ? Constants.SUCCESS 
                                : Constants.FAILED);
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
        for (User employee : employeeController.getAll()) {
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
    public void displayById() {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
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
    public void updateById() {
        System.out.print("Enter the Employee's Id to Update: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        byte logout;
        byte updater;
        boolean isUpdating = false;

        User employee = employeeController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updater = scanner.nextByte();
                     
            switch (updater) {
            case Constants.NAME:
                scanner.skip("\r\n");
                employee.setName(getName());
                System.out.println((employeeController.updateById(id, employee) != null)
                                                ? Constants.SUCCESS : Constants.FAILED);
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                employee.setEmailId(getEmail());
                System.out.println((employeeController.updateById(id, employee) != null)
                                                ? Constants.SUCCESS : Constants.FAILED);
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                employee.setPhoneNumber(getPhoneNumber());
                System.out.println((employeeController.updateById(id, employee) != null)
                                                ? Constants.SUCCESS : Constants.FAILED);
                break;

            case Constants.EXIT_EMPLOYEE_UPDATER:
                System.out.println(Constants.EXIT_MENU);
                logout = scanner.nextByte();
                isUpdating = (logout == Constants.LOGOUT) ? true : false;
                break;
                                  
            default:
                System.out.println(Constants.DEFAULT_MESSAGE);  
            } 
        }
    }

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name of the Employee and checks whether the Name is Valid or not
     * </p> 
     *
     * @return name - a Valid Name of the Employee
     */
    private String getName() {
        String name = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Name                          : ");
            name = scanner.nextLine();

            if (employeeController.isValidName(name)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Name Format, Give the proper Name! <<<<<\n");
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
    private String getEmail() {
        String email = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Email ID                      : ");
            email = scanner.nextLine();

            if (employeeController.isValidEmail(email)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Email Format, Give the proper Email! <<<<<\n");
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
    private String getPhoneNumber() {
        String phoneNumber = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Phone Number                  : ");
            phoneNumber = scanner.nextLine();

            if (employeeController.isValidPhoneNumber(phoneNumber)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Phone Number Format, Give the proper Phone Number! <<<<<\n");
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
    private String getPassword() {
        String password = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Enter the Employee's Password                     : ");
            password = scanner.nextLine();

            if (employeeController.isValidPassword(password)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Password Format, Give the proper Password! <<<<<\n");
            }  
        }
        return password;
    }

    /**
     * <h1> Delete the Employee </h1>
     * <p>
     * This method will Delete the Details of a Employee 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void deleteById() {
        System.out.print("Enter the ID to Employee\n \" Format:Employee_01 \" : ");
        String id = scanner.nextLine();
        System.out.println((employeeController.deleteById(id))
                                        ? Constants.SUCCESS : Constants.FAILED);
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
                        .append("Press \" ").append(Constants.EXIT)
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
        choicePrinter.append(">>>>> Lead Id can't be changed <<<<<\n")
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
