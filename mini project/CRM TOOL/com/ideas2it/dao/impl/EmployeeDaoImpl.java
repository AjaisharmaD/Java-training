package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.controller.EmployeeController;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.model.Lead;

/**
 * Stores and fetch the data from the Collection Storage
 * and the Implementation of abstract Methods goes here
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

    @Override
    public Lead addLead(String leadId, Lead lead) {
        lead.setId(leadId);
        return leadMap.put(leadId, lead);
    }

    @Override
    public Map<String, Lead> getLeads() {
        return leadMap;
    }

    @Override
    public Lead getLeadById(String id) {
        Lead leads = null;

        if (leadMap.containsKey(id)) {
            leads = leadMap.get(id);
        }
        return leads;
    }

    @Override
    public Lead updateLead(String id, Lead lead) {
        Lead updatedLead = null;

        if (leadMap.containsKey(id)) {
            updatedLead = leadMap.replace(id, lead);
        }
        return updatedLead;
    }

    @Override
    public Lead deleteLeadById(String id) {
        Lead deletedLead = null;
        if (leadMap.containsKey(id)) {
            deletedLead =leadMap.remove(id);
        }
        return deletedLead;
    }
}
