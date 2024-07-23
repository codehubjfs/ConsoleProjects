package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.testHub.utilities.DbConnection;

public class StudentAnswerDAO {
	
	 public void saveStudentAnswers(int studentId, Map<Integer, String> answers, int aid) throws SQLException {
	        String insertSQL = "INSERT INTO studentanswer (ANSID, SID, QID, STUDANSWER, AID) VALUES (ANSSEQ.NEXTVAL, ?, ?, ?, ?)";
	        try  {
	        	
	        	Connection connection = DbConnection.openConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
	            for (Map.Entry<Integer, String> entry : answers.entrySet()) {
	                preparedStatement.setInt(1, studentId);
	                preparedStatement.setInt(2, entry.getKey());
	                preparedStatement.setString(3, entry.getValue());
	                preparedStatement.setInt(4, aid);
	                preparedStatement.addBatch();
	                System.out.println(entry.getKey()+" "+entry.getValue());
	            }
	            preparedStatement.executeBatch();
	        }
	        catch(SQLException e) {
	        	System.out.println(e.getMessage());
	        }
	 }

}
