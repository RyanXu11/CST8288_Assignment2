package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBConnection;
import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;
import java.sql.SQLException;

/**
 * This class is used to run Assignment2
 * @author ryany
 */
public class Client {
	
    public static void main(String[] args) throws SQLException {
        int eventId;
      
        // Connect to the database
        DBConnection.getInstance();
        // Delete all exist records in database for testing
        DBOperations.purgeEvents();

        // Create events using the factory method: AcademicLibrary
        Library academicLibrary = new AcademicLibrary();
        Event workshopEvent = academicLibrary.createEvent(EventType.WORKSHOP);
        
        // Set all attributes of the event
        workshopEvent.setEventName("Java Workshop");
        workshopEvent.setEventDescription("CST8284: Object Oriented Programming (Java)");
        workshopEvent.setEventActivities("Inheritance and PolyMorphism");
        workshopEvent.calculateAdmissionFee();

        // Save the event to database
        DBOperations.createEvent(workshopEvent);

        // Create an instance of PublicLibrary
        Library publicLibrary = new PublicLibrary();
        Event kidsStoryTimeEvent = publicLibrary.createEvent(EventType.KIDS_STORY);
        
        // Set all attributes of the event
        kidsStoryTimeEvent.setEventName("Kids Story Time");
        kidsStoryTimeEvent.setEventDescription("Interactive storytelling session for kids");
        kidsStoryTimeEvent.setEventActivities("Reading stories");
        kidsStoryTimeEvent.calculateAdmissionFee();

        // Save the event to database
        DBOperations.createEvent(kidsStoryTimeEvent);

        // Retrieve and display the created events, printEvent() called in retrieveEvent
        DBOperations.retrieveEvent(workshopEvent.getEventId()); // Workshop event
        DBOperations.retrieveEvent(kidsStoryTimeEvent.getEventId()); // Kids Story Time event


        // Update the Workshop event
        workshopEvent.setEventName("Advanced Java Workshop");
        workshopEvent.setEventDescription("CST8288: Object Oriented Programming With Pattern");
        workshopEvent.setEventActivities("Factory Method and JDBC");
        workshopEvent.calculateAdmissionFee();
        
        // UpdateEvent in database by the eventID
        DBOperations.updateEvent(workshopEvent);
        System.out.println("\nAfter update:");
        eventId = workshopEvent.getEventId();
        DBOperations.retrieveEvent(eventId); // Workshop event


        // Delete the Kids Story Time event
//        DBOperations.deleteEvent(kidsStoryTimeEvent.getEventId()); // This will success
        DBOperations.deleteEvent(2);   // This will fail
        // Close the database connection
        DBConnection.closeConnection();  // Close the database connection
    }
}	

