package booking.model;

public class Booking {
    private int bookingId;
    private int allocationId;
    private int userId;
    private int bedsBooked;

    public Booking(int allocationId, int userId, int bedsBooked) {
        this.allocationId = allocationId;
        this.userId = userId;
        this.bedsBooked = bedsBooked;
    }

    public Booking(int bookingId, int allocationId, int userId, int bedsBooked) {
        this.bookingId = bookingId;
        this.allocationId = allocationId;
        this.userId = userId;
        this.bedsBooked = bedsBooked;
    }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getAllocationId() { return allocationId; }
    public void setAllocationId(int allocationId) { this.allocationId = allocationId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getBedsBooked() { return bedsBooked; }
    public void setBedsBooked(int bedsBooked) { this.bedsBooked = bedsBooked; }
}
