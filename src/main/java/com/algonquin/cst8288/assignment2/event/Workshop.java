/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
/**
 *
 * @author ryany
 */
public class Workshop extends Event {
    
    @Override
    public void calculateAdmissionFee(){
        admissionFees = Constants.WORKSHOP_DURATION * Constants.WORKSHOP_RATE;
    }
    
    /**
     * format eventName
     * @param eventName 
     */
    @Override
    public void setEventName(String eventName) {
        if (!eventName.startsWith("WORKSHOP: ")) {
            this.eventName = "WORKSHOP: " + eventName;
        } else {
            this.eventName = eventName;
        }
    }
}
