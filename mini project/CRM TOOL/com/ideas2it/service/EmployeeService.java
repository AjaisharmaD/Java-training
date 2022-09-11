package com.ideas2it.service;

import com.ideas2it.view.EmployeeView;

public class EmployeeService {
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
     * @return no return
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

        while (isUpdating) {
            for (Map.Entry<String, Lead> leadEntry : leadMap.entrySet()) {
                if (leadEntry.getKey().equals(id)) {
                    printUpdaterMenu();
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
                        printExitMenu();
                        byte logout = scanner.nextByte();
                        isUpdating = (logout == LOGOUT) ? false : true ; 
                        System.out.println("Logging Out from Updater......");
                        break;
                                  
                    default:
                        printDefaultStatement();
                        printUpdaterMenu();
                        choice = scanner.nextByte();   
                    }            
                }         
            }              
        }                
    }        

    /**
     * Prints the Menu for Employee to do updation
     */
    void printUpdaterMenu() {
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
        System.out.println(choicePrinter);
    }  
 
    /**
     * Prints the choice for Employee to exit
     */  
    void printExitMenu() {  
        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append("\n>>>>> Are you sure want to Exit? <<<<<\n")
                   .append("press \" 1 \" for Yes\n")
                   .append("press \" Any Number \" for No");
        System.out.println(exitPrinter);
    }

    /**
     * Prints the Default Statements
     */
    void printDefaultStatement() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the")
                      .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
    }
}