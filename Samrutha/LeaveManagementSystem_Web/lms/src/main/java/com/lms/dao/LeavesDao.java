package com.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lms.bean.Department;
import com.lms.bean.Employee;
import com.lms.bean.Leaves;
import com.lms.util.DbConnection;

public class LeavesDao {
	public static void insertLeave(Leaves leave) throws Exception {
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
        	String sql = "Insert into leaves values(leaveSeq.nextval,?, ?, ?, ?, ?,?, 'PENDING', null)";
        	PreparedStatement preparedStatement = connection.prepareStatement(sql); 
        	preparedStatement.setInt(1, leave.getEmp().getEmpId() );
            preparedStatement.setString(2, leave.getLeaveType().name());
            preparedStatement.setDate(3, java.sql.Date.valueOf(leave.getStartDate()));
            preparedStatement.setDate(4, java.sql.Date.valueOf(leave.getEndDate()));
            preparedStatement.setString(5, leave.getReason());
            preparedStatement.setString(6, leave.getAssignWork()); 
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
	public List<Leaves> selectAllLeaves() {
        List<Leaves> leaves = new ArrayList<>();
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
        
             PreparedStatement preparedStatement = connection.prepareStatement("select * from leaves");
             ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Leaves leave = new Leaves();
               
                leave.setLeaveType(Leaves.mapToEnum(rs.getString("leaveType")));
                leave.setStartDate(rs.getDate("startDate").toLocalDate());
                leave.setEndDate(rs.getDate("endDate").toLocalDate());
                leave.setReason(rs.getString("reason"));
                leave.setAssignWork(rs.getString("ASSIGNWORKID"));
                leave.setStatus(Leaves.mapToStatus(rs.getString("STATUS")));
                leave.setRejectionReason(rs.getString("rejectionReason"));
                leaves.add(leave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaves;
    }
	
	
	public static List<Leaves> selectLeavesByEmpId(Employee emp) {
	    List<Leaves> leaves = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet rs = null;

	    try {
	        connection = DbConnection.getInstance().getConnection();
	        preparedStatement = connection.prepareStatement("select * from leaves where empId = ?");
	        preparedStatement.setInt(1, emp.getEmpId());

	        rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            Leaves leave = new Leaves(); // Instantiate a new Leaves object inside the loop
	            leave.setEmp(emp);
	            leave.setLeaveId(rs.getInt("leaveID"));
	            leave.setLeaveType(Leaves.mapToEnum(rs.getString("leaveType")));
	            leave.setStartDate(rs.getDate("startDate").toLocalDate());
	            leave.setEndDate(rs.getDate("endDate").toLocalDate());
	            leave.setReason(rs.getString("reason"));
	            leave.setStatus(Leaves.mapToStatus(rs.getString("STATUS")));
	            leave.setAssignWork(rs.getString("ASSIGNWORK"));
	            leave.setRejectionReason(rs.getString("rejectionReason"));
	            leaves.add(leave); // Add the new Leaves object to the list
	            
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    
	    Collections.sort(leaves, new Comparator<Leaves>() {
            @Override
            public int compare(Leaves l1, Leaves l2) {
                return Integer.compare(l2.getLeaveId(), l1.getLeaveId());
            }
        });

	    return leaves;
	}
	
	
	public static void cancelLeave(int id) throws Exception {
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
        	String sql = "Update leaves set status = 'CANCELLED' where leaveId = ?";
        	PreparedStatement preparedStatement = connection.prepareStatement(sql); 
        	preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
	
	public static void updateLeave(Leaves leave) throws Exception {
		try {
			
        	Connection connection = DbConnection.getInstance().getConnection();
        	String sql = "UPDATE leaves SET startDate = ?, endDate = ?, reason = ?, assignWork = ? WHERE leaveId = ?";
        	PreparedStatement preparedStatement = connection.prepareStatement(sql); 
        	preparedStatement.setDate(1, Date.valueOf(leave.getStartDate()));
        	preparedStatement.setDate(2, Date.valueOf(leave.getEndDate()));
        	preparedStatement.setString(3, leave.getReason());
        	preparedStatement.setString(4, leave.getAssignWork());
        	preparedStatement.setInt(5, leave.getLeaveId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
	}
	
	public static List<Leaves> selectLeaveRequest(Employee emp) {
	    List<Leaves> leaves = new ArrayList<>();
	    
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet rs = null;

	    try {
	        connection = DbConnection.getInstance().getConnection();
	        preparedStatement = connection.prepareStatement("SELECT * FROM leaves l JOIN employee e1 ON e1.empId = l.empId JOIN department d ON e1.deptId = d.deptId WHERE e1.managerId = ?");

	        preparedStatement.setInt(1, emp.getEmpId());
	        
	        rs = preparedStatement.executeQuery();
	       
	        while (rs.next()) {
	        	
                Leaves leave = new Leaves(); // Instantiate a new Leaves object inside the loop
                Employee employee = new Employee();
                Department dept = new Department();
                
                dept.setDeptId(rs.getInt("DEPTID"));
                dept.setDeptName(rs.getString("deptName"));
                dept.setLocation(rs.getString("location"));
                
                
                employee.setEmpId(rs.getInt("empId"));
                employee.setFirstName(rs.getString("firstname"));
                employee.setLastName(rs.getString("lastName"));
                employee.setEmail(rs.getString("email"));
                employee.setDept(dept);
                employee.setManagerId(rs.getInt("managerId"));
                employee.setJoinDate(rs.getDate("joinDate").toLocalDate());
                employee.setSalaray(rs.getInt("salary"));
                employee.setGender(employee.mapToGender(rs.getString("gender")));
                employee.setRole(employee.mapToEnum(rs.getString("Role")));
                employee.setStatus(employee.mapToStatus(rs.getString("status")));
                employee.setUserName(rs.getString("userName"));
                employee.setPassword(rs.getString("password"));
                
                leave.setEmp(employee);
                leave.setLeaveId(rs.getInt("leaveID"));
                leave.setLeaveType(Leaves.mapToEnum(rs.getString("leaveType")));
                leave.setStartDate(rs.getDate("startDate").toLocalDate());
                leave.setEndDate(rs.getDate("endDate").toLocalDate());
                leave.setReason(rs.getString("reason"));
                leave.setStatus(Leaves.mapToStatus(rs.getString("STATUS")));
                leave.setAssignWork(rs.getString("ASSIGNWORK"));
                leave.setRejectionReason(rs.getString("rejectionReason"));
                
                leaves.add(leave); // Add the new Leaves object to the list
              }
            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    
	    Collections.sort(leaves, new Comparator<Leaves>() {
            @Override
            public int compare(Leaves l1, Leaves l2) {
                return Integer.compare(l1.getLeaveId(), l2.getLeaveId());
            }
        });
	   
	    return leaves;
	}
	
	public static void approveLeave(int id) throws Exception {
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
        	String sql = "Update leaves set status = 'APPROVED' where leaveId = ?";
        	PreparedStatement preparedStatement = connection.prepareStatement(sql); 
        	preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

	
	public static void reassignapproveLeave(int id, String name) throws Exception {
		
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
        	String sql = "Update leaves set status = 'APPROVED', ASSIGNWORK = ?  where leaveId = ?";
        	PreparedStatement preparedStatement = connection.prepareStatement(sql); 
        	preparedStatement.setString(1, name);
        	preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
	
	public static void rejectLeave(int id, String reason) throws Exception {
        try {
        	Connection connection = DbConnection.getInstance().getConnection();
        	String sql = "UPDATE leaves SET status = 'REJECTED', \"RejectionReason\" = ? WHERE leaveId = ?";
        	PreparedStatement preparedStatement = connection.prepareStatement(sql); 
        	preparedStatement.setInt(2, id);
        	if(reason.equals(null)) {
        		preparedStatement.setString(1, null);
        	}else {
        		preparedStatement.setString(1, reason);
        	}
            int n = preparedStatement.executeUpdate();
            if(n==1) {
            	System.out.println("success");
            }
            System.out.println("Leave dao");
            System.out.println(id);
            System.out.println(reason);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
