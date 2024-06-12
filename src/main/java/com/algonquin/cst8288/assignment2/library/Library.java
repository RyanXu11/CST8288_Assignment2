/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;

/**
 *
 * @author ryany
 */
public interface Library {
    
    public Event createEvent(EventType eventType);
}
