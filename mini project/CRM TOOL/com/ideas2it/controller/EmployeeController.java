package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.utils.ValidationUtils;

/**
 * <h1> Employee Controller </h1>
 * <p>
 * This class will get request and return the responces
 * like Adding, Updating, Viewing, Searching, Deleting
 * the details of Leads
 * </p> 
 *
 * @author Ajaisharma D
 * @version 1.0
 * @since 24-08-2022
 */
public class EmployeeController {
    private EmployeeService employeeService;
    private ValidationUtils validationUtils; 

    public EmployeeController() {
        this.employeeService = new EmployeeService();
        this.validationUtils = new ValidationUtils();
    }
       
    /**
     * <h1> Add Lead </h1>
     * <p>
     * Adds the Details of Leads 
     * </p>
     *
     * @param lead     - lead Object to add 
     *
     * @return boolean - true if the Details of an Lead added otherwise false
     */
    public boolean isLeadAdded(Lead lead) {
        return employeeService.isLeadAdded(lead);
    }

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Employee Leads
     * </p>
     *
     * @return List - Details of Leads
     */
    public List<Lead> getLeads() {
        return employeeService.getLeads();
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
    public Lead getLeadById(String id) {
        return employeeService.getLeadById(id);
    }

    /**
     * <h1> Update Details of Lead </h1>
     * <p>
     * Updates the Details of a Single Lead
     * </p>
     *
     * @param id       - key to update the Lead
     * @param lead     - updated Lead 
     *
     * @return boolean - true if the Details of Lead are updated otherwise false
     */
    public boolean isLeadUpdated(String id, Lead lead) {
        return employeeService.isLeadUpdated(id, lead);
    }

    /**
     * <h1> Remove Details of Lead by Id</h1>
     * <p>
     * Removes the Details of a Single Lead
     * </p>
     *
     * @param id       - key to remove the Lead
     *
     * @return boolean - true if the Details of Lead are Removed otherwise false
     */
    public boolean isLeadRemovedById(String id) {
        return employeeService.isLeadRemovedById(id);
    }

    /**
     * <h1> Valid Name </h1>
     * <p>
     * This method will get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of Lead given by the Employee  
     * @return boolean - true if the Name is valid otherwise false
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
     * This method will get the Email and checks whether the given Email is valid or not
     * </p>
     *
     * @param email    - Email of Lead given by the Employee  
     * @return boolean - true if the Email is valid otherwise false
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
     * This method will get the Phone Number and checks whether the given Phone Number is valid or not
     * </p>
     *
     * @param phoneNumber - Phone Number of Lead given by the Employee  
     * @return boolean    - true if the Phone Number is valid otherwise false
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
     * This method will get the Company Name and checks whether the given Company Name is valid or not
     * </p>
     *
     * @param companyName - Company Name of Lead given by the Employee  
     * @return boolean    - true if the Company Name is valid otherwise false
     */
    public boolean isValidCompanyName(String companyName) {
        if (validationUtils.isValidCompanyName(companyName)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Deal Size </h1>
     * <p>
     * This method will get the Deal Size and checks whether the given Deal Size is valid or not
     * </p>
     *
     * @param dealSize - Deal Size of Lead given by the Employee  
     * @return boolean - true if the Deal Size is valid otherwise false
     */
    public boolean isValidDealSize(String dealSize) {
        if (validationUtils.isValidDealSize(dealSize)) {
            return true;
        }
        return false;
    }
}
