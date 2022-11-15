package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.dao.AccountDao;
import com.ideas2it.dao.impl.AccountDaoImpl;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.model.Account;
import com.ideas2it.model.User;

/**
 * <h1> Account Service </h1>
 * <p>
 * Gets the Request and process the operatioin to be done
 * like adding, Viewing, Updating
 * the Details of Account
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class  AccountService {
    private AccountDao accountDao;

    public AccountService() {
        this.accountDao = new AccountDaoImpl();
    }

    /**
     * <h1> Create Account </h1>
     * <p>
     * Creates the Details of Account 
     * </p>
     *
     * @param account  - account details to add 
     *
     * @return boolean - status of account
     */
    public int create(Account account) {
       return accountDao.insert(account);
    } 

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Account
     * </p>
     *
     * @return List - Details of Account
     */
    public List<Account> getAll() throws NotFoundException {   
        List<Account> accounts = accountDao.fetchAll();

        if (!accounts.isEmpty()) {
            return accounts;
        } else {
            throw new NotFoundException(Messages.ACCOUNT_NOT_FOUND);
        }
    }

    /**
     * <h1> Get Details of Account by Id </h1>
     * <p>
     * Gets the Details of a Account by Id
     * </p>
     * 
     * @param id       - Account's Id to search the Account
     *
     * @return Account - Details of Account
     */
    public Account getById(int id) throws NotFoundException {
        Account account = accountDao.fetchById(id);
        
        if (null != account) {
            return account;
        } else {
            throw new NotFoundException(Messages.ACCOUNT_NOT_FOUND);
        }
    }

    /**
     * <h1> Update Details of Account </h1>
     * <p>
     * Updates the Details of a Account
     * </p>
     *
     * @param id          - User id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *  
     * @return Account - Details of Single lead
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return (accountDao.updateById(id, columnName, columnValue) <= 0) 
                                                                 ? false 
                                                                 : true;
    }

    /**
     * <h1> Detele Details of Account </h1>
     * <p>
     * Deletes the Details of a Account
     * </p>
     *
     * @param id       - key to Delete the Account
     *
     * @return boolean - Status of the Deleted Account
     */
    public boolean isDeletedById(int id) {
        return (accountDao.deleteById(id) <= 0) ? false : true;
    }
}