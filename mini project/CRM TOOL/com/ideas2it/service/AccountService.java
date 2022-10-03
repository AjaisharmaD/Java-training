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
    private static int idCount = 0;
    private AccountDao accountDao;

    public AccountService() {
        this.accountDao = new AccountDaoImpl();
    }

    /**
     * <h1> Id generator </h1>
     * <p>
     * Generates the Id for Account
     * </p>
     * 
     * @return String - generated Id
     */
    private String generateId() {   
        return Constants.ACCOUNT_ID + (++idCount);  
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
       return accountDao.insert(generateId(), account);
    } 
}