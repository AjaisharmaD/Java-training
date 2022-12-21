package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.model.Opportunity;
import com.ideas2it.dao.OpportunityDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
import com.ideas2it.logger.CustomLogger;

/**
 * <h1> Opportunity DAO Impl </h1>
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
public class OpportunityDaoImpl implements OpportunityDao {
     private Connection connection;
     private PreparedStatement statement;    
     private CustomLogger logger;

     public OpportunityDaoImpl() {
         logger = new CustomLogger(OpportunityDaoImpl.class);
     }

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(Opportunity opportunity) {
        int count = 0;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO opportunity (name, ")
             .append("amount, stage, account_id) VALUES (?, ?, ?, ?);");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString()); 
            statement.setString(1,opportunity.getName());
            statement.setDouble(2,opportunity.getAmount());
            statement.setString(3,opportunity.getStage());
            statement.setInt(4,opportunity.getAccountId());
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
    public List<Opportunity> fetchAll() {
        ResultSet resultSet = null;
        Opportunity opportunity;
        List<Opportunity> opportunityList = new ArrayList<>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT id, name, amount, statge FROM opportunity;");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                opportunity = new Opportunity(resultSet.getString("name"),
                                              resultSet.getDouble("amount"),
                                              resultSet.getString("stage"));
                opportunity.setId(resultSet.getInt("id"));
                opportunityList.add(opportunity);
            } 
            statement.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return opportunityList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Opportunity fetchById(int id) {
        ResultSet resultSet = null;
        Opportunity opportunity = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT id, name, amount, statge")
             .append("FROM opportunity WHERE id = ?;");

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query.toString());
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                opportunity = new Opportunity(resultSet.getString("name"),
                                              resultSet.getDouble("amount"),
                                              resultSet.getString("stage"));
                opportunity.setId(resultSet.getInt("id"));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return opportunity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(int id, String columnName, String columnValue) {
        int rowCount = 0; 
        String query = "UPDATE opportunity SET "+columnName+" = ? WHERE id = ?;";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,columnValue);
            statement.setInt(2,id);
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
        String query = "DELETE FROM opportunity WHERE id = ?;";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
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