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
public class KidsStoryTime extends Event {
    
    @Override
    public void calculateAdmissionFee(){
        admissionFees = Constants.KIDS_STORYTIME_DURATION * Constants.KIDS_STORYTIME_RATE;
    }
    
    @Override
    public void setEventName(String eventName) {
        if (!eventName.startsWith("KIDS_STORY: ")) {
            this.eventName = "KIDS_STORY: " + eventName;
        } else {
            this.eventName = eventName;
        }
    }
}
