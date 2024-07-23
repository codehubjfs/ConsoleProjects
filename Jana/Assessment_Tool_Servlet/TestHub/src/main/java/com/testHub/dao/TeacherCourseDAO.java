package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.testHub.bean.Course;
import com.testHub.bean.TeacherCoursesResult;
import com.testHub.utilities.DbConnection;

public class TeacherCourseDAO {
	
	private static final String SELECT_EID_BY_EMAIL = "SELECT eid FROM educator WHERE email = ?";
    private static final String SELECT_COURSES_BY_EDUCATOR_ID = "SELECT * FROM course INNER JOIN educatorcourse ON course.cid = educatorcourse.cid WHERE educatorcourse.eid = ?";

    public TeacherCoursesResult selectCoursesByTeacherEmail(String email) {
        List<Course> courses = new ArrayList<>();
        int eid = -1;
        try  {
            // First query to get the student ID (sid) based on email
        	Connection connection = DbConnection.openConnection();
            eid = getEducatorIdByEmail(connection, email);

            if (eid != -1) {
                // Second query to get the courses based on student ID
                try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSES_BY_EDUCATOR_ID)) {
                    preparedStatement.setInt(1, eid);
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
        return new TeacherCoursesResult(eid, courses);
    }

    private int getEducatorIdByEmail(Connection connection, String email) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EID_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("eid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if no student ID is found
    }

}
