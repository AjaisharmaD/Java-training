package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.Lead;
 
/**
 * <h1> Lead DAO </h1>
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
public interface LeadDao {
 
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
    public Lead add(String leadId, Lead lead);

    /**   
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of Lead by Id
     * </p>  
     *
     * @return Map - Details of Leads 
     */
    public Map<String, Lead> getAll();

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
    public Lead getById(String id);

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
     public Lead updateById(String id, Lead lead);

    /**
     * <h1> Delete Details of Lead </h1>
     * <p>
     * Deletes the Details of Lead 
     * </p>
     *
     * @param id    - key to Remove the Details of Lead
     *
     * @return Lead -  Delated Details of Lead
     */
    public Lead deleteById(String id);
}