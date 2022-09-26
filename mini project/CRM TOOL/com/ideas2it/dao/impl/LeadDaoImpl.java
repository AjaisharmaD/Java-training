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
    private Map<String, Lead> leadMap;
    
    public LeadDaoImpl() {
        this.leadMap = new HashMap<>(); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead addLead(String leadId, Lead lead) {
        lead.setId(leadId);
        return leadMap.put(leadId, lead);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Lead> getAll() {
        return leadMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead getById(String id) {
        if (leadMap.containsKey(id)) {
            return leadMap.get(id);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead updateById(String id, Lead lead) {
        if (leadMap.containsKey(id)) {
            return leadMap.replace(id, lead);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead deleteById(String id) {
        if (leadMap.containsKey(id)) {
            return leadMap.remove(id);
        }
        return null;
    }
}
