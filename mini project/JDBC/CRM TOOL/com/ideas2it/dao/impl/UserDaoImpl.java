package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.dao.UserDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
import com.ideas2it.logger.CustomLogger;
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
     private PreparedStatement statement; 
     private CustomLogger logger;

     public UserDaoImpl() {
         logger = new CustomLogger(UserDaoImpl.class);
     }
 

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(User user) {
        int count = 0;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("INSERT INTO user (name,"
                            +"email,phone_number,password) VALUES (?,?,?,?)"); 
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmailId());
            statement.setString(3,user.getPhoneNumber());
            statement.setString(4,user.getPassword());
            count = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            logger.error("@ SQL user create");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> fetchAll() {
        ResultSet resultSet = null;
        User user;
        List<User> userList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM user");
            resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
                user = new User(resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone_number"));
                user.setIsDeleted(resultSet.getBoolean("is_deleted"));
                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getString("password"));
                userList.add(user);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            logger.error("@ SQL user get all");
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
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM user WHERE id =?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new User(resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone_number"));
                user.setIsDeleted(resultSet.getBoolean("is_deleted"));
                user.setId(resultSet.getInt("id"));
            } 
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            logger.error("@ SQL user get by id");
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
        int rowCount = 0; 
        String query = "UPDATE user SET "+columnName+" = ? WHERE id = ?";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);

            if (columnName.equals("user_id")) {
                statement.setInt(1,Integer.parseInt(columnValue));
                statement.setInt(2,id);
                rowCount = statement.executeUpdate();
            } else {
                statement.setString(1,columnValue);
                statement.setInt(2,id);
                rowCount = statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException exception) {
            logger.error("@ SQL user update");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return rowCount;
    }	

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) {
        int rowCount = 0;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("UPDATE user SET is_deleted = 1 WHERE id = ?");
            statement.setInt(1,id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            logger.error("@ SQL user delete");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return rowCount;
    }
}