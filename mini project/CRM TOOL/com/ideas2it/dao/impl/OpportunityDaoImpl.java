package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.OpportunityDao;
import com.ideas2it.model.Opportunity;

/**
 * <h1> Opportunity DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Leads
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class OpportunityDaoImpl implements OpportunityDao {
    private Map<String, Opportunity> opportunityMap;
    
    public OpportunityDaoImpl() {
        this.opportunityMap = new HashMap<>(); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity insert(String opportunityId, Opportunity opportunity) {
        opportunityMap.put(opportunityId, opportunity);
        return opportunityMap.get(opportunityId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Opportunity> fetchAll() {
        return opportunityMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity fetchById(String id) {
        if (opportunityMap.containsKey(id)) {
            return opportunityMap.get(id);
        } 
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity updateById(String id, Opportunity opportunity) {
        if (opportunityMap.containsKey(id)) {
            return opportunityMap.replace(id, opportunity);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity deleteById(String id) {
        if (opportunityMap.containsKey(id)) {
            return opportunityMap.remove(id);
        }
        return null;
    }
}