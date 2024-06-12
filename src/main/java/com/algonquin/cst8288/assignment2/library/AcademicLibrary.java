/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;
import com.algonquin.cst8288.assignment2.event.BookLaunch;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.Workshop;

/**
 *
 * @author ryany
 */
public class AcademicLibrary implements Library {
    
    /**
     * 
     * @param eventType 
     * @return  
     */
    @Override
    public Event createEvent(EventType eventType) {
        switch (eventType) {
            case WORKSHOP:
                return new Workshop();
            case BOOK_LAUNCH:
                return new BookLaunch();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }
}
