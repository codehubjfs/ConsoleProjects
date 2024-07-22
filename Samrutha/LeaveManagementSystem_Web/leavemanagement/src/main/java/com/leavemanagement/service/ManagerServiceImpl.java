package com.leavemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.mapper.ManagerMapper;
import com.leavemanagement.model.Employee;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    ManagerMapper managerMapper;
    
    @Override
     public List<Employee> getTeams(int id) {
        List<Employee> teams = managerMapper.getTeams(id);
        return teams;
    }
}
