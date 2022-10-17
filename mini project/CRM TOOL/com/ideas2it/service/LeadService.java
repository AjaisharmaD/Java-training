package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
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
        return Constants.LEAD_ID + (++idCount);  
    }
    
    /**
     * <h1> Create Leads </h1>
     * <p>
     * Creates the Details of Leads 
     * </p>
     *
     * @param lead  - lead details to add 
     *
     * @return Lead - lead detail which is inserted into the map
     */
    public Lead create(Lead lead) {
       return leadDao.insert(generateId(), lead);
    } 

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Leads 
     * </p>
     *
     * @return List - Details of Leads 
     */
    public List<Lead> getAll(String userId) {   
         Map<String, Lead> map = leadDao.fetchAll();
         List<Lead> leads = new ArrayList<>();
         Lead lead;

         if (null != map) {
            for (Map.Entry<String, Lead> leadMap : map.entrySet()) {

                lead = leadMap.getValue();

                if (lead.getUserId().equals(userId)) {
                    leads.add(lead);
                }
            }
        }
        return leads;    
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
        Lead lead = leadDao.fetchById(id);

        if (null != lead) {
            if (lead.getUserId().equals(id)) {
                return lead;
            }
        }
        return lead;
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
     * @return Lead    - Details of Single lead
     */
    public Lead updateById(String id, Lead lead) {
        return leadDao.updateById(id, lead);
    }

    /**
     * <h1> Delete Details of Lead </h1>
     * <p>
     * Deletes the Details of a Single Lead
     * </p>
     *
     * @param id       - key to Delete the Lead
     *
     * @return boolean - Status of the Deleted Lead
     */
    public boolean isDeletedById(String id) {
        if (leadDao.deleteById(id) != null) {
            return true;
        }
        return false;
    }
}