package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.testHub.bean.QuestionAnalytics;
import com.testHub.bean.Result;
import com.testHub.utilities.DbConnection;

public class ResultDAO {
	
	private static final String FETCH_RESULTS_QUERY = "SELECT s.sid, st.fname, s.tot_mark FROM studentmark s JOIN student st ON s.sid = st.sid WHERE s.aid = ?";
    private static final String RETRIEVE_QUESTIONS_QUERY = "SELECT q.qid, q.answer FROM question q JOIN questionassessment a ON q.qid = a.qid WHERE a.aid = ? ORDER BY q.qid";
    private static final String RETRIEVE_STUDENT_ANSWERS_QUERY = "SELECT QID, studAnswer FROM StudentAnswer WHERE SID = ? AND AID=? AND QID IN (SELECT q.QID FROM Question q JOIN questionassessment a ON q.QID = a.QID WHERE a.AID = ?) ORDER BY QID";

    public List<Result> getResultsByAssessmentId(int assessmentId) {
        List<Result> results = new ArrayList<>();

        try  {
        	
        	Connection connection = DbConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FETCH_RESULTS_QUERY);
            
            preparedStatement.setInt(1, assessmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Result result = new Result();
                result.setStudentId(resultSet.getInt("sid"));
                result.setStudentName(resultSet.getString("fname"));
                result.setStudentMark(resultSet.getInt("tot_mark"));
                results.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<QuestionAnalytics> getQuestionsByAssessmentId(int assessmentId) {
        List<QuestionAnalytics> questions = new ArrayList<>();

        try  {
        	Connection connection = DbConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(RETRIEVE_QUESTIONS_QUERY);
            preparedStatement.setInt(1, assessmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	QuestionAnalytics question = new QuestionAnalytics();
                question.setQuestionId(resultSet.getInt("qid"));
                question.setCorrectAnswer(resultSet.getString("answer"));
                questions.add(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public Map<Integer, String> getStudentAnswers(int studentId, int assessmentId) {
        Map<Integer, String> studentAnswers = new HashMap<>();

        try  {
        	
        	Connection connection = DbConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(RETRIEVE_STUDENT_ANSWERS_QUERY);
            
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, assessmentId);
            preparedStatement.setInt(3, assessmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                studentAnswers.put(resultSet.getInt("QID"), resultSet.getString("studAnswer"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentAnswers;
    }

}
