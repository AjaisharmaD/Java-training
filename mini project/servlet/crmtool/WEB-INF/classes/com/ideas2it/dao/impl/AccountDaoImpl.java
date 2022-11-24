package com.ideas2it.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.dao.AccountDao;
import com.ideas2it.databaseconnection.DatabaseConnection;
import com.ideas2it.logger.CustomLogger;
import com.ideas2it.model.Account;

/**
 * <h1> Account DAO Impl </h1>
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
public class AccountDaoImpl implements AccountDao {
     private Connection connection;
     private PreparedStatement statement;      
     private CustomLogger logger;

     public AccountDaoImpl() {
         logger = new CustomLogger(AccountDaoImpl.class);
     }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(Account account) {
        int id = 0;
        PreparedStatement preparedStatement;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("INSERT INTO account (name,"
                            +"website,type) VALUES (?,?,?)"); 
            statement.setString(1,account.getName());
            statement.setString(2,account.getWebsite());
            statement.setString(3,account.getType());
            statement.execute();

            preparedStatement = connection.prepareStatement("SELECT MAX(id) FROM account");
            ResultSet resultSet = preparedStatement.executeQuery();
 
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            statement.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            logger.error("@ SQL Account create");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Account> fetchAll() {
        ResultSet resultSet = null;
        Account account;
        List<Account> accountList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM account");
            resultSet = statement.executeQuery();

            System.out.println(resultSet);
 
            while (resultSet.next()) {
                account = new Account(resultSet.getString("name"),
                                      resultSet.getString("website"),
                                      resultSet.getString("type"));
                account.setId(resultSet.getInt("id"));
                accountList.add(account);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            logger.error("@ SQL Account Get All");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return accountList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account fetchById(int id) {
        ResultSet resultSet = null;
        Account account = null;

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement("SELECT * FROM account WHERE id =?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                account = new Account(resultSet.getString("name"),
                                      resultSet.getString("website"),
                                      resultSet.getString("type"));
                account.setId(resultSet.getInt("id"));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException exception) {
            logger.error("@ SQL Account Get By Id");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return account;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateById(Account account) {
        int rowCount = 0; 
        String query = "UPDATE account SET name = ?, website = ?, type = ? WHERE id = ?";

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, account.getName());
            statement.setString(2, account.getWebsite());
            statement.setString(3, account.getType());
            statement.setInt(4, account.getId());
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            logger.error("@SQL Account update");
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
            statement = connection.prepareStatement("DELETE FROM account WHERE id = ?");
            statement.setInt(1,id);
            rowCount = statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            logger.error("@SQL account Delete");
        } finally {
            DatabaseConnection.closeConnection();
        }
        return rowCount;
    }
}