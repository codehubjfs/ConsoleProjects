package com.carrentalsystem.dao;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.carrentalsystem.beans.Login;
import com.carrentalsystem.util.DBConnection;
import jakarta.servlet.http.HttpSession;
public class LoginDao {    
	public boolean validateLogin(Login user) throws SQLException{
		boolean flag=false;
		
			Connection conn=DBConnection.openConnection();
			PreparedStatement pst=conn.prepareStatement("select * from users where username=? and password=?");
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());			
			ResultSet rs=pst.executeQuery();
			flag=rs.next();
			System.out.println(flag);
			System.out.println("SUCC ^ _ ^ ESSF - _ - ULLY ' _ '  LOGG ! _ ! EDIN");
		
		return flag;	
	}
}
