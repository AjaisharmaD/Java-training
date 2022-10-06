package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.ContactDao;
import com.ideas2it.model.Contact;

/**
 * <h1> Contact DAO Impl </h1>
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
public class ContactDaoImpl implements ContactDao {
    private Map<String, Contact> contactMap;
    
    public ContactDaoImpl() {
        this.contactMap = new HashMap<>(); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact insert(String contactId, Contact contact) {
        contactMap.put(contactId, contact);
        return contactMap.get(contactId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Contact> fetchAll() {
        return contactMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact fetchById(String id) {
        if (contactMap.containsKey(id)) {
            return contactMap.get(id);
        } 
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact updateById(String id, Contact contact) {
        if (contactMap.containsKey(id)) {
            return contactMap.replace(id, contact);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact deleteById(String id) {
        if (contactMap.containsKey(id)) {
            return contactMap.remove(id);
        }
        return null;
    }
}