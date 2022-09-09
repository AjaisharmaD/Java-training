import java.util.Scanner;

import com.ideas2it.model.Lead;
import com.ideas2it.view.EmployeeView;
 
/**
 * Dashboard to switch the user 
 *
 * @author Ajaisharma D
 * @version 1.0 24-08-2022
 */
public class SupportController {
    private final static byte EMPLOYEE = 1;
    private final static byte MANAGER = 2;
    private final static byte EXIT = 3;
    private final static byte LOGOUT = 1;
    private EmployeeView employee = new EmployeeView();
    //private ManagarView manager = new ManagerView();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	SupportController supportController = new SupportController();
	supportController.initialize();
	
    }
    /**
     * 
     *
     *
     */
    void initialize() {
        boolean isActive = true;
        
        do {
            switchUserMenu();
            byte choice = scanner.nextByte();
            
            switch (choice) {
            case EMPLOYEE:
                 employee.performEmployeeOperation();
                 break;
               
            case MANAGER:
                 //manager.control();
                 break;
             
            case EXIT:
                exitPointerMenu();
                byte logout = scanner.nextByte();
                isActive = (logout == LOGOUT) ? false : true ; 
                System.out.println("****** Signing Out From CRM Tool ******");
                break;
                 
            default:
                defaultPrinterMenu();
                switchUserMenu();
                choice = scanner.nextByte();
                break;
            }  
        } while (isActive);
    }

    void switchUserMenu() {
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append(">>>>> Enter your Choice for ")
                     .append("following Operations <<<<<\n")
                     .append("press \" 1 \" for Employee\n")
                     .append("press \" 2 \" for Manager\n")
                     .append("press \" 3 \" for EXIT");
	System.out.println(choicePrinter);
    }

    void exitPointerMenu() {
	StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append(">>>>> Are you sure want to Exit? <<<<<\n")
                   .append("press \" 1 \" for Yes\n")
                   .append("press \" Any Number \" for No");
	System.out.println(exitPrinter);
    }

    void defaultPrinterMenu() {
        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append(">>>>> You have entered wrong Choice <<<<<\n")
                  .append("Please enter any of the")
                  .append("number given Below to proceed\n");
        System.out.println(defaultPrinter);
    }
}