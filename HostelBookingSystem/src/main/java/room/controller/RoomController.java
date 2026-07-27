package room.controller;

import java.util.Scanner;
import room.service.RoomService;

public class RoomController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoomService roomService = new RoomService();

        System.out.println("Welcome to Room Manager");

        boolean running = true;

        while(running){
            System.out.println("\n1. Add Room");
            System.out.println("2. List Rooms");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    System.out.print("Enter room number: ");
                    String roomNumber = sc.nextLine();

                    System.out.print("Enter room type: ");
                    String roomType = sc.nextLine();

                    roomService.addRoom(roomNumber, roomType);
                    System.out.println("Room added successfully!");
                    break;

                case 2:
                    roomService.listRooms();
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        sc.close();
    }
}
