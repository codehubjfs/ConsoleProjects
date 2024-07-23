package com.testPortal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.testPortal.model.Question;

@Mapper
public interface QuestionMapper {

	@Select("SELECT q.qid, q.questions, q.c1, q.c2, q.c3, q.c4, q.answer, q.mark " + "FROM question q "
			+ "JOIN questionassessment qa ON q.qid = qa.qid " + "WHERE qa.aId = #{assessmentId} order by qid")
	List<Question> getQuestionsByAssessmentId(@Param("assessmentId") int assessmentId);

	@Insert("INSERT INTO question (qid, questions, c1, c2, c3, c4, answer, mark) "
			+ "VALUES (quesseq.nextval, #{questions}, #{c1}, #{c2}, #{c3}, #{c4}, #{answer}, #{mark})")
	@Options(useGeneratedKeys = true, keyProperty = "qid", keyColumn = "qid")
	int addNewQuestion(Question question);

	@Select("SELECT qid, questions, c1, c2, c3, c4, answer, mark FROM question order by qid")
	List<Question> getAllQuestions();

	@Insert("INSERT INTO questionassessment (aid, qid) VALUES (#{aid}, #{qid})")
	int assignQuestion(@Param("aid") int aid, @Param("qid") int qid);

	@Delete("DELETE FROM question WHERE qid = #{qid}")
	void deleteQuestion(@Param("qid") int qid);

	@Delete("DELETE FROM questionassessment WHERE qid = #{qid} AND aid = #{aid}")
	void deleteQuestionFromAssessment(@Param("qid") int qid, @Param("aid") int aid);

}
