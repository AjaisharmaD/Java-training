package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.constants.Constants;
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
        logger.info("inside the insert User in Dao");
        int id = 0;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO user (name, email, phone,")
             .append(" password, role_id) VALUES (?, ?, ?, ?, ?);");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString()); 
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmailId());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getRoleId());
            int count = statement.executeUpdate();
          
            if (0 != count) {
                String query1 = "SELECT LAST_INSERT_ID();";
                statement = connection.prepareStatement(query1);
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                } 
            }
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return id;
    }

    @Override
    public User fetchByEmailAndPassword(String email, String password) {
        logger.info("inside the user dao fetch by email and password");
        logger.info("email " + email);
        logger.info("password " + password);

        StringBuilder query = new StringBuilder();
        query.append("SELECT id, name, email, phone,")
             .append("role_id FROM user WHERE email = ? AND password = ?;");
        User user = null;

        try {
            logger.info("getting user in dao");
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString()); 
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new User(resultSet.getString("name"),
                                     resultSet.getString("email"),
                                     resultSet.getString("phone"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setId(resultSet.getInt("id")); 
            } 
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> fetchAll(int roleId) {
        List<User> userList = new ArrayList<>();   
        StringBuilder query = new StringBuilder();

        try {
            connection = DatabaseConnection.getConnection();

            if (roleId == Constants.ADMIN_ROLE_ID) {
                query.append("SELECT id, name, email, phone,")
                     .append("password, created_on, role_id FROM user")
                     .append(" WHERE role_id != ? AND is_deleted = 0;");
                statement = connection.prepareStatement(query.toString());
                statement.setInt(1, roleId);
            } else if (roleId == Constants.MANAGER_ROLE_ID) {
                query.append("SELECT id, name, email, phone,")
                     .append("password, created_on, role_id FROM user")
                     .append(" WHERE role_id = ? AND is_deleted = 0;");
                statement = connection.prepareStatement(query.toString());
                statement.setInt(1, Constants.EMPLOYEE_ROLE_ID);
            }
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone"));
                user.setId(resultSet.getInt("id"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setCreatedDate(resultSet.getTimestamp("created_on").toString());
                userList.add(user);
            }
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return userList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> fetchRoles() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT id, name FROM user_role;");  
        List<String> roles = new ArrayList();                
 
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            String role;
            int id;

            while (resultSet.next()) {
                logger.info("getting the roles");
                role = resultSet.getString("name");
                id = resultSet.getInt("id");
                logger.info("id: " + id);
                logger.info("role: " + role);
                roles.add(role);
            }
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }

            logger.info("user dao" + roles.toString());
        return roles;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User fetchById(int id) {
        User user = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT id, name, email, phone,")
             .append("role_id, created_on FROM user WHERE id = ?;");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString());
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new User(resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone"));
                user.setId(resultSet.getInt("id"));
                user.setRoleId(resultSet.getInt("role_id"));
            } 
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(User user) {
        int rowCount = 0; 
        StringBuilder query = new StringBuilder();
        query.append("UPDATE user SET name = ?, email = ?,")
             .append("phone = ? WHERE id = ?;");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString());
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmailId());
            statement.setString(3, user.getPhoneNumber());
            statement.setInt(4, user.getId());
            rowCount = statement.executeUpdate();
            String s1 = String.valueOf(rowCount);
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
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
        String query = "UPDATE user SET is_deleted = 1 WHERE id = ?;";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return rowCount;
    }
}