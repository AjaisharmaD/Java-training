package com.ideas2it.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import com.ideas2it.model.User;
import com.ideas2it.service.CRMService;
import com.ideas2it.service.impl.CRMServiceImpl;
import com.ideas2it.utils.ValidationUtils;
import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;
import com.ideas2it.logger.CustomLogger;

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
        this.crmService = new CRMServiceImpl();
        this.logger = new CustomLogger(CRMController.class);
        this.validationUtils = new ValidationUtils();
    }

    /**
     * <h1> Do Post </h1>
     * <p>
     * A Http Servlet's Do post is used to handle a POST request
     * This allows the Client to send data by hidding them from the url.
     * </p>
     *
     * @param request - the request from the JSP which holds the data likes
                        parameters, servlet path, context path, etc,.
     * @param response - the response is used to hold the stream and writer  
     */
    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws IOException, 
                                                      ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        logger.info("email = " + email + "password = " + password);
        User user = getValidUser(email, password);
        HttpSession session = request.getSession();

        if ( null != user ) {
            if (user.getRoleId() == Constants.ADMIN_ROLE_ID) {
                session.setAttribute("userId", user.getId());
                session.setAttribute("roleId", user.getRoleId());
                response.sendRedirect("get-users");
            } else if (user.getRoleId() == Constants.MANAGER_ROLE_ID) {
                session.setAttribute("userId", user.getId());
                session.setAttribute("roleId", user.getRoleId());
                response.sendRedirect("get-employees");
            } else if (user.getRoleId() == Constants.EMPLOYEE_ROLE_ID) {
                session.setAttribute("userId", user.getId());
                session.setAttribute("roleId", user.getRoleId());
                response.sendRedirect("get-leads");
            }
        } else {
                request.setAttribute("message", Messages.USER_NOT_FOUND);
                RequestDispatcher requestDispatcher = request
                                       .getRequestDispatcher("index.jsp");
                requestDispatcher.include(request, response);
        } 
    }

    /**
     * <h1> Get valid user </h1>
     * <p>
     * The getValidUser passes the email and password to the service 
     * to check whether the User is present or not
     * If the user is present then returns the object of the user else null 
     *
     *
     * @param email - Email Id of the User to login
     * @param password - Password of the User to login
     *
     * @return User - Object of the user or null object
     */
    public User getValidUser(String email, String password) {
        User user = null;

        try {
            user = crmService.getUserByEmailAndPassword(email, password);
        } catch(CustomException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return user;
    }

    /**
     * <h1> Valid Email </h1>
     * <p>
     * Gets the Email and checks whether 
     * the given Email is valid or not
     * </p>
     *
     * @param email    - Email of User 
     * @return boolean - Status of the Email Id
     */
    public boolean isValidEmailId(String emailId) {
        return validationUtils.isValidEmailId(emailId);
    }

    /**
     * <h1> Valid Password </h1>
     * <p>
     * gets the Password and checks whether 
     * the given Password is valid or not
     * </p>
     *
     * @param password - Company Name of User  
     * @return boolean - Status of the Company Name
     */
    public boolean isValidPassword(String password) {
        return validationUtils.isValidPassword(password);
    }
}