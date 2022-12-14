/**
 * File which is used to Controll the employees details
 * and getting the Employees name 
 * by giving some critaria
 */

import java.util.Scanner;

/**
 * Controls of this System goes in here
 * getting the input from the user 
 * And printing the Employee's name 
 * regarding the condition which is given by the customer
 *
 * @version 1.1  17-06-2022
 * @author Ajaisharma
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
    final static int DISPLAYER = 7;
    final static int EXIT = 8;
    
    /** 
    * sets the values to the POJO class 
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return {@link Detailrecorder} returns nothing
    */
    public DetailRecorder[] getDetails(DetailRecorder[] records, int count) { 

	for (int index = 0; index < count; index++) {
	    //records[index] = new DetailRecorder();
	    System.out.println("==========Enter the Employee " 
				    + (index+1) + "'s Details==========");
            System.out.println("Enter the ID");
            id = scanner.nextInt();
            System.out.println("Enter the Name");
            scanner.nextLine();
            name = scanner.nextLine();
            System.out.println("Enter the Experience");
            experience = scanner.nextInt();
            System.out.println("Enter the Salary");
            salary = scanner.nextFloat();
	    records[index] = new DetailRecorder(id, name, experience, salary);    
	}
        return records;
    }

    /** 
    * checks the employee's name 
    * regarding the experience more then 5 years 
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return {@link String} returns list of names
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
    * checks the employee's name 
    * regarding the salary more then 1 Lakh 
    *
    * @param {@link DetailRecorder} records
    * @param {@link int} count
    * @return {@link String} returns list of names
    */
    public String[] checkSalary(DetailRecorder[] records, int count) {
	System.out.println("Employee's name Salary Over 1 Lakh");
        stringIndex = 0;
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
    * @return {@link String} returns list of names
    */
    public String[] printExperts(DetailRecorder[] records, int count) {
	System.out.println("Most experienced Employee's name");
        stringIndex = 0;
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
	
	for(int index = 0; index < count; index++) {
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
    * @return {@link String} returns list of names
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
	
        stringIndex = 0;
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
	             .append(" 7.Show employee Details")
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
		records = controller.getDetails(records,count);
		break;

	    case EXPERIENCE_CHECKER:
		controller.names = controller.checkExperience(records, count);

		for(int index = 0; index < controller.stringIndex;
								 index++) {
		    System.out.println(controller.names[index]);
		}
		break;

	    case SALARY_CHECKER:
		controller.names = controller.checkSalary(records, count);

		for (int index = 0; index < controller.stringIndex; 
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
	
		for (int index = 0; index < controller.stringIndex / 2; 
							index++) {
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
