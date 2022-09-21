package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
 
/**
 * Contains all the Abstact methods to be Implemented
 * Stores and fetch the data from the Collection Storage
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 19-09-2022
 */
public interface EmployeeDao {
 
    /**
     * Adds the Lead's detail 
     *
     * @param leadId - Id of a lead 
     * @param lead - lead Details to add 
     *   
     * @return lead detail
     */
    public Lead addLead(String leadId, Lead lead);

    /**   
     * Gets all the lead's details  
     *
     * @return leads details 
     */
    public Map<String, Lead> getLeads();

    /**
     * Gets the lead's Details by Id
     * 
     * @param id - Lead's Id to search the lead
     *
     * @return one lead's Details
     */
    public Lead getLeadById(String id);

    /**
     * Updates the Lead
     *
     * @param id - key to update the name
     * @param lead - updated Lead 
     *
     * @return boolean
     */
     public Lead updateLead(String id, Lead lead);

    /**
     * Deletes the Lead by id
     *
     * @param id- key to delete the Lead
     *
     * @return boolean
     */
    public Lead deleteLeadById(String id);
}
