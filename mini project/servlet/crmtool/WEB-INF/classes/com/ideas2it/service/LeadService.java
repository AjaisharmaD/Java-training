package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.dao.LeadDao;
import com.ideas2it.dao.impl.LeadDaoImpl;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.logger.CustomLogger;
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
    private LeadDao leadDao;
    private CustomLogger logger;
    
    public LeadService() {
        this.leadDao = new LeadDaoImpl(); 
        this.logger = new CustomLogger(LeadService.class);
    }
    
    /**
     * <h1> Create Leads </h1>
     * <p>
     * Creates the Details of Leads 
     * </p>
     *
     * @param lead     - lead details to add 
     *
     * @return boolean - status of the lead
     */
    public boolean create(Lead lead) {
       boolean status = true;       

       if (leadDao.insert(lead) <= 0) {
           status = false;
       } 
       return status;
    } 

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Leads 
     * </p>
     * 
     * @return List - Details of Leads 
     */
    public List<Lead> getAll(int id) throws NotFoundException {   
         List<Lead> listOfLead = leadDao.fetchAll();
         List<Lead> leads = new ArrayList<>();
         logger.info("service is running");

         if (!listOfLead.isEmpty()) {
            for (Lead lead : listOfLead) {
                if (lead.getUserId() == id) {
                    leads.add(lead);
                }
            }
            
        } else {
            throw new NotFoundException(Messages.LEAD_NOT_FOUND);
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
    public Lead getById(int id, int userId) throws NotFoundException {
        Lead lead = leadDao.fetchById(id);

        if (null != lead) {
            if (lead.getUserId() == userId) {
                return lead;
            }
        } else {
            throw new NotFoundException(Messages.LEAD_NOT_FOUND);
        }
        return null;
    }

    /**
     * <h1> Update Details of Lead </h1>
     * <p>
     * Updates the Details of a Single Lead
     * </p>
     *
     * @param id          - User id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *  
     * @return Lead    - Status of the Updated lead
     */
    public boolean updateById(Lead lead) {
        return (leadDao.updateById(lead) <=0) ? false : true;
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
    public boolean isDeletedById(int id) {
        return (leadDao.deleteById(id) <= 0) ? false : true;
    }
}