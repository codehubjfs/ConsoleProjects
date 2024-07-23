package com.testPortal.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testPortal.mapper.AssessmentMapper;
import com.testPortal.model.Assessment;
import com.testPortal.model.QuestionAnalytics;
import com.testPortal.model.Result;

@Service
public class AssessmentServImpl implements AssessmentService {

	@Autowired
	private AssessmentMapper assessmentMapper;

	public List<Assessment> getAssessmentsByCourseId(int courseId) {
		return assessmentMapper.getAssessmentsByCourseId(courseId);
	}

	@Override
	public boolean checkAssessmentAlreadyTaken(int sid, int aid) {
		int count = assessmentMapper.checkAssessmentAlreadyTaken(sid, aid);
		return count > 0; // If count > 0, assessment has been taken; otherwise, it hasn't.
	}

	@Override
	public Assessment fetchAssessmentData(int assessmentId) {
		return assessmentMapper.fetchAssessmentData(assessmentId);
	}

	@Override
	public Map<Integer, String> fetchCorrectAnswers(int assessmentId) {
		List<Map<String, Object>> results = assessmentMapper.fetchCorrectAnswers(assessmentId);
		System.out.println("Raw Results for Correct Answers: " + results);
		Map<Integer, String> correctAnswers = new HashMap<>();
		for (Map<String, Object> row : results) {
			correctAnswers.put(((BigDecimal) row.get("QID")).intValue(), (String) row.get("ANSWER"));
		}
		System.out.println("Mapped Correct Answers: " + correctAnswers);
		return correctAnswers;
	}

	@Override
	public Map<Integer, String> fetchStudentAnswers(int studentId, int assessmentId) {
		List<Map<String, Object>> results = assessmentMapper.fetchStudentAnswers(studentId, assessmentId);
		System.out.println("Raw Results for Student Answers: " + results);
		Map<Integer, String> studentAnswers = new HashMap<>();
		for (Map<String, Object> row : results) {
			studentAnswers.put(((BigDecimal) row.get("QID")).intValue(), (String) row.get("STUDANSWER"));
		}
		System.out.println("Mapped Student Answers: " + studentAnswers);
		return studentAnswers;
	}

	@Override
	public int fetchTotalScore(int studentId, int assessmentId) {
		return assessmentMapper.fetchTotalScore(studentId, assessmentId);
	}

	@Override
	public int addAssessment(Assessment assessment) {
		return assessmentMapper.insertAssessment(assessment);

	}

	@Override
	public void updateAssessmentById(Assessment assessment) {
		// TODO Auto-generated method stub
		assessmentMapper.updateAssessment(assessment);

	}

	@Override
	public void deleteAssessmentById(int aid) {
		// TODO Auto-generated method stub
		assessmentMapper.deleteQuestionAssessment(aid);
		assessmentMapper.deleteAssessmentById(aid);

	}

	@Override
	public List<Result> getResultsByAssessmentId(int assessmentId) {
		return assessmentMapper.getResultsByAssessmentId(assessmentId);
	}

	@Override
	public Map<Integer, String> getStudentAnswers(int studentId, int assessmentId) {
		List<Map<String, Object>> rawAnswers = assessmentMapper.getStudentAnswers(studentId, assessmentId);
		System.out.println("raw" + rawAnswers);
		Map<Integer, String> studentAnswers = new HashMap<>();

		for (Map<String, Object> row : rawAnswers) {
			// Convert BigDecimal to Integer
			System.out.println("row: " + row);
			Integer questionId = ((BigDecimal) row.get("QID")).intValue();
			String studAnswer = (String) row.get("STUDANSWER");
			System.out.println("questionId: " + questionId + ", studAnswer: " + studAnswer);
			studentAnswers.put(questionId, studAnswer);
		}

		return studentAnswers;
	}

	@Override
	public List<QuestionAnalytics> getQuestionsAnalytics(int assessmentId) {
		return assessmentMapper.getQuestionsAnalytics(assessmentId);

	}

}
