package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBConnection;
import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class Client {
	
    public static void main(String[] args) throws SQLException {
        int eventId;
      
        // Connect to the database
        DBConnection.getInstance();
        DBOperations.purgeEvents();

        // Create events using the factory method
        Library academicLibrary = new AcademicLibrary();
        Event workshopEvent = academicLibrary.createEvent(EventType.WORKSHOP);
        
        workshopEvent.setEventName("Java Workshop");
        workshopEvent.setEventDescription("CST8284: Object Oriented Programming (Java)");
        workshopEvent.setEventActivities("Inheritance and PolyMorphism");
        workshopEvent.calculateAdmissionFee();

        DBOperations.createEvent(workshopEvent);

        Library publicLibrary = new PublicLibrary();
        Event kidsStoryTimeEvent = publicLibrary.createEvent(EventType.KIDS_STORY);
        kidsStoryTimeEvent.setEventName("Kids Story Time");
        kidsStoryTimeEvent.setEventDescription("Interactive storytelling session for kids");
        kidsStoryTimeEvent.setEventActivities("Reading stories");
        kidsStoryTimeEvent.calculateAdmissionFee();

        DBOperations.createEvent(kidsStoryTimeEvent);

        // Retrieve and display the created events
        DBOperations.retrieveEvent(workshopEvent.getEventId()); // Workshop event
        DBOperations.retrieveEvent(kidsStoryTimeEvent.getEventId()); // Kids Story Time event


        // Update the Workshop event
        workshopEvent.setEventName("Advanced Java Workshop");
        workshopEvent.setEventDescription("CST8288: Object Oriented Programming With Pattern");
        workshopEvent.setEventActivities("Factory Method and JDBC");
        workshopEvent.calculateAdmissionFee();
        
        // Retrieve and display the created events
        DBOperations.updateEvent(workshopEvent);
        System.out.println("\nAfter update:");
        eventId = workshopEvent.getEventId();
        DBOperations.retrieveEvent(eventId); // Workshop event


        // Delete the Kids Story Time event
//        DBOperations.deleteEvent(kidsStoryTimeEvent.getEventId());
        DBOperations.deleteEvent(2);
        // Close the database connection
        DBConnection.closeConnection();
    }
}	

