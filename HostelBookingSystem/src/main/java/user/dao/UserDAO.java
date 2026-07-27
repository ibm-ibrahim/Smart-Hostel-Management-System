package user.dao;

import user.db.DBConnection;
import user.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public void saveUser(User user){
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO User(phone, email, name, password) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPhone());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getName());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            System.out.println("User saved successfully!");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean verifyUser(String email, String password){
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM User WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
