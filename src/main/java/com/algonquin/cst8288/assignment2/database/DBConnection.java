package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * This class is used to connect database
 * @author ryany
 */
public class DBConnection {
    

    /**
     * instance for Singleton
     */
    private static DBConnection instance = null;
    private static Connection conn = null;
    private static final LMSLogger logger = LMSLogger.getInstance();

    
    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
    private String userString = "CST8288";
    private String passwordString = "Assignment2";
    private String driverString = "com.mysql.cj.jdbc.Driver";
//    private String dbName = "bookvault";
    

    /**
     * Private constructor to prevent instantiation from outside
     */
    private DBConnection(){
        String logMessage;
        try {
            Class.forName(driverString);  // Load the MySQL JDBC driver
            conn = DriverManager.getConnection(serverUrl, userString, passwordString);  // Create the connection
            logMessage = "Success to connect Database.";
            logger.log(LogLevel.INFO, logMessage); 
            System.out.println(logMessage); 
        } catch (ClassNotFoundException | SQLException e) { 
            logMessage = "Failed to connect Database.";
            logger.log(LogLevel.INFO, logMessage); 
            System.out.println(logMessage); 
        }
    }

    /**
     * Public and static method to get the instance
     * @return 
     */
    public static DBConnection getInstance() {
        if (instance == null) {   // Ensure only one instance
            // Create a new instance
            instance = new DBConnection();
        }
        return instance;
    }

    /**
     * Get the connection
     * @return 
     */
    public Connection getConnection() {
        return conn;
    }
    
    /**
     * Close the connection
     */
    public static void closeConnection() {
        String logMessage;
        if (conn != null) {
            try {
                conn.close();
                logMessage = "Database connection closed successfully.";
                logger.log(LogLevel.INFO, logMessage); 
                System.out.println(logMessage);                
            } catch (SQLException e) {
                logMessage = "Failed to close Database connection.";
                logger.log(LogLevel.INFO, logMessage); 
                System.out.println(logMessage);  
            }
        }
    }	
}
