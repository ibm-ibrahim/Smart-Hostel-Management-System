package room.dao;

import room.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import user.db.DBConnection; // <-- Use singleton

public class RoomDAO {

    // Add a room
    public void addRoom(String roomNumber, String roomType){
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Room(room_number, room_type) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomNumber);
            ps.setString(2, roomType);
            ps.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // List all rooms
    public void listRooms(){
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Room";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("room_id") + ", Room No: " + rs.getString("room_number") + ", Type: " + rs.getString("room_type"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // Save a room object
    public void saveRoom(Room room) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Room(room_number, room_type) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, room.getRoomNumber());
            ps.setString(2, room.getRoomType());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
