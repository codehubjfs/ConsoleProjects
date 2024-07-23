package com.testPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testPortal.mapper.QuestionMapper;
import com.testPortal.model.Question;

@Service
public class QuestionServImpl implements QuestionService {

	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public List<Question> getQuestionsByAssessmentId(int assessmentId) {
		return questionMapper.getQuestionsByAssessmentId(assessmentId);
	}

	@Override
	public int addNewQuestion(Question question) {
		questionMapper.addNewQuestion(question);

		// The qid should now be populated in the 'question' object due to
		// useGeneratedKeys
		int qid = question.getQid();

		return qid;
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionMapper.getAllQuestions();
	}

	@Override
	public int assignQuestion(int aid, int qid) {
		return questionMapper.assignQuestion(aid, qid);
	}

	@Override
	public void deleteQuestion(int qid) {
		questionMapper.deleteQuestion(qid);

	}

	@Override
	public void deleteQuestionFromAssessment(int qid, int aid) {
		questionMapper.deleteQuestionFromAssessment(qid, aid);

	}

}
