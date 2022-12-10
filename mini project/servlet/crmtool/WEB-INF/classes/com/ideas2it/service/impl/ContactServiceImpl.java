package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.model.Contact;
import com.ideas2it.service.ContactService;
import com.ideas2it.dao.ContactDao;
import com.ideas2it.dao.impl.ContactDaoImpl;
import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
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
public class  ContactServiceImpl implements ContactService {
    private ContactDao contactDao;

    public ContactServiceImpl() {
        this.contactDao = new ContactDaoImpl();
    }

    /**
     * {@inherit}
     */
    public boolean create(Contact contact) {
       boolean status = true;

       if (contactDao.insert(contact) <= 0) {
           status = false;
       } 
       return status;
    } 

    /**
     * {@inherit}
     */
    public List<Contact> getAll(int userId) throws CustomException { 
        List<Contact> contacts = contactDao.fetchAll();

        if (!contacts.isEmpty()) {
            return contacts;  
        } else {
            throw new CustomException(Messages.CONTACT_NOT_FOUND); 
        }
    }

    /**
     * {@inherit}
     */
    public Contact getById(int id, int userId) throws CustomException {
        Contact contact = contactDao.fetchById(id);

        if (null != contact) {
            return contact;
        } else {
            throw new CustomException(Messages.CONTACT_NOT_FOUND); 
        }
    }

    /**
     * {@inherit}
     */
    public boolean updateById(Contact contact) {
        return (contactDao.updateById(contact) <= 0) ? false : true;
    }

    /**
     * {@inherit}
     */
    public boolean isDeletedById(int id) {
        return (contactDao.deleteById(id) <= 0) ? false : true;
    }
}