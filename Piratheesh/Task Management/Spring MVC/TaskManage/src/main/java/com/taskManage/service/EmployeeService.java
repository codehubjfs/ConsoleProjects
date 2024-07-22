package com.taskManage.service;

import java.util.List;

import com.taskManage.model.AssignedTaskModel;
import com.taskManage.model.EmployeeModel;
import com.taskManage.model.PersonalTaskModel;
import com.taskManage.model.TaskModel;
import com.taskManage.model.UpdateTaskModel;

public interface EmployeeService {

    EmployeeModel getByEmail(String email);

    int getByEmailAssigned(String email);

    int getByEmailCompleted(String email);

    int getByEmailPending(String email);

    int getByEmailOverlayed(String email);

    List<AssignedTaskModel> getAssignedTasks(String email);

    List<AssignedTaskModel> getCompletedTasks(String email);

    List<AssignedTaskModel> getPendingTasks(String email);

    List<AssignedTaskModel> getOverlayedTasks(String email);

    boolean updateProfile(String email, String phone_number, String city);

    List<PersonalTaskModel> getPersonalByEmail(String email);
    
    void insertPersonalTask(PersonalTaskModel personaltaskmodel);
    
    boolean updatePersonalTask(PersonalTaskModel personaltaskmodel);
    
    boolean updateEmployeeTask(UpdateTaskModel updatetaskmodel);
    
    List<PersonalTaskModel> selectPersonalTasks(String email);
    
    List<TaskModel> selectTaskName(String email);
    
    void deletePersonalTask(String email,int task_id);
}
