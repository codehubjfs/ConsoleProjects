package com.testPortal.model;

import org.springframework.stereotype.Component;

@Component
public class Assessment {

	private int aid;
	private String aname;
	private String sttime;
	private String endtime;
	private int duration;
	private int tot_mark;
	private int cid;
	private String adate;
	private int eid;
	private String status;

	// Getters and Setters
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getSttime() {
		return sttime;
	}

	public void setSttime(String sttime) {
		this.sttime = sttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTot_mark() {
		return tot_mark;
	}

	public void setTot_mark(int tot_mark) {
		this.tot_mark = tot_mark;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Assessment [aid=" + aid + ", aname=" + aname + ", sttime=" + sttime + ", endtime=" + endtime
				+ ", duration=" + duration + ", tot_mark=" + tot_mark + ", cid=" + cid + ", adate=" + adate + ", eid="
				+ eid + ", status=" + status + "]";
	}

}
