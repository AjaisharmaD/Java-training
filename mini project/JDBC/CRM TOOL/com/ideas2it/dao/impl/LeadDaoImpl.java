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

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("INSERT INTO lead_info (name,"
                            +"email,phone_number,company_name,status,user_id,created_by) VALUES (?,?,?,?,?,?,?)"); 
            statement.setString(1,lead.getName());
            statement.setString(2,lead.getEmailId());
            statement.setString(3,lead.getPhoneNumber());
            statement.setString(4,lead.getCompanyName());
            statement.setString(5,lead.getStatus());
            statement.setInt(6,lead.getUserId());
            statement.setInt(7,lead.getUserId());
            count = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            System.out.println("@SQL LEAD Create");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Lead> fetchAll() {
        ResultSet resultSet = null;
        Lead lead;
        List<Lead> leadList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM lead_info");
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
        } catch (SQLException exception) {
            System.out.println("@ SQL lead get all");
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

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM lead_info WHERE id =?");
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
        } catch (SQLException exception) {
            System.out.println("@ SQL lead get by id");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return lead;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(int id, String columnName, String columnValue) {
        int rowCount = 0; 
        String query = "UPDATE lead_info SET "+columnName+" = ?, updated_date_time = now() WHERE id = ?";
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,columnValue);
            statement.setInt(2,id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            System.out.println("@ SQL lead update ");
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
            statement = connection.prepareStatement("DELETE FROM lead_info WHERE id = ?");
            statement.setInt(1,id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            System.out.println("@ SQL lead delete");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return rowCount;
    }
}