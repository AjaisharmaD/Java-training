package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.dao.UserDao;
import com.ideas2it.dao.impl.UserDaoImpl;
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

    public UserService() {
        this.userDao = new UserDaoImpl();
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
     * @return boolean - true if the Details of an user added otherwise false
     */
    public boolean create(User user, String password) {
        user.setPassword(password);
        return userDao.insert(user);
    }

    /**
     * <h1> Get Details of Users </h1>
     * <p>
     * Gets the Details of all Users
     * </p>
     *
     * @return List - Details of users
     */
    public List<User> getAll() {
        List<User> users = userDao.fetchAll();

        if(null != users) {
            return users;
        }
        return null;
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
    public User getById(int id) {
        return userDao.fetchById(id);
    }

    /**
     * <h1> Update Details of User </h1>
     * <p>
     * Updates the Details of a Single User
     * </p>
     *
     * @param id    - key to update the Details of User
     * @param user  - updated User Details
     *
     * @return boolean - status of the id
     */
    public boolean updateById(int id, String columnName, String columnValue) {
        return (userDao.updateById(id, columnName, columnValue) <= 0) ? false : true;

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
        return (userDao.deleteById(id) <= 0) ? false : true;
    }
}