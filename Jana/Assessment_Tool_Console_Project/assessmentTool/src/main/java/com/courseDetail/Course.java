package com.courseDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {

	Scanner sc = new Scanner(System.in);

	private int cId;
	private String cName;
	private String start_date;
	private String end_date;

	List<Assessment> assessments = new ArrayList<>();

	public Course(int cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}

	public Course(int cId) {
		super();
		this.cId = cId;
	}

	

	public Course(String cName, String start_date, String end_date) {
		super();
		this.cName = cName;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
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

	public List<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<Assessment> assessments) {
		this.assessments = assessments;
	}

	//
	@Override
	public String toString() {
		return String.format("%-10d | %-30s", cId, cName);
	}

//	 @Override
//	    public String toString() {
//	        return String.format("%-13d | %-30s", cId, cName);
//	    }

}
