package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Lead;
import com.ideas2it.exception.CustomException;

/**
 * <h1> Lead Service </h1>
 * <p>
 * This class will get the Request and process the operatioin to be done
 * like adding, Viewing, Updating, Deleting 
 * the Details of Leads
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   16-09-2022
 */
public interface LeadService {
    
    /**
     * <h1> Create Leads </h1>
     * <p>
     * Creates the Details of Leads 
     * </p>
     *
     * @param lead     - lead details to add 
     *
     * @return boolean - status of the lead
     */
    public boolean create(Lead lead);

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Leads 
     * </p>
     * 
     * @return List - Details of Leads 
     */
    public List<Lead> getAll(int id) throws CustomException;

    /**
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of a Single Lead by Id
     * </p>
     * 
     * @param id    - Lead's Id to search the lead
     *
     * @return Lead - Details of Single lead 
     */
    public Lead getById(int id, int userId) throws CustomException;

    /**
     * <h1> Update Details of Lead </h1>
     * <p>
     * Updates the Details of a Single Lead
     * </p>
     *
     * @param id          - User id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *  
     * @return Lead    - Status of the Updated lead
     */
    public boolean updateById(Lead lead);

    /**
     * <h1> Delete Details of Lead </h1>
     * <p>
     * Deletes the Details of a Single Lead
     * </p>
     *
     * @param id       - key to Delete the Lead
     *
     * @return boolean - Status of the Deleted Lead
     */
    public boolean isDeletedById(int id);
}