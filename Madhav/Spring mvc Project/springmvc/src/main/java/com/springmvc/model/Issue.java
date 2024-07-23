package com.springmvc.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
	
	private int issueid;
	private String issuetitle;
	private String description;
	private Date ticketraisedate;
	private String raisedby;
	private String allocatedto;
	private String priority;
	private Date issuedate;
	private String status;

}
