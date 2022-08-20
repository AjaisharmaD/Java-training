/*
 * This class is used to set and get the details of the Employees
 * 
 * @author AJAISHARMA D
 * version 1.0
 */

public class DetailRecorder {
    private int id;
    private String name;
    private int experience;
    private float salary;

    public void setEmployeeId(int id) {
	this.id = id;
    }
    
    public void setname(String name) {
	this.name = name ;
    }

    public void setEmployeeExperience(int experience) {
	this.experience = experience;
    }

    public void setEmployeeSalary(float salary) {
	this.salary = salary;
    }

    public int getEmployeeId() {
	return this.id;
    }

    public String getEmployeeName() {
	return this.name;
    }

    public int getEmployeeExperience() {
	return this.experience;
    }

    public float getEmployeeSalary() {
	return this.salary;
    }
    
    /*		
    public String toString() {
	return employeeId + " " + name + " " + employeeExperience + " " + employeeSalary;
    } 
    */
}
