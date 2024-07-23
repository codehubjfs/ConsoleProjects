package com.testPortal.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Result {

	private int studentId;
	private String studentName;
	private int studentMark;
	private Map<Integer, String> studentAnswers;

	// Getters and Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentMark() {
		return studentMark;
	}

	public void setStudentMark(int studentMark) {
		this.studentMark = studentMark;
	}

	public Map<Integer, String> getStudentAnswers() {
		return studentAnswers;
	}

	public void setStudentAnswers(Map<Integer, String> studentAnswers) {
		this.studentAnswers = studentAnswers;
	}

	@Override
	public String toString() {
		return "Result [studentId=" + studentId + ", studentName=" + studentName + ", studentMark=" + studentMark
				+ ", studentAnswers=" + studentAnswers + "]";
	}

}
