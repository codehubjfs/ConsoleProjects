package com.testHub.bean;

import java.util.List;

public class TeacherCoursesResult {
	
	private int eid;
    private List<Course> courses;
    
	public TeacherCoursesResult(int eid, List<Course> courses) {
		super();
		this.eid = eid;
		this.courses = courses;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

}
