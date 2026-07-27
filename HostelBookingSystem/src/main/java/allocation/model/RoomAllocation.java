package allocation.model;

public class RoomAllocation {
    private int allocationId;
    private int roomId;
    private int durationMonths;
    private int bedsAvailable;

    public RoomAllocation(int roomId, int durationMonths, int bedsAvailable) {
        this.roomId = roomId;
        this.durationMonths = durationMonths;
        this.bedsAvailable = bedsAvailable;
    }

    public int getAllocationId() {
        return allocationId;
    }
    public void setAllocationId(int allocationId) {
        this.allocationId = allocationId;
    }

    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getDurationMonths() {
        return durationMonths;
    }
    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public int getBedsAvailable() {
        return bedsAvailable;
    }
    public void setBedsAvailable(int bedsAvailable) {
        this.bedsAvailable = bedsAvailable;
    }
}
