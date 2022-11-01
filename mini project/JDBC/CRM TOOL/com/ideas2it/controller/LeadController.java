package com.ideas2it.controller;

import java.time.DateTimeException;
import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.service.LeadService;
import com.ideas2it.utils.ValidationUtils;

/**
 * <h1> Lead Controller </h1>
 * <p>
 * This class will get request and return the responces
 * like Adding, Updating, Viewing, Searching, Deleting
 * the details of Leads
 * </p> 
 *
 * @author  Ajaisharma D
 * @version 1.2
 * @since   24-08-2022
 */
public class LeadController {
    private LeadService leadService;
    private ValidationUtils validationUtils; 

    public LeadController() {
        this.leadService = new LeadService();
        this.validationUtils = new ValidationUtils();
    }
       
    /**
     * <h1> Create Lead </h1>
     * <p>
     * Passes the Details of Leads to Service
     * </p>
     *
     * @param lead     - lead Object to add 
     *
     * @return boolean - status of the lead
     */
    public boolean create(Lead lead) {
        return leadService.create(lead);
    }

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of Leads
     * </p>
     *
     * @return List - Details of Leads
     */
    public List<Lead> getAll(int userId) {
        return leadService.getAll(userId);
    }    

    /**
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of a Single Lead by Id
     * </p>
     * 
     * @param id    - Lead's Id to search the lead
     *
     * @return Lead - Details of a Single Lead
     */
    public Lead getById(int id) {
        return leadService.getById(id);
    }

    /**
     * <h1> Update Details of Lead By Id </h1>
     * <p>
     * Updates the Details of a Single Lead
     * </p>
     *
     * @param id          - Lead id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return lead - the Update details of lead
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return leadService.updateById(id, columnName, columnValue);
    }

    /**
     * <h1> Detele Details of Lead by Id</h1>
     * <p>
     * Deteles the Details of a Single Lead
     * </p>
     *
     * @param id       - key to Detele the Lead
     *
     * @return boolean - Status of the Delated Lead
     */
    public boolean isDeletedById(int id) {
        return leadService.isDeletedById(id);
    }

    /**
     * <h1> Valid Name </h1>
     * <p>
     * Get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of Lead 
     * @return boolean - Status of Name
     */
    public boolean isValidName(String name) {
        if (validationUtils.isValidName(name)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Email Id </h1>
     * <p>
     * Get the Email Id and checks whether the given Email Id is valid or not
     * </p>
     *
     * @param email    - Email Id of Lead 
     * @return boolean - Status of Email Id
     */
    public boolean isValidEmailId(String emailId) {
        if (validationUtils.isValidEmailId(emailId)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Phone Number </h1>
     * <p>
     * Get the Phone Number and checks whether the given Phone Number is valid or not
     * </p>
     *
     * @param phoneNumber - Phone Number of Lead 
     * @return boolean    - Status of Phone Number
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        if (validationUtils.isValidPhoneNumber(phoneNumber)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Company Name </h1>
     * <p>
     * Get the Company Name and checks whether the given Company Name is valid or not
     * </p>
     *
     * @param companyName - Company Name of Lead 
     * @return boolean    - Status of Company Name
     */
    public boolean isValidCompanyName(String companyName) {
        if (validationUtils.isValidCompanyName(companyName)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Amount </h1>
     * <p>
     * Get the Amount and checks whether the given Amount is valid or not
     * </p>
     *
     * @param amount   - Amount of deal
     * @return boolean - Status of Amount
     */
    public boolean isValidAmount(String amount) {
        if (validationUtils.isValidAmount(amount)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Website </h1>
     * <p>
     * Get the Website and checks whether the given Website is valid or not
     * </p>
     *
     * @param website  - Website of Account for deal
     * @return boolean - Status of Website
     */
    public boolean isValidWebsite(String website) {
        if (validationUtils.isValidWebsite(website)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid ID </h1>
     * <p>
     * This method will get the Id and checks whether the given Id is valid or not
     * </p>
     *
     * @param id       - id to be Validated  
     * @return boolean  - Status of the Id

    public boolean isValidId(String id) {
        if (validationUtils.isValidId(id)) {
            return true;
        }
        return false;
    }
     */
}