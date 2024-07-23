package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springmvc.model.Admin;
import com.springmvc.model.Student;
import com.springmvc.model.Supervisor;
import com.springmvc.model.Warden;
import com.springmvc.model.Worker;

@Mapper

public interface AdminMapper {
	
	
	@Select("select * from admin where mailid=#{mailid} and password=#{password}")
	 Admin getAdminUser(@Param("mailid") String mailid,@Param("password")String password);
	
	@Select("select * from admin where mailid=#{mailid}")
	List<Admin>getAdminlist(@Param("mailid") String mailid);
	
	@Insert("insert into students values(studentseq.nextval,#{mailid},#{password},#{department},#{roomno},#{blockno},#{phonenumber},#{role},#{name})")
	boolean insertStudent(Student student);
	
	@Update("update students set name=#{name},roomno=#{roomno},blockno=#{blockno} where mailid=#{mailid}")
	boolean editStudent(Student student);
	
	@Delete("delete from students where mailid=#{mailid}")
	boolean deleteStudent(Student student);
	
	
	@Insert("insert into warden values(wardensequence.nextval,#{mailid},#{password},#{name},#{role})")
	boolean insertWarden(Warden warden);
	
	
	@Update("update warden set name=#{name} where wardenid=#{wardenid}")
	boolean editWarden(Warden warden);
	
	@Delete("delete from warden where wardenid=#{wardenid}")
	boolean deleteWarden(Warden warden);
	
	@Insert("insert into supervisor values(supsequence.nextval,#{mailid},#{password},#{name},#{role},#{department})")
	boolean insertSupervisor(Supervisor supervisor);
	
	
	@Delete("delete from supervisor where mailid=#{mailid}")
	boolean deleteSupervisor(Supervisor supervisor);
	
	@Update("update supervisor set name=#{name},department=#{department} where mailid=#{mailid}")
	boolean editSupervisor(Supervisor supervisor);
	
	@Insert("insert into workers values(workerssequence.nextval,#{name},#{phonenumber},#{department})")
	boolean insertWorker(Worker worker);
	
	@Delete("delete from workers where workersid=#{workersid}")
	boolean deleteWorker(Worker worker);

}
