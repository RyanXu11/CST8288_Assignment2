/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.Library;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;

/**
 *
 * @author ryany
 */
public class factoryService {
    
    /**
     * 
     * @param eventType
     * @return 
     */
    public static Event createEvent(EventType eventType) {
        Library library;
        // Determine which library to use based on eventType
        if (eventType == EventType.WORKSHOP || eventType == EventType.BOOK_LAUNCH) {
            library = new AcademicLibrary();
        } else {
            library = new PublicLibrary();
        }
        return library.createEvent(eventType);
    } 
    
    /**
     * 
     * @param eventName
     * @return 
     */
    public static EventType getEventTypeFromName(String eventName) {
        if (eventName == null || eventName.isEmpty()) {
            return null; // Validate the eventName
        }
        String prefix = eventName.split(":")[0];
        switch (prefix) {
            case "WORKSHOP":
                return EventType.WORKSHOP;
            case "BOOK_LAUNCH":
                return EventType.BOOK_LAUNCH;
            case "MOVIE_NIGHT":
                return EventType.MOVIE_NIGHT;
            case "KIDS_STORY":
                return EventType.KIDS_STORY;
            default:
                return null; // Validate the eventName
        }
    }
}
