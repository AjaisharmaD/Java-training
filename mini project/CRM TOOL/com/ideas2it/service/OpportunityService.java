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
     * @return Opportunity - Opportunity detail which is inserted into the Map
     */
    public Opportunity create(Opportunity opportunity) {
       String id = opportunity.getId();
       return opportunityDao.insert(id, opportunity);
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
        Map<String, Opportunity> map = opportunityDao.fetchAll();    
        List<Opportunity> opportunities = new ArrayList<>();

        if (null != map) {
            for (Map.Entry<String, Opportunity> opportunityEntry : map.entrySet()) {
                opportunities.add(opportunityEntry.getValue());
            }  
        }
        return opportunities;
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
    public Opportunity getById(String id) {
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
     * @return Opportunity - Details of Single lead
     */
    public Opportunity updateById(String id, Opportunity opportunity) {
        return opportunityDao.updateById(id, opportunity);
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
    public boolean isDeletedById(String id) {
        if (opportunityDao.deleteById(id) != null) {
            return true;
        }
        return false;
    }
}