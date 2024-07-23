package com.testHub.bean;

import java.time.LocalDate;

public class Assessment {
	
	private int aid;
	private String aName;
	private String stTime;
	private String endTime;
	private double duration;
	private int tot_marks;
	private int cid;
	private int eid;
	private LocalDate aDate;
	private String status;
	
	public Assessment() {
		
	}
	
	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getStTime() {
		return stTime;
	}

	public void setStTime(String localTime) {
		this.stTime = localTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String localTime) {
		this.endTime = localTime;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getTot_marks() {
		return tot_marks;
	}

	public void setTot_marks(int tot_marks) {
		this.tot_marks = tot_marks;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public LocalDate getaDate() {
		return aDate;
	}

	public void setaDate(LocalDate aDate) {
		this.aDate = aDate;
	}
	
	

}
