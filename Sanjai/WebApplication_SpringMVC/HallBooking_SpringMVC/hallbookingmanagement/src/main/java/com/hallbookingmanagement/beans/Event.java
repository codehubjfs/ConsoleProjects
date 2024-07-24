package com.hallbookingmanagement.beans;

import org.springframework.stereotype.Component;

/**
 * Events class represents event details and provides methods to interact with event data.
 * This class includes methods for setting and getting event details as well as a method to
 * retrieve a list of events from the database.
 * @author Sanjai
 * @since 13-May-2024
 */


@Component
public class Event {
    private int eventId;
    private String eventName;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Event() {

    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public Event(String eventName, int eventId) {
        this.eventName = eventName;
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Events{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
