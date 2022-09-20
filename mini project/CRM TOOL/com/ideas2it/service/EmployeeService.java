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
     * generates the Id for Lead
     * 
     * @return returns the generated Id
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
     * @return returns boolean
     */
    public boolean addLead(Lead lead) {
       String id = generateId();
       return employeeDao.addLead(id, lead);
    }

    /**   
     * Gets all the lead's details  
     */
    public List<Lead> getLeads() {     
        return employeeDao.getLeads();
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
     * Updates the Name of the Lead
     *
     * @param id - key to update the name
     * @param leadName - updated name
     *
     * @return boolean
     */
    public boolean updateName(String id, String leadName) {
        return employeeDao.updateName(id, leadName);
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
        return employeeDao.updateEmail(id, leadEmail);
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
        return employeeDao.updatePhoneNumber(id, leadPhone);
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
        return employeeDao.updateStage(id, leadStage);
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
        return employeeDao.updateCompanyName(id, leadCompanyName);
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
        return employeeDao.updateStartDate(id, leadStartDate);
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
        return employeeDao.updateEndDate(id, leadEndDate);
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
        return employeeDao.updateDealSize(id, leadDealSize);
    }   

    /**
     * Deletes the Lead by id
     *
     * @param id- key to delete the Lead
     *
     * @return boolean
     */
    public boolean deleteLeadById(String id) {
        return employeeDao.deleteLeadById(id);
    }
}
