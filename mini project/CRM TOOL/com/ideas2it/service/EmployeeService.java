package com.ideas2it.service;

import java.util.List;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.dao.EmployeeDaoImpl;
import com.ideas2it.model.Lead;

public class EmployeeService {
    private EmployeeDaoImpl employeeDaoImpl;
    
    public EmployeeService() {
        this.employeeDaoImpl = new EmployeeDaoImpl(); 
    }
   
    /**
     * generates the Id for Lead
     * 
     * @return returns the generated Id
     */
    public String generateId() {
        String prefixId = "Lead_0";
        return prefixId + (++idCount);
    }
    
    /**
     * Adds the Lead's detail 
     *
     * @param lead - lead Object to add 
     * @return returns boolean
     */
    public boolean addLead(Lead lead) {
       String id = generateId();
       return employeeDaoImpl.addLead(id, lead);
    }

    /**   
     * Prints all the lead's details  
     *
     * @return returns nothing
     */
    public List<Lead> printLeads() {
       return employeeDaoImpl.printLeads();
    }

    /**
     * Prints the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     * @return one lead's Details
     */
    public Lead printLeadById(String id) {
       return employeeDaoImpl.printLeadById(id);
    }

    /**
     * Updates the Name of the Lead
     *
     * @param id - key to update the name
     * @param leadName - updated name
     * @return boolean
     */
     public boolean editName(String id, String leadName) {
       return employeeDaoImpl.editName(id, leadName);
     }

    /**
     * Updates the Email id of the Lead
     *
     * @param id - key to update the Email id
     * @param leadEmail - updated mail id
     * @return boolean
     */
     public boolean editEmail(String id, String leadEmail) {
       return employeeDaoImpl.editEmail(id, leadEmail);
     }

    /**
     * Updates the Phone Number of the Lead
     *
     * @param id - key to update the Phone Number
     * @param leadPhone - updated Phone Number
     * @return boolean
     */
     public boolean editPhone(String id, String leadPhone) {
       return employeeDaoImpl.editPhone(id, leadPhone);
     }

    /**
     * Updates the Stage of the Lead
     *
     * @param id - key to update the Stage
     * @param leadStage - updated Stage
     * @return boolean
     */
     public boolean editStage(String id, String leadStage) {
       return employeeDaoImpl.editEmail(id, leadStage);
     }

    /**
     * Updates the Company Name of the Lead
     *
     * @param id - key to update the Company Name
     * @param leadCompanyName - updated Company Name
     * @return boolean
     */
     public boolean editCompanyName(String id, String leadCompanyName) {
       return employeeDaoImpl.editEmail(id, leadCompanyName);
     }

    /**
     * Updates the Start Date of the Lead
     *
     * @param id - key to update the Start Date
     * @param leadStartDate - updated Start Date
     * @return boolean
     */
     public boolean editStartDate(String id, String leadStartDate) {
       return employeeDaoImpl.editEmail(id, leadStartDate);
     }


    /**
     * Updates the End Date of the Lead
     *
     * @param id - key to update the End Date
     * @param leadEndDate - updated End Date
     * @return boolean
     */
     public boolean editEndDate(String id, String leadEndDate) {
       return employeeDaoImpl.editEmail(id, leadEndDate);
     }

    /**
     * Updates the Deal Size of the Lead
     *
     * @param id - key to update the Deal Size
     * @param leadDealSize - updated Deal Size
     * @return boolean
     */
     public boolean editDealSize(String id, int leadDealSize) {
       return employeeDaoImpl.editDealSize(id, leadDealSize);
     }   

    /**
     * Deletes the Lead by id
     *
     * @param id- key to delete the Lead
     * @return boolean
     */
    public boolean deleteLeadById(String id) {
        return employeeDaoImpl.deleteLeadById(id);
    }
}
