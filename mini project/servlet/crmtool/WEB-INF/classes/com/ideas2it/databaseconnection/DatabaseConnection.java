package com.ideas2it.databaseconnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.ideas2it.constants.Constants;
import com.ideas2it.logger.CustomLogger;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection(){}

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            if (null == connection || connection.isClosed()) {
                connection = DriverManager.getConnection(Constants.URL, 
                                                         Constants.USERNAME, 
                                                         Constants.SQL_PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
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

