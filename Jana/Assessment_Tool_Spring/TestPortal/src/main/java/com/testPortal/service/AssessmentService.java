package com.testPortal.service;

import java.util.List;
import java.util.Map;

import com.testPortal.model.Assessment;
import com.testPortal.model.QuestionAnalytics;
import com.testPortal.model.Result;

public interface AssessmentService {

	List<Assessment> getAssessmentsByCourseId(int courseId);

	boolean checkAssessmentAlreadyTaken(int sid, int aid);

	Assessment fetchAssessmentData(int assessmentId);

	Map<Integer, String> fetchCorrectAnswers(int assessmentId);

	Map<Integer, String> fetchStudentAnswers(int studentId, int assessmentId);

	int fetchTotalScore(int studentId, int assessmentId);

	int addAssessment(Assessment assessment);

	void updateAssessmentById(Assessment assessment);

	void deleteAssessmentById(int aid);

	List<Result> getResultsByAssessmentId(int assessmentId);

	List<QuestionAnalytics> getQuestionsAnalytics(int assessmentId);

	Map<Integer, String> getStudentAnswers(int studentId, int assessmentId);

}
