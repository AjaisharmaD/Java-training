	package com.ideas2it.controller;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import com.ideas2it.exception.NotFoundException;
import com.ideas2it.service.CRMService;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.User;
import com.ideas2it.utils.ValidationUtils;

/**
 * <h1> CRM Controller </h1>
 * <p>
 * Controls the operation of the CRM Tool
 * Like validate user, exit
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   16-09-2022
 */
public class CRMController extends HttpServlet {
    private CRMService crmService;
    private CustomLogger logger;
    private ValidationUtils validationUtils;
    
    public CRMController() {
        this.crmService = new CRMService();
        this.logger = new CustomLogger(CRMController.class);
        this.validationUtils = new ValidationUtils();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        logger.info("inside crm controller");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = validUser(email, password);
            logger.info("user is not null and the user is"+user.toString());
        if (null != user) {
            request.setAttribute("name", user.getName());
            logger.info("user is not null and name of the user is"+user.getName());
            logger.info("user is not null and Id of the user is"+user.getId());
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            logger.info("session Userid is"+ session.getAttribute("userId").toString());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("moduleDashboard.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("status", "Wrong Credintials");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userLogin.jsp");
            requestDispatcher.include(request, response);
        }
    }

    /**
     * Validates the login Details
     */
    public User validUser(String email, String password) {
        User user = null;

        try {
            user = crmService.validUser(email, password);
        } catch(NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return user;
    }

    /**
     * <h1> Valid Email </h1>
     * <p>
     * This method will get the Email and checks whether the given Email is valid or not
     * </p>
     *
     * @param email    - Email of User 
     * @return boolean - Status of the Email Id
     */
    public boolean isValidEmailId(String emailId) {
        if (validationUtils.isValidEmailId(emailId)) {
            return true;
        }
        return false;
    }

    /**
     * <h1> Valid Password </h1>
     * <p>
     * This method will get the Password and checks whether the given Password is valid or not
     * </p>
     *
     * @param password - Company Name of User  
     * @return boolean - Status of the Company Name
     */
    public boolean isValidPassword(String password) {
        if (validationUtils.isValidPassword(password)) {
            return true;
        }
        return false;
    }
}