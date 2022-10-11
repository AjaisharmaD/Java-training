package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.UserDao;
import com.ideas2it.model.User;

/**
 * <h1> User DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Users
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   19-09-2022
 */
public class UserDaoImpl implements UserDao {
    private Map<String, String> passwordMap;
    private static Map<String, User> userMap;

    public UserDaoImpl() {
        this.passwordMap = new HashMap<>();
        this.userMap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User insert(String userId, User user, String password) {
        user.setId(userId);
        user.setPassword(password);
        //passwordMap.put(userId, password);
        userMap.put(userId, user);
        return userMap.get(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, User> fetchAll() {
        return userMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User fetchById(String id) {
        if (userMap.containsKey(id)) {
            return userMap.get(id);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateById(String id, User user) {
        if (userMap.containsKey(id)) {
            return userMap.replace(id, user); 
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User deleteById(String id) {
        if (userMap.containsKey(id)) {
            return userMap.remove(id);
        }
        return null;
    }
}