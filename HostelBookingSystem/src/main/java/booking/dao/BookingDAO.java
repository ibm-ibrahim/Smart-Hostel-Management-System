package booking.dao;

import java.sql.*;
import booking.model.Booking;
import user.db.DBConnection; // <-- Singleton

public class BookingDAO {

    // Create a new booking
    public void createBooking(Booking booking) {
        String sql = "INSERT INTO Booking(user_id, allocation_id, beds_booked) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getAllocationId());
            ps.setInt(3, booking.getBedsBooked());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    booking.setBookingId(rs.getInt(1));
                    System.out.println("Booking successful with ID: " + booking.getBookingId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all bookings
    public void viewBookings() {
        String sql = "SELECT b.booking_id, b.user_id, b.beds_booked, r.room_id, r.room_number " +
                     "FROM Booking b " +
                     "JOIN RoomAllocation a ON b.allocation_id = a.allocation_id " +
                     "JOIN Room r ON a.room_id = r.room_id";

        try (Connection conn = DBConnection.getInstance().getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                    "Booking ID: " + rs.getInt("booking_id") +
                    " | User ID: " + rs.getInt("user_id") +
                    " | Room ID: " + rs.getInt("room_id") +
                    " | Room Number: " + rs.getString("room_number") +
                    " | Beds Booked: " + rs.getInt("beds_booked")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
