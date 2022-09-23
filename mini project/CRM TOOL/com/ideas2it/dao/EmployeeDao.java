package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
 
/**
 * <h1> Employee DAO </h1>
 * <p>
 * This class will get the request and performs the operations
 * like Adding, Viewing, Updating, Deleting the Details of Leads
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   19-09-2022
 */
public interface EmployeeDao {
 
    /**
     * <h1> Add Leads </h1>
     * <p>
     * Adds the Details of Leads 
     * </p>
     *
     * @param leadId - Id of a lead 
     * @param lead   - Details of Leads to add 
     *   
     * @return Lead  - Details of Leads
     */
    public Lead addLead(String leadId, Lead lead);

    /**   
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of Lead by Id
     * </p>  
     *
     * @return Map - Details of Leads 
     */
    public Map<String, Lead> getLeads();

    /**
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of Lead by Id
     * </p>
     * 
     * @param id    - Lead's Id to search the lead
     *
     * @return Lead - Details of single Lead
     */
    public Lead getLeadById(String id);

    /**
     * <h1> Update Details of Lead </h1>
     * <p>
     * Updates the Details of Lead 
     * </p>
     *
     * @param id    - key to update the Lead
     * @param lead  - updated Details of Lead
     *
     * @return Lead -  updated Details of Lead
     */
     public Lead updateLead(String id, Lead lead);

    /**
     * <h1> Remove Details of Lead </h1>
     * <p>
     * Removes the Details of Lead 
     * </p>
     *
     * @param id    - key to Remove the Details of Lead
     *
     * @return boolean - true if value is not null otherwise false
     */
    public Lead removeLeadById(String id);
}
