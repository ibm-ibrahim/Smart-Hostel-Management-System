package complaint.model;

public class Complaint {
    private int complaintId;
    private int userId;
    private String description;

    public Complaint(int userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public int getComplaintId() { return complaintId; }
    public void setComplaintId(int complaintId) { this.complaintId = complaintId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
