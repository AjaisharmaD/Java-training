/*
 * set and get the details of the Employees
 * 
 * @author AJAISHARMA D
 * version 1.0
 */

public class DetailRecorder {
    private int id;
    private String name;
    private int experience;
    private float salary;

    public DetailRecorder(int id, String name, int experience, float salary) {
        this.id = id;
        this.name = name ;
        this.experience = experience;
        this.salary = salary;
    }
    
    public int getEmployeeId() {
	return id;
    }

    public String getEmployeeName() {
	return name;
    }

    public int getEmployeeExperience() {
	return experience;
    }

    public float getEmployeeSalary() {
	return salary;
    }
    
}
