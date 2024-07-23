package com.hotelmanagement.controller;

import java.io.IOException;

import com.hotelmanagement.bean.LoginRegister;
import com.hotelmanagement.dao.RegisterUserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setContentType("text/html");
//		int id = Integer.parseInt( request.getParameter("id"));
//		String fName = request.getParameter("firstName");
//		String lName = request.getParameter("lastName");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String gender = request.getParameter("gender");
//		long phone = Long.parseLong(request.getParameter("phone"));
//		String address = request.getParameter("address");
//		String state = request.getParameter("state");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		//Class:
//		LoginRegister obj = new LoginRegister();
//		obj.setFirst_name(fName);
//		obj.setLast_name(lName);
//		obj.setAge(age);
//		obj.setGender(gender);
//		obj.setPhone(phone);
//		obj.setState(state);
//		obj.setEmail(email);
//		obj.setPassword(password);
//		
//		RegisterUserDao reg = new RegisterUserDao();
//		boolean  result = reg.validateUser(obj);
//		
//		if(result)
//		{
//			response.sendRedirect("views/user/login.jsp");
//		}
//		else {
//			response.sendRedirect("views/user/register.jsp");
//		}
		

        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        int age = Integer.parseInt( request.getParameter("age"));
        String gender = request.getParameter("gender");
        long phone =Long.parseLong(request.getParameter("phone"));
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate input
//        if (fName == null || lName == null || ageStr == null || gender == null || phoneStr == null || 
//            address == null || state == null || email == null || password == null ||
//            fName.isEmpty() || lName.isEmpty() || ageStr.isEmpty() || gender.isEmpty() ||
//            phoneStr.isEmpty() || address.isEmpty() || state.isEmpty() || email.isEmpty() || password.isEmpty()) {
//            response.sendRedirect("views/user/register.jsp?error=Missing+or+invalid+parameters");
//            return;
//        }

      
//            int age = Integer.parseInt(ageStr);
//            long phone = Long.parseLong(phoneStr);

            
            LoginRegister obj = new LoginRegister();
            obj.setFirstName(fName);
            obj.setLastName(lName);
            obj.setAge(age);
            obj.setGender(gender);
            obj.setPhoneNo(phone);
            obj.setAddress(address);
            obj.setState(state);
            obj.setEmail(email);
            obj.setPassword(password);

       
            RegisterUserDao reg = new RegisterUserDao();
            boolean result = reg.registerCustomer(obj);
            System.out.println("Result is "+result);
            if (result) {
                response.sendRedirect("views/user/login.jsp");
            }
                else {
                response.sendRedirect("views/user/register.jsp?error=Registration+failed");
            }
	}

}
