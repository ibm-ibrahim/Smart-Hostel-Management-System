package allocation.dao;

import java.sql.*;
import allocation.model.RoomAllocation;
import user.db.DBConnection; // Singleton DB connection

public class AllocationDAO {

    // Add a new room allocation
    public void addAllocation(RoomAllocation allocation) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO RoomAllocation(room_id, duration_months, beds_available) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, allocation.getRoomId());
            ps.setInt(2, allocation.getDurationMonths());
            ps.setInt(3, allocation.getBedsAvailable());
            ps.executeUpdate();
            System.out.println("Room allocation added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all allocations
    public void viewAllocations() {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT allocation_id, room_id, duration_months, beds_available FROM RoomAllocation"
            );

            while (rs.next()) {
                System.out.println(
                    "Allocation ID: " + rs.getInt("allocation_id") +
                    " | Room ID: " + rs.getInt("room_id") +
                    " | Duration (months): " + rs.getInt("duration_months") +
                    " | Beds Available: " + rs.getInt("beds_available")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
