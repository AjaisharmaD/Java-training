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
    private static Map<String, Contact> contactMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact insert(String id, Contact contact) {
        contactMap.put(id, contact);
        return contactMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Contact> fetchAll() {
        if (!contactMap.isEmpty()) {
            return contactMap;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact fetchById(String id) {
        if (!contactMap.isEmpty()) {
            if (contactMap.containsKey(id)) {
                return contactMap.get(id);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact updateById(String id, Contact contact) {
        if (!contactMap.isEmpty()) {
            if (contactMap.containsKey(id)) {
                return contactMap.replace(id, contact);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact deleteById(String id) {
        if (!contactMap.isEmpty()) {
            if (contactMap.containsKey(id)) {
                return contactMap.remove(id);
            }
        }
        return null;
    }
}