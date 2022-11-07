package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.exception.NotFoundException;
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
     * @param Opportunity  - Details of Opportunity to add 
     *   
     * @return int  - count of row/s affected
     */
    public int insert(Opportunity opportunity);

    /**   
     * <h1> Get Details of Opportunity </h1>
     * <p>
     * Gets the Details of Opportunity
     * </p>  
     *
     * @return List - list of opportunity details
     */
    public List<Opportunity> fetchAll() throws NotFoundException;

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
    public Opportunity fetchById(int id) throws NotFoundException;

    /**
     * <h1> Update Details of Opportunity </h1>
     * <p>
     * Updates the Details of Opportunity 
     * </p>
     *
     * @param id          - id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return int        - count of rows affected
     */
     public int updateById(int id, String columnName, String columnValue);

    /**
     * <h1> Delete Details of Opportunity </h1>
     * <p>
     * Deletes the Details of Opportunity 
     * </p>
     *
     * @param id           - key to Remove the Details of Opportunity
     *
     * @return int  - count of rows affected
     */
    public int deleteById(int id);
}