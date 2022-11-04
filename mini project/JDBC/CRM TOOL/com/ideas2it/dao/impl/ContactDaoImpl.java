package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.dao.ContactDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
import com.ideas2it.model.Contact;

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
     Connection connection;
     PreparedStatement statement; 

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(Contact contact) {
        int count = 0;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("INSERT INTO contact (name,"
                            +"email,phone,role,account_id,account_name) VALUES (?,?,?,?,?,?)"); 
            statement.setString(1,contact.getName());
            statement.setString(2,contact.getEmailId());
            statement.setString(3,contact.getPhoneNumber());
            statement.setString(4,contact.getRole());
            statement.setInt(5,contact.getAccountId());
            statement.setString(6,contact.getAccountName());
            count = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception);
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

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM contact");
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
            resultSet.close();
        } catch (SQLException exception) {
            System.out.println(exception);
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

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM contact WHERE id =?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            
            if (null != resultSet) {
                while(resultSet.next()) {
                contact = new Contact(resultSet.getString("name"),
                                      resultSet.getString("email"),
                                      resultSet.getString("phone"),
                                      resultSet.getString("account_name"),
                                      resultSet.getString("role"));
                    contact.setId(resultSet.getInt("id"));
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            System.out.println(exception);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return contact;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(int id, String columnName, String columnValue) {
        int rowCount = 0; 
        String query = "UPDATE contact SET "+columnName+" = ? WHERE id = ?";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,columnValue);
            statement.setInt(2,id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception);
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
            statement = connection.prepareStatement("DELETE FROM contact WHERE id = ?");
            statement.setInt(1,id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception);
        } finally {
            DatabaseConnection.closeConnection();
        }
        return rowCount;
    }
}