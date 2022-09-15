package com.ideas2it.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
import com.ideas2it.controller.EmployeeController;

public class EmployeeService {
    private final static byte LOGOUT = 1;
    private int idCount = 0;
    private Map<String, Lead> leadMap = new HashMap<>();
    
    /**
     * generates the Id for Lead
     */
     public String generateId() {
         String prefixId = "Lead_0";
         return prefixId + (++idCount);
     }
    
    /**
     * adds the Lead's detail 
     *
     * @param lead - lead Object to add 
     */
     public boolean addLead(Lead lead) {
        String leadId =  generateId();
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
    public List<Lead> printLeads() {
        List<Lead> leadList = new ArrayList<>();
        for (Map.Entry<String, Lead> leadEntry : leadMap.entrySet()) {
            leadList.add(leadEntry.getValue());
        } 
        return leadList;
    }

    /**
     * Prints the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     */
    public Lead printLeadById(String id) {
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
     * @return boolean
     */
     public boolean editName(String id, String leadName) {
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
     * @return boolean
     */
     public boolean editEmail(String id, String leadEmail) {
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
     * @return boolean
     */
     public boolean editPhone(String id, String leadPhone) {
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
     * @return boolean
     */
     public boolean editStage(String id, String leadStage) {
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
     * @return boolean
     */
     public boolean editCompanyName(String id, String leadCompanyName) {
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
     * @return boolean
     */
     public boolean editStartDate(String id, String leadStartDate) {
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
     * @return boolean
     */
     public boolean editEndDate(String id, String leadEndDate) {
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
     * @return boolean
     */
     public boolean editDealSize(String id, int leadDealSize) {
         if (leadMap.containsKey(id)) {
             leadMap.get(id).setDealSize(leadDealSize);
             return true;
         }
         return false;
     }

    /**
     * Check the user's input to logout from the CRM Tool
     *
     * @param logout - key to logout
     * @return returns exit a boolean value 
     */
    public boolean closeEmployee(byte logout) {
        boolean exit;
        exit = (logout == LOGOUT) ? false : true; 
        return exit;
    }         
}