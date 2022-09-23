package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.impl.EmployeeDaoImpl;
import com.ideas2it.model.Lead;

/**
 * <h1> Employee Service </h1>
 * <p>
 * This class will get the Request and process the operatioin to be done
 * like adding, Viewing, Updating, Deleting 
 * the Details of Leads
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   16-09-2022
 */
public class EmployeeService {
    private static int idCount = 0;
    private EmployeeDao employeeDao;
    
    public EmployeeService() {
        this.employeeDao = new EmployeeDaoImpl(); 
    }
   
    /**
     * <h1> Id generator </h1>
     * <p>
     * Generates the Id for Employee
     * </p>
     * 
     * @return String - generated Id
     */
    private String generateId() {   
        String prefixId = "Lead_0";
        return prefixId + (++idCount);  
    }
    
    /**
     * <h1> Add Leads </h1>
     * <p>
     * Adds the Details of Leads then returns true
     * </p>
     *
     * @param lead     - lead Object to add 
     *
     * @return boolean - true if the Details of an employee added otherwise false
     */
    public boolean isLeadAdded(Lead lead) {
       String id = generateId();

       if (employeeDao.addLead(id, lead) != null) {
           return true;
       }
       return false;
    } 

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Leads 
     * </p>
     *
     * @return List - Details of Leads 
     */
    public List<Lead> getLeads() {    
        List<Lead> leadList = new ArrayList<>();

        for (Map.Entry<String, Lead> leadEntry : employeeDao.getLeads().entrySet()) {
            leadList.add(leadEntry.getValue());
        }  
        return leadList;
    }

    /**
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of a Single Lead by Id
     * </p>
     * 
     * @param id    - Lead's Id to search the lead
     *
     * @return Lead - Details of Single lead 
     */
    public Lead getLeadById(String id) {
        return employeeDao.getLeadById(id);
    }

    /**
     * <h1> Update Details of Lead </h1>
     * <p>
     * Updates the Details of a Single Lead
     * </p>
     *
     * @param id       - key to update the Lead
     * @param lead     - an updated Lead 
     *  
     * @return boolean - true if the Details of Lead are updated otherwise false
     */
    public boolean isLeadUpdated(String id, Lead lead) {
        if (employeeDao.updateLead(id, lead) != null) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Remove Details of Lead </h1>
     * <p>
     * Removes the Details of a Single Lead
     * </p>
     *
     * @param id       - key to Remove the Lead
     *
     * @return boolean - true if the Details of Lead are Removed otherwise false
     */
    public boolean isLeadRemovedById(String id) {
        if (employeeDao.removeLeadById(id) != null) {
            return true;
        }
        return false;
    }
}
