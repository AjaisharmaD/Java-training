package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.model.Lead;

/**
 * Stores and fetch the data from the Collection Storage
 * and the Implementation of abstract Methods goes here
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 19-09-2022
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private int idCount = 0;
    private Map<String, Lead> leadMap;
    
    public EmployeeDaoImpl() {
        this.leadMap = new HashMap<>(); 
    }

    /** 
     * {inheritdoc}
     */
    public boolean addLead(String leadId, Lead lead) {
        lead.setId(leadId);
        leadMap.put(leadId, lead);

        if (leadMap.containsKey(leadId)) {
            return true;
        }
        return false;
    }

    /**   
     * Prints all the lead's details  
     *
     * @return returns nothing
     */
    public Map<String, Lead> getLeads() {
        return leadMap;
    }

    /**
     * Prints the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     *
     * @return one lead's Details
     */
    public Lead getLeadById(String id) {
        Lead lead = null;

        if (leadMap.containsKey(id)) {
            lead = leadMap.get(id);
        }
        return lead;
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
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setName(leadName);
             return true;
         }
         return false;
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
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setEmailId(leadEmail);
             return true;
         }
         return false;
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
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setPhoneNumber(leadPhone);
             return true;
         }
         return false;
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
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setStage(leadStage);
             return true;
         }
         return false;
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
        if (leadMap.containsKey(id)) {
            leadMap.get(id).setCompanyName(leadCompanyName);
            return true;
        }
        return false;
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
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setStartDate(leadStartDate);
             return true;
         }
         return false;
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
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setEndDate(leadEndDate);
             return true;
         }
         return false;
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
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setDealSize(leadDealSize);
             return true;
         }
         return false;
     }      

    /**
     * Deletes the Lead by Id
     *
     * @param id - key to Delete the Lead
     *
     * @return boolean
     */
    public boolean deleteLeadById(String id) {
        leadMap.remove(id);
        return true;
    }
}