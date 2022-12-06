package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.dao.UserDao;
import com.ideas2it.dao.impl.UserDaoImpl;
import com.ideas2it.exception.NotFoundException;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.User;

/**
 * <h1> User Service </h1>
 * <p>
 * This class will get the Request and process the operatioin to be done
 * like adding, Viewing, Updating, Deleting
 * the Details of  Users
 * </p>
 * 
 * @author  Ajaisharma D
 * @version 1.0  
 * @since   19-09-2022
 */
public class UserService {
    private UserDao userDao;
    private CustomLogger logger;

    public UserService() {
        this.userDao = new UserDaoImpl();
        logger = new CustomLogger(UserService.class);
    }

    /**
     * <h1> Add User </h1>
     * <p>
     * Adds the Details of Users 
     * </p>
     *
     * @param user     - Details of User to add 
     * @param password - password to login
     *
     * @return boolean - status of the user 
     */
    public boolean create(User user) {
        logger.info("User service create is running");
        boolean status = true;

        if (userDao.insert(user) <= 0) {
            status = false;
        }
        return status;
    }

    /**
     * <h1> Get Details of Users </h1>
     * <p>
     * Gets the Details of all Users
     * </p>
     *
     * @return List - Details of users
     */
    public List<User> getAll(int roleId) throws NotFoundException {
        logger.info("user service get all user....");
        List<User> userList = userDao.fetchAll(roleId);

        if(!userList.isEmpty()) {
            logger.info("got the user from dao in service");
            return userList;
        } else {
            logger.info("user list is empty in user service");
            throw new NotFoundException(Messages.USER_NOT_FOUND);
        }
    }

    /**
     * <h1> Get the user by Email and password </h1>
     * <p> 
     * Gets the user Details by Email and Password 
     * and passes it to Validate the User is valid or not
     * </p>
     * 
     * @param email - email Id of the User
     * @param password - password of the User
     *
     * @return User - Details of the User
     */
    public User getByEmailAndPassword(String email, String password) {
        logger.info("inside user service get by email and password");
        return userDao.fetchByEmailAndPassword(email, password);
    }

    /**
     * <h1> Get Details of User by Id </h1>
     * <p>
     * Gets the Details of a Single User by Id
     * </p>
     * 
     * @param id    - User's Id to search the Details of User
     *
     * @return user - Details of a Single User
     */
    public User getById(int id) throws NotFoundException {
        logger.info("user service get user by id");
        User user = userDao.fetchById(id);
       
        if (null != user) {
            return user;
        } else {
            throw new NotFoundException(Messages.USER_NOT_FOUND);
        } 
    }

    /**
     * <h1> Update Details of User </h1>
     * <p>
     * Updates the Details of a Single User
     * </p>
     *
     * @param id          - User id to update the Detail
     * @param columnName  - name of the Column to update the Value
     * @param columnValue - value to be updated in Column
     *
     * @return boolean - status of the id
     */
    public boolean updateById(User user) {
        logger.info("user service update user");
        return (userDao.updateById(user) <= 0) ? false : true;
    }

    /**
     * <h1> Delete Details of User </h1>
     * <p>
     * Deletes the Details of a Single User
     * </p>
     *
     * @param id       - key to Delete the User
     *
     * @return boolean - true if the Details of User are Deleted otherwise false
     */
    public boolean isDeletedById(int id) {
        logger.info("user service delete user by id");
        return (userDao.deleteById(id) <= 0) ? false : true;
    }
}