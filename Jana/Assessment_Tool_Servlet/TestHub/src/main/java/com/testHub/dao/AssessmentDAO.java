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
	private static final String INSERT_ASSESSMENT_SQL = "INSERT INTO assessment (AID, ANAME, STTIME, ENDTIME, DURATION, TOT_MARK, CID, ADATE, EID) VALUES (assessseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
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
	                assessment.setStTime(rs.getString("sttime"));
	                assessment.setEndTime(rs.getString("endtime"));;
	                assessment.setTot_marks(rs.getInt("tot_mark"));;
	                assessment.setEid(rs.getInt("eid"));
	                assessment.setCid(rs.getInt("cid"));
	                assessment.setDuration(rs.getDouble("Duration"));
	                assessments.add(assessment);
	                System.out.println("all"+rs.getInt("aid"));
	            }
	            
	            System.out.println(courseId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return assessments;
	    }
	 
	 public boolean addAssessment(Assessment assessment) {
		 boolean rowInserted = false;
	        try {
	        	Connection connection = DbConnection.openConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASSESSMENT_SQL);
	            preparedStatement.setString(1, assessment.getaName());
	            preparedStatement.setString(2, assessment.getStTime());
	            preparedStatement.setString(3, assessment.getEndTime());
	            preparedStatement.setDouble(4, assessment.getDuration());
	            preparedStatement.setInt(5, assessment.getTot_marks());
	            preparedStatement.setInt(6, assessment.getCid());
	            preparedStatement.setDate(7, java.sql.Date.valueOf(assessment.getaDate())); // Convert LocalDate to java.sql.Date
	            preparedStatement.setInt(8, assessment.getEid());

	            rowInserted = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rowInserted;
	 }

}
