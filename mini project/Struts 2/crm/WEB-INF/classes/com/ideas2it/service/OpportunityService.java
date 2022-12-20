package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Opportunity;
import com.ideas2it.exception.CustomException;

/**
 * <h1> Opportunity Service </h1>
 * <p>
 * Gets the Request and process the operatioin to be done
 * like adding, Viewing, Updating
 * the Details of Opportunity
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public interface OpportunityService {

    /**
     * <h1> Create Opportunity </h1>
     * <p>
     * Creates the Details of Opportunity 
     * </p>
     *
     * @param Opportunity  - Opportunity details to add 
     *
     * @return boolean -  status of opportunity
     */
    public boolean create(Opportunity opportunity);

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Opportunity
     * </p>
     *
     * @return List - Details of Opportunity
     */
    public List<Opportunity> getAll() throws CustomException;

    /**
     * <h1> Get Details of Opportunity by Id </h1>
     * <p>
     * Gets the Details of a Opportunity by Id
     * </p>
     * 
     * @param id           - Opportunity's Id to search the Opportunity
     *
     * @return Opportunity - Details of Opportunity
     */
    public Opportunity getById(int id) throws CustomException;

    /**
     * <h1> Update Details of Opportunity </h1>
     * <p>
     * Updates the Details of a Opportunity
     * </p>
     *
     * @param id           - key to update the Opportunity
     * @param Opportunity  - an updated Opportunity
     *  
     * @return boolean - status of the id
     */
    public boolean updateById(int id, String columnName, String columnValue);

    /**
     * <h1> Detele Details of Opportunity </h1>
     * <p>
     * Deletes the Details of a Opportunity
     * </p>
     *
     * @param id       - key to Delete the Opportunity
     *
     * @return boolean - Status of the Deleted Opportunity
     */
    public boolean isDeletedById(int id);
}