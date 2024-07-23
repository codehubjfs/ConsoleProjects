package com.adminservices;

import java.sql.SQLException;

import com.jobportal.bean.Admin;
import com.jobportal.dao.AdminDao;

public class AdminService {
	private AdminDao adminDAO;

    public AdminService() {
        this.adminDAO = new AdminDao();
    }

    public Admin getAdminByEmail(String email) {
        return adminDAO.findAdminByEmail(email);
    }

    public boolean validateOldPassword(Admin admin, String oldPassword) {
        return admin.getPassword().equals(oldPassword);
    }

    public void updateAdmin(Admin admin) {
        try {
			adminDAO.updateAdmin(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    }

    public boolean registerAdmin(Admin admin) {
        if (adminDAO.findAdminByEmail(admin.getEmail()) == null) {
            try {
				adminDAO.saveAdmin(admin);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return true;
        } else {
            return false;
        }
    }
}
