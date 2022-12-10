package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.model.User;
import com.ideas2it.service.UserService;
import com.ideas2it.dao.UserDao;
import com.ideas2it.dao.impl.UserDaoImpl;
import com.ideas2it.constants.Constants;
import com.ideas2it.constants.Messages;
import com.ideas2it.exception.CustomException;
import com.ideas2it.logger.CustomLogger;

/**
 * <h1> User Service Impl </h1>
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
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private CustomLogger logger;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
        this.logger = new CustomLogger(UserService.class);
    }

    /**
     * {@inherit}
     */
    public boolean create(User user) {
        return (userDao.insert(user) > 0);
    }

    /**
     * {@inherit}
     */
    public List<User> getAll(int roleId) throws CustomException {
        List<User> userList = userDao.fetchAll(roleId);

        if(!userList.isEmpty()) {
            logger.info(userList.toString());
            return userList;
        } else {
            throw new CustomException(Messages.USER_NOT_FOUND);
        }
    }

    /**
     * {@inherit}
     */
    public List<String> getRoles() {
        List<String> roles = userDao.fetchRoles();

        if (!roles.isEmpty()) {
        logger.info("user service " + roles.toString());
            return roles;
        }
        return null;
    }

    /**
     * {@inherit}
     */
    public User getByEmailAndPassword(String email, String password) {
        return userDao.fetchByEmailAndPassword(email, password);
    }

    /**
     * {@inherit}
     */
    public User getById(int id) throws CustomException {
        User user = userDao.fetchById(id);
       
        if (null != user) {
            return user;
        } else {
            throw new CustomException(Messages.USER_NOT_FOUND);
        } 
    }

    /**
     * {@inherit}
     */
    public boolean updateById(User user) {
        return (userDao.updateById(user) <= 0) ? false : true;
    }

    /**
     * {@inherit}
     */
    public boolean isDeletedById(int id) {
        return (userDao.deleteById(id) <= 0) ? false : true;
    }
}