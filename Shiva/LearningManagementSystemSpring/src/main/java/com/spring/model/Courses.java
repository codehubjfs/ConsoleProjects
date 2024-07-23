package com.spring.model;

import java.time.LocalDate;

public class Courses {
	private int courseId;
	private String coursename;
	private int instructorId;
	private LocalDate startDate;
	private LocalDate endDate;
	public Courses() {
		super();
	}
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", coursename=" + coursename + ", instructorId=" + instructorId
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
