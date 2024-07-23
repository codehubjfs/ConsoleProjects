package com.testHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testHub.bean.Question;
import com.testHub.utilities.DbConnection;

public class QuestionDAO {
	
	 public List<Question> getQuestionsByAssessmentId(int assessmentId) {
	        List<Question> questions = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;

	        try {
	            // Get database connection
	            connection = DbConnection.openConnection();

	            // SQL query to fetch questions based on assessment ID
	            String sql = "SELECT q.qid, q.questions, q.c1, q.c2, q.c3, q.c4, q.answer, q.mark " +
	                         "FROM question q " +
	                         "JOIN questionassessment qa ON q.qid = qa.qid " +
	                         "WHERE qa.aId = ?";
	            statement = connection.prepareStatement(sql);
	            statement.setInt(1, assessmentId);
	            resultSet = statement.executeQuery();

	            // Process the result set and create Question objects
	            while (resultSet.next()) {
	                Question question = new Question();
	                question.setQid(resultSet.getInt("qid"));
	                question.setQuestions(resultSet.getString("questions"));
	                question.setC1(resultSet.getString("c1"));
	                question.setC2(resultSet.getString("c2"));
	                question.setC3(resultSet.getString("c3"));
	                question.setC4(resultSet.getString("c4"));
	                question.setAnswer(resultSet.getString("answer"));
	                question.setMark(resultSet.getInt("mark"));
	                questions.add(question);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return questions;
	    }
	 
	 public int addNewQuestion(Question question) {
	        int qid = -1;
	        String query = "INSERT INTO question (qid, questions, c1, c2, c3, c4, answer, mark) VALUES (quesseq.nextval, ?, ?, ?, ?, ?, ?, ?)";
	        try  {
	        	Connection con = DbConnection.openConnection();
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, question.getQuestions());
	            ps.setString(2, question.getC1());
	            ps.setString(3, question.getC2());
	            ps.setString(4, question.getC3());
	            ps.setString(5, question.getC4());
	            ps.setString(6, question.getAnswer());
	            ps.setInt(7, question.getMark());
	            ps.executeUpdate();
	            PreparedStatement qidStmt = con.prepareStatement("select qid from question where questions=? and answer=?");
				qidStmt.setString(1, question.getQuestions());
				qidStmt.setString(2, question.getAnswer());
				ResultSet rs = qidStmt.executeQuery();
				while (rs.next()) {
					qid = rs.getInt("qId");
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return qid;
	    }

	    public List<Question> getAllQuestions() {
	        List<Question> questions = new ArrayList<>();
	        String query = "SELECT * FROM question";
	        try  {
	        	Connection con = DbConnection.openConnection();
	             PreparedStatement stmt = con.prepareStatement(query);
	             ResultSet rs = stmt.executeQuery();
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
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return questions;
	    }

		public int assignQuestion(int aid,int qid) {
			String sql = "insert into questionassessment(aid,qid) values(?,?)";
			int n = 0;
			 try  {
		        	Connection con = DbConnection.openConnection();
		             PreparedStatement stmt = con.prepareStatement(sql);
		             stmt.setInt(1, aid);
		             stmt.setInt(2, qid);
		             n = stmt.executeUpdate();
		             
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			return n;
		}

}
