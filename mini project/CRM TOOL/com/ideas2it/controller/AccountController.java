package com.ideas2it.controller;

import com.ideas2it.model.Account;
import com.ideas2it.service.AccountService;

/**
 * <h1> Account Controller </h1>
 * <p>
 * Gets the request and return the responces
 * like Adding, Updating, Viewing, Searching, 
 * the details of Account
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class AccountController {
    private AccountService accountService;

    public AccountController() {
        this.accountService = new AccountService();
    }

    /**
     * <h1> Create Account </h1>
     * <p>
     * Passes the Details of Account to Service
     * </p>
     *
     * @param account  - account details to add 
     *
     * @return Account - Details of a added account
     */
    public Account create(Account account) {
        return accountService.create(account);
    }

}
