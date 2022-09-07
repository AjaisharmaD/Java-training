package employee.model;

/**
 * This class is used to set and get the details of the Employees
 * 
 * @author AJAISHARMA D
 * version 1.0
 */
public class Employee {
    private String name;
    private int experience;
    private float salary;

    public EmployeeDetail(){};  // default Constructor

    public EmployeeDetail(String name, 
                          int experience, float salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
	return name;
    }

    public int getExperience() {
	return experience;
    }

    public float getSalary() {
	return salary;
    }
    
    public String toString() {
        return "\nname          :" + name 
               + "\nSalary        :" + salary
               + "\nExperience    :" + experience;
    }
}
