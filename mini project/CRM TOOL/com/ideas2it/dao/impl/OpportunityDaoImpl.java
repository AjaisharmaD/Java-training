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
    private static Map<String, Opportunity> opportunityMap = new HashMap<>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity insert(String id, Opportunity opportunity) {
        opportunityMap.put(id, opportunity);
        return opportunityMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Opportunity> fetchAll() {
        if (!opportunityMap.isEmpty()) {
            return opportunityMap;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity fetchById(String id) {
        if (!opportunityMap.isEmpty()) {
            if (opportunityMap.containsKey(id)) {
                return opportunityMap.get(id);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity updateById(String id, Opportunity opportunity) {
        if (!opportunityMap.isEmpty()) {
            if (opportunityMap.containsKey(id)) {
                return opportunityMap.replace(id, opportunity);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity deleteById(String id) {
        if (!opportunityMap.isEmpty()) {
            if (opportunityMap.containsKey(id)) {
                return opportunityMap.remove(id);
            }
        }
        return null;
    }
}