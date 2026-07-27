package fee.controller;

import java.util.Scanner;
import fee.service.FeeService;
import fee.strategy.FeeStrategy;
import fee.strategy.MonthlyFee;
import fee.strategy.YearlyFee;

public class FeeController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FeeService service = new FeeService();

        System.out.print("Enter Booking ID: ");
        int bookingId = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Fee Type (MONTHLY / YEARLY): ");
        String type = sc.nextLine();

        FeeStrategy strategy = type.equalsIgnoreCase("YEARLY") ? new YearlyFee() : new MonthlyFee();

        service.payFee(bookingId, amount, strategy);
    }
}
