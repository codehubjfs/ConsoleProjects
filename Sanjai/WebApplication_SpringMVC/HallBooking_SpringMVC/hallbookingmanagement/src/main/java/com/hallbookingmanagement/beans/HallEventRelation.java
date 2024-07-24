package com.hallbookingmanagement.beans;

import org.springframework.stereotype.Component;

@Component
public class HallEventRelation {
	private int hallId;
	private int eventId;
	public HallEventRelation() {
	}
	
	public HallEventRelation(int hallId, int eventId) {
		super();
		this.hallId = hallId;
		this.eventId = eventId;
	}

	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "HallEventRelation [hallId=" + hallId + ", eventId=" + eventId + "]";
	}
	
	
}
