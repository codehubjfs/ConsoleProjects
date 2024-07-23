package com.hotelmanagement.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.hotelmanagement.bean.Staff;
import com.hotelmanagement.dao.FrontStaffDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/")
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FrontStaffDao staffDAO;

    public void init() {
        staffDAO = new FrontStaffDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                	
                    insertStaff(request, response);
                    break;
                case "/delete":
                    deleteStaff(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStaff(request, response);
                    break;
                default:
                    listStaff(request, response);
                    break;
            }
        } 
        catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Staff> listStaff = staffDAO.selectAllStaff();
        request.setAttribute("listStaff", listStaff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff existingStaff = staffDAO.selectStaff(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp");
        request.setAttribute("staff", existingStaff);
        dispatcher.forward(request, response);
    }

    private void insertStaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = "Welcome@123";

        Staff newStaff = new Staff();
        newStaff.setName(name);
        newStaff.setEmail(email);
        newStaff.setPhone(phone);
        newStaff.setPassword(password);

        staffDAO.insertStaff(newStaff);
        response.sendRedirect("list");
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Staff staff = new Staff();
        staff.setId(id);
        staff.setName(name);
        staff.setEmail(email);
        staff.setPhone(phone);

        staffDAO.updateStaff(staff);
        response.sendRedirect("list");
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffDAO.deleteStaff(id);
        response.sendRedirect("list");
    }
}
