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
    int employeeCount;
    int stringIndex;
    String[] nameFilter = new String[100];
    ArrayList<String> names = new ArrayList<>();
    EmployeeDetail record = new EmployeeDetail();   

    final static int EMPLOYEE_ADDER = 1;
    final static int EXPERIENCE_CHECKER = 2;
    final static int SALARY_CHECKER = 3;
    final static int HIGH_EXPERIENCE = 4;
    final static int HIGH_SALARY = 5;
    final static int EXPERTS = 6;
    final static int DISPLAYER = 7;
    final static int EXIT = 8;


    Set<EmployeeDetail> employeeSets = new HashSet<EmployeeDetail>();
    
   /** 
    * sets the values to the POJO class 
    *
    * @param {@link EmployeeDetail} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link EmployeeDetail} returns nothing
    */
    public Set<EmployeeDetail> giveDetails(int count) { 
        String name;
        int experience;
        float salary;

        for (int index = 0; index < count; index++) {
            record = new EmployeeDetail();
            System.out.println("==========Enter the Employee " 
				    + (index+1) + "'s Details==========");
            System.out.println("Enter the Name");
            scanner.nextLine();
            name = scanner.nextLine();
            System.out.println("Enter the Experience");
            experience = scanner.nextInt();
            System.out.println("Enter the Salary");
            salary = scanner.nextFloat();
	    record = new EmployeeDetail(name, experience, salary);    
            employeeSets.add(record);
            employeeCount++;
	}
       return employeeSets;
    }

   /** 
    * checks the employee's name 
    * regarding the experience more then 5 years 
    *
    * @param {@link EmployeeDetail} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link String} returns list of names
    */
    public ArrayList<String> checkExperience(int count) {
	System.out.println("Employee's experience more then 5 years");
        names.clear();
	for (EmployeeDetail record : employeeSets) {
	    if (5 <= record.getExperience()) {
		names.add(record.getName());
	    }
	}
	return names;
    }
    
   /** 
    * checks the employee's name 
    * regarding the salary more then 1 Lakh 
    *
    * @param {@link EmployeeDetail} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link String} returns list of names
    */
    public ArrayList<String> checkSalary(int count) {
        System.out.println("Employee's name Salary Over 1 Lakh");
        names.clear();
        for (EmployeeDetail record : employeeSets) {
	    if (100000 <= record.getSalary()) {
		names.add(record.getName());
	    }
	}
        return names;
    }
    
   /** 
    * printExpert used to check the employee's name 
    * regarding the Experience who are having more experience
    *
    * @param {@link EmployeeDetail} records - array of Employee Details
    * @param {@link int} count  - count of Employee
    * @return {@link String} returns list of names
    */
    public ArrayList<String> checkExperts(int count) {
        System.out.println("Most experienced Employee's name");
        stringIndex = 0;
        int[] experience = new int[employeeCount];
    
        for (EmployeeDetail record : employeeSets) {
            for (int index = 0; index < employeeCount; index++) {
                experience[index] = record.getExperience();
                nameFilter[index] = record.getName();
            }
        }

        for (int index = 0; index < employeeCount; index++) {
            if (experience[index] < experience[index + 1]) {
                int temp = experience[index];
                experience[index] = experience[index + 1];
                experience[index + 1]  = temp;
            }
        }
        int experienceFilter = 5;
        for (int index = 0; index < experienceFilter ; index++) {
            names.add(nameFilter[index]);
        }
	return names;
    }    
    
   /** 
    * printExpert used to check the employee's name 
    * regarding the Salary who are having more experience 
    *
    * @param {@link EmployeeDetail} records - array of Employee Details
    * @param {@link int} count - count of Employee
    * @return {@link String} returns list of names
    
    public String[] checkHighSalary(int count) {
        System.out.println("Highest paid Employee's name");

        for (int index = 0; index < count; index++) {
            for (int index_j = index + 1; index_j <= count; index_j++) {
		if (records[index].getSalary() 
                              <= records[index_j].getSalary()) {
		     temp = records[index];
		    records[index] = records[index_j];
		    records[index_j]= temp;
		}
	    }
	}
	
        stringIndex = 0;
	for(int index = 0; index < 5; index++) {
	    names[stringIndex] = records[index].getName();
	    stringIndex++;
	}
	return names;
    }  
    */
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
		for(EmployeeDetail detail : controller.employeeSets) 
                System.out.println(detail);
		break;
	    
	    case EXPERIENCE_CHECKER:
		controller.names = controller.checkExperience(count);

		for(String name: controller.names) {
		    System.out.println(name);
		}
		break;

	    case SALARY_CHECKER:
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
            /*
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
            */
	    default:
		System.out.println(defaultPrinter);
		int process = scanner.nextInt();
		isActive = (process == 1) ? true : false;
	    }

	} while(isActive);
	
    }
}