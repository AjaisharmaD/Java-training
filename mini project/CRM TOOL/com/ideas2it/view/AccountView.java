package com.ideas2it.view;

import com.ideas2it.controller.AccountController;
import com.ideas2it.enums.Status;
import com.ideas2it.model.Account;
import com.ideas2it.model.Lead;

/**
 * <h1> Account View </h1>
 * <p>
 * Converts the Lead into Account who are qualified
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class AccountView {
    private AccountController accountController;

    public AccountView() {
        this.accountController = new AccountController();
    }

    /**
     * <h1> Convert To Account </h1>
     * <p>
     * Converts the lead into Account
     * </p>
     *
     * @param lead    - lead to convert as Account 
     * @return status - status of the Lead 
     */
    public String convertToAccount(Lead lead) {
        Account account = new Account();
        account.setName(lead.getCompanyName());
        account.setOwnerName(lead.getName());
        account.setEmailId(lead.getEmailId());
        account.setPhoneNumber(lead.getPhoneNumber());

        String status = accountController.create(account) != null 
                                 ? Status.Converted.toString()
                                 : "Failed";
        return status;
    }
}