package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.AccountDao;
import com.ideas2it.model.Account;

/**
 * <h1> Account DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Leads
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class AccountDaoImpl implements AccountDao {
    private Map<String, Account> accountMap;
    
    public AccountDaoImpl() {
        this.accountMap = new HashMap<>(); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account insert(String accountId, Account account) {
        accountMap.put(accountId, account);
        return accountMap.get(accountId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Account> fetchAll() {
        return accountMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account fetchById(String id) {
        if (accountMap.containsKey(id)) {
            return accountMap.get(id);
        } 
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateById(String id, Account account) {
        if (accountMap.containsKey(id)) {
            return accountMap.replace(id, account);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account deleteById(String id) {
        if (accountMap.containsKey(id)) {
            return accountMap.remove(id);
        }
        return null;
    }
}