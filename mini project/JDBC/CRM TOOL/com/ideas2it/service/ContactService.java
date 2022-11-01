package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.dao.ContactDao;
import com.ideas2it.dao.impl.ContactDaoImpl;
import com.ideas2it.model.Contact;

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
public class  ContactService {
    private ContactDao contactDao;

    public ContactService() {
        this.contactDao = new ContactDaoImpl();
    }

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
    public boolean create(Contact contact) {
       return contactDao.insert(contact);
    } 

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of all contact
     * </p>
     *
     * @return List - Details of Contact
     */
    public List<Contact> getAll() {  
        List<Contact> contacts = contactDao.fetchAll();

        if (null != contacts) {
            return contacts;  
        }
        return null;
    }

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
    public Contact getById(int id) {
        return contactDao.fetchById(id);
    }

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
    public boolean updateById(int id, String columnName, String columnValue) {
        return (contactDao.updateById(id, columnName, columnValue) <= 0) ? false : true;
    }

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
    public boolean isDeletedById(int id) {
        return (contactDao.deleteById(id) <= 0) ? false : true;
    }
}