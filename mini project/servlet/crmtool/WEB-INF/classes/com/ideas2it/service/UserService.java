package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.dao.UserDao;
import com.ideas2it.dao.impl.UserDaoImpl;
import com.ideas2it.exception.NotFoundException;
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
     * @return boolean - status of the user 
     */
    public boolean create(User user) {
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
    public List<User> getAll() throws NotFoundException {
        List<User> userList = userDao.fetchAll();
        List<User> users = new ArrayList<>();

        if(!userList.isEmpty()) { 
            for (User user : userList) {
                if (!user.getIsDeleted()) {
                     users.add(user);
                }
            }
        } else {
            throw new NotFoundException(Messages.USER_NOT_FOUND);
        }
        return users;
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
        User user = userDao.fetchById(id);
       
        if (null != user) {
            if(!user.getIsDeleted()) {
                return user;
            }
        } else {
            throw new NotFoundException(Messages.USER_NOT_FOUND);
        } 
        return null;
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