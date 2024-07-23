package com.testPortal.model;

import org.springframework.stereotype.Component;

@Component
public class Course {

	private int cid;
	private String cname;
	private String start_date;
	private String end_date;

	// getters and setters
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", start_date=" + start_date + ", end_date=" + end_date
				+ "]";
	}

}
