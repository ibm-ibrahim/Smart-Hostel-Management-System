package room.model;

public class Room {
    private String roomNumber;
    private String roomType;

    public Room(String roomNumber, String roomType){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
}
