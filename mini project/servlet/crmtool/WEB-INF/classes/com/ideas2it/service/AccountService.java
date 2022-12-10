package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Account;
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
public interface AccountService {

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
    public boolean create(Account account);

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all Account
     * </p>
     *
     * @return List - Details of Account
     */
    public List<Account> getAll() throws CustomException;

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
    public Account getById(int id) throws CustomException;

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
    public boolean updateById(Account account);

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
    public boolean isDeletedById(int id);
}