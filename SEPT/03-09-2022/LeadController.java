import java.util.Set;
import java.util.HashSet;

public class LeadController { 
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.prinln("Enter the count of the lead to enter : ");
        int leadCount  = scanner.nextInt();     
        Set<Employee> leadSet = new HashSet<>();
        
        for (int index = 0; index < leadCount; index++) {
            System.out.println("Enter the Name : ");
            String name =  scanner.nextLine();
            System.out.println("Enter the Id : ");
            String id = scanner.nextLine();
            Lead leads = new Lead(name, id);       
            leadSet.add(leads);
        }
        System.out.println(leadSet);           
    }
}