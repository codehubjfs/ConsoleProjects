package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobsSeekersDao;

//@WebServlet("/SeekerProfileCreating")
public class SeekerProfileCreating extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SeekerProfileCreating() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String state = request.getParameter("state");
        String district = request.getParameter("district");
        String pincode = request.getParameter("pincode");
        String gender = request.getParameter("gender");

        // Education Information
        String eduQualification = request.getParameter("eduQualification");
        String course = request.getParameter("course");
        String specialization = request.getParameter("specialization");
        String passingYear = request.getParameter("passingYear");
        String institute = request.getParameter("institute");
        String cgpa = request.getParameter("cgpa");
        String courseType = request.getParameter("courseType");

        // Experience Information
        String yearsExperience = request.getParameter("yearsExperience");
        String designation = request.getParameter("designation");

        // Languages Known
        String language = request.getParameter("language");
        String proficiencyRead = request.getParameter("proficiency_read");
        String proficiencyWrite = request.getParameter("proficiency_write");
        String proficiencySpeak = request.getParameter("proficiency_speak");

        // Certification Information
        String certification = request.getParameter("certification");
        String certificationYear = request.getParameter("certificationYear");
        String certificationInstitute = request.getParameter("certificationInstitute");

        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("email");

        JobSeekers js = new JobSeekers();
        js.setName(name);
        js.setDob(dob);
        js.setState(state);
        js.setDistrict(district);
        js.setPincode(pincode);
        js.setGender(gender);
        js.setEduQualification(eduQualification);
        js.setCourse(course);
        js.setSpecialization(specialization);
        js.setPassingYear(passingYear);
        js.setInstitute(institute);
        js.setCgpa(cgpa);
        js.setCourseType(courseType);
        js.setYearsExperience(yearsExperience);
        js.setDesignation(designation);
        js.setLanguage(language);
        js.setProficiencyRead(proficiencyRead);
        js.setProficiencyWrite(proficiencyWrite);
        js.setProficiencySpeak(proficiencySpeak);
        js.setCertification(certification);
        js.setCertificationYear(certificationYear);
        js.setCertificationInstitute(certificationInstitute);
System.out.println(name+" kkxkkkskskks"+email);     
System.out.println(name+" kkxkkkskskks"+language);  
JobsSeekersDao seekerDao = new JobsSeekersDao();
        try {
            JobSeekers updatedSeeker = seekerDao.updateSeeker(js, email);

            if (updatedSeeker != null) {
                session.setAttribute("seeker", updatedSeeker);
              
                
                response.sendRedirect(request.getContextPath() + "/views/JobSeekers/SeekerDash.jsp");
            } else {
                // Handle the case where the update failed
                response.sendRedirect(request.getContextPath() + "/profileCreation.jsp?error=true");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
