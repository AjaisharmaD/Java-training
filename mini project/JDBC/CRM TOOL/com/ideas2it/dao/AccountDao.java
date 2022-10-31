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
     * @param name      - name of a Account
     * @param account   - Details of Account to add 
     *   
     * @return Account  - Details of Account
     */
    public Account insert(String name, Account account);

    /**   
     * <h1> Get Details of Account </h1>
     * <p>
     * Gets the Details of Account
     * </p>  
     *
     * @return Map - Details of Accounts 
     */
    public Map<String, Account> fetchAll();

    /**
     * <h1> Get Details of Account by Id </h1>
     * <p>
     * Gets the Details of Account by Id
     * </p>
     * 
     * @param id    - Account's Id to search the Account
     *
     * @return Account - Details of single Account
     */
    public Account fetchById(String name);

    /**
     * <h1> Update Details of Account </h1>
     * <p>
     * Updates the Details of Account 
     * </p>
     *
     * @param id       - key to update the Account
     * @param Account  - updated Details of Account
     *
     * @return Account -  updated Details of Account
     */
     public Account updateById(String name, Account account);

    /**
     * <h1> Delete Details of Account </h1>
     * <p>
     * Deletes the Details of Account 
     * </p>
     *
     * @param id       - key to Remove the Details of Account
     *
     * @return Account -  Delated Details of Account
     */
    public Account deleteById(String name);
}