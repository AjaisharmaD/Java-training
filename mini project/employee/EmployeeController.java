/**
 * File which is used to Controll the employees details
 * and getting the Employees name 
 * by giving some critaria
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Controls of this System goes in here
 * getting the input from the user 
 * And printing the Employee's name 
 * regarding the condition which is given by the customer
 *
 * @version 1.0  17-06-2022
 * @author Ajaisharma
 */
public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);
    private int employeeCount;
    private int stringIndex;
    private String[] nameFilter = new String[100];  

    private final static int EMPLOYEE_ADDER = 1;
    private final static int EXPERIENCE_VALIDATOR = 2;
    private final static int SALARY_VALIDATOR = 3;
    private final static int HIGH_EXPERIENCE = 4;
    private final static int HIGH_SALARY = 5;
    private final static int EXPERTS = 6;
    private final static int DISPLAYER = 7;
    private final static int EXIT = 8;

    private Set<Employee> employeeSets = new HashSet<>();
    private ArrayList<String> names = new ArrayList<>();
    private Employee record = new Employee(); 
    
   /** 
    * sets the values to the POJO class 
    *
    * @param {@link Employee} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link Employee} returns nothing
    */
    public Set<Employee> giveDetails(int count) { 
        String name;
        int experience;
        float salary;

        for (int index = 0; index < count; index++) {
            record = new Employee();
            System.out.println("==========Enter the Employee " 
				    + (index+1) + "'s Details==========");
            System.out.println("Enter the Name");
            scanner.nextLine();
            name = scanner.nextLine();
            System.out.println("Enter the Experience");
            experience = scanner.nextInt();
            System.out.println("Enter the Salary");
            salary = scanner.nextFloat();
	    record = new Employee(name, experience, salary);    
            employeeSets.add(record);
            employeeCount++;
	}
       return employeeSets;
    }

   /** 
    * checks the employee's name 
    * regarding the experience more then 5 years 
    *
    * @param {@link Employee} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link String} returns list of names
    */
    public ArrayList<String> checkExperience(int count) {
	System.out.println("Employee's experience more then 5 years");
        names.clear();

	for (Employee name : employeeSets) {
	    if (5 <= name.getExperience()) {
		names.add(name.getName());
	    }
	}
	return names;
    }
    
   /** 
    * checks the employee's name 
    * regarding the salary more then 1 Lakh 
    *
    * @param {@link Employee} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link String} returns list of names
    */
    public ArrayList<String> checkSalary(int count) {
        System.out.println("Employee's name Salary Over 1 Lakh");
        names.clear();
        for (Employee name : employeeSets) {
	    if (100000 <= name.getSalary()) {
		names.add(name.getName());
	    }
	}
        return names;
    }
    
   /** 
    * printExpert used to check the employee's name 
    * regarding the Experience who are having more experience
    *
    * @param {@link Employee} records - array of Employee Details
    * @param {@link int} count  - count of Employee
    * @return {@link String} returns list of names
    */
    public ArrayList<String> checkExperts(int count) {
        System.out.println("Most experienced Employee's name");
        
        ArrayList<Integer> experience = new ArrayList<>();
        names.clear();
        for (Employee record : employeeSets) {
            experience.add(record.getExperience());
        }
        Collection.reverse(experience);
        
        for (int index = 0; index < count; index++) {
            for (int index_j = 0; index_j < count; index_j++) {
                if (experience.get(index) == Employee.get(index_j).getExperience()) {
                    names.add(Employee.get(index_j).getName()); 
                }
            } 
        }
	return names;
    }    
    
   /** 
    * printExpert used to check the employee's name 
    * regarding the Salary who are having more experience 
    * 
    * @param {@link Employee} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link String} returns list of names
    */
    public String[] checkHighSalary(int count) {
        System.out.println("Highest paid Employee's name");

        ArrayList<Integer> salary = new ArrayList<>();
        names.clear();
        for (Employee record : employeeSets) {
            salary.add(record.getSalary());
        }
        Collection.reverse(salary);
        
        for (int index = 0; index < count; index++) {
            for (int index_j = 0; index_j < count; index_j++) {
                if (salary.get(index) == Employee.get(index_j).getSalary()) {
                    names.add(Employee.get(index_j).getName()); 
                }
            } 
        }
	return names;
    }  
    
    public static void main(String[] args) {
	System.out.println("Enter the Emplyoee count");
	int count = scanner.nextInt();
	EmployeeController controller = new EmployeeController();
	boolean isActive = true;
        
        StringBuilder choicePrinter = new StringBuilder();
        choicePrinter.append("====================Enter the number to")
	             .append(" process the operations====================\n") 
	             .append(" 1.Add Employee Details\n")
	             .append(" 2.Experience over 5 years\n")
	             .append(" 3.Salary over 1 Lakh\n")
	             .append(" 4.Heighest Paid\n")
	             .append(" 5.Heighest Expereince\n") 
	             .append(" 6.Top experienced\n")
	             .append(" 7.Show employee Details\n")
	             .append(" 8.EXIT Controller"); 

        StringBuilder defaultPrinter = new StringBuilder();
        defaultPrinter.append("Do you want to do process?\n")
                      .append("Press \"1\" for \" YES \"\n")
                      .append("press Any Number for \" NO \"");

	do {
	    System.out.println(choicePrinter);
	    int choice = scanner.nextInt();

	    switch (choice) {
	    case EMPLOYEE_ADDER:
                controller.giveDetails(count);
		for(Employee detail : controller.employeeSets) 
                System.out.println(detail);
		break;
	    
	    case EXPERIENCE_VALIDATOR:
		controller.names = controller.checkExperience(count);

		for(String name: controller.names) {
		    System.out.println(name);
		}
		break;

	    case SALARY_VALIDATOR:
		controller.names = controller.checkSalary(count);

		for(String name: controller.names) {
		    System.out.println(name);
		}
		break;
            
	    case HIGH_EXPERIENCE:
		controller.names = controller.checkExperts(count);
                
                for (String name: controller.names) {
		    System.out.println(name);
                }
                break;
            
	    case HIGH_SALARY:
		controller.names = controller.checkHighSalary(records, count);
		System.out.println(controller.names[0]);    // need to change 
		break;

	    case EXPERTS:
		controller.names = controller.checkExperts(records, count);
	
		for (int index = 0; index < controller.stringIndex; index++) {
		    System.out.println(controller.names[index]);
		}
		break;
            
	    default:
		System.out.println(defaultPrinter);
		int process = scanner.nextInt();
		isActive = (process == 1) ? true : false;
	    }

	} while(isActive);
	
    }
}