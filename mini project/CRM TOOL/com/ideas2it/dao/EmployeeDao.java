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
     * @param lead - lead Object to add 
     *   
     * @return returns boolean
     */
    public boolean addLead(String leadId, Lead lead);

    /**   
     * Gets all the lead's details  
     *
     * @return returns nothing
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
     * Updates the Name of the Lead
     *
     * @param id - key to update the name
     * @param leadName - updated name
     *
     * @return boolean
     */
     public boolean updateName(String id, String leadName);

    /**
     * Updates the Email id of the Lead
     *
     * @param id - key to update the Email id
     * @param leadEmail - updated mail id to store
     *
     * @return boolean
     */
     public boolean updateEmail(String id, String leadEmail);

    /**
     * Updates the PhoneNumber of the Lead
     *
     * @param id - key to update the Phone Number 
     * @param leadPhoneNumber - updated Phone Number to store
     *
     * @return boolean
     */
     public boolean updatePhoneNumber(String id, String leadPhoneNumber);

    /**
     * Updates the Stage of the Lead
     *
     * @param id - key to update the Stage
     * @param leadStage - updated Stage
     *
     * @return boolean
     */
     public boolean updateStage(String id, String leadStage);

    /**
     * Updates the Company Name of the Lead
     *
     * @param id - key to update the Company Name
     * @param leadCompanyName - updated Company Name
     *
     * @return boolean
     */
     public boolean updateCompanyName(String id, String leadCompanyName);

    /**
     * Updates the Start Date of the Lead
     *
     * @param id - key to update the Start Date
     * @param leadStartDate - updated Start Date
     *
     * @return boolean
     */
     public boolean updateStartDate(String id, String leadStartDate);

    /**
     * Updates the End Date of the Lead
     *
     * @param id - key to update the End Date
     * @param leadEndDate - updated End Date
     *
     * @return boolean
     */
     public boolean updateEndDate(String id, String leadEndDate);

    /**
     * Updates the Deal Size of the Lead
     *
     * @param id - key to update the Deal Size
     * @param leadDealSize - updated Deal Size
     *
     * @return boolean
     */
     public boolean updateDealSize(String id, int leadDealSize);

    /**
     * deletes the Lead by id
     *
     * @param id- key to delete the Lead
     *
     * @return boolean
     */
    public boolean deleteLeadById(String id);
}