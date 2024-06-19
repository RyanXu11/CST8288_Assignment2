


package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {

    /**
     * for logging
     */
    private static final LMSLogger logger = LMSLogger.getInstance();
    
    /**
     * 
     * @param event 
     */
    public void createEvent(Event event) {
        int eventId = -1; //default value if insertion fails
        String logMessage;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows >0){
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    eventId = rs.getInt(1);
                    event.setEventId(eventId);
                    logMessage = "Event created successfully with ID: " + eventId;
                    System.out.println(logMessage);
                    logger.log(LogLevel.INFO, logMessage);   
                }            
            } else {
                logMessage = "Event created successfully with ID: " + eventId;
                System.out.println(logMessage);
                logger.log(LogLevel.WARN, logMessage);
            }
        } catch (SQLException e) {
            logMessage = "SQLException: " + e;
            logger.log(LogLevel.ERROR, logMessage);
            e.printStackTrace();
        }
    }

    public void retrieveEvent(int event_id) {
        String logMessage;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "SELECT * FROM events WHERE event_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, event_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                EventType eventType = factoryService.getEventTypeFromName(rs.getString("event_name"));
                Event event = factoryService.createEvent(eventType);
                event.setEventId(rs.getInt("event_id"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDescription(rs.getString("event_description"));
                event.setEventActivities(rs.getString("event_activities"));
                event.setAdmissionFees(rs.getDouble("admission_fees"));
                event.printEvent();
                logMessage = "Event " + event_id + " retrieved successfully.";
                logger.log(LogLevel.INFO, logMessage); 
            } else {
                logMessage = "Event " + event_id + " not found!";
                System.out.println(logMessage);
                logger.log(LogLevel.WARN, logMessage); 
            }
        }catch(SQLException e) {
            logMessage = "SQLException: " + e;
            logger.log(LogLevel.ERROR, logMessage);
//            e.printStackTrace();
        }
    } 


    public void updateEvent(Event event){
        String logMessage;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());    
            pstmt.setInt(5, event.getEventId());
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows >0){
                logMessage = "Event " + event.getEventId() + " updated successfully.";
                logger.log(LogLevel.INFO, logMessage); 
                System.out.println(logMessage);
            } else {
                logMessage = "Failed to update Event " + event.getEventId() + ".";
                logger.log(LogLevel.WARN, logMessage); 
                System.out.println(logMessage);           
            }
        }catch(SQLException e) {
            logMessage = "SQLException: " + e;
            logger.log(LogLevel.ERROR, logMessage);
//            e.printStackTrace();
        }
    }

    public void deleteEvent(int event_id) throws SQLException{
        String logMessage;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "DELETE FROM events WHERE event_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, event_id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows >0) {
                logMessage = "Event ID " + event_id + " deleted successfully!";
                logger.log(LogLevel.INFO, logMessage); 
                System.out.println(logMessage);
            } else {
                logMessage = "Failed to delete event with ID: " + event_id;   
                logger.log(LogLevel.WARN, logMessage); 
                System.out.println(logMessage);
            }
        }catch(SQLException e) {
            logMessage = "SQLException: " + e;
            logger.log(LogLevel.ERROR, logMessage);
//            e.printStackTrace();
        }
    }
    
    public void purgeEvents() {
        String logMessage;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "DELETE FROM events";
            PreparedStatement pstmt = conn.prepareStatement(query);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                logMessage = "All events deleted successfully!";
                System.out.println(logMessage);
                logger.log(LogLevel.INFO, logMessage);
            } else {
                logMessage = "No events to delete.";
                System.out.println(logMessage);
                logger.log(LogLevel.WARN, logMessage);
            }
        } catch(SQLException e) {
            logMessage = "SQLException: " + e;
            logger.log(LogLevel.ERROR, logMessage);
//            e.printStackTrace();
        }
    }
    
}
