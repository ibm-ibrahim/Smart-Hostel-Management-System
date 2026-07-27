package allocation.controller;

import java.util.Scanner;
import allocation.model.RoomAllocation;
import allocation.service.AllocationService;

public class AllocationController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AllocationService service = new AllocationService();

        try {
            System.out.print("Enter Room ID: ");
            int roomId = sc.nextInt();

            System.out.print("Enter Duration (months): ");
            int duration = sc.nextInt();

            System.out.print("Enter Number of Beds Available: ");
            int beds = sc.nextInt();

            RoomAllocation allocation = new RoomAllocation(roomId, duration, beds);

            service.addAllocation(allocation);

            System.out.println("\n--- Current Room Allocations ---");
            service.viewAllocations();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error adding room allocation!");
        } finally {
            sc.close();
        }
    }
}
