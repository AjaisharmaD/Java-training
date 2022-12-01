package com.ideas2it.controller;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.List; 

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import com.ideas2it.constants.Messages;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.logger.CustomLogger;
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
public class ContactController extends HttpServlet {
    private ContactService contactService;
    private CustomLogger logger;

    public ContactController() {
        this.contactService = new ContactService();
        this.logger = new CustomLogger(ContactController.class);
    }

    protected void doPost(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        String choice = request.getServletPath();
 
        switch (choice) {
        case "/create-contact":
            create(request, response);
            break;

        case "/update-contact":
            updateById(request, response);
            break;
        }
    }

    protected void doGet(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        String choice = request.getServletPath();
        
        switch (choice) {
        case "/get-contacts":
            getAll(request, response);
            break;
 
        case "/search":
            getById(request, response);
            break;

        case "/search-to-update":
            getByIdToUpdate(request, response);
            break;

        case "/delete":
            deleteById(request, response);
            break;
        }
    }

    /**
     * <h1> Create Contact </h1>
     * <p>
     * Passes the Details of Contact to Service
     * </p>
     *
     * @param contact  - contact details to add 
     *
     * @return boolean - status of contact
     */
    private void create(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String accountName = request.getParameter("accountName");
        String role = request.getParameter("role");
 
        Contact contact = new Contact(name, email, phone, accountName, role);
        boolean isCreated = contactService.create(contact);

        if (isCreated) {
            request.setAttribute("status", Messages.CREATED_SUCCESSFULLY);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("createAccount.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("status", Messages.FAILED_TO_CREATE);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("createAccount.jsp");
            requestDispatcher.include(request, response);
        }
    }

    /**   
     * <h1> Get Details of contacts </h1>
     * <p>
     * Gets the Details of contacts
     * </p>
     *
     * @return List - Details of contacts
     */
    private void getAll(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            String id = session.getAttribute("userId").toString();
            int userId = Integer.parseInt(id);
            String name = request.getParameter("name");
            List<Contact> contacts = contactService.getAll(userId);
            request.setAttribute("contacts", contacts);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("contactDashboard.jsp");
            requestDispatcher.forward(request, response);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("message", Messages.CONTACT_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                   .getRequestDispatcher("contactDashboard.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            request.setAttribute("message", "Exception");
            RequestDispatcher requestDispatcher = request
                                   .getRequestDispatcher("conatactDashboard.jsp");
            requestDispatcher.include(request, response);
        }
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
    private void getById(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            Contact contact = contactService.getById(id, userId);
            request.setAttribute("contact", contact);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchContact.jsp");
            requestDispatcher.forward(request, response);
        } catch (NotFoundException leadNotFoundException) {
            logger.error(leadNotFoundException.getMessage());
            request.setAttribute("message", Messages.CONTACT_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchContact.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

   /*
    *
    * 
    */
    private void getByIdToUpdate(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            Contact contact = contactService.getById(id, userId);
            request.setAttribute("contact", contact);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateContact.jsp");
            requestDispatcher.include(request, response);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("lead", Messages.LEAD_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateConatct.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    /**
     * <h1> Update Details of contact By Id </h1>
     * <p>
     * Updates the Details of a Single contact
     * </p>
     *
     * @param id          - id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return boolean - updated status of contact
     */
    private void updateById(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String companyName = request.getParameter("companyName");
        String role = request.getParameter("status");
        int userId = Integer.parseInt(request.getParameter("userId"));
        Contact contact = new Contact(name, email, phone, companyName, role);
        contact.setId(id);

        boolean isUpdated = contactService.updateById(contact);

        if (isUpdated) {
            request.setAttribute("status", Messages.UPDATED_SUCCESSFULLY);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateLead.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("status", Messages.FAILED_TO_UPDATE);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateLead.jsp");
            requestDispatcher.include(request, response);
        }
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
    private  void deleteById(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean isDeleted = contactService.isDeletedById(id);

            if(isDeleted) {
                request.setAttribute("status", Messages.DELETED_SUCCESSFULLY);
                RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("deleteLead.jsp");
                requestDispatcher.include(request, response);            
            } else {
                request.setAttribute("status", Messages.FAILED_TO_DELETE);
                RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("deleteLead.jsp");
                requestDispatcher.include(request, response);    
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }
}
