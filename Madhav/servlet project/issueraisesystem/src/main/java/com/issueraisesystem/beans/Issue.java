package com.issueraisesystem.beans;

import java.sql.Date;

public class Issue {
	
	
	private int issueid;
	private String issuetitle;
	private String description;
	private Date ticketraisedate;
	private String raisedby;
	private String allocateto;
	private String priority;
	private Date issuedate;
	private String status;
	
	public Issue() {
		
	}

	public int getIssueid() {
		return issueid;
	}

	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}

	public String getIssuetitle() {
		return issuetitle;
	}

	public void setIssuetitle(String issuetitle) {
		this.issuetitle = issuetitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTicketraisedate() {
		return ticketraisedate;
	}

	public void setTicketraisedate(Date ticketraisedate) {
		this.ticketraisedate = ticketraisedate;
	}

	public String getRaisedby() {
		return raisedby;
	}

	public void setRaisedby(String raisedby) {
		this.raisedby = raisedby;
	}

	public String getAllocateto() {
		return allocateto;
	}

	public void setAllocateto(String allocateto) {
		this.allocateto = allocateto;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date date) {
		this.issuedate = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
