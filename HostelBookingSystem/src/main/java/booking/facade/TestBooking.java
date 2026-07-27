package booking.facade;

import booking.dao.BookingDAO;
import fee.strategy.MonthlyFee;

public class TestBooking {
    public static void main(String[] args) {
        HostelFacade facade = new HostelFacade();

        // Book 2 beds for user 1, allocation 1, log a complaint, pay monthly fee of 5000
        facade.studentOperations(1, 1, 2, "Fan not working in room", 5000.0, new MonthlyFee());

        // Optional: view bookings
        BookingDAO bookingDAO = new BookingDAO();
        bookingDAO.viewBookings();
    }
}
