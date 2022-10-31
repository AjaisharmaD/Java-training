package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.Opportunity;

/**
 * <h1> Opportunity DAO </h1>
 * <p>
 * Gets the request and performs the operations
 * like Adding, Viewing, Updating the Details of Opportunity
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public interface OpportunityDao {
 
    /**
     * <h1> Insert Opportunity Details </h1>
     * <p>
     * Inserts the Details of Opportunity 
     * </p>
     *
     * @param OpportunityId - Id of a Opportunity
     * @param Opportunity   - Details of Opportunity to add 
     *   
     * @return Opportunity  - Details of Opportunity
     */
    public Opportunity insert(int OpportunityId, Opportunity opportunity);

    /**   
     * <h1> Get Details of Opportunity </h1>
     * <p>
     * Gets the Details of Opportunity
     * </p>  
     *
     * @return Map - Details of Opportunitys 
     */
    public Map<Integer, Opportunity> fetchAll();

    /**
     * <h1> Get Details of Opportunity by Id </h1>
     * <p>
     * Gets the Details of Opportunity by Id
     * </p>
     * 
     * @param id           - Opportunity's Id to search the Opportunity
     *
     * @return Opportunity - Details of single Opportunity
     */
    public Opportunity fetchById(int id);

    /**
     * <h1> Update Details of Opportunity </h1>
     * <p>
     * Updates the Details of Opportunity 
     * </p>
     *
     * @param id           - key to update the Opportunity
     * @param Opportunity  - updated Details of Opportunity
     *
     * @return Opportunity -  updated Details of Opportunity
     */
     public Opportunity updateById(int id, Opportunity opportunity);

    /**
     * <h1> Delete Details of Opportunity </h1>
     * <p>
     * Deletes the Details of Opportunity 
     * </p>
     *
     * @param id           - key to Remove the Details of Opportunity
     *
     * @return Opportunity -  Delated Details of Opportunity
     */
    public Opportunity deleteById(int id);
}