package com.taskManage.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManage.mapper.EmployeeMapper;
import com.taskManage.model.AssignedTaskModel;
import com.taskManage.model.EmployeeModel;
import com.taskManage.model.PersonalTaskModel;
import com.taskManage.model.TaskModel;
import com.taskManage.model.UpdateTaskModel;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeModel getByEmail(String email) {
        return employeeMapper.getEmployee(email);
    }

    @Override
    public int getByEmailAssigned(String email) {
        return employeeMapper.getAssignedTaskCount(email);
    }

    @Override
    public int getByEmailCompleted(String email) {
        return employeeMapper.getCompletedTaskCount(email);
    }

    @Override
    public int getByEmailPending(String email) {
        return employeeMapper.getPendingTaskCount(email);
    }

    @Override
    public int getByEmailOverlayed(String email) {
        return employeeMapper.getOverlayedTaskCount(email);
    }

    @Override
    public List<AssignedTaskModel> getAssignedTasks(String email) {
        return employeeMapper.getAssignedTasks(email);
    }

    @Override
    public List<AssignedTaskModel> getCompletedTasks(String email) {
        return employeeMapper.getCompletedTasks(email);
    }

    @Override
    public List<AssignedTaskModel> getPendingTasks(String email) {
        return employeeMapper.getPendingTasks(email);
    }

    @Override
    public List<AssignedTaskModel> getOverlayedTasks(String email) {
        return employeeMapper.getOverlayedTasks(email);
    }

    @Override
    public boolean updateProfile(String email, String phone_number, String city) {
        int rowsAffected = employeeMapper.updateProfile(email, phone_number, city);
        return rowsAffected > 0;
    }

	@Override
	public List<PersonalTaskModel> getPersonalByEmail(String email) {
		return employeeMapper.selectAllPersonalTasks(email);
	}

	@Override
	public void insertPersonalTask(PersonalTaskModel personaltaskmodel) {
		
		employeeMapper.insertPersonalTask(personaltaskmodel);
		
	}

	@Override
	public boolean updatePersonalTask(PersonalTaskModel personaltaskmodel) {
		int rowsAffected = employeeMapper.updatePerosnalTask(personaltaskmodel);
        return rowsAffected > 0;
	}

	@Override
	public boolean updateEmployeeTask(UpdateTaskModel updatetaskmodel) {
		int rowsAffected = employeeMapper.updateEmployeeTask(updatetaskmodel);
        return rowsAffected > 0;
	}
	
	@Override
    public List<PersonalTaskModel> selectPersonalTasks(String email) {
        List<PersonalTaskModel> tasks = employeeMapper.selectPersonalTasks(email);
        return tasks.stream()
                    .filter(task -> task.getEnd_date().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());
    }

	@Override
	public List<TaskModel> selectTaskName(String email) {
		return employeeMapper.selectTaskName(email);
	}

	@Override
	public void deletePersonalTask(String email, int task_id) {
		
		employeeMapper.deletePersonalTask(task_id, email);
		
	}

}
