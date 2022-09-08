/**
 * Common details are set and get from here
 *
 * @author Ajaisharma D
 * @version 1.0  07-09-2022
 *
 */   
public class Employee {
    private String name;
    private String phoneNumber;
    private String emailId;
    //private String passsword;

    Employee(String name, String phoneNumber, String emailId) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    /*
    public void setPassword(String password) {
        this.password = password;
    }
    */
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }
    /*
    public String getPassword() {
        return password;
    }
     */
    @Override
    public String toString() {
         String commonResponder = "\nName          : " + name
                                  + "\nEmail ID      : " + emailId 
                                  + "\nPhone Number  : " + phoneNumber;
         return commonResponder;
    }
}