package com.hallbookingmanagement.beans;

import org.springframework.stereotype.Component;

@Component
public class ArrangementHallRelation {
	private int hallId;
	private int arrangmentId;
	private int capacity;
	public ArrangementHallRelation() {
		
	}
	
	
	public ArrangementHallRelation(int hallId, int arrangmentId, int capacity) {
		this.hallId = hallId;
		this.arrangmentId = arrangmentId;
		this.capacity = capacity;
	}


	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public int getArrangmentId() {
		return arrangmentId;
	}
	public void setArrangmentId(int arrangmentId) {
		this.arrangmentId = arrangmentId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
