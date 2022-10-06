package com.ideas2it.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.controller.LeadController;
import com.ideas2it.enums.Status;
import com.ideas2it.enums.Title;
import com.ideas2it.enums.Type;
import com.ideas2it.model.Lead;
import com.ideas2it.view.AccountView;
import com.ideas2it.view.ContactView;

/**
 * <h1> Lead View </h1>
 * <p> 
 * Lead view class used to Provide Dashboard of operations 
 * performed by the Employee, like Adding, Updating,
 * Viewing, Searching, Deleting the Details of Lead
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.5 06-10-2022
 * @since   16-09-2022
 */
public class LeadView {
    private LeadController leadController;
    private AccountView accountView;
    private ContactView contactView;
        
    public LeadView() {
        this.leadController = new LeadController();
        this.accountView = new AccountView();
        this.contactView = new ContactView();
    }

    /**
     * <h1> Employee Dashboard </h1>
     * <p>
     * Method is used to do Operations 
     * such as Adding, Printing, Updating, Deleting 
     * the Details of Lead
     * </p>
     */
    public void openEmployeeDashboard(Scanner scanner) {
        boolean isActive = false;
        byte operationChoice; 
        byte logout;   
        printWelcomeMessage();     
                
        while (!isActive) {
            printLeadMenu();
            operationChoice = getChoice(scanner);
                   
            switch (operationChoice) {
            case Constants.LEAD:
                openLeadOperations(scanner);
                break;
                 
            case Constants.ACCOUNT:
                accountView.showAccountDashboard(scanner, contactView);
                break;
                              
            case Constants.CONTACT:
                contactView.showContactDashboard(scanner);
                break;
                  
            case Constants.EXIT:
                while (!isActive) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isActive = (logout == Constants.LOGOUT) ? true : false;        
                } 
                break;
                   
            default:
                System.out.println(Messages.DEFAULT_MESSAGE); 
            }        
        }
    }

    private void openLeadOperations(Scanner scanner) {
        boolean isOpened = false;
        byte operationChoice; 
        byte logout;   
        printLeadTitle();     
                
        while (!isOpened) {
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
                while (!isOpened) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isOpened = (logout == Constants.LOGOUT) ? true : false;        
                } 
                break;
                   
            default:
                System.out.println(Messages.DEFAULT_MESSAGE); 
            }        
        }
    }
    
    /**
     * <h1> Create Lead </h1>
     * <p>
     * Method will ask for the Details from the Employee
     * and passes the Details of Lead to store
     * </p>
     */
    private void create(Scanner scanner) {
        Lead lead = null;
        String name;
        String email;
        String phoneNumber;
        String companyName;
        String status;
        String accountType;
        String contactTitle;
        String startDate;

        int count = 0;
        boolean isRight = false;

        while (!isRight) {
            try {
                System.out.print("\nEnter the Employee count to add: ");
                count = scanner.nextInt();
                isRight = true;
            } catch (InputMismatchException e) {
                System.out.println("\n>>>>> Please Enter Numbers only! <<<<<\n");
                scanner.next();
                continue;
            }
        }
        scanner.skip("\r\n");

        for (int index = 0; index < count; index++) {
            System.out.println("\n====== Enter Lead 0" + (index + 1) 
                                                       + " Details ======\n");
            name = getName(scanner);
            email = getEmail(scanner);     
            phoneNumber = getPhoneNumber(scanner); 
            status = getStatus(scanner, lead);   
            accountType = getType(scanner);
            contactTitle = getTitle(scanner); 
            companyName = getCompanyName(scanner);   
            startDate = getStartDate();
            System.out.println((leadController.create(new Lead(name, email, 
                                          phoneNumber, status, accountType, 
                                          contactTitle, companyName,
                                          startDate)) != null) 
                                          ? Messages.SUCCESS : Messages.FAILED);
        }
    }

    /**   
     * <h1> Display Details of lead </h1>
     * <p>
     * Method will Display all the Details of Lead
     * </p>
     */
    private void displayAll() {
        System.out.println("\n========== LEAD DETAILS ==========\n");

        if (leadController.getAll() != null) {
            for (Lead lead : leadController.getAll()) {
                System.out.println(lead);
                System.out.println("\n--------------X---------------\n");
            }
        } else {
                System.out.println(">>>>> No Leads Found! <<<<<");
        }
    }
   
   /**
     * <h1> Display Lead By Id </h1>
     * <p>
     * Method is used to serach the Details of Lead by calling the Lead Id
     * This will Display the Details of a Single Lead
     * </p>
     */
    private void displayById(Scanner scanner) {
        System.out.println("\n========== SEARCH LEAD ==========\n");  
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        if (leadController.getById(id) != null) {
            System.out.println("\n" + leadController.getById(id));
            System.out.println("\n--------------X---------------\n");
        } else {
            System.out.println(">>>>> No Lead Found! <<<<<");
            System.out.println("\n--------------X---------------\n");
        }
    }

    /**
     * <h1> Update the Lead </h1>
     * <p>
     * Method will updates the each fields of the Lead Details 
     * and Display the Message that the fields are Updated or not
     * </p>
     */
    private void updateById(Scanner scanner) {  
        System.out.println("\n========== UPDATE LEAD  ==========\n");
        System.out.print("Enter the ID to Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();   
        boolean isUpdating = false;
        byte updaterChoice;
        byte logout;
        Lead lead = leadController.getById(id);

        while (!isUpdating) {
            printUpdaterMenu();
            updaterChoice = getChoice(scanner);
                     
            switch (updaterChoice) {
            case Constants.NAME:
                scanner.skip("\r\n");
                lead.setName(getName(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                    
            case Constants.EMAIL:
                scanner.skip("\r\n");
                lead.setEmailId(getEmail(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                         
            case Constants.PHONE_NUMBER:
                scanner.skip("\r\n");
                lead.setPhoneNumber(getPhoneNumber(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
                        
            case Constants.COMPANY_NAME:
                scanner.skip("\r\n");
                lead.setCompanyName(getCompanyName(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;
   
            case Constants.STATUS:
                scanner.skip("\r\n");
                lead.setStatus(getStatus(scanner, lead));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;

            case Constants.ACCOUNT_TYPE:
                scanner.skip("\r\n");
                lead.setAccountType(getType(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;

            case Constants.CONTACT_TITLE:
                scanner.skip("\r\n");
                lead.setContactTitle(getTitle(scanner));
                System.out.println((leadController.updateById(id, lead) != null) 
                                        ? Messages.SUCCESS : Messages.FAILED);
                break;

            case Constants.EXIT_LEAD_UPDATER:
                while (!isUpdating) {
                    System.out.println(Messages.EXIT_MENU);
                    logout = getChoice(scanner);
                    isUpdating = (logout == Constants.LOGOUT) ? true : false;                    
                } 
                break;
                                  
            default:
                System.out.println(Messages.DEFAULT_MESSAGE);  
            }            
        }         
    }   

    /**
     * <h1> Delete the Lead </h1>
     * <p>
     * Method will Delete the Details of a Lead 
     * and Prints the Message that the fields are Deleted or not
     * </p>
     */
    private void deleteById(Scanner scanner) {
        System.out.println("\n========== DELETE LEAD  ==========\n");
        System.out.print("Enter the ID to Delete Lead\n \" Format:Lead_01 \" : ");
        scanner.skip("\r\n");
        String id = scanner.nextLine();
        System.out.println((leadController.isDeletedById(id)) 
                                   ? Messages.SUCCESS : Messages.FAILED);
    }          

    /**
     * <h1> Get Name </h1>
     * <p>
     * Gets the Name of the Lead and checks whether the Name is Valid or not
     * </p> 
     *
     * @return name - a Valid Name of the Lead
     */
    private String getName(Scanner scanner) {
        String name = "";
        boolean isNotValid = false;
        //scanner.skip("\r\n");

        while (!isNotValid) {
            System.out.print("Name                 : ");
            name = scanner.nextLine();

            if (leadController.isValidName(name)) {
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
     * Gets the Email of the Lead and checks whether the Email is Valid or not
     * </p>
     *
     * @return email - a Valid Email of the Lead
     */
    private String getEmail(Scanner scanner) {
        String email = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Email ID             : ");
            email = scanner.nextLine();

            if (leadController.isValidEmail(email)) {
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
     * Gets the Phone Number of the Lead and checks whether the Phone Number is Valid or not
     * </p>
     *
     * @return phoneNumber - a Valid Phone Number of the Lead
     */
    private String getPhoneNumber(Scanner scanner) {
        String phoneNumber = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Phone Number         : ");
            phoneNumber = scanner.nextLine();

            if (leadController.isValidPhoneNumber(phoneNumber)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Phone Number Format, Give the proper Phone Number! <<<<<\n");
            }  
        }
        return phoneNumber;
    }

    /**
     * <h1> Get Status </h1>
     * <p>
     * Gets the Status of the Lead
     * </p>
     *
     * @return status - Status of a Lead
     */
    private String getStatus(Scanner scanner, Lead lead) {
        System.out.print("Status               : ");
        boolean isSelecting = false;
        byte logout;
        String status = "";
        byte statusChoice;

        while (!isSelecting) {
            printStatusMenu();
            statusChoice = getChoice(scanner);

            switch (statusChoice) {
            case Constants.NEW:
                status = Status.New.toString();
                isSelecting = true;
                break;

            case Constants.CONTACTED:
                status = Status.Contacted.toString();
                isSelecting = true;
                break;

            case Constants.WORKING:
                status = Status.Working.toString();
                isSelecting = true;
                break;

            case Constants.QUALIFIED:
                status = Status.Qualified.toString();
                isSelecting = true;
                break;

            case Constants.UNQUALIFIED:
                status = Status.Unqualified.toString();
                isSelecting = true; 
                break;

            case Constants.CONVERTED:               
                try {
                    status = accountView.toAccount(scanner, lead);
                    contactView.create(scanner, lead);
                    isSelecting = true; 
                } catch (NullPointerException e) {
                    System.out.println("New Lead Can't be converted to Account:");
                    scanner.next();
                    continue;
                } 
                break;

            case Constants.EXIT_STATUS:
                isSelecting = true; 
                break;

            default:
                System.out.println(Messages.DEFAULT_MESSAGE);
            }
        }
        return status;
    }

    /**
     * <h1> Get type </h1>
     * <p>
     * Gets the Type of the Account
     * </p>
     *
     * @return type - type of a Account
     */
    private String getType(Scanner scanner) {
        System.out.print("Type               : ");
        String type = "";
        printTypeMenu();
        byte typeChoice = getChoice(scanner);

        switch (typeChoice) {
        case Constants.CUSTOMER:
            type = Type.Customer.toString();
            break;

        case Constants.RESELLER:
            type = Type.Reseller.toString();
            break;

        case Constants.INVESTOR:
            type = Type.Investor.toString();
            break;

        case Constants.PARTNER:
            type = Type.Partner.toString();
            break;

            default:
                System.out.println(Messages.DEFAULT_MESSAGE);
        }
        return type;
    }

    /**
     * <h1> Get Title </h1>
     * <p>
     * Gets the Title of the Contact
     * </p>
     *
     * @return title - title of a Contact
     */
    private String getTitle(Scanner scanner) {
        System.out.print("Title               : ");
        String title = "";
        printTitleMenu();
        byte titleChoice = getChoice(scanner);

        switch (titleChoice) {
        case Constants.CEO:
            title = Title.CEO.toString();
            break;

        case Constants.FOUNDER:
            title = Title.Founder.toString();
            break;

        case Constants.PRESIDENT:
            title = Title.President.toString();
            break;

        case Constants.VICE_PRESIDENT:
            title = Title.VicePresident.toString();
            break;

        case Constants.DIRECTOR:
            title = Title.Director.toString();
            break;

            default:
                System.out.println(Messages.DEFAULT_MESSAGE);
        }
        return title;
    }

    /**
     * <h1> Get Company Name </h1>
     * <p>
     * Gets the Company Name of the Lead and checks whether the Company Name is Valid or not
     * </p> 
     *
     * @return companyName - a Valid Company Name of the Lead
     */
    private String getCompanyName(Scanner scanner) {
        String companyName = "";
        boolean isNotValid = false;

        while (!isNotValid) {
            System.out.print("Company Name         : ");
            scanner.skip("\r\n");
            companyName = scanner.nextLine();

            if (leadController.isValidCompanyName(companyName)) {
                break;
            } else { 
                System.out.println("\n>>>>> Wrong Company Name Format, Give the proper Company Name! <<<<<\n");
            }  
        }
        return companyName;
    }
    
    /**
     * <h1> Get Start Date </h1>
     * <p>
     * Gets the Start Date of the Lead
     * </p>
     *
     * @return date - a Valid Start Date
     */
    private String getStartDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        String startDate = formatter.format(date); 
        return startDate;
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
            System.out.println("\n>>>>> Please Enter Numbers only! <<<<<\n");
            scanner.next();  // clears the scanner buffer
        }
        return choice;
    }

    /**
     * <h1> Print Lead Menu </h1>
     * <p>
     * Prints the Lead Menu
     * </p>
     */
    private void printLeadMenu() {
        StringBuilder leadMenu = new StringBuilder();
        leadMenu.append("Press \" ").append(Constants.LEAD)
                        .append(" \" for Lead\n")
                        .append("Press \" ").append(Constants.ACCOUNT)
                        .append(" \" for Account\n")
                        .append("Press \" ").append(Constants.CONTACT)
                        .append(" \" for Contact\n")
                        .append("Press \" ").append(Constants.OPPORTUNITY)
                        .append(" \" for Opportunity\n")
                        .append("Press \" ").append(Constants.EXIT)
                        .append(" \" for EXIT\n")
                        .append("Enter your Operation: ");
        System.out.print(leadMenu);
    }
    /**
     * <h1> Print Operation Menu </h1>
     * <p>
     * Prints the Operation Menu
     * </p>
     */
    private void printOperationMenu() {
        StringBuilder operationMenu = new StringBuilder();
        operationMenu.append("Press \" ").append(Constants.ADDER)
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
        System.out.print(operationMenu);
    }

    /**
     * <h1> Print Updation Menu </h1>
     * <p>
     * Prints the Menu for Updating the Details of Lead
     * </p>
     */
    private void printUpdaterMenu() {
        StringBuilder updaterMenu = new StringBuilder();
        updaterMenu.append(">>>>> Lead Id can't be changed <<<<<\n")
                   .append("\npress \" ").append(Constants.NAME)
                   .append(" \" for Name\n")
                   .append("press \" ").append(Constants.EMAIL)
                   .append(" \" for Email\n")
                   .append("press \" ").append(Constants.PHONE_NUMBER)
                   .append(" \" for Phone Number\n")
                   .append("press \" ").append(Constants.COMPANY_NAME)
                   .append(" \" for Company Name\n")
                   .append("press \" ").append(Constants.STATUS)
                   .append(" \" for Status\n")
                   .append("press \" ").append(Constants.ACCOUNT_TYPE)
                   .append(" \" for Account type\n")
                   .append("press \" ").append(Constants.CONTACT_TITLE)
                   .append(" \" for Contact Title\n")
                   .append("press \" ").append(Constants.EXIT_LEAD_UPDATER)
                   .append(" \" for Exit\n")
                   .append("Enter your Updater: "); 
        System.out.print(updaterMenu);
    }

    /**
     * <h1> Print Status Menu </h1>
     * <p>
     * Prints the Menu for Lead Status
     * </p>
     */
    private void printStatusMenu() {
        StringBuilder statusMenu = new StringBuilder();
        statusMenu.append("\n+=============================+ ")
                  .append("\n| press \" ").append(Constants.NEW)
                  .append(" \" for New         |\n")
                  .append("| press \" ").append(Constants.CONTACTED)
                  .append(" \" for Contacted   |\n")
                  .append("| press \" ").append(Constants.WORKING)
                  .append(" \" for Working     |\n")
                  .append("| press \" ").append(Constants.QUALIFIED)
                  .append(" \" for Qualified   |\n")
                  .append("| press \" ").append(Constants.UNQUALIFIED)
                  .append(" \" for Unqualified |\n")
                  .append("| press \" ").append(Constants.CONVERTED)
                  .append(" \" for Converted   |\n")
                  .append("| press \" ").append(Constants.EXIT_STATUS)
                  .append(" \" for Exit        |\n")
                  .append("+=============================+\n")
                  .append("Enter your Choice: ");
        System.out.print(statusMenu);
    }

    /**
     * <h1> Print Type Menu </h1>
     * <p>
     * Prints the Menu for Account Type
     * </p>
     */
    private void printTypeMenu() {
        StringBuilder typeMenu = new StringBuilder();
        typeMenu.append("\n+=============================+ ")
                .append("\n| press \" ").append(Constants.CUSTOMER)
                .append(" \" for Customer    |\n")
                .append("| press \" ").append(Constants.RESELLER)
                .append(" \" for Reseller    |\n")
                .append("| press \" ").append(Constants.INVESTOR)
                .append(" \" for Investor    |\n")
                .append("| press \" ").append(Constants.PARTNER)
                .append(" \" for Partner     |\n")
                .append("+=============================+\n")
                .append("Enter your Choice: ");
        System.out.print(typeMenu);
    }

    /**
     * <h1> Print Title Menu </h1>
     * <p>
     * Prints the Menu for Contact Title
     * </p>
     */
    private void printTitleMenu() {
        StringBuilder titleMenu = new StringBuilder();
        titleMenu.append("\n+====================================+")
                 .append("\n| press \" ").append(Constants.CEO)
                 .append(" \" for CEO                |\n")
                 .append("| press \" ").append(Constants.FOUNDER)
                 .append(" \" for Founder            |\n")
                 .append("| press \" ").append(Constants.PRESIDENT)
                 .append(" \" for President          |\n")
                 .append("| press \" ").append(Constants.VICE_PRESIDENT)
                 .append(" \" for Vice President     |\n")
                 .append("| press \" ").append(Constants.DIRECTOR)
                 .append(" \" for Director           |\n")
                 .append("+====================================+\n")
                 .append("Enter your Choice: ");
        System.out.print(titleMenu);
    }

    /**
     * <h1> Print Welcome message </h1>
     * <p>
     * Prints the Welcome Statements
     * </p>
     */
    private void printWelcomeMessage() {
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("\n========================================")
                      .append("|           WELCOME EMPLOYEE!            |")
                      .append("========================================\n");
        System.out.println(welcomeMessage);
    }

    /**
     * <h1> Print  </h1>
     * <p>
     * Prints the Title of Lead
     * </p>
     */
    private void printLeadTitle() {
        StringBuilder title = new StringBuilder();
        title.append("\n========================================")
             .append("|                 LEAD!                  |")
             .append("========================================\n");
        System.out.println(title);
    }
}                                          