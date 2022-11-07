package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.dao.OpportunityDao;
import com.ideas2it.dao.impl.OpportunityDaoImpl;
import com.ideas2it.model.Opportunity;

/**
 * <h1> Opportunity Service </h1>
 * <p>
 * Gets the Request and process the operatioin to be done
 * like adding, Viewing, Updating
 * the Details of Opportunity
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class  OpportunityService {
    private OpportunityDao opportunityDao;

    public OpportunityService() {
        this.opportunityDao = new OpportunityDaoImpl();
    }

    /**
     * <h1> Create Opportunity </h1>
     * <p>
     * Creates the Details of Opportunity 
     * </p>
     *
     * @param Opportunity  - Opportunity details to add 
     *
     * @return boolean -  status of opportunity
     */
    public boolean create(Opportunity opportunity) {
       boolean status = true; 

       if (opportunityDao.insert(opportunity) <= 0) {
           status = false;
       }
       return status;
    } 

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Opportunity
     * </p>
     *
     * @return List - Details of Opportunity
     */
    public List<Opportunity> getAll() {
        List<Opportunity> opportunities = opportunityDao.fetchAll();  

        if (null != opportunities) {
            return opportunities;
        }
        return null;
    }

    /**
     * <h1> Get Details of Opportunity by Id </h1>
     * <p>
     * Gets the Details of a Opportunity by Id
     * </p>
     * 
     * @param id           - Opportunity's Id to search the Opportunity
     *
     * @return Opportunity - Details of Opportunity
     */
    public Opportunity getById(int id) {
        return opportunityDao.fetchById(id);
    }

    /**
     * <h1> Update Details of Opportunity </h1>
     * <p>
     * Updates the Details of a Opportunity
     * </p>
     *
     * @param id           - key to update the Opportunity
     * @param Opportunity  - an updated Opportunity
     *  
     * @return boolean - status of the id
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return (opportunityDao.updateById(id, columnName, columnValue) <= 0) ? false : true;
    }

    /**
     * <h1> Detele Details of Opportunity </h1>
     * <p>
     * Deletes the Details of a Opportunity
     * </p>
     *
     * @param id       - key to Delete the Opportunity
     *
     * @return boolean - Status of the Deleted Opportunity
     */
    public boolean isDeletedById(int id) {
        return (opportunityDao.deleteById(id) <= 0) ? false : true;
    }
}