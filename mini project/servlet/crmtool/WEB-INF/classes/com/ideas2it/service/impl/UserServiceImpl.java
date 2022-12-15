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
     * {@inheritDoc}
     */
    @Override
    public User create(User user) {
        logger.info("===== Inside the User Service Create =====");
        return userDao.insert(user); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAll(int roleId) throws CustomException {
        logger.info("===== Inside the User Service Get All =====");
        List<User> userList = userDao.fetchAll(roleId);

        if (userList.isEmpty()) {
            throw new CustomException(Messages.USER_NOT_FOUND);
        } 
        return userList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getRoles() {
        logger.info("===== Inside the user service Get Role =====");
        List<String> roles = userDao.fetchRoles();

        if (!roles.isEmpty()) {
            return roles;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        logger.info("===== Inside get user by Email =====");
        return userDao.fetchByEmailAndPassword(email, password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getById(int id) {
        User user = userDao.fetchById(id);
       
        if (null == user) {
            return null;
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateById(User user) {
        logger.info("===== Inside User Service Update by Id =====");
        return userDao.updateById(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDeletedById(int id) {
        logger.info("===== Inside User Service Delete By Id =====");
        return userDao.deleteById(id) > 0;
    }
}