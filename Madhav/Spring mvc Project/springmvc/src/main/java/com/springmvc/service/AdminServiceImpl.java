package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.AdminMapper;
import com.springmvc.model.Admin;
import com.springmvc.model.Student;
import com.springmvc.model.Supervisor;
import com.springmvc.model.Warden;
import com.springmvc.model.Worker;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	 AdminMapper adminMapper;
	
	
	public  Admin getAdminUser(String mailid,String password) {
		
		return adminMapper.getAdminUser(mailid,password);
		
	}
	@Override
	public List<Admin> getAdminlist(String mailid) {
		return adminMapper.getAdminlist(mailid);
		
	}
	
	public boolean insertStudent(Student student) {
		
		
		boolean inserted= adminMapper.insertStudent(student);
		return inserted;
	}
	@Override
	public boolean editStudent(Student student) {
		boolean inserted=adminMapper.editStudent(student);
		return inserted;
	}
	@Override
	public boolean deleteStudent(Student student) {
		boolean deleted=adminMapper.deleteStudent(student);
		
		return deleted;
	
	}
	@Override
	public boolean insertWarden(Warden warden) {
		// TODO Auto-generated method stub
		boolean inserted=adminMapper.insertWarden(warden);
		return inserted;
	}
	@Override
	public boolean editWarden(Warden warden) {
		boolean inserted=adminMapper.editWarden(warden);
		System.out.println(inserted);
		return inserted;
	}
	@Override
	public boolean deleteWarden(Warden warden) {
		
		boolean deleted=adminMapper.deleteWarden(warden);
		return deleted;
		
	}
	@Override
	public boolean insertSupervisor(Supervisor supervisor) {
		
		boolean inserted=adminMapper.insertSupervisor(supervisor);
		return inserted;
	}
	@Override
	public boolean deleteSupervisor(Supervisor supervisor) {
		boolean deleted=adminMapper.deleteSupervisor(supervisor);
		return deleted;
	}
	@Override
	public boolean editSupervisor(Supervisor supervisor) {
		boolean inserted=adminMapper.editSupervisor(supervisor);
		
		return inserted;
	}
	@Override
	public boolean insertWorker(Worker worker) {
		
		boolean inserted=adminMapper.insertWorker(worker);
		return inserted;
	}
	@Override
	public boolean deleteWorker(Worker worker) {
		boolean deleted=adminMapper.deleteWorker(worker);
		return deleted;
	}
	

}
