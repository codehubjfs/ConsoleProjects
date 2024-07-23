package com.testPortal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.testPortal.model.Course;
import com.testPortal.model.Question;
import com.testPortal.model.Student;
import com.testPortal.model.StudentAnswer;

@Mapper
public interface StudentMapper {

	@Select("SELECT * FROM student WHERE email = #{email}")
	Student findSidByEmail(@Param("email") String email);

	@Select("SELECT course.cid, course.cname, course.start_date, course.end_date FROM course INNER JOIN studentcourse ON course.cid = studentcourse.cid WHERE studentcourse.sid = #{sid}")
	List<Course> findCoursesByStudentId(@Param("sid") int sid);

	@Insert("INSERT INTO studentanswer (ANSID, SID, QID, STUDANSWER,AID) VALUES (ANSSEQ.NEXTVAL, #{studentId}, #{questionId}, #{studentAnswer}, #{assessmentId})")
	void insertStudentAnswer(StudentAnswer studentAnswer);

	@Select("SELECT q.QID, q.Questions, q.Answer, q.Mark " + "FROM Question q "
			+ "JOIN QuestionAssessment a ON q.QID = a.QID " + "WHERE a.AID = #{assessmentId} " + "ORDER BY q.QID")
	List<Question> retrieveQuestions(@Param("assessmentId") int assessmentId);

	@Select("SELECT SID AS studentId, QID AS questionId, studAnswer AS studentAnswer, AID AS assessmentId "
			+ "FROM StudentAnswer " + "WHERE SID = #{studentId} " + "AND AID = #{assessmentId} "
			+ "AND QID IN (SELECT q.QID " + "FROM Question q " + "JOIN QuestionAssessment a ON q.QID = a.QID "
			+ "WHERE a.AID = #{assessmentId}) " + "ORDER BY QID")
	List<StudentAnswer> retrieveStudentAnswers(@Param("studentId") int studentId,
			@Param("assessmentId") int assessmentId);

	@Insert("INSERT INTO Studentmark (sid, aid, tot_mark) VALUES (#{studentId}, #{assessmentId}, #{totalMarks})")
	void storeTotalMarks(@Param("studentId") int studentId, @Param("assessmentId") int assessmentId,
			@Param("totalMarks") int totalMarks);

}
