package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.service.EmployeeService;

/**
 * Controls all the operations performed by the employee
 * Like adding, updating, searching the leads
 *
 * @author Ajaisharma D
 * @version 1.0 24-08-2022
 */
public class EmployeeController {
    private Lead lead;
    private EmployeeService employeeService = new EmployeeService();
       
    /**
     * adds the Lead's detail 
     *
     * @param lead - lead Object to add 
     */
    public boolean addLead (Lead lead) {
        return employeeService.addLead(lead);
    }

    /**   
     * Prints all the lead's details  
     *
     * @return returns nothing
     */
    public List<Lead> printLeads() {
        return employeeService.printLeads();
    }    

    /**
     * Prints the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     */
    public Lead printLeadById(String id) {
        return employeeService.printLeadById(id);
    }

    /**
     * Updates the Name of the Lead
     *
     * @param id - key to update the name
     * @param leadName - updated name
     * @return boolean
     */
     public boolean editName(String id, String leadName) {
         return employeeService.editName(id, leadName);
     }

    /**
     * Updates the Email id of the Lead
     *
     * @param id - key to update the Email id
     * @param leadEmail - updated mail id
     * @return boolean
     */
     public boolean editEmail(String id, String leadEmail) {
         return employeeService.editEmail(id, leadEmail);
     }

    /**
     * Updates the Phone Number of the Lead
     *
     * @param id - key to update the Phone Number
     * @param leadPhone - updated Phone Number
     * @return boolean
     */
     public boolean editPhone(String id, String leadPhone) {
         return employeeService.editPhone(id, leadPhone);
     }

    /**
     * Updates the Stage of the Lead
     *
     * @param id - key to update the Stage
     * @param leadStage - updated Stage
     * @return boolean
     */
     public boolean editStage(String id, String leadStage) {
         return employeeService.editStage(id, leadStage);
     }

    /**
     * Updates the Company Name of the Lead
     *
     * @param id - key to update the Company Name
     * @param leadCompanyName - updated Company Name
     * @return boolean
     */
     public boolean editCompanyName(String id, String leadCompanyName) {
         return employeeService.editCompanyName(id, leadCompanyName);
     }

    /**
     * Updates the Start Date of the Lead
     *
     * @param id - key to update the Start Date
     * @param leadStartDate - updated Start Date
     * @return boolean
     */
     public boolean editStartDate(String id, String leadStartDate) {
         return employeeService.editStartDate(id, leadStartDate);
     }

    /**
     * Updates the End Date of the Lead
     *
     * @param id - key to update the End Date
     * @param leadEndDate - updated End Date
     * @return boolean
     */
     public boolean editEndDate(String id, String leadEndDate) {
         return employeeService.editEndDate(id, leadEndDate);
     }

    /**
     * Updates the Deal Size of the Lead
     *
     * @param id - key to update the Deal Size
     * @param leadDealSize - updated Deal Size
     * @return boolean
     */
     public boolean editDealSize(String id, int leadDealSize) {
         return employeeService.editDealSize(id, leadDealSize);
     }

    /**
     * Check the employee's input to logout from the Employee Dashboard
     *
     * @param logout - Key to logout
     * @return returns exit a boolean value 
     */
    public boolean closeEmployee(byte logout) {
        return employeeService.closeEmployee(logout);
    }
}