package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testHub.utilities.DbConnection;

public class StudentMarkDAO {
	
	private static final String SELECT_COMPLETED_ASSESSMENTS = "SELECT aid FROM studentmark WHERE sid = ?";
	
	public List<Integer> getCompletedAssessments(int studentId) {
        List<Integer> completedAssessments = new ArrayList<>();
        try  {
        	Connection connection = DbConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPLETED_ASSESSMENTS);
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                completedAssessments.add(rs.getInt("aid"));
                System.out.println("completed"+rs.getInt("aid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return completedAssessments;
    }

}
