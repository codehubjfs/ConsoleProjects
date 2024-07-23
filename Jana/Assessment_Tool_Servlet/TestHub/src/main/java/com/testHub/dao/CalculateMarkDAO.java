package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.testHub.utilities.DbConnection;

public class CalculateMarkDAO {
    
    public static void calculateAndStoreTotalMarks(int studentId, int assessmentId) throws SQLException {
        String retrieveQuestionsQuery = "SELECT * FROM question q join questionassessment a on q.qid=a.qid WHERE a.aid=? order by q.qid";
        String retrieveStudentAnswersQuery = "SELECT QID, studAnswer FROM StudentAnswer WHERE SID = ? AND AID =? AND QID IN (SELECT q.QID FROM Question q JOIN questionassessment a ON q.QID = a.QID WHERE a.AID = ?) ORDER BY QID";

        int totalMarks = calculateTotalMarks(retrieveQuestionsQuery, retrieveStudentAnswersQuery, studentId, assessmentId);
        storeTotalMarks(studentId, assessmentId, totalMarks);
    }

    private static int calculateTotalMarks(String retrieveQuestionsQuery, String retrieveStudentAnswersQuery, int studentId, int assessmentId) {
        int totalMarks = 0;

        try  {
        	Connection connection = DbConnection.openConnection();
            PreparedStatement retrieveQuestionsStmt = connection.prepareStatement(retrieveQuestionsQuery);
            PreparedStatement retrieveStudentAnswersStmt = connection.prepareStatement(retrieveStudentAnswersQuery);

            retrieveQuestionsStmt.setInt(1, assessmentId);

            try (ResultSet questionsResult = retrieveQuestionsStmt.executeQuery()) {
                retrieveStudentAnswersStmt.setInt(1, studentId);
                retrieveStudentAnswersStmt.setInt(2, assessmentId);
                retrieveStudentAnswersStmt.setInt(3, assessmentId);

                try (ResultSet studentAnswersResult = retrieveStudentAnswersStmt.executeQuery()) {
                    while (questionsResult.next() && studentAnswersResult.next()) {
                        String correctAnswer = questionsResult.getString("Answer");
                        System.out.println(correctAnswer);
                        String studentAnswer = studentAnswersResult.getString("studAnswer");
                        System.out.println(studentAnswer);

                        if (correctAnswer != null && correctAnswer.equals(studentAnswer)) {
                        	
                            totalMarks += questionsResult.getInt("Mark");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       

        return totalMarks;
    }

    public static void storeTotalMarks(int studentId, int assessmentId, int totalMarks) throws SQLException {
        String insertMarkQuery = "INSERT INTO Studentmark (sid, aid, tot_mark) VALUES (?, ?, ?)";

        try  {
        	
        	Connection connection = DbConnection.openConnection();
            PreparedStatement insertMarkStmt = connection.prepareStatement(insertMarkQuery);

            insertMarkStmt.setInt(1, studentId);
            insertMarkStmt.setInt(2, assessmentId);
            insertMarkStmt.setInt(3, totalMarks);

            int rows = insertMarkStmt.executeUpdate();
            if (rows == 1) {
                System.out.println("Marks Evaluated!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
