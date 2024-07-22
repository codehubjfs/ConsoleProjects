package com.taskManage.service;

import java.util.List;

import com.taskManage.model.AssignedTaskModel;
import com.taskManage.model.EmployeeModel;
import com.taskManage.model.PersonalTaskModel;
import com.taskManage.model.TaskAssignModel;
import com.taskManage.model.TaskModel;
import com.taskManage.model.UpdateTaskModel;

public interface ManagerService {

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
    
    List<TaskModel> getFutureTasks();
    
    void insertTask(TaskModel taskmodel);
    
    boolean updateTask(TaskModel taskmodel);
    
    List<TaskAssignModel> taskAssignAll(String email);
    
    void deleteTask(int task_id);
    
    void insertAssignTask(int emp_id,int task_id, int mag_id);
    
    List<EmployeeModel> selectEmployeeByMage(int mag_id);
    
    void updateAssign(int status_id, int emp_id, int task_id);
    
    void deletePersonalTask(String email,int task_id);
    
    void deleteAssignTask(int task_id,int emp_id);
    
    List<PersonalTaskModel> selectPersonalAllTasks(String email);
    
    void deleteAssignedTask(int task_id);
}
