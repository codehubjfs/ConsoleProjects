package com.testPortal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.testPortal.model.Assessment;
import com.testPortal.model.QuestionAnalytics;
import com.testPortal.model.Result;

public interface AssessmentMapper {

	@Select("SELECT * FROM assessment WHERE cid = #{courseId} order by aid desc")
	List<Assessment> getAssessmentsByCourseId(int courseId);

	@Select("SELECT COUNT(*) FROM studentmark WHERE sid = #{sid} AND aid = #{aid}")
	int checkAssessmentAlreadyTaken(@Param("sid") int sid, @Param("aid") int aid);

	@Select("SELECT * FROM assessment WHERE aid = #{assessmentId}")
	Assessment fetchAssessmentData(@Param("assessmentId") int assessmentId);

	@Select("SELECT q.qid, q.answer FROM question q JOIN questionassessment a ON q.qid = a.qid WHERE a.aid = #{assessmentId} ORDER BY q.qid")
	List<Map<String, Object>> fetchCorrectAnswers(@Param("assessmentId") int assessmentId);

	@Select("SELECT qid, studAnswer FROM StudentAnswer WHERE sid = #{studentId} AND AID = #{assessmentId} AND qid IN (SELECT q.qid FROM question q JOIN questionassessment a ON q.qid = a.qid WHERE a.aid = #{assessmentId}) ORDER BY qid")
	List<Map<String, Object>> fetchStudentAnswers(@Param("studentId") int studentId,
			@Param("assessmentId") int assessmentId);

	@Select("SELECT tot_mark FROM studentmark WHERE sid = #{studentId} AND aid = #{assessmentId}")
	Integer fetchTotalScore(@Param("studentId") int studentId, @Param("assessmentId") int assessmentId);

	@Insert("INSERT INTO assessment (aid, aname, sttime, endtime, duration, tot_mark, cid, adate, eid) "
			+ "VALUES (assessseq.nextval, #{aname}, #{sttime}, #{endtime}, #{duration}, #{tot_mark}, #{cid}, TO_DATE(#{adate}, 'YYYY-MM-DD'), #{eid})")
	int insertAssessment(Assessment assessment);

	@Delete("DELETE from questionassessment where aid = #{aid}")
	void deleteQuestionAssessment(int aid);

	@Delete("DELETE FROM assessment WHERE aid = #{aid}")
	void deleteAssessmentById(int aid);

	@Update("UPDATE assessment SET aname = #{aname}, adate = TO_DATE(#{adate}, 'YYYY-MM-DD'), sttime = #{sttime}, endtime = #{endtime}, duration = #{duration}, tot_mark = #{tot_mark}, cid = #{cid}, eid = #{eid} WHERE aid = #{aid}")
	void updateAssessment(Assessment assessment);

	@Select("SELECT s.sid as studentId, st.fname AS studentName, s.tot_mark AS studentMark " + "FROM studentmark s "
			+ "JOIN student st ON s.sid = st.sid " + "WHERE s.aid = #{assessmentId}")
	List<Result> getResultsByAssessmentId(@Param("assessmentId") int assessmentId);

	@Select("SELECT q.qid as questionId, q.answer AS correctAnswer " + "FROM question q "
			+ "JOIN questionassessment a ON q.qid = a.qid " + "WHERE a.aid = #{assessmentId} " + "ORDER BY q.qid")
	List<QuestionAnalytics> getQuestionsAnalytics(@Param("assessmentId") int assessmentId);

	@Select("SELECT QID, studAnswer " + "FROM StudentAnswer " + "WHERE SID = #{studentId} "
			+ "AND AID = #{assessmentId} " + "AND QID IN (SELECT q.QID " + "            FROM Question q "
			+ "            JOIN questionassessment a ON q.QID = a.QID " + "            WHERE a.AID = #{assessmentId}) "
			+ "ORDER BY QID")
	List<Map<String, Object>> getStudentAnswers(@Param("studentId") int studentId,
			@Param("assessmentId") int assessmentId);
}
