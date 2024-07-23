package com.jobportal.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobsSeekersDao;

//@WebServlet("/SeekerRegister")
@MultipartConfig
public class SeekerRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SeekerRegister() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String course = request.getParameter("course");
        String specialization = request.getParameter("specialization");
        String institute = request.getParameter("institute");
        String passingYear = request.getParameter("passingYear");
        String cgpa = request.getParameter("cgpa");
        String companyName = request.getParameter("companyName");
        String experience = request.getParameter("experience");
        String designation = request.getParameter("designation");

        // Handling file upload for resume
        Part filePart = request.getPart("resume");
        InputStream fileContent = filePart.getInputStream();
        long fileSize = filePart.getSize();

//        HttpSession session = request.getSession();
//        String email = "arumukam@gmail.com"; // Retrieve email from session or other source
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("email");
        // Store other form data in database or session
        JobSeekers jobSeeker = new JobSeekers();
        jobSeeker.setDob(dob);
        jobSeeker.setGender(gender);
        jobSeeker.setAddress(address);
        jobSeeker.setCourse(course);
        jobSeeker.setSpecialization(specialization);
        jobSeeker.setInstitute(institute);
        jobSeeker.setPassingYear(passingYear);
        jobSeeker.setCgpa(cgpa);
        jobSeeker.setCompanyName(companyName);
        jobSeeker.setYearsExperience(experience);
        jobSeeker.setDesignation(designation);
        jobSeeker.setResumeFileName(getFileName(filePart)); // Store the file name in your bean or database entity

        // Example of saving job seeker details to database using DAO
        JobsSeekersDao dao = new JobsSeekersDao();
        try {
            boolean updateSuccess = dao.updateJobSeekerResumeAndDOB(email,jobSeeker, fileContent, fileSize);
            if (updateSuccess) {
                session.setAttribute("seeker", jobSeeker);
                response.sendRedirect(request.getContextPath() + "/views/JobSeekers/SeekerDash.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/views/JobSeekers/RegisterFail.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/views/JobSeekers/RegisterFail.jsp");
        } finally {
            fileContent.close();
        }
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
}
