/**
 * File which is used to Controll the employees details
 * and getting the Employees name 
 * by giving some critaria
 *
 * 
 * @version 1.0  17-06-2022
 * @author Ajaisharma
 */

import java.util.Scanner;

/**
 * Controls of this System goes in here
 * getting the input from the user 
 * And printing the Employee's name 
 * regarding the condition which is given by the customer
 */
public class DetailController {
    static Scanner scanner = new Scanner(System.in);
    int id;
    String name;
    int experience;
    float salary;
    String[] names = new String[100];
    int stringIndex = 0;

    final static int EMPLOYEE_ADDER = 1;
    final static int EXPERIENCE_CHECKER = 2;
    final static int SALARY_CHECKER = 3;
    final static int HIGH_EXPERIENCE = 4;
    final static int HIGH_SALARY = 5;
    final static int EXPERTS = 6;
    
    /** 
    * getdetails used to set the values to the POJO class 
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return noreturn
    */
    public DetailRecorder[] getDetails(DetailRecorder[] records, int count) { 

	for (int index = 0; index < count; index++) {
	    records[index] = new DetailRecorder();
	    System.out.println("==========Enter the Employee " 
				    + (index+1) + "'s Details==========");
	    System.out.println("Enter the Employee's ID:");
	    id = scanner.nextInt();
	    records[index].setEmployeeId(id);  
	    scanner.nextLine();
	    System.out.println("Enter the name:");
	    name = scanner.nextLine();
	    records[index].setEmployeeName(name);    
	    System.out.println("Enter the Employee's Experience:");  
	    experience = scanner.nextInt();
	    records[index].setEmployeeExperience(experience);   
	    System.out.println("Enter the Employee's Salary :");
	    salary = scanner.nextFloat();
	    records[index].setEmployeeSalary(salary);     
	}
    }

    /** 
    * checkExperience used to check the employee's name 
    * regarding the experience more then 5 years 
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return list of names
    */
    public String[] checkExperience(DetailRecorder[] records, int count) {
	System.out.println("Employee's experience more then 5 years");

	for (int index = 0; index < count; index++) {
	    if (5 <= records[index].getEmployeeExperience()) {
		names[stringIndex] = records[index].getEmployeeName();
		stringIndex++;
	    }
	}
	return names;
    }

    /** 
    * checkSalary used to check the employee's name 
    * regarding the salary more then 1 Lakh 
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return list of names
    */
    public String[] checkSalary(DetailRecorder[] records, int count) {
	System.out.println("Employee's name Salary Over 1 Lakh");
	for (int index = 0; index < count; index++) {
	    if(100000 <= records[index].getEmployeeSalary()) {
		names[stringIndex] = records[index].getEmployeeName();
		stringIndex++;
	    }
	}
	return names;
    }

    /** 
    * printExpert used to check the employee's name 
    * regarding the Experience who are having more experience
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return list of names
    */
    public String[] printExperts(DetailRecorder[] records, int count) {
	System.out.println("Most experienced Employee's name");
	for (int index = 0; index < count; index++) {
	    for (int index_j = index + 1; index_j < count; index_j++) {
		if (records[index].getEmployeeExperience() 
					<= (records[index_j].getEmployeeExperience())) {
		    DetailRecorder temp = records[index];
		    records[index] = records[index_j];
		    records[index_j] = temp;
		}
	    }
	}
	
	for(int index = 0; index < (count % 2); index++) {
	    names[stringIndex] = records[index].getEmployeeName();
	    stringIndex++;
	}
	return names;
    }    

    /** 
    * printExpert used to check the employee's name 
    * regarding the Salary who are having more experience 
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return list of names
    */
    public String[] printHighSalary(DetailRecorder[] records, int count) {
	System.out.println("Highest paid Employee's name");

	for (int index = 0; index < count; index++) {
	    for (int index_j = index + 1; index_j <= count; index_j++) {
		if (records[index].getEmployeeSalary() 
					<= records[index_j].getEmployeeSalary()) {
		    DetailRecorder temp = records[index];
		    records[index] = records[index_j];
		    records[index_j]= temp;
		}
	    }
	}
	
	for(int index = 0; index < 5; index++) {
	    names[stringIndex] = records[index].getEmployeeName();
	    stringIndex++;
	}
	return names;
    }  

    public static void main(String[] args) {
	System.out.println("Enter the Emplyoee count");
	int count = scanner.nextInt();
	DetailController controller = new DetailController();
	DetailRecorder[] records = new DetailRecorder[count];      
	boolean active = false;
	do {
	    System.out.println("====================Enter the number to"
				    + " process the operations====================\n" 
				    + " 1.Add Employee Details\n" 
				    + " 2.Experience over 5 years\n"
				    + " 3.Salary over 1 Lakh\n"
				    + " 4.Heighest Paid\n"
				    + " 5.Heighest Expereince\n" 
				    + " 6.Top experienced" );

	    int choice = scanner.nextInt();
	    switch (choice) {
	    case EMPLOYEE_ADDER:
		controller.getDetails(records,count);
		break;

	    case EXPERIENCE_CHECKER:
		controller.names = controller.checkExperience(records, count);

		for(index = 0; index < controller.stringIndex;
						       index++) {
		    System.out.println(controller.names[index]);
		}
		break;

	    case SALARY_CHECKER:
		controller.names = controller.checkSalary(records, count);

		for (index = 0; index < controller.stringIndex; 
							index++) {
		    System.out.println(controller.names[index]);
		}
		break;

	    case HIGH_EXPERIENCE:
		controller.names = controller.printExperts(records, count);
		System.out.println(controller.names[0]);
                break;

	    case HIGH_SALARY:
		controller.names = controller.printHighSalary(records, count);
		System.out.println(controller.names[0]);
		break;

	    case EXPERTS:
		controller.names = controller.printExperts(records, count);
	
		for (index = 0; index < controller.stringIndex; 
							index++) {
		    System.out.println(controller.names[index]);
		}
		break;

	    default:
		System.out.println("Do you want to do process?\n Press ' 1 ' for YES\n  press ' 2 ' for NO ");
		int process = scanner.nextInt();
		active = (process == 1) ? true : false;
	    }

	} while(active);
	
    }
}
