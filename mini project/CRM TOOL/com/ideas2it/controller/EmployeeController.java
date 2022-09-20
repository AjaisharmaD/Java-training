package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.service.EmployeeService;

/**
 * Controls all the operations performed by the employee
 * Like Adding, Printing, Searching, Updating the leads
 *
 * @author Ajaisharma D
 * @version 1.0 24-08-2022
 */
public class EmployeeController {
    private Lead lead;
    private EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }
       
    /**
     * Adds the Lead's details 
     *
     * @param lead - lead Object to add 
     *
     * @return boolean
     */
    public boolean addLead(Lead lead) {
        return employeeService.addLead(lead);
    }

    /**   
     * Gets all the lead's details  
     *
     * @return returns List of Details
     */
    public List<Lead> getLeads() {
        return employeeService.getLeads();
    }    

    /**
     * Gets the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     *
     * @return Lead object
     */
    public Lead getLeadById(String id) {
        return employeeService.getLeadById(id);
    }

    /**
     * Updates the Name of the Lead
     *
     * @param id - key to update the name
     * @param leadName - updated name
     *
     * @return boolean
     */
    public boolean updateName(String id, String leadName) {
        return employeeService.updateName(id, leadName);
    }

    /**
     * Updates the Email id of the Lead
     *
     * @param id - key to update the Email id
     * @param leadEmail - updated mail id
     *
     * @return boolean
     */
    public boolean updateEmail(String id, String leadEmail) {
        return employeeService.updateEmail(id, leadEmail);
    }

    /**
     * Updates the Phone Number of the Lead
     *
     * @param id - key to update the Phone Number
     * @param leadPhone - updated Phone Number
     *
     * @return boolean
     */
    public boolean updatePhoneNumber(String id, String leadPhone) {
        return employeeService.updatePhoneNumber(id, leadPhone);
    }

    /**
     * Updates the Stage of the Lead
     *
     * @param id - key to update the Stage
     * @param leadStage - updated Stage
     *
     * @return boolean
     */
    public boolean updateStage(String id, String leadStage) {
        return employeeService.updateStage(id, leadStage);
    }

    /**
     * Updates the Company Name of the Lead
     *
     * @param id - key to update the Company Name
     * @param leadCompanyName - updated Company Name
     *
     * @return boolean
     */
    public boolean updateCompanyName(String id, String leadCompanyName) {
        return employeeService.updateCompanyName(id, leadCompanyName);
    }

    /**
     * Updates the Start Date of the Lead
     *
     * @param id - key to update the Start Date
     * @param leadStartDate - updated Start Date
     *
     * @return boolean
     */
    public boolean updateStartDate(String id, String leadStartDate) {
        return employeeService.updateStartDate(id, leadStartDate);
    }

    /**
     * Updates the End Date of the Lead
     *
     * @param id - key to update the End Date
     * @param leadEndDate - updated End Date
     *
     * @return boolean
     */
    public boolean updateEndDate(String id, String leadEndDate) {
        return employeeService.updateEndDate(id, leadEndDate);
    }

    /**
     * Updates the Deal Size of the Lead
     *
     * @param id - key to update the Deal Size
     * @param leadDealSize - updated Deal Size
     *
     * @return boolean
     */
    public boolean updateDealSize(String id, int leadDealSize) {
        return employeeService.updateDealSize(id, leadDealSize);
    }

    /**
     * Deletes the Lead by id
     *
     * @param id- key to delete the Lead
     *
     * @return boolean
     */
    public boolean deleteLeadById(String id) {
        return employeeService.deleteLeadById(id);
    }
}
