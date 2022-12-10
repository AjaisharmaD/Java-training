package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Contact;
import com.ideas2it.exception.CustomException;

/**
 * <h1> Contact Service </h1>
 * <p>
 * Gets the Request and process the operatioin to be done
 * like adding, Viewing, Updating
 * the Details of contact
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public interface ContactService {

    /**
     * <h1> Create Contact </h1>
     * <p>
     * Creates the Details of contact 
     * </p>
     *
     * @param contact  - contact details to add 
     *
     * @return boolean - status of contact
     */
    public boolean create(Contact contact);

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all contact
     * </p>
     *
     * @return List - Details of Contact
     */
    public List<Contact> getAll(int userId) throws CustomException;

    /**
     * <h1> Get Details of contact by Id </h1>
     * <p>
     * Gets the Details of a contact by Id
     * </p>
     * 
     * @param id       - contact's Id to search the contact
     *
     * @return contact - Details of contact
     */
    public Contact getById(int id, int userId) throws CustomException;

    /**
     * <h1> Update Details of contact </h1>
     * <p>
     * Updates the Details of a contact
     * </p>
     *
     * @param id       - key to update the contact
     * @param contact  - an updated contact
     *  
     * @return boolean - status of contact
     */
    public boolean updateById(Contact contact);

    /**
     * <h1> Detele Details of contact </h1>
     * <p>
     * Deletes the Details of a contact
     * </p>
     *
     * @param id       - key to Delete the contact
     *
     * @return boolean - Status of the Deleted contact
     */
    public boolean isDeletedById(int id);
}