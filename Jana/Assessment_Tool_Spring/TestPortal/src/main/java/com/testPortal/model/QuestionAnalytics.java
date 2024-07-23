package com.testPortal.model;

import org.springframework.stereotype.Component;

@Component
public class QuestionAnalytics {

	private int questionId;
	private String correctAnswer;

	// Getters and Setters
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "QuestionAnalytics [questionId=" + questionId + ", correctAnswer=" + correctAnswer + "]";
	}

}
