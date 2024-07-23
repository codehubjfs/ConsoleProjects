package com.testHub.bean;

import java.util.List;

public class StudentCoursesResult {
	
	private int sid;
    private List<Course> courses;

    public StudentCoursesResult(int sid, List<Course> courses) {
        this.sid = sid;
        this.courses = courses;
    }

    public int getSid() {
        return sid;
    }

    public List<Course> getCourses() {
        return courses;
    }
}


