package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.LeadDao;
import com.ideas2it.model.Lead;

/**
 * <h1> Lead DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Leads
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   19-09-2022
 */
public class LeadDaoImpl implements LeadDao {
    private static Map<String, Lead> leadMap = new HashMap<>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Lead insert(String id, Lead lead) {
        lead.setId(id);
        leadMap.put(id, lead);
        return leadMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Lead> fetchAll() {
        if (null != leadMap) {
            return leadMap;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead fetchById(String id) {
        if (null != leadMap) {
            if (leadMap.containsKey(id)) {
                return leadMap.get(id);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead updateById(String id, Lead lead) {
        if (null != leadMap) {
            if (leadMap.containsKey(id)) {
                return leadMap.replace(id, lead);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead deleteById(String id) {
        if (null != leadMap) {
            if (leadMap.containsKey(id)) {
                return leadMap.remove(id);
            }
        }
        return null;
    }
}