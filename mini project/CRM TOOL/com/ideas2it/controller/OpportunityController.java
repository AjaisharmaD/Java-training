package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Opportunity;
import com.ideas2it.service.OpportunityService;

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

    public OpportunityController() {
        this.opportunityService = new OpportunityService();
    }

    /**
     * <h1> Create Opportunity </h1>
     * <p>
     * Passes the Details of Opportunity to Service
     * </p>
     *
     * @param Opportunity  - Opportunity details to add 
     *
     * @return Opportunity - Details of a added Opportunity
     */
    public Opportunity create(Opportunity opportunity) {
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
        return opportunityService.getAll();
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
    public Opportunity getById(String id) {
        return opportunityService.getById(id);
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
     * @return Opportunity - the Update details of Opportunity
     */
    public Opportunity updateById(String id, Opportunity opportunity) {
        return opportunityService.updateById(id, opportunity);
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
    public boolean isDeletedById(String id) {
        return opportunityService.isDeletedById(id);
    }

}
