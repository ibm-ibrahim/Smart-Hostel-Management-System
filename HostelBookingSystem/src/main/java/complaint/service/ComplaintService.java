package complaint.service;

import complaint.dao.ComplaintDAO;
import complaint.model.Complaint;

public class ComplaintService {
    ComplaintDAO dao = new ComplaintDAO();

    public void registerComplaint(Complaint complaint) {
        dao.registerComplaint(complaint);
    }

    public void viewComplaints() {
        dao.viewComplaints();
    }
}
