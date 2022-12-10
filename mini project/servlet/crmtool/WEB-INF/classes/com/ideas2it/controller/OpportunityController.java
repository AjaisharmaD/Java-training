package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Opportunity;
import com.ideas2it.service.OpportunityService;
import com.ideas2it.service.impl.OpportunityServiceImpl;
import com.ideas2it.exception.CustomException;
import com.ideas2it.logger.CustomLogger;

/**
 * <h1> Opportunity Controller </h1>
 * <p>
 * Gets the request and return the responces
 * like Adding, Updating, Viewing, Searching, 
 * the details of Opportunity
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   07-10-2022
 */
public class OpportunityController {
    private OpportunityService opportunityService;
    private CustomLogger logger;

    public OpportunityController() {
        this.opportunityService = new OpportunityServiceImpl();
        this.logger = new CustomLogger(OpportunityController.class);
    }

    /**
     * <h1> Create Opportunity </h1>
     * <p>
     * Passes the Details of Opportunity to Service
     * </p>
     *
     * @param Opportunity  - Opportunity details to add 
     *
     * @return boolean - status of opportuntiy
     */
    public boolean create(Opportunity opportunity) {
        return opportunityService.create(opportunity);
    }

    /**   
     * <h1> Get Details of Opportunitys </h1>
     * <p>
     * Gets the Details of Opportunitys
     * </p>
     *
     * @return List - Details of Opportunitys
     */
    public List<Opportunity> getAll() {
        try {
            return opportunityService.getAll();
        } catch(CustomException opportunityNotFoundException) {
            logger.error(opportunityNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;
    }    

    /**
     * <h1> Get Details of Opportunity by Id </h1>
     * <p>
     * Gets the Details of a Opportunity by Id
     * </p>
     * 
     * @param id           - Opportunity's Id to search the Opportunity
     *
     * @return Opportunity - Details of a Single Opportunity
     */
    public Opportunity getById(int id) {
        try {
            return opportunityService.getById(id);
        } catch(CustomException opportunityNotFoundException) {
            logger.error(opportunityNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;
    }

    /**
     * <h1> Update Details of Opportunity By Id </h1>
     * <p>
     * Updates the Details of a Single Opportunity
     * </p>
     *
     * @param id           - key to update the Opportunity
     * @param opportunity  - updated Opportunity 
     *
     * @return boolean - status of opportuntiy
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return opportunityService.updateById(id, columnName, columnValue);
    }

    /**
     * <h1> Detele Details of Opportunity by Id</h1>
     * <p>
     * Deteles the Details of a Opportunity
     * </p>
     *
     * @param id       - key to Detele the Opportunity
     *
     * @return boolean - Status of the Delated Opportunity
     */
    public boolean isDeletedById(int id) {
        return opportunityService.isDeletedById(id);
    }
}
