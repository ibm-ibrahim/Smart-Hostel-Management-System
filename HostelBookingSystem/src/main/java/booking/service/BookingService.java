package booking.service;

import booking.dao.BookingDAO;
import booking.model.Booking;

public class BookingService {
    BookingDAO dao = new BookingDAO();

    public void bookRoom(Booking booking) {
        dao.createBooking(booking);
    }

    public void viewBookings() {
        dao.viewBookings();
    }
}
