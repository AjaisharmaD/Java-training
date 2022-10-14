package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.dao.AccountDao;
import com.ideas2it.dao.impl.AccountDaoImpl;
import com.ideas2it.model.Account;

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
     * @return Account - account detail which is inserted into the Map
     */
    public Account create(Account account) {
       String name = account.getName();
       return accountDao.insert(name, account);
    } 

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Account
     * </p>
     *
     * @return List - Details of Account
     */
    public List<Account> getAll() {    
        List<Account> accounts = new ArrayList<>();

        if (!accountDao.fetchAll().isEmpty()) {
            for (Map.Entry<String, Account> accountEntry : accountDao.fetchAll().entrySet()) {
                accounts.add(accountEntry.getValue());
            }  
            return accounts;
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
     * @return Account - Details of Account
     */
    public Account getById(String id) {
        return accountDao.fetchById(id);
    }

    /**
     * <h1> Update Details of Account </h1>
     * <p>
     * Updates the Details of a Account
     * </p>
     *
     * @param id       - key to update the Account
     * @param account  - an updated Account
     *  
     * @return Account - Details of Single lead
     */
    public Account updateById(String id, Account account) {
        return accountDao.updateById(id, account);
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
    public boolean isDeletedById(String id) {
        if (accountDao.deleteById(id) != null) {
            return true;
        }
        return false;
    }
}