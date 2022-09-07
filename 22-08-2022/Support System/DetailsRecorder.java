/**
 * <h1>Record  the Details</h1>
 * <p>
 * The DetailRecorder working as a POJO class
 * which sets and gets the details of the users
 * both the Admin and customer
 * </p>
 *
 * @version 1.0
 * @author Ajaisharma D
 * @since 22-Augest-2022
 */
public class DetailsRecorder {
    private String name;
    private Long phoneNumber;
    private String emailId;
    private String address;
    private char gender;
    private int age;

    // SETTERS
    public void setName(String name) {
        this.name = name ;
    }

    public void setPhoneNumber(Long number) {
        phoneNumber = number;
    }

    public void setEmail(String mailId) {
        emailId = mailId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }    

    public String getName() {
        return name;
    }

    // GETTERS
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return emailId;
    }

    public String getAddress() {
        return address;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}