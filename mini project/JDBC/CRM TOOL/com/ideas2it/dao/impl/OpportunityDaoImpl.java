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
    private static Map<Integer, Opportunity> opportunityMap = new HashMap<>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity insert(int id, Opportunity opportunity) {
        opportunityMap.put(id, opportunity);
        return opportunityMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Integer, Opportunity> fetchAll() {
        if (null != opportunityMap) {
            return opportunityMap;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity fetchById(int id) {
        if (null != opportunityMap) {
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
    public Opportunity updateById(int id, Opportunity opportunity) {
        if (null != opportunityMap) {
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
    public Opportunity deleteById(int id) {
        if (null != opportunityMap) {
            if (opportunityMap.containsKey(id)) {
                return opportunityMap.remove(id);
            }
        }
        return null;
    }
}