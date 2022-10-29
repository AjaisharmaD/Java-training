package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.dao.UserDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
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
    private static Map<String, String> passwordMap = new HashMap<>();
    private static Map<String, User> userMap = new HashMap<>();
    private Connection connection;
    private Statement statement;
    //private PreparedStatement preparedStatement;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insert(String userId, User user, String password) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String query = "INSERT INTO USER (name,email,phone_number,password)" 
                                     +"VALUES ('"+user.getName()+"','"
                                                +user.getEmailId()+"','"
                                                +user.getPhoneNumber()+"','"
                                                +password+"')";
            return statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> fetchAll() {
        User user;
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM USER";
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
       
            while (rs.next()) {
                user = new User(rs.getString(2),rs.getString(3),rs.getString(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return userList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User fetchById(String id) {
        if (!userMap.isEmpty()) {
            if (userMap.containsKey(id)) {
                return userMap.get(id);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateById(String id, User user) {
        if (!userMap.isEmpty()) {
            if (userMap.containsKey(id)) {
                return userMap.replace(id, user); 
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User deleteById(String id) {
        if (!userMap.isEmpty()) {
            if (userMap.containsKey(id)) {
                return userMap.remove(id);
            }
        }
        return null;
    }
}