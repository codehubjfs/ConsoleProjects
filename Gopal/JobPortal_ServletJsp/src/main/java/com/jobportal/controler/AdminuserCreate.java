package com.jobportal.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.adminservices.AdminService;
import com.jobportal.bean.Admin;
import com.jobportal.dao.AdminDao;

/**
 * Servlet implementation class AdminuserCreate
 */
public class AdminuserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminuserCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    
   
    public class AdminController extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private AdminService adminService = new AdminService();

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            Admin admin = (Admin) session.getAttribute("admin");

            if (admin == null) {
                response.sendRedirect(request.getContextPath() + "/Adminlogin.jsp");
                return;
            }

            request.setAttribute("admin", admin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/demopro.jsp");
            dispatcher.forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");

            if ("edit".equals(action)) {
                editProfile(request, response);
            } else if ("register".equals(action)) {
                registerAdmin(request, response);
            }
        }

        private void editProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            Admin admin = (Admin) session.getAttribute("admin");

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("password");

            if (adminService.validateOldPassword(admin, oldPassword)) {
                admin.setName(name);
                admin.setEmail(email);
                admin.setPassword(newPassword);
                adminService.updateAdmin(admin);
                session.setAttribute("admin", admin);
                request.setAttribute("message", "Profile updated successfully.");
            } else {
                request.setAttribute("error", "Old password is incorrect.");
            }

            doGet(request, response);
        }

        private void registerAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Admin newAdmin = new Admin();

            if (adminService.registerAdmin(newAdmin)) {
                request.setAttribute("message", "New admin registered successfully.");
            } else {
                request.setAttribute("error", "Registration failed. Email already exists.");
            }

            doGet(request, response);
        }
    }

}
	







