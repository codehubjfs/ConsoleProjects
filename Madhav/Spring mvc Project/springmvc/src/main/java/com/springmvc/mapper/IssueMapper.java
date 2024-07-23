package com.springmvc.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springmvc.model.Issue;

@Mapper
public interface IssueMapper {
	
	@Select("select * from issue order by issuedate desc")
	List<Issue> getIssue();

	@Select("SELECT * FROM (SELECT * FROM issue WHERE raisedby = #{mailid} ORDER BY issueid DESC) WHERE ROWNUM = 1")
	List<Issue> getRecentTicketsByUsername(@Param("mailid")String mailid);
	
	@Select("SELECT * FROM issue WHERE raisedby = #{mailid} order by issueid desc")
	List<Issue>getTicketsByUsername(@Param("mailid") String mailid);
	
	@Insert("insert into issue values(#{issuetitle},#{description},#{ticketraisedate},#{raisedby},#{allocatedto},#{priority},#{issuedate},#{status},ticketseq.nextval)")
	boolean insertNewTicket(Issue issue);
	
}
