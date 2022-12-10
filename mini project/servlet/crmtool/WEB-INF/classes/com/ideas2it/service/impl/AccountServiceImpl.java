package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Account;
import com.ideas2it.model.User;
import com.ideas2it.service.AccountService;
import com.ideas2it.dao.AccountDao;
import com.ideas2it.dao.impl.AccountDaoImpl;
import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;

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
public class  AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl() {
        this.accountDao = new AccountDaoImpl();
    }

    /**
     * {@inherit}
     */
    public boolean create(Account account) {
       return (accountDao.insert(account) <= 0) ? false : true;
    } 

    /**
     * {@inherit}
     */
    public List<Account> getAll() throws CustomException {   
        List<Account> accounts = accountDao.fetchAll();

        if (!accounts.isEmpty()) {
            return accounts;
        } else {
            throw new CustomException(Messages.ACCOUNT_NOT_FOUND);
        }
    }

    /**
     * {@inherit}
     */
    public Account getById(int id) throws CustomException {
        Account account = accountDao.fetchById(id);
        
        if (null != account) {
            return account;
        } else {
            throw new CustomException(Messages.ACCOUNT_NOT_FOUND);
        }
    }

    /**
     * {@inherit}
     */
    public boolean updateById(Account account) {
        return (accountDao.updateById(account) <= 0) ? false : true;
    }

    /**
     * {@inherit}
     */
    public boolean isDeletedById(int id) {
        return (accountDao.deleteById(id) <= 0) ? false : true;
    }
}