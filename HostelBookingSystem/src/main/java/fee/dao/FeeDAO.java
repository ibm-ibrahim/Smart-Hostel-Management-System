package fee.dao;

import java.sql.*;
import fee.model.Fee;
import user.db.DBConnection; // <-- Singleton

public class FeeDAO {

    // Record a fee payment
    public void payFee(Fee fee) {
        String sql = "INSERT INTO Fee(booking_id, amount, fee_type) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, fee.getBookingId());
            ps.setDouble(2, fee.getAmount());
            ps.setString(3, fee.getFeeType());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    fee.setFeeId(rs.getInt(1));
                    System.out.println("Fee recorded with ID: " + fee.getFeeId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
