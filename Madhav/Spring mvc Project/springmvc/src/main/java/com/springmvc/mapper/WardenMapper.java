package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Admin;
import com.springmvc.model.Issue;
import com.springmvc.model.Warden;

@Mapper
public interface WardenMapper {
	
	@Select("select * from warden order by wardenid ")
	List<Warden>getWarden();
	
	@Select("select * from warden where mailid=#{mailid} and password=#{password}")
	Warden getWardenUser(@Param("mailid")String mailid,@Param("password")String password);
	
	
	@Select("SELECT * FROM (SELECT * FROM issue WHERE status=#{status} ORDER BY issueid DESC) WHERE ROWNUM <=5")
	List<Issue> getRecentTicket(@Param("status")String status);
	
	
	@Update("update issue set allocatedto=#{supervisornName},status=#{status} where issueid=#{issueid}")
	boolean assignSupervisor(@Param("supervisornName")String supervisornName,@Param("issueid")int issueid,@Param("status")String status);
	

	@Update("update students set roomno=#{roomNo},blockno=#{blockno} where mailid=#{mailid}")
	boolean editRoom(@Param("mailid")String mailid,@Param("roomNo")int roomno,@Param("blockno")String blockno);
}
