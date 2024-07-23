package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.AdminBean;
import util.Database;

public class AdminDao {

    public AdminBean login(String email, String password) throws ClassNotFoundException {
        AdminBean customer = null;
        
        String sql = "SELECT * FROM Admin WHERE email=? AND password=?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                customer = new AdminBean();
                customer.setUsername(email);
                customer.setPassword(password);
                customer.setFirstName(resultSet.getString("firstName"));
                customer.setLastName(resultSet.getString("lastName"));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return customer;
    }

    public void addAdmin(AdminBean admin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Database.getConnection();
            String maxIdQuery = "SELECT MAX(Admin_id) AS max_id FROM Admin";
            ps = con.prepareStatement(maxIdQuery);
            rs = ps.executeQuery();
            int newAdminId = 1;

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                newAdminId = maxId + 1; 
            }

            String query = "INSERT INTO admin (Admin_id, firstname, lastname, email, username, password, phonenumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, newAdminId);
            ps.setString(2, admin.getFirstName());
            ps.setString(3, admin.getLastName());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getUsername());
            ps.setString(6, admin.getPassword());
            ps.setString(7, admin.getPhoneNumber());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
