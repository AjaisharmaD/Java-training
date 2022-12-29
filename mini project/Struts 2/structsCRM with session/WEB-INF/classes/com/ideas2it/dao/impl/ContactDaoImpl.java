package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.model.Contact;
import com.ideas2it.dao.ContactDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
import com.ideas2it.logger.CustomLogger;

/**
 * <h1> Contact DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Leads
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   03-10-2022
 */
public class ContactDaoImpl implements ContactDao {
     private Connection connection;
     private PreparedStatement statement; 
     private CustomLogger logger;

     public ContactDaoImpl() {
         logger = new CustomLogger(ContactDaoImpl.class);
     }

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(Contact contact) {
        int count = 0;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO contact (name,")
             .append("email,phone,role,account_id,")
             .append("account_name) VALUES (?,?,?,?,?,?)");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString()); 
            statement.setString(1,contact.getName());
            statement.setString(2,contact.getEmailId());
            statement.setString(3,contact.getPhoneNumber());
            statement.setString(4,contact.getRole());
            statement.setInt(5,contact.getAccountId());
            statement.setString(6,contact.getAccountName());
            count = statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Contact> fetchAll() {
        ResultSet resultSet = null;
        Contact contact;
        List<Contact> contactList = new ArrayList<>();
        String query = "SELECT * FROM contact";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
           
            while (resultSet.next()) {
                contact = new Contact(resultSet.getString("name"),
                                      resultSet.getString("email"),
                                      resultSet.getString("phone"),
                                      resultSet.getString("account_name"),
                                      resultSet.getString("role"));
                contact.setId(resultSet.getInt("id"));
                contactList.add(contact);
            }
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return contactList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contact fetchById(int id) {
        ResultSet resultSet = null;
        Contact contact = null;
        String query = "SELECT * FROM contact WHERE id =?";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                contact = new Contact(resultSet.getString("name"),
                                      resultSet.getString("email"),
                                      resultSet.getString("phone"),
                                      resultSet.getString("account_name"),
                                      resultSet.getString("role"));
                contact.setId(resultSet.getInt("id"));
            } 
            statement.close();
            resultSet.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return contact;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(Contact contact) {
        int rowCount = 0; 
        String query = "UPDATE contact SET name = ?, email = ?, phone = ?,  role = ?, account_id = ? WHERE id = ?";
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getEmailId());
            statement.setString(3, contact.getPhoneNumber());
            statement.setString(5, contact.getRole());
            statement.setInt(6, contact.getAccountId());
            statement.setInt(7, contact.getId());
            rowCount = statement.executeUpdate();
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
        String query = "DELETE FROM contact WHERE id = ?";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
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