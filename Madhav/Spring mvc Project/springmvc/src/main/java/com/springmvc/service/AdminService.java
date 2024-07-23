package com.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.model.Admin;
import com.springmvc.model.Student;
import com.springmvc.model.Supervisor;
import com.springmvc.model.Warden;
import com.springmvc.model.Worker;

@Service
public interface AdminService {

	
	Admin getAdminUser(String mailid,String password);
	
	List<Admin>getAdminlist(String mailid);
	
	boolean insertStudent(Student student);
	
	boolean editStudent(Student student);
	
	boolean deleteStudent(Student student);
	
	boolean insertWarden(Warden warden);
	
	boolean editWarden(Warden warden);
	
	boolean deleteWarden(Warden warden);
	
	boolean insertSupervisor(Supervisor supervisor);
	
	boolean deleteSupervisor(Supervisor supervisor);
	
	boolean editSupervisor(Supervisor supervisor);
	
	boolean insertWorker(Worker worker);
	
	boolean deleteWorker(Worker worker);
	
}
