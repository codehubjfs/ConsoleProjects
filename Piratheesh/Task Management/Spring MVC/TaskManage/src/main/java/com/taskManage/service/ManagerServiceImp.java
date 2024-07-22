package com.taskManage.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManage.mapper.ManagerMapper;
import com.taskManage.model.AssignedTaskModel;
import com.taskManage.model.EmployeeModel;
import com.taskManage.model.PersonalTaskModel;
import com.taskManage.model.TaskAssignModel;
import com.taskManage.model.TaskModel;
import com.taskManage.model.UpdateTaskModel;

@Service
public class ManagerServiceImp implements ManagerService {

	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public EmployeeModel getByEmail(String email) {
		return managerMapper.getEmployee(email);
	}

	@Override
	public int getByEmailAssigned(String email) {
		return managerMapper.getAssignedTaskCount(email);
	}

	@Override
	public int getByEmailCompleted(String email) {
		return managerMapper.getCompletedTaskCount(email);
	}

	@Override
	public int getByEmailPending(String email) {
		return managerMapper.getPendingTaskCount(email);
	}

	@Override
	public int getByEmailOverlayed(String email) {
		return managerMapper.getOverlayedTaskCount(email);
	}

	@Override
	public List<AssignedTaskModel> getAssignedTasks(String email) {
		return managerMapper.getAssignedTasks(email);
	}

	@Override
	public List<AssignedTaskModel> getCompletedTasks(String email) {
		return managerMapper.getCompletedTasks(email);
	}

	@Override
	public List<AssignedTaskModel> getPendingTasks(String email) {
		return managerMapper.getPendingTasks(email);
	}

	@Override
	public List<AssignedTaskModel> getOverlayedTasks(String email) {
		return managerMapper.getOverlayedTasks(email);
	}

	@Override
	public boolean updateProfile(String email, String phone_number, String city) {
		int rowsAffected = managerMapper.updateProfile(email, phone_number, city);
        return rowsAffected > 0;
	}

	@Override
	public List<PersonalTaskModel> getPersonalByEmail(String email) {
		return managerMapper.selectAllPersonalTasks(email);
	}

	@Override
	public void insertPersonalTask(PersonalTaskModel personaltaskmodel) {
		
		managerMapper.insertPersonalTask(personaltaskmodel);
		
	}

	@Override
	public boolean updatePersonalTask(PersonalTaskModel personaltaskmodel) {
		int rowsAffected = managerMapper.updatePerosnalTask(personaltaskmodel);
        return rowsAffected > 0;
	}

	@Override
	public boolean updateEmployeeTask(UpdateTaskModel updatetaskmodel) {
		int rowsAffected = managerMapper.updateEmployeeTask(updatetaskmodel);
        return rowsAffected > 0;
	}
	
    public List<TaskModel> getFutureTasks() {
        List<TaskModel> tasks = managerMapper.selectAllTask();
        return tasks.stream()
                    .filter(task -> task.getEnd_date().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());
    }

	@Override
	public void insertTask(TaskModel taskmodel) {
		
		managerMapper.insertTask(taskmodel);
		
	}

	@Override
	public boolean updateTask(TaskModel taskmodel) {
		int rowsAffected = managerMapper.updateTask(taskmodel);
        return rowsAffected > 0;
	}
	
    public List<PersonalTaskModel> selectPersonalTasks(String email) {
        List<PersonalTaskModel> tasks = managerMapper.selectPersonalTasks(email);
        return tasks.stream()
                    .filter(task -> task.getEnd_date().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());
    }

	@Override
	public List<TaskAssignModel> taskAssignAll(String email) {
		System.out.println("hello service");
		System.out.println();
		return managerMapper.taskAssignAll(email);
	}

	@Override
	public void deleteTask(int task_id) {
		managerMapper.deleteTask(task_id);
	}

	@Override
	public void insertAssignTask(int emp_id, int task_id, int mag_id) {
		
		managerMapper.insertAssign(emp_id, task_id, mag_id);
		
	}

	@Override
	public List<EmployeeModel> selectEmployeeByMage(int mag_id) {
		return managerMapper.selectEmployeeByMag(mag_id);
	}

	@Override
	public void updateAssign(int status_id, int emp_id, int task_id) {
		managerMapper.updateAssign(status_id, emp_id, task_id);
		
	}
	
	@Override
	public void deletePersonalTask(String email, int task_id) {
		
		managerMapper.deletePersonalTask(task_id, email);
		
	}

	@Override
	public void deleteAssignTask(int task_id, int emp_id) {
		
		managerMapper.deleteAssignTask(task_id, emp_id);
		
	}
	
	@Override
    public List<PersonalTaskModel> selectPersonalAllTasks(String email) {
        List<PersonalTaskModel> tasks = managerMapper.selectPersonalTasks(email);
        return tasks.stream()
                    .filter(task -> task.getEnd_date().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());
    }

	@Override
	public void deleteAssignedTask(int task_id) {
		managerMapper.deleteAssignedTask(task_id);
		
	}

}
