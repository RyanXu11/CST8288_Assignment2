package com.algonquin.cst8288.assignment2.event;

public abstract class Event {
    
	
    protected String eventName;
    protected String eventDescription;
    protected String eventActivities;
    protected double admissionFees;
    protected int eventId;  // If no id, it will be be difficult to update the event and associated record in database
    
    /**
     * Default constructor
     */ 
    public Event() {

    }
    

    /**
     * @return the eventId
     */
    public int getEventId() {
        return eventId;
    }


    /**
     * @param eventId the eventId to set
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    
    
    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }


    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    /**
     * @return the eventDescription
     */
    public String getEventDescription() {
        return eventDescription;
    }


    /**
     * @param eventDescription the eventDescription to set
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }


    /**
     * @return the eventActivities
     */
    public String getEventActivities() {
        return eventActivities;
    }


    /**
     * @param eventActivities the eventActivities to set
     */
    public void setEventActivities(String eventActivities) {
        this.eventActivities = eventActivities;
    }


    /**
     * @return the admissionFees
     */
    public double getAdmissionFees() {
        return admissionFees;
    }


    /**
     * @param admissionFees the admissionFees to set
     */
    public void setAdmissionFees(double admissionFees) {
        this.admissionFees = admissionFees;
    }


    // Every library as it own admission fee
    public abstract void calculateAdmissionFee();
    
    /**
     * 
     */
    public void printEvent(){
        System.out.println("\nEvent ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Description: " + eventDescription);
        System.out.println("Event Activities: " + eventActivities);
        System.out.println("Admission Fees: " + admissionFees);
    }
    


    
}
