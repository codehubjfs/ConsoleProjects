package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class SeekerPasswordForget
 */

public class SeekerPasswordForget extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerPasswordForget() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // No specific logic for GET method in this case, but it could be implemented if needed
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Fetching the email from the request
        String email = req.getParameter("email");
System.out.println("email"+""+email);
        // Initialize the DAO and JobSeeker objects
        JobsSeekersDao seekerDao = new JobsSeekersDao();
        JobSeekers jobseeker = new JobSeekers();
        jobseeker.setEmail(email);

        // Attempt to retrieve the job seeker details based on the email
        JobSeekers js = seekerDao.forgetPassword(jobseeker);

        // Forwarding to the appropriate JSP based on whether the job seeker was found
        if (js != null) {
            req.getRequestDispatcher("/views/JobSeekers/ForgetPasswordSuccess.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/views/JobSeekers/ForgetPasswordError.jsp").forward(req, res);
        }
    }
}
