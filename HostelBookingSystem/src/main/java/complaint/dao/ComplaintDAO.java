package complaint.dao;

import java.sql.*;
import complaint.model.Complaint;
import user.db.DBConnection;

public class ComplaintDAO {

    public void registerComplaint(Complaint complaint) {
        String sql = "INSERT INTO Complaint(user_id, description) VALUES (?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, complaint.getUserId());
            ps.setString(2, complaint.getDescription());
            ps.executeUpdate();
            System.out.println("Complaint Registered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewComplaints() {
        String sql = "SELECT * FROM Complaint";
        try (Connection conn = DBConnection.getInstance().getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                    "Complaint ID: " + rs.getInt("complaint_id") +
                    " | User ID: " + rs.getInt("user_id") +
                    " | Description: " + rs.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
