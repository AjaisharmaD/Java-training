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
    private static Map<String, Account> accountMap = new HashMap<>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Account insert(String name, Account account) {
        accountMap.put(name, account);
        return accountMap.get(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Account> fetchAll() {
        if (null != accountMap) {
            return accountMap;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account fetchById(String name) {
        if (null != accountMap) {
            if (accountMap.containsKey(name)) {
                return accountMap.get(name);
            }
        } 
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateById(String name, Account account) {
        if (null != accountMap) {
            if (accountMap.containsKey(name)) {
                return accountMap.replace(name, account);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account deleteById(String name) {
        if (null != accountMap) {
            if (accountMap.containsKey(name)) {
                return accountMap.remove(name);
            }
        }
        return null;
    }
}