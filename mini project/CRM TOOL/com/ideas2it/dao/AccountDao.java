package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.Account;

/**
 * <h1> Account DAO </h1>
 * <p>
 * Gets the request and performs the operations
 * like Adding, Viewing, Updating the Details of Account
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public interface AccountDao {
 
    /**
     * <h1> Insert Account Details </h1>
     * <p>
     * Inserts the Details of account 
     * </p>
     *
     * @param accountId - Id of a account
     * @param account   - Details of account to add 
     *   
     * @return Account  - Details of account
     */
    public Account insert(String accountId, Account account);
}