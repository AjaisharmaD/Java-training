package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.ManagerController;
import com.ideas2it.model.User;

/**
 * controlls all the operation performed by the Manager
 * like adding employee, updating Employee, viewing lead, searching leads
 * 
 * @author Ajaisharma D
 * @version 1.0  16-09-2022
 */
public class ManagerView {
    private Scanner scanner = new Scanner(System.in);
    private final static byte ADDER = 1;
    private final static byte PROJECTOR = 2;
    private final static byte FINDER = 3;
    private final static byte EDITOR = 4;
    private final static byte EXIT = 5;

    private final static byte NAME = 1;
    private final static byte EMAIL = 2;
    private final static byte PHONE_NUMBER = 3;
    private final static byte EXIT_UPDATER = 4;
    
    private ManagerController managerController = new ManagerController();

    /**
     * Manager's operation goes here
     */
    public void openManagerDashboard() {
        boolean isActive = true;
        byte operation;

        printWelcomeMessage();

        while (isActive) {
            printOperationMenu();
            operation = scanner.nextByte();
                   
            switch (operation) {
            case ADDER:
                createEmployee();
                break;
               
            case PROJECTOR:
                viewEmployee();
                break;
                                                
            case FINDER:
                findEmployee();
                break;
                       
            case EDITOR:
                modifyEmployee();
                break;
               
            case EXIT:
                printExitMenu();
                byte logout = scanner.nextByte();
                isActive = managerController.closeManager(logout); 
                break;
                   
            default:
                printDefaultStatement();
            }        
        }
    }

    /**
     * Creates the Employee's detail 
     */
    public void createEmployee() {
        User user;
        System.out.print("\nEnter the Employee count to add: ");
        int count = scanner.nextInt();
 
        String employeeName;
        String employeeEmailId;
        String employeePhone;
        String password;

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter Employee 0"+ (index + 1) + " Details ======\n");
            System.out.print("Enter the Employee's Name         :  ");
            scanner.nextLine();
            employeeName = scanner.nextLine();
            System.out.print("Enter the Employee's Email ID     :  ");
            employeeEmailId = scanner.nextLine();
            System.out.print("Enter the Employee's Phone Number :  ");
            employeePhone = scanner.nextLine();
            System.out.print("Enter the Password                :  ");
            password = scanner.nextLine();

            user = new User(employeeName, employeeEmailId, employeePhone);

            boolean isAdded = managerController.addEmployee(user, password);
        }
    }

    /**
     * Prints the Employee Details 
     */
    public void viewEmployee() {
        System.out.println("\n========== EMPLOYEE DETAILS ==========\n");
        System.out.println(managerController.printEmployee());
    }

    /**
     * Finds the Employee by id
     */
    public void findEmployee() {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the Employee's Id to Search: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        System.out.println(managerController.printEmployeeById(id));
    }

    /**
     * updates the lead's details 
     *
     * @param id - key to update the Values
     * @return returns nothing
     */
    public void modifyEmployee() {
        System.out.print("Enter the Employee's Id to Update: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        boolean isUpdating = true;

        while (isUpdating) {
            printUpdaterMenu();
            byte update = scanner.nextByte();
                     
            switch (update) {
            case NAME:
                editName(id);
                break;
                    
            case EMAIL:
                editEmail(id);
                break;
                         
            case PHONE_NUMBER:
                editPhone(id);
                break;

            case EXIT_UPDATER:
                printExitMenu();
                byte logout = scanner.nextByte();
                isUpdating = managerController.closeManager(logout); 
                break;
                                  
            default:
                printDefaultStatement();  
            } 
        }
    }

    /**
     * Updates the Name of the Employee
     *
     * @param id - key to update the name
     */
    public void editName(String id) {
        System.out.print("Enter the Name: ");
        scanner.nextLine();
        String employeeName = scanner.nextLine();
        managerController.editName(id, employeeName);
    }

    /**
     * Updates the Email Id of the Employee
     *
     * @param id - key to update the Email id
     */
    public void editEmail(String id) {
        System.out.print("Enter the Email: ");
        scanner.nextLine();
        String employeeEmail = scanner.nextLine();
        managerController.editEmail(id, employeeEmail);
    }

    /**
     * Updates the Phone Number of the Employee
     *
     * @param id - key to update the Phone number
     */
    public void editPhone(String id) {
        System.out.print("Enter the Phone Number: ");
        scanner.nextLine();
        String employeePhone = scanner.nextLine();
        managerController.editPhone(id, employeePhone);
    }

    /**
     * Prints the Menu for Employee to do operations
     */
    private void printOperationMenu() {
        StringBuilder OperationPrinter = new StringBuilder();
        OperationPrinter.append("Press \" 1 \" for Add New Employee\n")
                     .append("Press \" 2 \" for View\n")
                     .append("Press \" 3 \" for Search\n")
                     .append("Press \" 4 \" for Update\n")
                     .append("Press \" 5 \" for EXIT\n")
                     .append("Enter your Operation: ");
        System.out.print(OperationPrinter);
    }

    /**
     * Prints the Menu for Employee to do updation
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
     * Prints the choice for Employee to exit
     */
    private void printExitMenu() {
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("Press \" 1 \" for Yes\n")
                   .append("Press \" Any Number \" for No");
        System.out.println(exitPrinter);
    }

    /**
     * Prints the Default Statements
     */
    private void printDefaultStatement() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the ")
                      .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
    }

    /**
     * Prints the Welcome Statements
     */
    private void printWelcomeMessage() {
        StringBuilder welcomePrinter = new StringBuilder();
        welcomePrinter.append("\n========================================")
                      .append("|            WELCOME MANAGER!            |")
                      .append("========================================\n");
        System.out.println(welcomePrinter);
    }
}
