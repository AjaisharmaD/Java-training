package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.exception.NotFoundException;
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
     * <h1> Insert Leads </h1>
     * <p>
     * Inserts the Details of Leads 
     * </p>
     *
     * @param lead      - Details of Leads to add 
     *   
     * @return int - count of row/s affected 
     */
    public int insert(Lead lead);

    /**   
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of Lead by Id
     * </p>  
     *
     * @return Map - Details of Leads 
     */
    public List<Lead> fetchAll();

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
    public Lead fetchById(int id);

    /**
     * <h1> Update Details of Lead </h1>
     * <p>
     * Updates the Details of Lead 
     * </p>
     *
     * @param id          - lead id to update
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return int - int value of rows affected
     */
     public int updateById(Lead lead);

    /**
     * <h1> Delete Details of Lead </h1>
     * <p>
     * Deletes the Details of Lead 
     * </p>
     *
     * @param id    - key to Remove the Details of Lead
     *
     * @return int - int value of rows affected
     */
    public int deleteById(int id);
}