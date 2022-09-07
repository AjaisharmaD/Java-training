 import java.util.Scanner;

/**
 * 
 *
 * @author Ajaisharma 
 * @version 1.0 24-08-2022
 */
public class SupportController {
    private final static byte EMPLOYEE = 1;
    private final static byte MANAGER = 2;
    private final static byte EXIT = 3;
    private final static byte LOGOUT = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee();
        // Managar manager = new Manager();
        boolean isActive = true;

        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append(">>>>> Enter your Choice for ")
                     .append("following Operations <<<<<\n")
                     .append("press \" 1 \" for Employee\n")
                     .append("press \" 2 \" for Manager\n")
                     .append("press \" 3 \" for EXIT");

        StringBuilder exitPrinter = new StringBuilder();
        exitPrinter.append(">>>>> Are you sure want to Exit? <<<<<\n")
                   .append("press \" 1 \" for Yes\n")
                   .append("press \" Any Number \" for No");

        StringBuilder defaultPrinter = new StringBuilder();        
        defaultPrinter.append(">>>>> You have entered wrong Choice <<<<<\n")
                  .append("Please enter any of the")
                  .append("number given Below to proceed\n");

        do {
            System.out.println(choicePrinter);
            byte choice = scanner.nextByte();
            
            switch (choice) {
            case EMPLOYEE:
                 employee.control();
                 break;

            case MANAGER:
                 //manager.control();
                 break;

            case EXIT:
                System.out.println(exitPrinter);
                byte logout = scanner.nextByte();
                isActive = (logout == LOGOUT) ? false : true ; 
                break;

            default:
                System.out.println(defaultPrinter);
                System.out.println(choicePrinter);
                choice = scanner.nextByte();
                break;
            }  
        } while (isActive);
    }
}