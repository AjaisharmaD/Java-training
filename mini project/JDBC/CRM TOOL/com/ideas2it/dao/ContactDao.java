package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.Contact;

/**
 * <h1> Contact DAO </h1>
 * <p>
 * Gets the request and performs the operations
 * like Adding, Viewing, Updating the Details of Contact
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public interface ContactDao {
 
    /**
     * <h1> Insert Contact Details </h1>
     * <p>
     * Inserts the Details of Contact 
     * </p>
     *
     * @param Contact   - Details of Contact to add 
     *   
     * @return int   - count of row/s affected
     */
    public int insert(Contact contact);

    /**   
     * <h1> Get Details of contact </h1>
     * <p>
     * Gets the Details of contact
     * </p>  
     *
     * @return List - list of Contact Details
     */
    public List<Contact> fetchAll();

    /**
     * <h1> Get Details of Contact by Id </h1>
     * <p>
     * Gets the Details of Contact by Id
     * </p>
     * 
     * @param id       - Contact's Id to search the Contact
     *
     * @return Contact - Details of a Contact
     */
    public Contact fetchById(int id);

    /**
     * <h1> Update Details of Contact </h1>
     * <p>
     * Updates the Details of Contact 
     * </p>
     *
     * @param id          - User id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return int        - count of rows affected
     */
     public int updateById(int id, String columnName, String columnValue);

    /**
     * <h1> Delete Details of Contact </h1>
     * <p>
     * Deletes the Details of Contact 
     * </p>
     *
     * @param id   - key to Remove the Details of Contact
     *
     * @return int - count of rows affected
     */
    public int deleteById(int id);
}