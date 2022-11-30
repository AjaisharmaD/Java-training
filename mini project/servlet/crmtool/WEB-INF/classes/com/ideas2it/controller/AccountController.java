package com.ideas2it.controller;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.List; 

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import com.ideas2it.constants.Messages;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Account;
import com.ideas2it.service.AccountService;

/**
 * <h1> Account Controller </h1>
 * <p>
 * Gets the request and return the responces
 * like Adding, Updating, Viewing, Searching, 
 * the details of Account
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class AccountController extends HttpServlet {
    private AccountService accountService;
    private CustomLogger logger;

    public AccountController() {
        this.accountService = new AccountService();
        this.logger = new CustomLogger(AccountController.class);
    }

    protected void doPost(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        String choice = request.getServletPath();
 
        switch (choice) {
        case "/create-account":
            create(request, response);
            break;

        case "/update-account":
            updateById(request, response);
            break;
        }
    }

    protected void doGet(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        String choice = request.getServletPath();
        
        switch (choice) {
        case "/get-accounts":
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
     * <h1> Create Account </h1>
     * <p>
     * Passes the Details of Account to Service
     * </p>
     *
     * @param account  - account details to add 
     *
     * @return int    - id of the account
     */
    private void create(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String website = request.getParameter("website");
        String type = request.getParameter("type");

        Account account = new Account(name, website, type);
        boolean isCreated = accountService.create(account);

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
     * <h1> Get Details of Accounts </h1>
     * <p>
     * Gets the Details of Accounts
     * </p>
     *
     * @return List - Details of Accounts
     */
    private void getAll(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Account> accounts = accountService.getAll();
            request.setAttribute("accounts", accounts);
            RequestDispatcher requestDispatcher = request
                                   .getRequestDispatcher("accountDashboard.jsp");
            requestDispatcher.include(request, response);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("accounts", Messages.USER_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                   .getRequestDispatcher("accountDashboard.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    } 

    /**
     * <h1> Get Details of Account by Id </h1>
     * <p>
     * Gets the Details of a Account by Id
     * </p>
     * 
     * @param id       - Account's Id to search the Account
     *
     * @return Account - Details of a Single Account
     */
    private void getById(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Account account = accountService.getById(id);
            request.setAttribute("account", account);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchAccount.jsp");
            requestDispatcher.forward(request, response);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("account", Messages.USER_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchAccount.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    /**
     * <h1> Get Details of Account by Id </h1>
     * <p>
     * Gets the Details of a Account by Id
     * </p>
     * 
     * @param id       - Account's Id to search the Account
     *
     * @return Account - Details of a Single Account
     */
    private void getByIdToUpdate(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Account account = accountService.getById(id);
            request.setAttribute("account", account);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchAccount.jsp");
            requestDispatcher.forward(request, response);
        } catch (NotFoundException userNotFoundException) {
            logger.error(userNotFoundException.getMessage());
            request.setAttribute("account", Messages.USER_NOT_FOUND);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchAccount.jsp");
            requestDispatcher.include(request, response);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    /**
     * <h1> Update Details of Account By Id </h1>
     * <p>
     * Updates the Details of a Single Account
     * </p>
     *
     * @param id       - key to update the Account
     * @param account  - updated Account 
     *
     * @return boolean - status of the account
     */
    private void updateById(HttpServletRequest request, 
          HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String website = request.getParameter("website");
        String type = request.getParameter("type");

        Account account = new Account(name, website, type);
        account.setId(id);
        boolean isUpdated = accountService.updateById(account);

        if (isUpdated) {
            request.setAttribute("status", Messages.UPDATED_SUCCESSFULLY);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("accountDashboard.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("status", Messages.FAILED_TO_UPDATE);
            RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("accountDashboard.jsp");
            requestDispatcher.include(request, response);
        }
    }

    /**
     * <h1> Detele Details of Account by Id</h1>
     * <p>
     * Deteles the Details of a Account
     * </p>
     *
     * @param id       - key to Detele the Account
     *
     * @return boolean - Status of the Delated Account
     */
    private  void deleteById(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean isDeleted = accountService.isDeletedById(id);

            if(isDeleted) {
                request.setAttribute("status", Messages.DELETED_SUCCESSFULLY);
                RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchUser.jsp");
                requestDispatcher.include(request, response);            
            } else {
                request.setAttribute("status", Messages.FAILED_TO_DELETE);
                RequestDispatcher requestDispatcher = request
                                      .getRequestDispatcher("searchUser.jsp");
                requestDispatcher.include(request, response);    
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }
    public boolean isDeletedById(int id) {
        return accountService.isDeletedById(id);
    }
}
