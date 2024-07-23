package com.testPortal.model;

public class StudentAnswer {

	private int studentId;
	private int questionId;
	private String studentAnswer;
	private int qid;
	private int sid;
	private String studAnswer;
	private int assessmentId;

	public StudentAnswer(int studentId, int questionId, String studentAnswer, int assessmentId) {
		this.studentId = studentId;
		this.questionId = questionId;
		this.studentAnswer = studentAnswer;
		this.assessmentId = assessmentId;
	}

	// Getters and setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getStudAnswer() {
		return studAnswer;
	}

	public void setStudAnswer(String studAnswer) {
		this.studAnswer = studAnswer;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	@Override
	public String toString() {
		return "StudentAnswer [studentId=" + studentId + ", questionId=" + questionId + ", studentAnswer="
				+ studentAnswer + ", qid=" + qid + ", sid=" + sid + ", studAnswer=" + studAnswer + ", assessmentId="
				+ assessmentId + "]";
	}

}
