package com.issuesystem.issue;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.issuesystem.dbconnection.DBConnection;
import com.issuesystem.subcategory.Issue;


public class IssueInsert {

		public static void details(String username,int key,Issue obj) throws SQLException {
			
			
			String insertion = "INSERT INTO issues VALUES(issues_sequence.nextval,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt1 = DBConnection.getDBConnextion().prepareStatement(insertion);
			
			stmt1.setString(1,obj.getIssue_title());
			stmt1.setString(2, obj.getDescription());
			stmt1.setDate(3,Date.valueOf(obj.getIssue_raise_date()));
			stmt1.setInt(4, key);
			stmt1.setString(5, username);
			stmt1.setString(6, "Not-Allocated"); // Assuming the sixth parameter is supposed to be null
			stmt1.setString(7,obj.getPriority());
			stmt1.setDate(8,Date.valueOf(obj.getIssue_date()));
			stmt1.setString(9,"Raised");
			stmt1.executeUpdate();
			System.out.println("-------Issue Raised successfully-----");
		}

	}

