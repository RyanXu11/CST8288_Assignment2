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
public class MovieNight extends Event {
    
    @Override
    public void calculateAdmissionFee(){
        admissionFees = Constants.MOVIE_NIGHT_DURATION * Constants.MOVIE_NIGHT_RATE;
    }
    
    @Override
    public void setEventName(String eventName) {
        if (!eventName.startsWith("MOVIE_NIGHT: ")) {
            this.eventName = "MOVIE_NIGHT: " + eventName;
        } else {
            this.eventName = eventName;
        }
    }
}
