package com.testPortal.service;

import java.util.List;

import com.testPortal.model.Question;

public interface QuestionService {

	List<Question> getQuestionsByAssessmentId(int assessmentId);

	int addNewQuestion(Question question);

	List<Question> getAllQuestions();

	int assignQuestion(int aid, int qid);

	void deleteQuestion(int qid);

	void deleteQuestionFromAssessment(int qid, int aid);

}
