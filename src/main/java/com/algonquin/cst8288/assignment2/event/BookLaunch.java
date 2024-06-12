/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

/**
 *
 * @author ryany
 */
public class BookLaunch extends Event {
    
    @Override
    public void calculateAdmissionFee(){
        admissionFees = 50.0;
    }
    
    @Override
    public void setEventName(String eventName) {
        if (!eventName.startsWith("BOOK_LAUNCH: ")) {
            this.eventName = "BOOK_LAUNCH: " + eventName;
        } else {
            this.eventName = eventName;
        }
    }
}
