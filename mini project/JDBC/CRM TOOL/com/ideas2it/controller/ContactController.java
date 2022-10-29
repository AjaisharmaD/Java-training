package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Contact;
import com.ideas2it.service.ContactService;

/**
 * <h1> Contact Controller </h1>
 * <p>
 * Gets the request and return the responces
 * like Adding, Updating, Viewing, Searching, 
 * the details of Contact
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   06-10-2022
 */
public class ContactController {
    private ContactService contactService;

    public ContactController() {
        this.contactService = new ContactService();
    }

    /**
     * <h1> Create Contact </h1>
     * <p>
     * Passes the Details of Contact to Service
     * </p>
     *
     * @param contact  - contact details to add 
     *
     * @return Contact - Details of a added Contact
     */
    public Contact create(Contact contact) {
        return contactService.create(contact);
    }


    /**   
     * <h1> Get Details of contacts </h1>
     * <p>
     * Gets the Details of contacts
     * </p>
     *
     * @return List - Details of contacts
     */
    public List<Contact> getAll() {
        return contactService.getAll();
    }    

    /**
     * <h1> Get Details of contact by Id </h1>
     * <p>
     * Gets the Details of a contact by Id
     * </p>
     * 
     * @param id       - contact's Id to search the contact
     *
     * @return contact - Details of a Single contact
     */
    public Contact getById(String id) {
        return contactService.getById(id);
    }

    /**
     * <h1> Update Details of contact By Id </h1>
     * <p>
     * Updates the Details of a Single contact
     * </p>
     *
     * @param id       - key to update the contact
     * @param contact  - updated contact 
     *
     * @return Contact - the Update details of contact
     */
    public Contact updateById(String id, Contact contact) {
        return contactService.updateById(id, contact);
    }

    /**
     * <h1> Detele Details of contact by Id</h1>
     * <p>
     * Deteles the Details of a contact
     * </p>
     *
     * @param id       - key to Detele the contact
     *
     * @return boolean - Status of the Delated contact
     */
    public boolean isDeletedById(String id) {
        return contactService.isDeletedById(id);
    }

}
