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
    private static int idCount = 0;
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    /**
     * <h1> Id generator </h1>
     * <p>
     * Generates the Id for User
     * </p>
     * 
     * @return String - generated Id
     */
    private String generateId() {
        return Constants.EMPLOYEE_ID + (++idCount);   
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
    public User create(User user, String password) {
        return userDao.insert(generateId(), user, password);
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
        Map<String, User> map = userDao.fetchAll();
        
        if (null != map) {
            List<User> user = new ArrayList<>(map.values());
            return user;
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
    public User getById(String id) {
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
     * @return User - Details of a Single User
     */
    public User updateById(String id, User user) {
        return userDao.updateById(id, user);
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
    public boolean isDeletedById(String id) {
        if (userDao.deleteById(id) != null) {
            return true;
        }
        return false;
    }
}