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
 * Helps the User to login by validating their credentials
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
        logger.info("===== Inside CRM Controller DoPost =====");
        String path = request.getParameter("path");

        switch(path) {
        case Constants.LOGIN_PATH:
            logger.info("===== Calling the Login Method =====");
            login(request, response);
            break;
        default:
            logger.info("===== Redirecting to Error Page =====");
            response.sendRedirect("errorPage.jsp");
        }
    }

    /**
     * <h1> Login </h1>
     * <p>
     * Gets the EmailId and password parameter from the Request
     * Sends them to CRM Service to validate the User is valid or not
     * If the User is valid then gets the User Role and redirect them 
     * to the Corresponding pages, Else Prints the Corresponding Messages
     * </p>
     *
     * @param request - the request from the JSP which holds the data likes
                        parameters, servlet path, context path, etc,.
     * @param response - the response is used to hold the stream and writer 
     */
    public void login(HttpServletRequest request, 
                      HttpServletResponse response) throws IOException, 
                                                     ServletException {
        logger.info("===== Inside the Login Method =====");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        logger.info("email = " + email + "password = " + password);
        HttpSession session = request.getSession();

	try {
            User user = crmService.getUserByEmailAndPassword(email, password);

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
	} catch (CustomException customException) {
            request.setAttribute("message", customException.getMessage());
            RequestDispatcher requestDispatcher = request
                                       .getRequestDispatcher("index.jsp");
            requestDispatcher.include(request, response);
        } 
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