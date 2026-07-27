package complaint.controller;

import java.util.Scanner;
import complaint.model.Complaint;
import complaint.service.ComplaintService;

public class ComplaintController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplaintService service = new ComplaintService();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Complaint Description: ");
        String description = sc.nextLine();

        Complaint complaint = new Complaint(userId, description);
        service.registerComplaint(complaint);

        System.out.println("\n--- All Complaints ---");
        service.viewComplaints();

        sc.close();
    }
}
