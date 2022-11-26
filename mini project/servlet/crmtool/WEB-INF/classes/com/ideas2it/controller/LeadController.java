package com.ideas2it.controller;

import java.time.DateTimeException;
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
import com.ideas2it.model.Lead;
import com.ideas2it.service.LeadService;
import com.ideas2it.utils.ValidationUtils;

/**
 * <h1> Lead Controller </h1>
 * <p>
 * This class will get request and return the responces
 * like Adding, Updating, Viewing, Searching, Deleting
 * the details of Leads
 * </p> 
 *
 * @author  Ajaisharma D
 * @version 1.2
 * @since   24-08-2022
 */
public class LeadController extends HttpServlet {
    private LeadService leadService;
    private ValidationUtils validationUtils; 
    private CustomLogger logger;

    public LeadController() {
        this.leadService = new LeadService();
        this.validationUtils = new ValidationUtils();
        this.logger = new CustomLogger(LeadController.class);
    }

    protected void doPost(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        String choice = request.getServletPath();

        switch (choice) {
        case "/CreateLead":
            create(request, response);
            break;

        case "/UpdateUser":
            updateById(request, response);
            break;
        }
    }
       
    protected void doGet(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        String choice = request.getServletPath();
        logger.info(choice);

        logger.info("do get is running");
        
        switch (choice) {
        case "/leads":
        logger.info("calling get all leads");
            getAll(request, response);
            break;
 
        case "/Search":
            getById(request, response);
            break;

        case "/SearchToUpdate":
            getByIdToUpdate(request, response);
            break;

        case "/Delete":
            deleteById(request, response);
            break;
        }
    }

    /**
     * <h1> Create Lead </h1>
     * <p>
     * Passes the Details of Leads to Service
     * </p>
     *
     * @param lead     - lead Object to add 
     *
     * @return boolean - status of the lead
     */
    private void create(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String companyName = request.getParameter("companyName");
        String status = request.getParameter("status");
        int userId = Integer.parseInt(request.getParameter("userId"));
        boolean isCreated = leadService.create(new Lead(name, email, phone, companyName, status, userId));

        if (isCreated) {
            request.setAttribute("status", Messages.CREATED_SUCCESSFULLY);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("createLead.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("status", Messages.FAILED_TO_CREATE);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("createLead.jsp");
            requestDispatcher.include(request, response);
        }
    }

    /**   
     * <h1> Get Details of Leads </h1>
     * <p>
     * Gets the Details of Leads
     * </p>
     *
     * @return List - Details of Leads
     */

    private void getAll(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        logger.info("inside get all");

        try {
            HttpSession session = request.getSession();
            logger.info("after session created");
            String id = session.getAttribute("userId").toString();
            int userId = Integer.parserInt(id);
            logger.info("user Id to get All leads " +id);
            List<Lead> leads = leadService.getAll(userId);
    
            if(leads.isEmpty()){
                logger.info("leads is empty");
            } else { 
                logger.info("leads is not empty");
            }
            request.setAttribute("leads", leads);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("moduleDashboard.jsp");
            requestDispatcher.forward(request, response);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("leads", Messages.LEAD_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                   .getRequestDispatcher("moduleDashboard.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            request.setAttribute("leads", "Exception");
            RequestDispatcher requestDispatcher = request
                                   .getRequestDispatcher("moduleDashboard.jsp");
            requestDispatcher.include(request, response);
        }
    }    

    /**
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of a Single Lead by Id
     * </p>
     * 
     * @param id    - Lead's Id to search the lead
     *
     * @return Lead - Details of a Single Lead
     */
    private void getById(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            Lead lead = leadService.getById(id, userId);
            request.setAttribute("lead", lead);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchLead.jsp");
            requestDispatcher.forward(request, response);
        } catch (NotFoundException leadNotFoundException) {
            logger.error(leadNotFoundException.getMessage());
            request.setAttribute("lead", Messages.LEAD_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchLead.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    /**
     * <h1> Get Details of Lead by Id </h1>
     * <p>
     * Gets the Details of a Single Lead by Id
     * </p>
     * 
     * @param id    - Lead's Id to search the lead
     *
     * @return Lead - Details of a Single Lead
     */
    private void getByIdToUpdate(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            Lead lead = leadService.getById(id, userId);
            request.setAttribute("lead", lead);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateLead.jsp");
            requestDispatcher.include(request, response);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("lead", Messages.LEAD_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateLead.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    /**
     * <h1> Update Details of Lead By Id </h1>
     * <p>
     * Updates the Details of a Single Lead
     * </p>
     *
     * @param id          - Lead id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return lead - the Update details of lead
     */
    private void updateById(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String companyName = request.getParameter("companyName");
        String status = request.getParameter("status");
        int userId = Integer.parseInt(request.getParameter("userId"));
        Lead lead = new Lead(name, email, phone, companyName, status, userId);
        lead.setId(id);

        boolean isUpdated = leadService.updateById(lead);

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
     * <h1> Detele Details of Lead by Id</h1>
     * <p>
     * Deteles the Details of a Single Lead
     * </p>
     *
     * @param id       - key to Detele the Lead
     *
     * @return boolean - Status of the Delated Lead
     */
    private  void deleteById(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean isDeleted = leadService.isDeletedById(id);

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

    /**
     * <h1> Valid Name </h1>
     * <p>
     * Get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of Lead 
     * @return boolean - Status of Name
     */
    public boolean isValidName(String name) {
        if (validationUtils.isValidName(name)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Email Id </h1>
     * <p>
     * Get the Email Id and checks whether the given Email Id is valid or not
     * </p>
     *
     * @param email    - Email Id of Lead 
     * @return boolean - Status of Email Id
     */
    public boolean isValidEmailId(String emailId) {
        if (validationUtils.isValidEmailId(emailId)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Phone Number </h1>
     * <p>
     * Get the Phone Number and checks whether the given Phone Number is valid or not
     * </p>
     *
     * @param phoneNumber - Phone Number of Lead 
     * @return boolean    - Status of Phone Number
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        if (validationUtils.isValidPhoneNumber(phoneNumber)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Company Name </h1>
     * <p>
     * Get the Company Name and checks whether the given Company Name is valid or not
     * </p>
     *
     * @param companyName - Company Name of Lead 
     * @return boolean    - Status of Company Name
     */
    public boolean isValidCompanyName(String companyName) {
        if (validationUtils.isValidCompanyName(companyName)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Amount </h1>
     * <p>
     * Get the Amount and checks whether the given Amount is valid or not
     * </p>
     *
     * @param amount   - Amount of deal
     * @return boolean - Status of Amount
     */
    public boolean isValidAmount(String amount) {
        if (validationUtils.isValidAmount(amount)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Website </h1>
     * <p>
     * Get the Website and checks whether the given Website is valid or not
     * </p>
     *
     * @param website  - Website of Account for deal
     * @return boolean - Status of Website
     */
    public boolean isValidWebsite(String website) {
        if (validationUtils.isValidWebsite(website)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid ID </h1>
     * <p>
     * This method will get the Id and checks whether the given Id is valid or not
     * </p>
     *
     * @param id       - id to be Validated  
     * @return boolean  - Status of the Id

    public boolean isValidId(String id) {
        if (validationUtils.isValidId(id)) {
            return true;
        }
        return false;
    }
     */
}