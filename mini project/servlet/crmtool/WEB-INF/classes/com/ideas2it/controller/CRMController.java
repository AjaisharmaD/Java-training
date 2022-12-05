package com.ideas2it.controller;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import com.ideas2it.constants.Constants;
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

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws IOException, 
                                                      ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = validUser(email, password);

        if (user != null) {
            if (user.roleId() == Constants.ADMIN_ROLE_ID) {
                HttpSession session = request.getSession();
                session.setAttribute(userId, user.getId());
                session.setAttribute(roleId, user.getRollId());
                response.sendRedirect("get-users");
            } else if (user.getRoleId() == constants.MANAGER_ROLE_ID) {
                HttpSession session = request.getSession();
                session.setAttribute(userId, user.getId());
                session.setAttribute(roleId, user.getRollId());
                response.sendRedirect("get-employees");
            } else if (user.getRoleId() == Constants.EMPLOYEE_ROLE_ID) {
                HttpSession session = request.getSession();
                session.setAttribute(userId, user.getId());
                session.setAttribute(roleId, user.getRollId());
                response.sendRedirect("get-leads");
            }
        } else {
                request.setAttribute("message", "Email or Password is Incorrect");
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
     * Gets the Email and checks whether 
     * the given Email is valid or not
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
     * gets the Password and checks whether 
     * the given Password is valid or not
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