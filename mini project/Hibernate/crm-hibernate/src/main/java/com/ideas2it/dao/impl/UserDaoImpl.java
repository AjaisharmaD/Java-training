package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ideas2it.constants.Constants;
import com.ideas2it.dao.UserDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
import com.ideas2it.databaseconnection.HibernateConfig;
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
     private CustomLogger logger;

     public UserDaoImpl() {
         this.logger = new CustomLogger(UserDaoImpl.class);
     }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(User user) {
        logger.info("inside the insert User in Dao");
        Transaction transaction = null;
        int id = 0;

        try {
            Session session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = ((Long)session.save(user)).intValue();
            transaction.commit();
            session.close();
        } catch (Exception hibernateException) {
            transaction.rollback();
            logger.error(hibernateException.getMessage());
        } 
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User fetchByEmailAndPassword(String email, String password) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT id, name, email, phone,")
             .append(" role_id FROM user WHERE email = ? AND password = MD5(?);");
        User user = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query.toString()); 
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
        List<User> userList = new ArrayList<User>();   
        StringBuilder query = new StringBuilder();

        try {
            ResultSet resultSet ;
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement  statement = null;

            if (roleId == Constants.ADMIN_ROLE_ID) {
                query.append("SELECT id, name, email, phone,")
                     .append(" password, created_on, role_id FROM user")
                     .append(" WHERE role_id != ? AND is_deleted = 0;");
                statement = connection.prepareStatement(query.toString());
                statement.setInt(1, roleId);

            } else if (roleId == Constants.MANAGER_ROLE_ID) {
                query.append("SELECT id, name, email, phone,")
                     .append(" password, created_on, role_id FROM user")
                     .append(" WHERE role_id = ? AND is_deleted = 0;");
                statement = connection.prepareStatement(query.toString());
                statement.setInt(1, Constants.EMPLOYEE_ROLE_ID);
            }
            resultSet = statement.executeQuery();
       
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
        query.append("SELECT id, name FROM user_role WHERE id != ?;");  
        List<String> roles = new ArrayList();                
 
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query.toString());
            statement.setInt(1, Constants.ADMIN_ROLE_ID);
            ResultSet resultSet = statement.executeQuery();
            String role;
            int id;

            while (resultSet.next()) {
                role = resultSet.getString("name");
                id = resultSet.getInt("id");
                roles.add(role);
            }
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return roles;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User fetchById(int id) {
        Transaction transaction = null;
        User user = null;

        try {
            Session session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            transaction.rollback();
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateById(User user) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE user SET name = ?, email = ?,")
             .append(" phone = ?, role_id = ?, updated_on = now() WHERE id = ?;");

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query.toString());
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmailId());
            statement.setString(3, user.getPhoneNumber());
            statement.setInt(4, user.getRoleId());  
            statement.setInt(5, user.getId());       
            int rowCount = statement.executeUpdate();
         
            if (0 < rowCount) {
                user.setId(user.getId());
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
    public int deleteById(int id) {
        int rowCount = 0;
        String query = "UPDATE user SET is_deleted = 1 WHERE id = ?;";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
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