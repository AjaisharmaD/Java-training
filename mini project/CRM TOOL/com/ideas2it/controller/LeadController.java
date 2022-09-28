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
     * @return Lead    - Details of a added Lead
     */
    public Lead create(Lead lead) {
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
    public List<Lead> getAll() {
        return leadService.getAll();
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
    public Lead getById(String id) {
        return leadService.getById(id);
    }

    /**
     * <h1> Update Details of Lead By Id </h1>
     * <p>
     * Updates the Details of a Single Lead
     * </p>
     *
     * @param id       - key to update the Lead
     * @param lead     - updated Lead 
     *
     * @return lead - the Update details of lead
     */
    public Lead updateById(String id, Lead lead) {
        return leadService.updateById(id, lead);
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
    public boolean isDeletedById(String id) {
        return leadService.isDeletedById(id);
    }

    /**
     * <h1> Valid Name </h1>
     * <p>
     * Get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of Lead given by the Employee  
     * @return boolean - Status of Lead Name
     */
    public boolean isValidName(String name) {
        if (validationUtils.isValidName(name)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Email </h1>
     * <p>
     * Get the Email and checks whether the given Email is valid or not
     * </p>
     *
     * @param email    - Email of Lead given by the Employee  
     * @return boolean - Status of Lead Email
     */
    public boolean isValidEmail(String email) {
        if (validationUtils.isValidEmail(email)) {
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
     * @param phoneNumber - Phone Number of Lead given by the Employee  
     * @return boolean    - Status of Lead Phone Number
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
     * @param companyName - Company Name of Lead given by the Employee  
     * @return boolean    - Status of Lead Company Name
     */
    public boolean isValidCompanyName(String companyName) {
        if (validationUtils.isValidCompanyName(companyName)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Date </h1>
     * <p>
     * Get the Date and checks whether the given Date is valid or not
     * </p>
     *
     * @param date - Start/End Date given by the Employee  
     * @return boolean - Status of Lead Date
     */
    public boolean isValidDate(String date) {
        try {
            if (validationUtils.validateDate(date).equals(date)) {
                return true;
            } else {
                return false;
            }   
        } catch (DateTimeException e) {
            return false;
        }
    }

    /**
     * <h1> Valid Deal Cost </h1>
     * <p>
     * Get the Deal Cost and checks whether the given Deal Cost is valid or not
     * </p>
     *
     * @param dealCost - Deal Cost of Lead given by the Employee  
     * @return boolean - Status of Lead Deal Cost
     */
    public boolean isValidDealCost(String dealCost) {
        if (validationUtils.isValidDealCost(dealCost)) {
            return true;
        }
        return false;
    }
}