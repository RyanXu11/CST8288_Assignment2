package com.algonquin.cst8288.assignment2.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author ryany
 */
public class LMSLogger {
    
    private PrintWriter writer;
    private static final String LOG_FILE = "bookvault.log";
    private static LMSLogger instance = null;

    /**
     * For Singleton, the constructor should be private
     */
    private LMSLogger() {
        try {
            // get current directory
            String currentDirectory = System.getProperty("user.dir"); // It's project directory, not LMSLogger.java's directory
            
            currentDirectory += "\\src\\main\\java\\com\\algonquin\\cst8288\\assignment2\\logger"; // The LMSLogger's directory
            // set the abslute path for log file
            String logFilePath = currentDirectory + File.separator + LOG_FILE;
            
            writer = new PrintWriter(new FileWriter(logFilePath, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Make sure it's Singleton, use synchronized for double check
     * @return 
     */
    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    /**
     * Save the message to 
     * @param level
     * @param message 
     */
    public void log(LogLevel level, String message) {
        String logMessage = String.format("[%s] [%s] %s",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), //Get current date and time to ISO 8601 format
                level.toString(),
                message);
        writer.println(logMessage);
        writer.flush();
    }

    /**
     * Log exception
     * @param e 
     */
    public void logException(Exception e) {
        log(LogLevel.ERROR, "Exception occurred: " + e.getMessage());
        e.printStackTrace(writer);
        writer.flush();
    }

    /**
     * Close the logger
     */
    public void closeLog() {
        writer.close();
    }	

}
