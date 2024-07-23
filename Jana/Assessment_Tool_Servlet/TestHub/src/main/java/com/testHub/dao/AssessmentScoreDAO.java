package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.testHub.bean.Assessment;
import com.testHub.bean.Question;
import com.testHub.utilities.DbConnection;

public class AssessmentScoreDAO {
	
	public int fetchTotalScore(Object studentId, int assessmentId) {
        int totalScore = 0;
        String query = "SELECT tot_mark FROM studentmark WHERE sid = ? AND aid = ?";
        
        try  {
        	
        	Connection conn = DbConnection.openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
             
            ps.setObject(1, studentId);
            ps.setInt(2, assessmentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalScore = rs.getInt("tot_mark");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return totalScore;
    }
	
	 public Map<Integer, String> fetchCorrectAnswers(int assessmentId) {
	        Map<Integer, String> correctAnswers = new HashMap<>();
	        String query = "SELECT q.qid,q.answer FROM question q join questionassessment a on q.qid=a.qid WHERE a.aid=? order by q.qid";
	        
	        try  {
	        	
	        	Connection conn = DbConnection.openConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             
	            ps.setInt(1, assessmentId);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    correctAnswers.put(rs.getInt("qid"), rs.getString("answer"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return correctAnswers;
	    }

	    public Map<Integer, String> fetchStudentAnswers(Object studentId, int assessmentId) {
	        Map<Integer, String> studentAnswers = new HashMap<>();
	        String query = "SELECT QID, studAnswer FROM StudentAnswer WHERE SID = ? AND AID=? AND QID IN (SELECT q.QID FROM Question q JOIN questionassessment a ON q.QID = a.QID WHERE a.AID = ?) ORDER BY QID";
	        
	        try  {
	        	
	        	Connection conn = DbConnection.openConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             
	            ps.setObject(1, studentId);
	            ps.setInt(2, assessmentId);
	            ps.setInt(3, assessmentId);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    studentAnswers.put(rs.getInt("qid"), rs.getString("studanswer"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return studentAnswers;
	    }
	    
	    public List<Question> fetchQuestions(int assessmentId) {
	        List<Question> questions = new ArrayList<>();
	        String query = "SELECT * FROM question q join questionassessment a on q.qid=a.qid WHERE a.aid=? order by q.qid";
	        
	        try  {
	        	
	        	Connection conn = DbConnection.openConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             
	            ps.setInt(1, assessmentId);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    Question question = new Question();
	                    question.setQid(rs.getInt("qid"));
	                    question.setQuestions(rs.getString("questions"));
	                    question.setC1(rs.getString("c1"));
	                    question.setC2(rs.getString("c2"));
	                    question.setC3(rs.getString("c3"));
	                    question.setC4(rs.getString("c4"));
	                    question.setAnswer(rs.getString("answer"));
	                    question.setMark(rs.getInt("mark"));
	                    questions.add(question);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return questions;
	    }
	    
	    public Assessment fetchAssessmentData(int assessmentId) {
	        Assessment assessment = null;
	        String query = "SELECT * FROM assessment WHERE aid = ?";
	        
	        try  {
	        	
	        	Connection conn = DbConnection.openConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             
	            ps.setInt(1, assessmentId);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    assessment = new Assessment();
	                    assessment.setAid(rs.getInt("aid"));
	                    assessment.setaName(rs.getString("aname"));
	                    assessment.setStTime(rs.getString("sttime"));
	                    assessment.setEndTime(rs.getString("endtime"));
	                    assessment.setDuration(rs.getInt("duration"));
	                    assessment.setTot_marks(rs.getInt("tot_mark"));
	                    assessment.setCid(rs.getInt("cid"));
	                    assessment.setaDate(rs.getDate("adate").toLocalDate());
	                    assessment.setEid(rs.getInt("eid"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return assessment;
	    }

}
