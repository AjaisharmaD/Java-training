import java.util.Scanner;

/**
 * <h1> System Controller </h1>
 * 
 * The System Controller controls the user to login 
 * sends and gets the Details of user
 * 
 * @version 1.0
 * @author Ajaisharma D
 * @since 22-Augest-2022 
 */

public class SystemController {
    final static byte AGENT = 1;
    final static byte CUSTOMER = 2;
    final static byte EXIT = 3;
    final static byte YES = 1;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long agentCount = scanner.nextLong();
        AgentController[] agentRecords = new AgentController[agentCount];
        CustomerController[] customerRecords = new CustomerController[agentCount * 5];

        StringBuilder printer = new StringBuilder();
        printer.append("You are Logging in as Agent.....");
        printer.append("*****Enter a Number to for further operations*****\n");
        printer.append("press \" 1 \" Enter Leads\n"); 
        printer.append("press \" 2 \" Edit Leads\n");
        printer.append("press \" 3 \" Show Leads\n");
        printer.append("press \" 4 \" Logout Agent");

        boolean isActive = true; 
        do {
            System.out.print("Enter Your choice: ");
            byte choice = scanner.nextByte();
            switch(choice) {
            case AGENT:
                StringBuilder printer = new StringBuilder();
                printer.append("You are Logging in as Agent.....");
                printer.append("*****Enter a Number to for further operations*****\n");
                printer.append("press \" 1 \" Enter Leads\n"); 
                printer.append("press \" 2 \" Edit Leads\n");
                printer.append("press \" 3 \" Show Leads\n");
                printer.append("press \" 4 \" Logout Agent");
                byte agentChoice = scanner.nextByte();
                
                switch(agentChoice) {
                case 
                }
                break;

            case CUSTOMER:
                
                System.out.println("You are Logging in as Customer.....");
                break;

            case EXIT:
                System.out.println("*****You have pressed the Exit button*****\n" 
                                      + "Are you sure want to continue ?\n " 
                                      + "For Yes press Number \" 1 \" \n"
                                      + "For No press Any key");
                byte logout = scanner.nextByte();
                isActive = (logout == YES) ? false : true;
                System.out.println("\nYou are Logging Out.....");
                break;

            default: 
                System.out.println("*****You have entered wrong Choice*****");
                break;
            }

        } while(isActive);
    }
}



sop(agent[] + print);