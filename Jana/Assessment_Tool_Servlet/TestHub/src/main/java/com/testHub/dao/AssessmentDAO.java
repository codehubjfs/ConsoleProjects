package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testHub.bean.Assessment;
import com.testHub.utilities.DbConnection;

public class AssessmentDAO {
	
	private static final String SELECT_ASSESSMENTS_BY_COURSE_ID = "SELECT * FROM assessment WHERE cid = ?";
	
	 public List<Assessment> getAssessmentsByCourseId(int courseId) {
	        List<Assessment> assessments = new ArrayList<>();
	        try  {
	        	Connection connection = DbConnection.openConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSESSMENTS_BY_COURSE_ID);
	            preparedStatement.setInt(1, courseId);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                Assessment assessment = new Assessment();
	                assessment.setAid(rs.getInt("aid"));
	                assessment.setaName(rs.getString("aname"));
	                assessment.setaDate(rs.getDate("adate").toLocalDate());
	                assessment.setStTime(rs.getTime("sttime").toLocalTime());
	                assessment.setEndTime(rs.getTime("endtime").toLocalTime());;
	                assessment.setTot_marks(rs.getInt("tot_marks"));;
	                assessment.setEid(rs.getInt("eid"));
	                assessment.setEid(rs.getInt("cid"));
	                assessment.setDuration(rs.getDouble("Duration"));
	                assessments.add(assessment);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return assessments;
	    }

}
