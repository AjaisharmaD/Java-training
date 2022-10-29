package com.ideas2it.databaseconnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.ideas2it.constants.Constants;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection(){}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

