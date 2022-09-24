package com.ideas2it.controller;

import com.ideas2it.service.CRMService;

/**
 * Controls the operation of the CRM Tool
 * Like validate user, exit
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 16-09-2022
 */
public class CRMController {
    private CRMService crmSevice;
    
    public CRMController() {
        this.crmService = new CRMService();
    }

    /**
     * Validates the login Details
     */
    public boolean loginUser(String email, String password) {
        return crmService.loginUser(email, password);
    }
}