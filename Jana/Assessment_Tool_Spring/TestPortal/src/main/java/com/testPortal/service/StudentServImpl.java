package com.testPortal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testPortal.mapper.StudentMapper;
import com.testPortal.model.Course;
import com.testPortal.model.Question;
import com.testPortal.model.Student;
import com.testPortal.model.StudentAnswer;

@Service
public class StudentServImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public Student getStudentIdByEmail(String email) {
		return studentMapper.findSidByEmail(email);
	}

	@Override
	public List<Course> getCoursesByStudentId(int sid) {
		return studentMapper.findCoursesByStudentId(sid);
	}

	@Override
	public void saveStudentAnswers(int studentId, Map<Integer, String> answers, int assessmentId) {
		List<StudentAnswer> studentAnswers = new ArrayList<>();
		for (Map.Entry<Integer, String> entry : answers.entrySet()) {
			studentAnswers.add(new StudentAnswer(studentId, entry.getKey(), entry.getValue(), assessmentId));
		}
		for (StudentAnswer answer : studentAnswers) {
			studentMapper.insertStudentAnswer(answer);
		}
	}

	public void calculateAndStoreTotalMarks(int studentId, int assessmentId) {
		List<Question> questions = studentMapper.retrieveQuestions(assessmentId);
		List<StudentAnswer> studentAnswers = studentMapper.retrieveStudentAnswers(studentId, assessmentId);

		int totalMarks = calculateTotalMarks(questions, studentAnswers);
		studentMapper.storeTotalMarks(studentId, assessmentId, totalMarks);
	}

	private int calculateTotalMarks(List<Question> questions, List<StudentAnswer> studentAnswers) {
		int totalMarks = 0;

		for (int i = 0; i < questions.size(); i++) {
			Question question = questions.get(i);
			System.out.println("cans" + question.getAnswer());
			StudentAnswer studentAnswer = studentAnswers.get(i);
			System.out.println("sans" + studentAnswer);

			if (question.getAnswer() != null && question.getAnswer().equals(studentAnswer.getStudentAnswer())) {
				totalMarks += question.getMark();
				System.out.println("mark" + totalMarks);
			}
		}

		return totalMarks;
	}

}
