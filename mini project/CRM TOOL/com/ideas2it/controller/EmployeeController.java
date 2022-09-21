package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.service.EmployeeService;

/**
 * Controls all the operations performed by the employee
 * Like Adding, Printing, Searching, Updating the leads
 *
 * @author Ajaisharma D
 * @version 1.0
 * @since 24-08-2022
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
     * @return true if the Lead is added into map
     */
    public boolean isLeadAdded(Lead lead) {
        return employeeService.isLeadAdded(lead);
    }

    /**   
     * Gets all the lead's details as List  
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
     * @return Lead object which contain the details of the Lead
     */
    public Lead getLeadById(String id) {
        return employeeService.getLeadById(id);
    }

    /**
     * Updates the Lead
     *
     * @param id - key to update the Lead
     * @param lead - updated Lead 
     *
     * @return true if the lead is Updated
     */
    public boolean isLeadUpdated(String id, Lead lead) {
        return employeeService.isLeadUpdated(id, lead);
    }

    /**
     * Deletes the Lead by id
     *
     * @param id- key to delete the Lead
     *
     * @return true if the lead is deleted
     */
    public boolean isLeadDeletedById(String id) {
        return employeeService.isLeadDeletedById(id);
    }
}
