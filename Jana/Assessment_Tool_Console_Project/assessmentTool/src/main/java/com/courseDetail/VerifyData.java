package com.courseDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.smartcliff.assessmentTool.DbmsConnection;
import com.userDetail.Educator;
import com.userDetail.Student;

public interface VerifyData {

	// TO VERIFY WHETHER A STUDENT IS ALREADY PRESENT
	
	

	static Student validateStudent(int sid) {
		try {
			String sql1 = "select * from student where sid=?";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
			stmt.setInt(1, sid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt("sid"), rs.getString("email"), rs.getString("password"),
						rs.getString("fname"), rs.getString("lname"), rs.getString("gender"), rs.getString("city"),
						rs.getString("country"));
				return student;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// TO VERIFY WHETHER A EDUCATOR IS ALREADY PRESENT

	static Educator validateEducator(int eid) {
		try {
			String sql1 = "select * from educator where eid=?";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
			stmt.setInt(1, eid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Educator educator = new Educator(rs.getInt("eid"), rs.getString("email"), rs.getString("password"),
						rs.getString("fname"), rs.getString("lname"), rs.getString("gender"), rs.getString("city"),
						rs.getString("country")
				);
				return educator;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// TO VERIFY WHETHER A COURSE IS ALREADY PRESENT

	static Course validateCourse(int cid) {
		try {
			String sql1 = "select * from course where cid=?";
			PreparedStatement stmt = DbmsConnection.getConnection().prepareStatement(sql1);
			stmt.setInt(1, cid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Course c = new Course(rs.getInt("cid"), rs.getString("cname"));
				return c;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// TO VERIFY WHETHER A ASSESSMENT IS ALREADY PRESENT

	static Assessment checkAssessment(int aid, int cid) {
		String sql = "SELECT * FROM assessment WHERE aid = ? and cid=?";
		try (Connection connection = DbmsConnection.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, aid);
			stmt.setInt(2, cid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int aId = rs.getInt("aid");
				String aName = rs.getString("aname");
				String stTime = rs.getString("sttime");
				String endTime = rs.getString("endtime");
				double duration = rs.getDouble("duration");
				int totalMarks = rs.getInt("tot_mark");
				int cId = rs.getInt("cid");
				String aDate = rs.getString("adate");
				int eId = rs.getInt("eid");
				Assessment a = new Assessment(aId, aName, stTime, endTime, duration, totalMarks, cId, aDate, eId);
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

}
