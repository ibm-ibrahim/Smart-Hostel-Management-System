package booking.controller;

import java.util.Scanner;
import booking.model.Booking;
import booking.service.BookingService;

public class BookingController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingService service = new BookingService();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter Allocation ID: ");
        int allocationId = sc.nextInt();

        System.out.print("Enter Beds to Book: ");
        int bedsBooked = sc.nextInt();

        Booking booking = new Booking(allocationId, userId, bedsBooked);
        service.bookRoom(booking);

        service.viewBookings();
    }
}
