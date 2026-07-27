package booking.facade;

import booking.model.Booking;
import booking.dao.BookingDAO;
import complaint.dao.ComplaintDAO;
import complaint.model.Complaint;
import fee.dao.FeeDAO;
import fee.model.Fee;
import fee.strategy.FeeStrategy;

public class HostelFacade {

    private BookingDAO bookingDAO;
    private ComplaintDAO complaintDAO;
    private FeeDAO feeDAO;

    public HostelFacade() {
        bookingDAO = new BookingDAO();
        complaintDAO = new ComplaintDAO();
        feeDAO = new FeeDAO();
    }

    /**
     * Runs a full student flow in one call: book a room, optionally log a
     * complaint, and pay the fee via whichever FeeStrategy was chosen.
     * This mirrors the original studentOperations() method, now backed by
     * the database instead of just printing to the console.
     */
    public void studentOperations(int userId, int allocationId, int bedsBooked,
                                   String complaintDescription, double feeAmount, FeeStrategy feeStrategy) {
        try {
            System.out.println("Hostel booking started for User ID: " + userId);

            // 1. Create Booking
            Booking booking = new Booking(allocationId, userId, bedsBooked);
            bookingDAO.createBooking(booking);

            // 2. Register Complaint (optional, mirrors original ComplaintService call)
            if (complaintDescription != null && !complaintDescription.isEmpty()) {
                Complaint complaint = new Complaint(userId, complaintDescription);
                complaintDAO.registerComplaint(complaint);
            }

            // 3. Pay Fee (Strategy Pattern chooses Monthly/Yearly at runtime)
            feeStrategy.payFee();
            Fee fee = new Fee(booking.getBookingId(), feeAmount, feeStrategy.getFeeType());
            feeDAO.payFee(fee);

            System.out.println("Hostel booking completed successfully for User ID: " + userId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hostel booking failed for User ID: " + userId);
        }
    }
}
