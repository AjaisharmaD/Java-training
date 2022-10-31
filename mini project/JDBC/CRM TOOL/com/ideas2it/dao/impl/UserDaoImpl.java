package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

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
    private Connection connection;
    private Statement statement;
    //private PreparedStatement preparedStatement;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insert(User user) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String query = "INSERT INTO user (name,email,phone_number,password)" 
                                    +"VALUES ('"+user.getName()+"','"
                                                +user.getEmailId()+"','"
                                                +user.getPhoneNumber()+"','"
                                                +user.getPassword()+"')";
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
        String query = "SELECT * FROM user";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
       
            while (rs.next()) {
                user = new User(rs.getString("name"),rs.getString("email"),rs.getString("phone_number"));
                user.setId(rs.getInt("id"));
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
    public User fetchById(int id) {
        User user = null;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM user WHERE id ="+id;
            ResultSet rs = statement.executeQuery(query);
            
            if (null != rs) {
                while(rs.next()) {
                    user = new User(rs.getString("name"),rs.getString("email"),rs.getString("phone_number"));
                    user.setId(rs.getInt("id"));
                }
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(int id, String columnName, String columnValue) {
        int status = 0;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String query = "UPDATE user SET "+columnName+" = '"+columnValue+"' WHERE id = "+id;
            status = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) {
        int status = 0;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String query = "DELETE FROM user WHERE id = "+id;
            status = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return status;
    }
}