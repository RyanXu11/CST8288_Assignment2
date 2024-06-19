package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


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

    
    private String url; // = "jdbc:mysql://localhost:3306/bookvault";
    private String username; //= "CST8288";
    private String password; // = "Assignment2";
    private String driverString = "com.mysql.cj.jdbc.Driver";
//    private String dbName = "bookvault";
    
    /**
     * This function is used to load database properties from database.properties
     * It equals setter
     */
    private void loadDBProp(){
          Properties props = new Properties();
        try {
           // get current directory
            String currentDirectory = System.getProperty("user.dir"); // It's project directory
            currentDirectory += "\\src\\main\\java\\com\\algonquin\\cst8288\\assignment2\\database"; // The file's directory
            // set the abslute path
            String propFilePath = currentDirectory + File.separator + "database.properties";
            InputStream in = Files.newInputStream(Paths.get(propFilePath));
            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.url = props.getProperty("jdbc.url");
        this.username = props.getProperty("jdbc.username");
        this.password = props.getProperty("jdbc.password");

        System.out.printf("%s\n%s\n%s\n", url, username, password);    
    }
    

    /**
     * Private constructor to prevent instantiation from outside
     */
    private DBConnection(){
        String logMessage;
        try {
            Class.forName(driverString);  // Load the MySQL JDBC driver
            loadDBProp();
            conn = DriverManager.getConnection(url, username, password);  // Create the connection
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
