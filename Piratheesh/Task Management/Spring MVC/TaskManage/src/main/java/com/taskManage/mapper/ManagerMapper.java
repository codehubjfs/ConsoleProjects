package com.taskManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.taskManage.model.AssignedTaskModel;
import com.taskManage.model.EmployeeModel;
import com.taskManage.model.PersonalTaskModel;
import com.taskManage.model.TaskAssignModel;
import com.taskManage.model.TaskModel;
import com.taskManage.model.UpdateTaskModel;

public interface ManagerMapper {

    @Select("select * from employee where email = #{email}")
    EmployeeModel getEmployee(@Param("email") String email);

    @Select("select count(*) as assigned_task_count "
            + "from employee e join transcation ts on e.emp_id = ts.emp_id "
            + "join task t on t.task_id = ts.task_id "
            + "join task_status st on st.id=ts.status_id "
            + "where e.email = #{email} and st.id=1")
    int getAssignedTaskCount(@Param("email") String email);

    @Select("select count(*) as assigned_task_count "
            + "from employee e join transcation ts on e.emp_id = ts.emp_id "
            + "join task t on t.task_id = ts.task_id "
            + "join task_status st on st.id=ts.status_id "
            + "where e.email = #{email} and st.id=4")
    int getCompletedTaskCount(@Param("email") String email);

    @Select("select count(*) as assigned_task_count "
            + "from employee e join transcation ts on e.emp_id = ts.emp_id "
            + "join task t on t.task_id = ts.task_id "
            + "join task_status st on st.id=ts.status_id "
            + "where e.email = #{email} and st.id=3")
    int getPendingTaskCount(@Param("email") String email);

    @Select("select count(*) as assigned_task_count "
            + "from employee e join transcation ts on e.emp_id = ts.emp_id "
            + "join task t on t.task_id = ts.task_id "
            + "join task_status st on st.id=ts.status_id "
            + "where e.email = #{email} and st.id=5")
    int getOverlayedTaskCount(@Param("email") String email);

    @Select("SELECT t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,st.status " +
            "FROM employee e " +
            "JOIN transcation ts ON e.emp_id = ts.emp_id " +
            "JOIN task t ON t.task_id = ts.task_id " +
            "JOIN task_status st ON st.id = ts.status_id " +
            "WHERE e.email = #{email} AND st.id = 1")
    List<AssignedTaskModel> getAssignedTasks(@Param("email") String email);

    @Select("SELECT t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,st.status " +
            "FROM employee e " +
            "JOIN transcation ts ON e.emp_id = ts.emp_id " +
            "JOIN task t ON t.task_id = ts.task_id " +
            "JOIN task_status st ON st.id = ts.status_id " +
            "WHERE e.email = #{email} AND st.id = 4")
    List<AssignedTaskModel> getCompletedTasks(@Param("email") String email);

    @Select("SELECT t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,st.status " +
            "FROM employee e " +
            "JOIN transcation ts ON e.emp_id = ts.emp_id " +
            "JOIN task t ON t.task_id = ts.task_id " +
            "JOIN task_status st ON st.id = ts.status_id " +
            "WHERE e.email = #{email} AND st.id = 3")
    List<AssignedTaskModel> getPendingTasks(@Param("email") String email);

    @Select("SELECT t.task_id, t.task_name, t.task_desp, t.start_date, t.end_date, t.task_priortiy ,st.status " +
            "FROM employee e " +
            "JOIN transcation ts ON e.emp_id = ts.emp_id " +
            "JOIN task t ON t.task_id = ts.task_id " +
            "JOIN task_status st ON st.id = ts.status_id " +
            "WHERE e.email = #{email} AND st.id = 5")
    List<AssignedTaskModel> getOverlayedTasks(@Param("email") String email);

    @Update("UPDATE employee SET city = #{city}, phone_number = #{phone_number} WHERE email = #{email}")
    int updateProfile(@Param("email") String email, @Param("phone_number") String phone_number, @Param("city") String city);
    
    @Select("SELECT * FROM personal_task WHERE email = #{email}")
    List<PersonalTaskModel> selectAllPersonalTasks(@Param("email") String email);
    
    @Insert("INSERT INTO personal_task VALUES (personalseq.nextval, #{task_name}, #{task_desp}, #{start_date}, #{end_date}, #{task_priority}, #{email},'Assigned')")
    void insertPersonalTask(PersonalTaskModel personaltaskmodel);
    
    @Update("UPDATE personal_task SET task_name = #{task_name}, task_desp = #{task_desp}, start_date = #{start_date}, end_date = #{end_date}, task_priority = #{task_priority} WHERE task_id = #{task_id} and email = #{email}")
    int updatePerosnalTask(PersonalTaskModel personaltaskmodel);
    
    @Update("UPDATE transcation SET status_id = #{task_status} where task_id = #{task_id} and emp_id= #{emp_id}")
    int updateEmployeeTask(UpdateTaskModel updatetaskmodel);
    
    @Select("SELECT * FROM task")
    List<TaskModel> selectAllTask();
    
    @Insert("INSERT INTO task VALUES (TASKSEQ.nextVal, #{task_name}, #{task_desp}, #{start_date}, #{end_date}, #{task_priortiy})")
    void insertTask(TaskModel taskmodel);
    
    @Update("UPDATE task SET task_name = #{task_name}, task_desp = #{task_desp}, start_date = #{start_date}, end_date = #{end_date}, task_priortiy = #{task_priortiy} WHERE task_id = #{task_id}")
    int updateTask(TaskModel taskmodel);
    
    @Select("SELECT * FROM personal_task WHERE email = #{email}")
    List<PersonalTaskModel> selectPersonalTasks(@Param("email") String email);
    
    @Select(" select tr.task_id, t.task_name, t.task_desp, t.task_priortiy, tr.emp_id, e.name, s.status from task_status s left join transcation tr on s.id=tr.status_id left join task t on tr.task_id=t.task_id left join employee e on tr.emp_id=e.emp_id where tr.assigner_id=(select emp_id from employee where email=#{email})")
    List<TaskAssignModel> taskAssignAll(@Param("email") String email);
    
//    @Select("select e.emp_id from employee e where e.mag_id = (select emp_id from employee where email = #{email})")
//    List<ID> getEmpid(String email);
    
    @Select("select t.task_name from task t left join transcation tr on t.task_id = tr.task_id where tr.emp_id=(select emp_id from employee where email = #{email})")
    List<TaskModel> selectTaskName(@Param("email") String email);
    
    @Delete("DELETE FROM task WHERE task_id = #{task_id}")
    void deleteTask(@Param("task_id") int task_id);
    
    @Insert("insert into transcation values (#{emp_id}, #{task_id},1,#{mag_id})")
    void insertAssign(@Param("emp_id")int emp_id,@Param("task_id")int task_id,@Param("mag_id")int mag_id);
    
    @Select("select * from employee where mag_id =#{mag_id}")
    List<EmployeeModel> selectEmployeeByMag(@Param("mag_id")int mag_id);
    
    @Update("update transcation set status_id = #{status_id} where emp_id=#{emp_id} and task_id=#{task_id}")
    void updateAssign(@Param("status_id")int status_id,@Param("emp_id")int emp_id,@Param("task_id")int task_id);
    
    @Delete("delete from personal_task where task_id = #{task_id} and email=#{email}")
    void deletePersonalTask(@Param("task_id")int task_id, @Param("email") String email);
    
    @Delete("delete from transcation where task_id = #{task_id} and emp_id=#{emp_id}")
    void deleteAssignTask(@Param("task_id")int task_id,@Param("emp_id")int emp_id);
    
    @Delete("delete from transcation where task_id = #{task_id}")
    void deleteAssignedTask(@Param("task_id") int task_id);
}
