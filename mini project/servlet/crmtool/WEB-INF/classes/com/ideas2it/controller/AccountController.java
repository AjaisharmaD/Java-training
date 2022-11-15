package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.exception.NotFoundException;
import com.ideas2it.logger.CustomLogger;
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
    private CustomLogger logger;

    public AccountController() {
        this.accountService = new AccountService();
        this.logger = new CustomLogger(AccountController.class);
    }

    /**
     * <h1> Create Account </h1>
     * <p>
     * Passes the Details of Account to Service
     * </p>
     *
     * @param account  - account details to add 
     *
     * @return int    - id of the account
     */
    public int create(Account account) {
        return accountService.create(account);
    }


    /**   
     * <h1> Get Details of Accounts </h1>
     * <p>
     * Gets the Details of Accounts
     * </p>
     *
     * @return List - Details of Accounts
     */
    public List<Account> getAll() {
        try {
            return accountService.getAll();
        } catch (NotFoundException accountNotFoundException) {
            logger.error(accountNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;
    }    

    /**
     * <h1> Get Details of Account by Id </h1>
     * <p>
     * Gets the Details of a Account by Id
     * </p>
     * 
     * @param id       - Account's Id to search the Account
     *
     * @return Account - Details of a Single Account
     */
    public Account getById(int id) {
        try {
            return accountService.getById(id);
        } catch (NotFoundException accountNotFoundException) {
            logger.error(accountNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;
    }

    /**
     * <h1> Update Details of Account By Id </h1>
     * <p>
     * Updates the Details of a Single Account
     * </p>
     *
     * @param id       - key to update the Account
     * @param account  - updated Account 
     *
     * @return boolean - status of the account
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return accountService.updateById(id, columnName, columnValue);
    }

    /**
     * <h1> Detele Details of Account by Id</h1>
     * <p>
     * Deteles the Details of a Account
     * </p>
     *
     * @param id       - key to Detele the Account
     *
     * @return boolean - Status of the Delated Account
     */
    public boolean isDeletedById(int id) {
        return accountService.isDeletedById(id);
    }

}
