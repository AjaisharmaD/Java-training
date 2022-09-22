package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.model.Lead;

/**
 * <h1> Employee DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Leads
 * by Stores and fetching the data
 * </p> 
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 19-09-2022
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private Map<String, Lead> leadMap;
    
    public EmployeeDaoImpl() {
        this.leadMap = new HashMap<>(); 
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will store the Details of Lead to leadMap
     * </p>
     */
    @Override
    public Lead addLead(String leadId, Lead lead) {
        lead.setId(leadId);
        return leadMap.put(leadId, lead);
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will fetch the data of Leads from the leadMap
     * </p>
     */
    @Override
    public Map<String, Lead> getLeads() {
        return leadMap;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will fetch the data of Lead from the leadMap
     * </p>
     */
    @Override
    public Lead getLeadById(String id) {
        Lead leads = null;

        if (leadMap.containsKey(id)) {
            leads = leadMap.get(id);
        }
        return leads;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will replce the data of Lead in the leadMap
     * </p>
     */
    @Override
    public Lead updateLead(String id, Lead lead) {
        Lead updatedLead = null;

        if (leadMap.containsKey(id)) {
            updatedLead = leadMap.replace(id, lead);
        }
        return updatedLead;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This method will remove the data of Lead from the leadMap
     * </p>
     */
    @Override
    public Lead deleteLeadById(String id) {
        Lead deletedLead = null;
        if (leadMap.containsKey(id)) {
            deletedLead =leadMap.remove(id);
        }
        return deletedLead;
    }
}
