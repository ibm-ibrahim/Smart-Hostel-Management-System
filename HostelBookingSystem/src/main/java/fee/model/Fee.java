package fee.model;

public class Fee {
    private int feeId;
    private int bookingId;
    private double amount;
    private String feeType;
    private String status;

    public Fee(int bookingId, double amount, String feeType) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.feeType = feeType;
    }

    public int getFeeId() { return feeId; }
    public void setFeeId(int feeId) { this.feeId = feeId; }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getFeeType() { return feeType; }
    public void setFeeType(String feeType) { this.feeType = feeType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
