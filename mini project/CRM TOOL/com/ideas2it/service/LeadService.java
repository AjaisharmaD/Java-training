package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.controller.LeadController;
import com.ideas2it.dao.LeadDao;
import com.ideas2it.dao.impl.LeadDaoImpl;
import com.ideas2it.model.Lead;

/**
 * <h1> Lead Service </h1>
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
public class LeadService {
    private static int idCount = 0;
    private LeadDao leadDao;
    
    public LeadService() {
        this.leadDao = new LeadDaoImpl(); 
    }
   
    /**
     * <h1> Id generator </h1>
     * <p>
     * Generates the Id for Lead
     * </p>
     * 
     * @return String - generated Id
     */
    private String generateId() {   
        return "Lead_0" + (++idCount);  
    }
    
    /**
     * <h1> Create Leads </h1>
     * <p>
     * Creates the Details of Leads 
     * </p>
     *
     * @param lead     - lead Object to add 
     *
     * @return boolean - true if the Details of an employee added otherwise false
     */
    public Lead createLead(Lead lead) {
       return leadDao.addLead(generateId(), lead);
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

        for (Map.Entry<String, Lead> leadEntry : leadDao.getLeads().entrySet()) {
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
    public Lead getById(String id) {
        return leadDao.getById(id);
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
     * @return Lead - Details of Single lead
     */
    public Lead updateById(String id, Lead lead) {
        return leadDao.updateById(id, lead);
    }

    /**
     * <h1> Detele Details of Lead </h1>
     * <p>
     * Deteles the Details of a Single Lead
     * </p>
     *
     * @param id       - key to Remove the Lead
     *
     * @return boolean - true if the Details of Lead are Deteled otherwise false
     */
    public boolean deleteById(String id) {
        if (leadDao.deleteById(id) != null) {
            return true;
        }
        return false;
    }
}