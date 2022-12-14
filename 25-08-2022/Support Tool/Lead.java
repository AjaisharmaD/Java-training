/**
 * sets and gets the value for the attributes
 *
 * @author Ajaisharma 
 * @version 1.0 24-08-2022
 */
public class Lead {
    private String id;
    private String name;
    private String phoneNumber;
    private String emailId;
    private int dealSize;
    private String startDate;
    private String endDate;
    private String companyName;
    private String stage;

    Lead(String id, String name,String emailId, 
                    String phoneNumber, String stage, String companyName, 
                    String startDate, String endDate, int dealSize) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.stage =  stage;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealSize = dealSize;
    }
    // setter
    public void setId(String id) {
        this.id = id;
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

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName; 
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDealSize(int dealSize) {
        this.dealSize = dealSize;
    }
    // getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getStage() {
        return stage;
    }
    
    public String getCompanyName() {
        return companyName; 
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getDealSize() {
        return dealSize;
    }

    public String toString() {
        return "ID            : " + id
               + "\nName          : " + name
               + "\nEmail ID      : " + emailId
               + "\nPhone Number  : " + phoneNumber
               + "\nStage         : " + stage
               + "\nCompany Name  : " + companyName
               + "\nStart Date    : " + startDate
               + "\nEnd Date      : " + endDate
               + "\nDeal Size     : " + dealSize
               + "\n----------------------------------------\n";
    }
}