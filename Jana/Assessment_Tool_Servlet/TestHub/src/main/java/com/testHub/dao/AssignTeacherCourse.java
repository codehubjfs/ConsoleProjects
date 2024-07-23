package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.testHub.bean.Course;
import com.testHub.bean.Educator;
import com.testHub.utilities.DbConnection;

public class AssignTeacherCourse {
	
	public List<Educator> getAllEducators() {
        List<Educator> educators = new ArrayList<>();
        try (Connection connection = DbConnection.openConnection()) {
            String query = "SELECT eid, fname FROM educator";
            try (PreparedStatement ps = connection.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Educator educator = new Educator();
                    educator.setEid(rs.getInt("eid"));
                    educator.setFname(rs.getString("fname"));
                    educators.add(educator);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return educators;
    }
	
	public List<Course> getUnassignedCoursesForTeacher(String teacherId) {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DbConnection.openConnection()) {
            String query = "SELECT c.cid, c.cname " +
                           "FROM course c " +
                           "LEFT JOIN educatorcourse e ON c.cid = e.cid AND e.eid = ? " +
                           "WHERE e.cId IS NULL";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, teacherId);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Course course = new Course();
                        course.setCourseId(rs.getInt("cId"));
                        course.setCourseName(rs.getString("cName"));
                        courses.add(course);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

}
