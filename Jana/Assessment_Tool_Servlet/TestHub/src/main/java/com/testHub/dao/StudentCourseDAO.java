package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.testHub.bean.Course;
import com.testHub.utilities.DbConnection;

public class StudentCourseDAO {

    private static final String SELECT_SID_BY_EMAIL = "SELECT sid FROM student WHERE email = ?";
    private static final String SELECT_COURSES_BY_STUDENT_ID = "SELECT * FROM course INNER JOIN studentcourse ON course.cid = studentcourse.cid WHERE studentcourse.sid = ?";

    public List<Course> selectCoursesByStudentEmail(String email) {
        List<Course> courses = new ArrayList<>();
        try  {
            // First query to get the student ID (sid) based on email
        	Connection connection = DbConnection.openConnection();
            int sid = getStudentIdByEmail(connection, email);
            System.out.println(sid);

            if (sid != -1) {
                // Second query to get the courses based on student ID
                try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSES_BY_STUDENT_ID)) {
                    preparedStatement.setInt(1, sid);
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        int cid = rs.getInt("cid");
                        String name = rs.getString("cname");
                        LocalDate startDate = rs.getDate("start_date").toLocalDate();
                        LocalDate endDate = rs.getDate("end_date").toLocalDate();

                        Course c = new Course();
    	                c.setCourseId(cid);
    	                c.setCourseName(name);
    	                c.setStartDate(startDate);
    	                c.setEndDate(endDate);
    	                courses.add(c);
    	                System.out.println(c.getCourseName());
                        
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    private int getStudentIdByEmail(Connection connection, String email) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SID_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("sid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if no student ID is found
    }
}