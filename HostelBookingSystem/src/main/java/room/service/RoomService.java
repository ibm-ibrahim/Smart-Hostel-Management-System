package room.service;

import room.dao.RoomDAO;

public class RoomService {
    RoomDAO dao = new RoomDAO();

    public void addRoom(String roomNumber, String roomType) {
        dao.addRoom(roomNumber, roomType);
    }

    public void listRooms() {
        dao.listRooms();
    }
}
