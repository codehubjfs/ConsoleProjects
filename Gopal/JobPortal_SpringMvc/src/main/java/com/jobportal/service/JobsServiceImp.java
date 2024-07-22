package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.jobportal.mapper.JobsMapper;
import com.jobportal.model.Jobs;
@Service
public class JobsServiceImp implements JobsService{
	@Autowired
    private JobsMapper jobsMapper;
	 /**
     * Retrieves a list of all available jobs.
     * @return A list of Jobs objects representing the available job postings.
     */
	@Override
	public List<Jobs> viewJobs() {
		// TODO Auto-generated method stub
		return jobsMapper.viewJobs();
	}
	 /**
     * Retrieves the employer ID for a specific job.
     * @param job_Id The ID of the job.
     * @return The employer ID associated with the given job.
     */
	@Override
	public int getEmployerIdForJob(int job_Id) {
		// TODO Auto-generated method stub
		return jobsMapper.getEmployerIdForJob(job_Id);
	}
	
	/**
     * Allows a job seeker to apply for a specific job.
     * Handles DataIntegrityViolationException to manage unique constraint violations.
     * @param job_Id The ID of the job to apply for.
     * @param job_Seeker_Id The ID of the job seeker applying for the job.
     * @param employer_id The ID of the employer offering the job.
     * @return True if the application is successful; false otherwise.
     */
//	@Override
//	public boolean applyJob(int job_Id, int job_Seeker_Id, int employer_id) {
//		// TODO Auto-generated method stub
//		return jobsMapper.applyForJob(job_Id, job_Seeker_Id, employer_id);
//	}
	public boolean applyJob(int job_Id, int job_Seeker_Id, int employer_id) {
        try {
            return jobsMapper.applyForJob(job_Id, job_Seeker_Id, employer_id);
        } catch (DataIntegrityViolationException e) {
            // Handle unique constraint violation exception
            // You can log the error or throw a custom exception, or handle it based on your application's logic
//            e.printStackTrace(); // For logging purposes
            return false; // or throw a custom exception if needed
        }
    }
	
	 /**
     * Retrieves a list of jobs that a specific job seeker has applied for.
     * @param job_Seeker_Id The ID of the job seeker.
     * @return A list of Jobs objects that the job seeker has applied to.
     */
	@Override
	public List<Jobs> appliedJobs(int job_Seeker_Id) {
		// TODO Auto-generated method stub
		return jobsMapper.getJobApplicationsByJobSeekerId(job_Seeker_Id);
	}
	
	/**
     * Retrieves the status of a specific job application for a job seeker.
     * @param job_Id The ID of the job.
     * @param job_Seeker_Id The ID of the job seeker.
     * @param employer_id The ID of the employer.
     * @return The status of the job application (e.g., "Pending", "Accepted", "Rejected").
     */
	@Override
	public String jobStatus(int job_Id, int job_Seeker_Id, int employer_id) {
		// TODO Auto-generated method stub
		return jobsMapper.getStatusByJobIdEmpIdJobSeekerId(job_Id, employer_id, job_Seeker_Id);
	}

}
