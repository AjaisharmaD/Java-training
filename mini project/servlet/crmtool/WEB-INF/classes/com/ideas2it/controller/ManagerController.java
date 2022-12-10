package com.ideas2it.controller;

import java.io.IOException;
import java.util.List; 

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.ideas2it.model.Lead;
import com.ideas2it.model.User;
import com.ideas2it.service.LeadService;
import com.ideas2it.service.impl.LeadServiceImpl;
import com.ideas2it.service.UserService;
import com.ideas2it.service.impl.UserServiceImpl;
import com.ideas2it.utils.ValidationUtils;
import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;
import com.ideas2it.logger.CustomLogger;

/**
 * <h1> User Controller </h1>
 * <p>
 * Gets request from the valid user then gets all the users details
 * and redirected to admin dashboard or manager dashboard. 
 * From those dashboards gets the request from the manager
 * and return the responses like Adding, Updating, Viewing, Searching,
 * Deleting the Details of User.
 * Assigns a lead to a specific Employee.
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   07-12-2022
 */
public class ManagerController extends HttpServlet {
    private UserService userService;
    private LeadService leadService;
    private ValidationUtils validationUtils;
    private CustomLogger logger;
    
    public ManagerController() {
        this.userService = new UserServiceImpl();
        this.leadService = new LeadServiceImpl();
        this.validationUtils = new ValidationUtils();
        this.logger = new CustomLogger(UserController.class);
    }

    /**
     * <h1> Do Post </h1>
     * <p>
     * A Http Servlet's Do post is used to handle a POST request
     * This allows the Client to send data by hidding them from the url.
     * </p>
     *
     * @param request - the request from the JSP which holds the data like 
                        parameters, servlet path, context path, etc,.
     * @param response - the response is used to hold the stream and writer  
     */
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) throws IOException,
                                                         ServletException {
        String path = request.getParameter("path");
        String choice = request.getServletPath();
 
        switch (choice) {
        case "/create-manager":
            create(request, response);
            break;

        case "/update-manager":
            updateById(request, response);
            break;

        case "/get-managers":
            getAll(request, response);
            break;
        }
    }

    /**
     * <h1> Do Get </h1>
     * <p>
     * A HTTP Servlet Do Get is used to handle GET request
     * This allows to get the information from the Server
     * </p>
     *
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) throws IOException, 
                                                        ServletException {
        String choice = request.getServletPath();
        
        switch (choice) {
        case "/get-managers":
            getAll(request, response);
            break;
 
        case "/search-user":
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
     * <h1> Create User </h1>
     * <p>
     * Adds the user by getting their name, email, phone etc
     * from the Admin or The Manager,
     * First validates the inputs,
     * Checks whether the user role is Employee or Manager the creates 
     * the User account and sends the Message as Status to the Display
     * </p>
     *
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    private void create(HttpServletRequest request,
                        HttpServletResponse response) throws IOException, 
                                                       ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        int roleId = 0;
        logger.info("role:- " + role);

        try {
            roleId = Integer.valueOf(role) + 1;
        } catch (NumberFormatException numberFormatException) {
            logger.error(numberFormatException.toString());
        }
 
        logger.info("role ID" + roleId);
        User user = new User(name, email, phone);
        user.setPassword(password);

        //if (role.equals(Constants.MANAGER_ROLE)) {
            user.setRoleId(roleId);
        //} else if (role.equals(Constants.EMPLOYEE_ROLE)) {
          //  user.setRoleId(Constants.EMPLOYEE_ROLE_ID);
        //}
        logger.info("role id -" + user.getRoleId());
        boolean isCreated = userService.create(user);

        if (isCreated) {
            logger.info(Messages.CREATED_SUCCESSFULLY);
            request.setAttribute("status", Messages.CREATED_SUCCESSFULLY);
            RequestDispatcher requestDispatcher = request
                                .getRequestDispatcher("adminDashboard.jsp");
            requestDispatcher.include(request, response);
        } else {
            logger.info(Messages.FAILED_TO_CREATE);
            request.setAttribute("status", Messages.FAILED_TO_CREATE);
            RequestDispatcher requestDispatcher = request
                                .getRequestDispatcher("adminDashboard.jsp");
            requestDispatcher.include(request, response);
        }
    }

    /**
     * <h1> Get All Users </h1>
     * <p>
     * If the user is Admin then it will gets all the Users Details
     * Who are Managers and Employees or else 
     * If the user is Manager then Gets all the Employees Details
     * If users Not Found then Displays the Users Not Found Message
     * </p>
     *
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    private void getAll(HttpServletRequest request,
                        HttpServletResponse response) throws IOException, 
                                                       ServletException {
        logger.info("getting all users");
        HttpSession session = request.getSession();
        int roleId = Integer.parseInt(session.getAttribute("roleId").toString());

        List<User> users;

        if (roleId == Constants.ADMIN_ROLE_ID) { 
            try {
                logger.info("logged in as admin...");         //Covert to method
                users = userService.getAll(roleId);
                request.setAttribute("users", users);
                RequestDispatcher requestDispatcher = request
                                       .getRequestDispatcher("adminDashboard.jsp");
                requestDispatcher.include(request, response);
            } catch (CustomException userNotFoundException) {
                logger.info(Messages.USER_NOT_FOUND);
                logger.error(userNotFoundException.getMessage());
                request.setAttribute("status", Messages.USER_NOT_FOUND);
                RequestDispatcher requestDispatcher = request
                                    .getRequestDispatcher("adminDashboard.jsp");
                requestDispatcher.include(request, response);
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        } else if (roleId == Constants.MANAGER_ROLE_ID) {
            try {
                logger.info("logged in as manager....");
                users = userService.getAll(roleId);
                request.setAttribute("users", users);
                RequestDispatcher requestDispatcher = request
                                    .getRequestDispatcher("managerDashboard.jsp");
                requestDispatcher.include(request, response);
            } catch (CustomException userNotFoundException) {
                logger.info(Messages.USER_NOT_FOUND);
                logger.error(userNotFoundException.getMessage());
                request.setAttribute("status", Messages.USER_NOT_FOUND);
                RequestDispatcher requestDispatcher = request
                                   .getRequestDispatcher("managerDashboard.jsp");
                requestDispatcher.include(request, response);
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        } 
    }

    /**
     * <h1> Get User By Id </h1>
     * <p>
     * Gets the Details of the User By their Id 
     * Admin can search Managers and Employees By the Id of the Manager or Employee
     * But a Manager can Search only the Employees By the Id od Employee
     * If manager or Employee not found then 
     * Displays the User Not Found Message
     * </p>
     *
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    private void getById(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, 
                                                        ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.getById(id);
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request
                                .getRequestDispatcher("searchUser.jsp");
            requestDispatcher.forward(request, response);
        } catch (CustomException userNotFoundException) {
            logger.info(Messages.USER_NOT_FOUND);
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("message", Messages.USER_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                .getRequestDispatcher("searchUser.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    /**
     * <h1> Updates the User by their </h1>
     * <p>
     * Gets the Details of a User by Id
     * </p>
     *
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    private void getByIdToUpdate(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException,
                                                                ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.getById(id);

            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateUser.jsp");
            requestDispatcher.include(request, response);
        } catch (CustomException userNotFoundException) {
            logger.info(Messages.USER_NOT_FOUND);
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("user", Messages.USER_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("updateUser.jsp");
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
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    private Lead getLeadById(int id,int userId) {
        try {
            return leadService.getById(id,userId);
        } catch (CustomException leadNotFoundException) {
            logger.error(leadNotFoundException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return null;        
    }

    /**
     * <h1> Update Details of User </h1>
     * <p>
     * Updates the Details of a Single User
     * </p>
     *
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    private void updateById(HttpServletRequest request, 
                            HttpServletResponse response) throws IOException, 
                                                           ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User(name, email, phone);
        user.setId(id);
        boolean isUpdated = userService.updateById(user);

        if (isUpdated) {
            request.setAttribute("status", Messages.UPDATED_SUCCESSFULLY);
            RequestDispatcher requestDispatcher = request
                                    .getRequestDispatcher("userDashboard.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("status", Messages.FAILED_TO_UPDATE);
            RequestDispatcher requestDispatcher = request
                                    .getRequestDispatcher("userDashboard.jsp");
            requestDispatcher.include(request, response);
        }
    }

    /**
     * <h1> Remove Details of User by Id</h1>
     * <p>
     * Removes the Details of a Single User
     * </p>
     *
     * @param request - Used to pass parameter
     * @param response - Used to provides the stream and writer 
     */
    private  void deleteById(HttpServletRequest request,
         		     HttpServletResponse response) throws IOException, 
							    ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean isDeleted = userService.isDeletedById(id);

            if(isDeleted) {
                logger.info(Messages.DELETED_SUCCESSFULLY);
                request.setAttribute("status", Messages.DELETED_SUCCESSFULLY);
                RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchUser.jsp");
                requestDispatcher.include(request, response);            
            } else {
                logger.info(Messages.FAILED_TO_DELETE);
                request.setAttribute("status", Messages.FAILED_TO_DELETE);
                RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchUser.jsp");
                requestDispatcher.include(request, response);    
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    /**
     * <h1> Valid Name </h1>
     * <p>
     * This method will get the Name and checks whether the given Name is valid or not
     * </p>
     *
     * @param name     - Name of User  
     * @return boolean - Status of the Name
     */
    public boolean isValidName(String name) {
        return validationUtils.isValidName(name);
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
        return validationUtils.isValidEmailId(emailId);
    }

    /**
     * <h1> Valid Phone Number </h1>
     * <p>
     * This method will get the Phone Number and checks whether the given Phone Number is valid or not
     * </p>
     *
     * @param phoneNumber - Phone Number of User  
     * @return boolean    - Status of the Phone Number
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        return validationUtils.isValidPhoneNumber(phoneNumber);
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
        return validationUtils.isValidPassword(password);
    }
}