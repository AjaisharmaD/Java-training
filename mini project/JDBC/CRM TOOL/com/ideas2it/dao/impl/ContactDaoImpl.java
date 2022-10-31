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
    private static Map<Integer, Contact> contactMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact insert(int id, Contact contact) {
        contactMap.put(id, contact);
        return contactMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Integer, Contact> fetchAll() {
        if (null != contactMap) {
            return contactMap;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact fetchById(int id) {
        if (null != contactMap) {
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
    public Contact updateById(int id, Contact contact) {
        if (null != contactMap) {
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
    public Contact deleteById(int id) {
        if (null != contactMap) {
            if (contactMap.containsKey(id)) {
                return contactMap.remove(id);
            }
        }
        return null;
    }
}