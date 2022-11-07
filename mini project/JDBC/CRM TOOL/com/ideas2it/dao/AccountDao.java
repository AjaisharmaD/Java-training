package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.exception.NotFoundException;
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
     * @param account  - Details of Account to add 
     *   
     * @return int     - id of the account inserted  
     */
    public int insert(Account account);

    /**   
     * <h1> Get Details of Account </h1>
     * <p>
     * Gets the Details of Account
     * </p>  
     *
     * @return List - list of account
     */
    public List<Account> fetchAll() throws NotFoundException;

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
    public Account fetchById(int id) throws NotFoundException;

    /**
     * <h1> Update Details of Account </h1>
     * <p>
     * Updates the Details of Account 
     * </p>
     *
     * @param id          - Account id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return int        - count of rows affected
     */
     public int updateById(int id, String columnName, String columnValue);

    /**
     * <h1> Delete Details of Account </h1>
     * <p>
     * Deletes the Details of Account 
     * </p>
     *
     * @param id   - id to delete the account
     * @return int - count of rows affected
     */
    public int deleteById(int id);
}