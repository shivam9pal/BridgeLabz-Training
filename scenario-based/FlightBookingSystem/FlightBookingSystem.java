package week02.scenario.FlightBookingSystem;

import java.util.Scanner;

public class FlightBookingSystem {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		FlightBooking service = new FlightBooking();
		System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile: ");
        String mobile = sc.nextLine();

        User user = new User(id, name, mobile);

        int choice;

        do {
            System.out.println("\n===== FLIGHT BOOKING MENU =====");
            System.out.println("1. View All Flights");
            System.out.println("2. Search Flight");
            System.out.println("3. Book Flight");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        service.showAllFlights();
                        break;

                    case 2:
                        System.out.print("Enter Origin: ");
                        String o = sc.nextLine();
                        System.out.print("Enter Destination: ");
                        String d = sc.nextLine();
                        System.out.println(service.searchFlight(o, d));
                        break;

                    case 3:
                        System.out.print("Enter Origin: ");
                        o = sc.nextLine();
                        System.out.print("Enter Destination: ");
                        d = sc.nextLine();
                        service.bookFlight(user, o, d);
                        break;

                    case 4:
                        service.displayBookings();
                        break;

                    case 5:
                        System.out.println("Thank you for using Flight Booking System!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (FlightNotAvailableException e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 5);

        sc.close();
	}
}
