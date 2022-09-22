package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.service.EmployeeService;

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
    private Lead lead;
    private EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
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
     * <h1> Delete Details of Lead by Id</h1>
     * <p>
     * Deletes the Details of a Single Lead
     * </p>
     *
     * @param id       - key to delete the Lead
     *
     * @return boolean - true if the Details of Lead are Deleted otherwise false
     */
    public boolean isLeadDeletedById(String id) {
        return employeeService.isLeadDeletedById(id);
    }
}
