package com.ideas2it.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;

import com.ideas2it.model.Lead;

/**
 * controls all the operations performed by the employee
 * like adding, updating, searching the leads
 *
 * @author Ajaisharma D
 * @version 1.0 24-08-2022
 */
public class EmployeeView {
    private static Scanner scanner = new Scanner(System.in);
    private final static byte ADDER = 1;
    private final static byte PROJECTOR = 2;
    private final static byte FINDER = 3;
    private final static byte EDITOR = 4;
    private final static byte EXIT = 5;

    private final static byte LOGOUT = 1;
    private final static byte ALL_LEAD = 1;
    private final static byte ONE_LEAD = 2;

    private final static byte NAME = 1;
    private final static byte EMAIL = 2;
    private final static byte PHONE_NUMBER = 3;
    private final static byte STAGE = 4;
    private final static byte COMPANY_NAME = 5;
    private final static byte START_DATE = 6;
    private final static byte END_DATE = 7;
    private final static byte DEAL_SIZE = 8;
    private final static byte EXIT_UPDATER = 9;

    private String leadId;
    private String leadName;
    private String leadEmail;
    private String leadPhone;
    private String leadStage;
    private String leadCompanyName;
    private String leadStartDate;
    private String leadEndDate;
    private int leadDealSize;
    
    private int count;
    private int idCount = 0;
    private Lead lead; 
    private Map<String, Lead> leadMap = new HashMap<>();
    private boolean isActive = true;
    private byte choice;
    private String id;

    public void performEmployeeOperation() {
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append("press \" 1 \" for Add New Lead\n")
                     .append("press \" 2 \" for View\n")
                     .append("press \" 3 \" for Search\n")
                     .append("press \" 4 \" for Update\n")
                     .append("press \" 5 \" for EXIT\n")
                     .append("Enter your choice: ");
        
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("press \" 1 \" for Yes\n")
                   .append("press \" Any Number \" for No");
        
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the")
                      .append("number given Below to proceed\n");
        
        StringBuilder welcomePrinter = new StringBuilder();
        welcomePrinter.append("========================================")
                      .append("|          WELCOME EMPLOYEE!           |")
                      .append("========================================");
        
        System.out.println(welcomePrinter);
        
        while (isActive) {
            System.out.print(choicePrinter);
            choice = scanner.nextByte();
                   
            switch (choice) {
            case ADDER:
                System.out.print("\nEnter the lead count to add: ");
                count = scanner.nextInt();
                addLead(count);
                break;
                      
            case PROJECTOR:
                System.out.println("\n========== LEAD DATA ==========\n");
                viewLead();
                break;
                                            
            case FINDER:
                System.out.println("\n========== SEARCH LEAD ==========\n");  
                System.out.print("Enter the lead's Id to Search: ");
                scanner.nextLine();
                id = scanner.nextLine();
                printLeadById(id);
                break;
                       
            case EDITOR:
                System.out.println("\n========== EDIT LEAD  ==========\n");
                System.out.print("Enter the lead's Id to Update: ");
                scanner.nextLine();
                id = scanner.nextLine();
                editLead(id);
                break;
                   
            case EXIT:
                System.out.println(exitPrinter);
                byte logout = scanner.nextByte();
                isActive = (logout == LOGOUT) ? false : true ; 
                System.out.println("Logging Out from Employee ......");
                break;
                   
            default:
                System.out.println(defaultPrinter);
                System.out.println(choicePrinter);
                choice = scanner.nextByte();
                break;
            }        
        }
    }

    /**
     * adds the lead detail to the object array
     *
     * @param count - count of lead to add
     * @return no return
     */
    public void addLead(int count) {

        for (int index = 0; index < count; index++) {
            System.out.println("\n======Enter Lead 0"+ (index + 1) + " Details ======\n");
            leadId = "Lead_0" + (++idCount);
            System.out.print("Enter the Lead's Name      :  ");
            scanner.nextLine();
            leadName = scanner.nextLine();
            System.out.print("Enter the Lead's Email ID  :  ");
            leadEmail = scanner.nextLine();
            System.out.print("Enter the Lead's Phone     :  ");
            leadPhone = scanner.nextLine();
            System.out.print("Enter the Lead's Stage     :  ");
            leadStage = scanner.nextLine();
            System.out.print("Enter the Lead's Company   :  ");
            leadCompanyName = scanner.nextLine();
            System.out.print("Enter the Start-Date       :  ");
            leadStartDate = scanner.nextLine(); 
            System.out.print("Enter the End-Date         :  ");
            leadEndDate = scanner.nextLine();
            System.out.print("Enter the Deal-Size        :  ");
            leadDealSize = scanner.nextInt();
            lead = new Lead(leadId, leadName, leadEmail, 
                                   leadPhone, leadStage, leadCompanyName,
                                   leadStartDate, leadEndDate, leadDealSize);
            leadMap.put(leadId, lead);
        }
    }

    /**
     * prints the lead's details 
     *
     * @return returns nothing
     */
    public void viewLead() {

        for (Map.Entry<String, Lead> leadEntry : leadMap.entrySet()) {
            System.out.println(leadEntry.getKey() + "\n" + leadEntry.getValue());
        }
    }
    
    /**
     * prints the lead's detail by id 
     *
     * @param id - key to search the value
     * @return returns nothing
     */
    public void printLeadById(String id) {
    
        if (leadMap.containsKey(id)) {
            System.out.println(leadMap.get(id));
        }
     }
    
    /**
     * updates the lead's details 
     *
     * @param id - key to update the Values
     * @return returns nothing
     */
    public void editLead(String id) {
        boolean isUpdating = true;
                
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append(">>>>> which data you want to Update? <<<<<\n")
                     .append("\nLead Id can't be changed\n")
                     .append("\npress \" 1 \" for Name\n")
                     .append("press \" 2 \" for Email\n")
                     .append("press \" 3 \" for Phone Number\n")
                     .append("press \" 4 \" for Stage\n")
                     .append("press \" 5 \" for Company Name\n")
                     .append("press \" 6 \" for Start date\n")
                     .append("press \" 7 \" for End date\n")
                     .append("press \" 8 \" for Deal Size\n")
                     .append("press \" 9 \" for Exit\n")
                     .append("Enter your choice: ");               
           
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("press \" 1 \" for Yes\n")
                   .append("press \" Any Number \" for No");
            
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the ")
                      .append("number given Below to proceed\n");
            
        while (isUpdating) {
            for (Map.Entry<String, Lead> leadEntry : leadMap.entrySet()) {
                if (leadEntry.getKey().equals(id)) {
                    System.out.print(choicePrinter);
                    choice = scanner.nextByte();
                     
                    switch (choice) {
                    case NAME:
                        System.out.print("Enter the Name: ");
                        scanner.nextLine();
                        leadName = scanner.nextLine();
                        leadMap.get(id).setName(leadName);
                        break;
                    
                    case EMAIL:
                        System.out.print("Enter the Email: ");
                        scanner.nextLine();
                        leadEmail = scanner.nextLine();
                        leadMap.get(id).setEmailId(leadEmail);
                        break;
                         
                    case PHONE_NUMBER:
                        System.out.print("Enter the Email: ");
                        scanner.nextLine();
                        leadPhone = scanner.nextLine();
                        leadMap.get(id).setPhoneNumber(leadPhone);
                        break;
                           
                    case STAGE:
                        System.out.print("Enter the Email: ");
                        scanner.nextLine();
                        leadEmail = scanner.nextLine();
                        leadMap.get(id).setStage(leadStage);
                        break;
                           
                    case COMPANY_NAME:
                        System.out.print("Enter the Email: ");
                        scanner.nextLine();
                        leadCompanyName = scanner.nextLine();
                        leadMap.get(id).setCompanyName(leadCompanyName);
                        break;
                           
                    case START_DATE:
                        System.out.print("Enter the Email: ");
                        scanner.nextLine();
                        leadStartDate = scanner.nextLine();
                        leadMap.get(id).setStartDate(leadStartDate);
                        break;
                           
                    case END_DATE:
                        System.out.print("Enter the Email: ");
                        scanner.nextLine();
                        leadEndDate = scanner.nextLine();
                        leadMap.get(id).setEndDate(leadEndDate);
                        break;
                           
                    case DEAL_SIZE:
                        System.out.print("Enter the Email: ");
                        scanner.nextLine();
                        leadDealSize = scanner.nextInt();
                        leadMap.get(id).setDealSize(leadDealSize);
                        break;
                           
                    case EXIT_UPDATER:
                        System.out.println(exitPrinter);
                        byte logout = scanner.nextByte();
                        isUpdating = (logout == LOGOUT) ? false : true ; 
                        System.out.println("Logging Out from Updater......");
                        break;
                                  
                    default:
                        System.out.println(defaultPrinter);
                        System.out.println(choicePrinter);
                        choice = scanner.nextByte();   
                    }            
                }         
            }              
        }                
    }                 
}                                          
