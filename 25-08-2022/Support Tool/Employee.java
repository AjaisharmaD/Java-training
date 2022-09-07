import java.util.Arrays;
import java.util.Scanner;

/**
 * controls all the operations performed by the employee
 * like adding, updating, searching the leads
 *
 * @author Ajaisharma 
 * @version 1.0 24-08-2022
 */
public class Employee {
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
    private final static byte PHONE_NUMBER = 2;
    private final static byte EMAIL = 3;
    private final static byte START_DATE = 4;
    private final static byte END_DATE = 5;
    private final static byte COMPANY_NAME = 6;
    private final static byte STAGE = 7;
    private final static byte DEAL_SIZE = 8;

    private String leadId;
    private String leadName;
    private String leadEmail;
    private String leadPhone;
    private String leadCompanyName;
    private String leadStartDate;
    private String leadEndDate;
    private String leadStage;
    private int leadDealSize;
    
    private static int leadCount;
    private int count;
    private int idCount = 0;
    private static Lead[] lead = new Lead[100]; 
    private boolean isActive = true;
    private byte choice;
    private String id;

    public void control() {
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append("press \" 1 \" for Add New Lead\n")
                     .append("press \" 2 \" for View\n")
                     .append("press \" 3 \" for Search\n")
                     .append("press \" 4 \" for Update\n")
                     .append("press \" 5 \" for EXIT\n")
                     .append("Enter your choice");
        
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
            System.out.println(choicePrinter);
            choice = scanner.nextByte();

            switch (choice) {
            case ADDER:
                System.out.println("\n>>>>> Enter the lead count to add <<<<<");
                count = scanner.nextInt();
                addLead(count);
                break;

            case PROJECTOR:
                System.out.println("\n========== LEAD DATA ==========\n");
                viewLead();
                break;

            case FINDER:
                System.out.println("\n========== SEARCH LEAD ==========\n");  
                System.out.print("Enter the lead Id to Update: ");
                scanner.nextLine();
                id = scanner.nextLine();
                printLeadById(id);
                break;
   
            case EDITOR:
                System.out.println("\n========== EDIT LEAD  ==========\n");
                System.out.print("Enter the lead Id to Update: ");
                scanner.nextLine();
                id = scanner.nextLine();
                editLead(id);
                break;

            case EXIT:
                System.out.println(exitPrinter);
                byte logout = scanner.nextByte();
                isActive = (logout == LOGOUT) ? false : true ; 
                System.out.println("********** Logging Out from Employee **********");
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
            System.out.println("======Enter Lead 0" + (index + 1) + "======\n");
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
            System.out.print("Enter  the  End-Date       :  ");
            leadEndDate = scanner.nextLine();
            System.out.print("Enter  the Deal-Size       :  ");
            leadDealSize = scanner.nextInt();
            lead[leadCount] = new Lead(leadId, leadName, leadEmail, 
                                     leadPhone, leadStage,leadCompanyName,
                                     leadStartDate, leadEndDate, leadDealSize);
            leadCount++;
            System.out.println();
        }
    }

    /**
     * prints the lead's details 
     *
     * @return returns nothing
     */
    public void viewLead() {
        for (int index = 0; index < leadCount; index++) {
            System.out.println(lead[index]);
        }
    }

    /**
     * prints the lead's detail by id 
     *
     * @return returns nothing
     */
    public void printLeadById(String id) {
        for (int index = 0; index < leadCount; index++) {
            if (lead[index].getId().equals(id)) {
                System.out.println(lead[index]);
            }
        }
    }

    /**
     * updates the lead's details 
     *
     * @return returns nothing
     */
     public void editLead(String id) {
        System.out.println("Lead Id can't be changed");
        
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append(">>>>> which data you want to Update? <<<<<\n")
                     .append("press \" 1 \" for Name\n")
                     .append("press \" 2 \" for Phone Number\n")
                     .append("press \" 3 \" for Email\n")
                     .append("press \" 4 \" for Stage\n")
                     .append("press \" 5 \" for Company Name\n")
                     .append("press \" 6 \" for Start date\n")
                     .append("press \" 7 \" for End date\n")
                     .append("press \" 8 \" for Deal Size\n")
                     .append("Enter your choice:");

        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append("\n>>>>> You have entered wrong Choice <<<<<\n")
                      .append("Please enter any of the")
                      .append("number given Below to proceed\n");
        

        for (int index = 0; index < leadCount; index++) {
            if (lead[index].getId().equals(id)) {
                System.out.print(choicePrinter);
                choice = scanner.nextByte();

                switch (choice) {
                case NAME:
                    System.out.print("Enter the Name: ");
                    scanner.nextLine();
                    lead[index].setName(scanner.nextLine());
                    break;
       
                case PHONE_NUMBER:
                    System.out.print("Enter the Phone Number: ");
                    scanner.nextLine();
                    lead[index].setPhoneNumber(scanner.nextLine());
                    break;

                case EMAIL:
                    System.out.print("Enter the Email: ");
                    scanner.nextLine();
                    lead[index].setEmailId(scanner.nextLine());
                    break;

                case STAGE: // need to creat a method with switch case 
                    System.out.print("Enter the Stage: ");
                    scanner.nextLine();
                    lead[index].setStage(scanner.nextLine());
                    break;

                case COMPANY_NAME:
                    System.out.print("Enter the Company Name: ");
                    scanner.nextLine();
                    lead[index].setCompanyName(scanner.nextLine());
                    break;

                case START_DATE:
                    System.out.print("Enter the Start Date: ");
                    scanner.nextLine();
                    lead[index].setStartDate(scanner.nextLine());
                    break;

                case END_DATE:
                    System.out.print("Enter the End Date: ");
                    scanner.nextLine();
                    lead[index].setEndDate(scanner.nextLine());
                    break;

                case DEAL_SIZE:
                    System.out.print("Enter the Deal Size: ");
                    lead[index].setDealSize(scanner.nextInt());
                    break;

                default:
                    System.out.println(defaultPrinter);
                    System.out.println(choicePrinter);
                    choice = scanner.nextByte();
                    break;
                    
                }
            }
        }
     }   
}