package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.impl.EmployeeDaoImpl;
import com.ideas2it.model.Lead;

/**
 * Stores and fetch the data from the Collection Storage
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 16-09-2022
 */
public class EmployeeService {
    private static int idCount = 0;
    private EmployeeDao employeeDao;
    
    public EmployeeService() {
        this.employeeDao = new EmployeeDaoImpl(); 
    }
   
    /**
     * Generates the Id for Lead to store it as a Key for eah user Details
     * 
     * @return returns the generated Lead Id
     */
    private String generateId() {   
        String prefixId = "Lead_0";
        return prefixId + (++idCount);  
    }
    
    /**
     * Adds the Lead's detail 
     *
     * @param lead - lead Object to add 
     *
     * @return true if the details not null otherwise false
     */
    public boolean isLeadAdded(Lead lead) {
       String id = generateId();

       if (employeeDao.addLead(id, lead) != null) {
           return true;
       }
       return false;
    } 

    /**   
     * Gets all the lead's details by iterating the map Object
     * and stores it in the List
     *
     * @return List of leads details 
     */
    public List<Lead> getLeads() {    
        List<Lead> leadList = new ArrayList<>();

        for (Map.Entry<String, Lead> leadEntry : employeeDao.getLeads().entrySet()) {
            leadList.add(leadEntry.getValue());
        }  
        return leadList;
    }

    /**
     * Gets the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     *
     * @return one lead's Details
     */
    public Lead getLeadById(String id) {
        return employeeDao.getLeadById(id);
    }

    /**
     * Updates the Lead
     *
     * @param id - key to update the Lead
     * @param lead - updated Lead 
     *
     * @return true if the returned value is not null otherwise false
     */
    public boolean isLeadUpdated(String id, Lead lead) {
        if (employeeDao.updateLead(id, lead) != null) {
            return true;
        }
        return false;
    }

    /**
     * Deletes the Lead by id
     *
     * @param id- key to delete the Lead
     *
     * @return true if the returned value is not null otherwise false
     */
    public boolean isLeadDeletedById(String id) {
        if (employeeDao.deleteLeadById(id) != null) {
            return true;
        }
        return false;
    }
}
