package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class SeekerProfileEdit
 */
//@WebServlet("/SeekerProfileEdit")
@MultipartConfig
public class SeekerProfileEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerProfileEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if needed
    	  String name = request.getParameter("name");
          String phone = request.getParameter("phone");
          String email = request.getParameter("email");
          String dob = request.getParameter("dob");
          String gender = request.getParameter("gender");
          String address = request.getParameter("address");
          String course = request.getParameter("course");
          String specialization = request.getParameter("specialization");
          String institute = request.getParameter("institute");
          String passingYear = request.getParameter("passingYear");
          String cgpa = request.getParameter("cgpa");
          String companyName = request.getParameter("companyName");
          String experience = request.getParameter("yearsExperience");
          String designation = request.getParameter("designation");
          String objective = request.getParameter("experienceDescription");
          String courseType = request.getParameter("courseType");
          System.out.println("Name: " + name);
          System.out.println("Phone: " + phone);
          System.out.println("Email: " + email);
          System.out.println("Date of Birth: " + dob);
          System.out.println("Gender: " + gender);
          System.out.println("Address: " + address);
          System.out.println("Course: " + course);
          System.out.println("Specialization: " + specialization);
          System.out.println("Institute: " + institute);
          System.out.println("Passing Year: " + passingYear);
          System.out.println("CGPA: " + cgpa);
          System.out.println("Company Name: " + companyName);
          System.out.println("Years of Experience: " + experience);
          System.out.println("Designation: " + designation);
          System.out.println("Objective: " + objective);
          System.out.println("Course Type: " + courseType);
          // Handling file upload for resume
          Part filePart = request.getPart("resume");
          InputStream fileContent = filePart.getInputStream();
          long fileSize = filePart.getSize();

          // Replace with actual logic to retrieve job seeker ID
          HttpSession session = request.getSession();
	        JobSeekers seeke = (JobSeekers) session.getAttribute("seeker");
	         int id =seeke.getSeeker_id();
	         
	         System.out.println(id +"your id");
          // Store other form data in database or session
          JobSeekers jobSeeker = new JobSeekers();
          jobSeeker.setName(name);
          jobSeeker.setPhone(phone);
          jobSeeker.setEmail(email);
          jobSeeker.setDob(dob);
          jobSeeker.setGender(gender);
          jobSeeker.setAddress(address);
          jobSeeker.setCourse(course);
          jobSeeker.setSpecialization(specialization);
          jobSeeker.setInstitute(institute);
          jobSeeker.setPassingYear(passingYear);
          jobSeeker.setCgpa(cgpa);
          jobSeeker.setObjective(objective);
          jobSeeker.setCourseType(courseType);
          jobSeeker.setCompanyName(companyName);
          jobSeeker.setYearsExperience(experience);
          jobSeeker.setDesignation(designation);
          jobSeeker.setResumeFileName(getFileName(filePart)); // Store the file name in your bean or database entity

          // Example of saving job seeker details to database using DAO
          JobsSeekersDao dao = new JobsSeekersDao();
          try {
              boolean updateSuccess = dao.updateJobSeekerDetails(id, jobSeeker, fileContent, fileSize);
              if (updateSuccess) {
                  session.setAttribute("seeker", jobSeeker);
                  response.sendRedirect("SeekerProfileEditController");
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
