package com.testPortal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.testPortal.model.Assessment;
import com.testPortal.model.Course;
import com.testPortal.model.Teacher;

@Mapper
public interface TeacherMapper {

	@Select("SELECT * FROM educator WHERE email = #{email}")
	Teacher findEidByEmail(@Param("email") String email);

	@Select("SELECT course.cid, course.cname, course.start_date, course.end_date FROM course INNER JOIN educatorcourse ON course.cid = educatorcourse.cid WHERE educatorcourse.eid = #{eid}")
	List<Course> findCoursesByTeacherId(@Param("eid") int eid);

	@Select("SELECT * FROM assessment WHERE cid = #{courseId}")
	List<Assessment> getAssessmentsByCourseId(int courseId);

	@Update("UPDATE educator SET fname = #{fname}, lname = #{lname}, gender = #{gender}, city = #{city}, country = #{country}, password = #{password} WHERE eid = #{eid}")
	void updateTeacher(Teacher teacher);

}
