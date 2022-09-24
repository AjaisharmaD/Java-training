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
                display();
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
                printExitMenu();
                logout = scanner.nextByte();
                isActive = (logout == Constants.LOGOUT) ? true : false; 
                break;
                   
            default:
                printDefaultStatement();
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
            System.out.println(employeeController.createEmployee(new User(name, emailId, phoneNumber), password));
        }
    }

    /**
     * <h1> Display Employee byte logout </h1>
     * <p>
     * Displys the Details of an employee
     * </p>
     */
    public void display() {
        System.out.println("\n========== EMPLOYEE DETAILS ==========\n");
        System.out.println(managerController.display());
    }

    /**
     * <h1> Display Single Employee Details By Id </h1>
     * <p>
     * Searchs the Employee Details by calling the Employee Id
     * This will print the Details of a Single Employee
     * </p>
     */
    public void DisplayById() {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the Employee's Id to Search: ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println(managerController.getEmployeeById(id));
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

        User employee = employeeController.getEmployeeById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updater = scanner.nextByte();
                     
            switch (updater) {
            case Constants.NAME:
                scanner.skip("\r\n");
                employee.setName(getName());
                System.out.println(employeeController.updateById(id, user));
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                employee.setEmailId(getEmail());
                System.out.println(employeeController.updateById(id, user));
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                employee.setPhoneNumber(getPhoneNumber());
                System.out.println(employeeController.updateById(id, user));
                break;

            case Constants.EXIT_MANAGER_UPDATER:
                printExitMenu();
                logout = scanner.nextByte();
                isUpdating = (logout == Constants.LOGOUT) ? true : false;
                break;
                                  
            default:
                printDefaultStatement();  
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
        boolean isDeleted = employeeController.deleteById(id);
        printSuccessMessage(isDeleted);
    }

    /**
     * <h1> Print Success Message </h1>
     * <p>
     * Prints the Message that the Operation completed Successfully or not
     * </p>
     *
     * @param isSuccess - boolean value of Operation performed
     */
    private void printSuccessMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("\n>>>>> Successfully finished the operation <<<<<\n");
        } else {
            System.out.println("\n>>>>> Error: Please check something went wrong <<<<<\n");
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
        OperationPrinter.append("\nPress \" 1 \" for Add New Employee\n")
                        .append("Press \" 2 \" for View\n")
                        .append("Press \" 3 \" for Search\n")
                        .append("Press \" 4 \" for Update\n")
                        .append("Press \" 5 \" for Delete\n")
                        .append("Press \" 6 \" for EXIT\n")
                        .append("Enter your Operation: ");
        System.out.print(OperationPrinter);
    }

    /**
     * <h1> Print Updation Menu </h1>
     * <p>
     * Prints the Menu for Updating the Details of Employee
     * </p>
     */
    private void printUpdaterMenu() {
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append("\nEmployee Id can't be changed\n")
                     .append("\npress \" 1 \" for Name\n")
                     .append("press \" 2 \" for Email\n")
                     .append("press \" 3 \" for Phone Number\n")
                     .append("press \" 4 \" for Exit\n")
                     .append("Enter your Updater: "); 
        System.out.println(choicePrinter);
    } 

    /**
     * <h1> Print Exit Menu </h1>
     * <p>
     * Prints the choice for Employee to exit
     * </p>
     */
    private void printExitMenu() {
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("Press \" 1 \" for Yes\n")
                   .append("Press \" Any Number \" for No");
        System.out.println(exitPrinter);
    }

    /**
     * <h1> Print Default Statement </h1>
     * <p>
     * Prints the Default Statements
     * </p>
     */
    private void printDefaultStatement() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the ")
                      .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
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