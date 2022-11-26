package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.dao.LeadDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Lead;

/**
 * <h1> Lead DAO Impl </h1>
 * <p>
 * This class will Implements all the operations
 * like Adding, Viewing, Updating, Deleting the Details of Leads
 * by Stores and fetching the data
 * </p> 
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   19-09-2022
 */
public class LeadDaoImpl implements LeadDao {
     private Connection connection;
     private PreparedStatement statement; 
     private CustomLogger logger; 

     public LeadDaoImpl() {
         logger = new CustomLogger(LeadDaoImpl.class);
     }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(Lead lead) {
        int count = 0;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO lead_info (name,")
             .append("email, phone_number, company_name, status,")
             .append("user_id, created_by) VALUES (?, ?, ?, ?, ?, ?, ?)");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString()); 
            statement.setString(1, lead.getName());
            statement.setString(2, lead.getEmailId());
            statement.setString(3, lead.getPhoneNumber());
            statement.setString(4, lead.getCompanyName());
            statement.setString(5, lead.getStatus());
            statement.setInt(6, lead.getUserId());
            statement.setInt(7, lead.getUserId());
            count = statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.toString());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Lead> fetchAll(int id) {
        ResultSet resultSet = null;
        Lead lead;
        List<Lead> leadList = new ArrayList<>();
        String query = "SELECT * FROM lead_info where user_id = ?";
        logger.error("lead dao is running");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
           
            while (resultSet.next()) {
                lead = new Lead(resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone_number"),
                                resultSet.getString("company_name"),
                                resultSet.getString("status"),
                                resultSet.getInt("user_id"));
                lead.setCreatedDate(resultSet.getString("created_date_time"));
                lead.setId(resultSet.getInt("id"));
                leadList.add(lead);
            } 
            statement.close();
            resultSet.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.toString());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return leadList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lead fetchById(int id) {
        ResultSet resultSet = null;
        Lead lead = null;
        String query = "SELECT * FROM lead_info WHERE user_id =?";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                lead = new Lead(resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone_number"),
                                resultSet.getString("company_name"),
                                resultSet.getString("status"),
                                resultSet.getInt("user_id"));
                lead.setId(resultSet.getInt("id"));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.toString());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return lead;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(Lead lead) {
        int rowCount = 0; 
        StringBuilder query = new StringBuilder();       
        query.append("UPDATE lead_info SET name = ?, email=?,")
             .append("phone_number=?, company_name=?, status=?,")
             .append("updated_date_time = now() WHERE id = ?");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString());
            statement.setString(1, lead.getName());
            statement.setString(2, lead.getEmailId());
            statement.setString(3, lead.getPhoneNumber());
            statement.setString(4, lead.getCompanyName());
            statement.setString(5, lead.getStatus());
            statement.setInt(6, lead.getId());
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.toString());
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
        String query = "DELETE FROM lead_info WHERE id = ?";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.toString());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return rowCount;
    }
}