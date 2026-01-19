package review.flighbookingsystem;

import java.util.Scanner;

public class BookingServiceImpl {
	public static void main(String[] args) throws FlightNotAvailableException {
		Scanner sc=new Scanner(System.in);
		BookingService service=new BookingService();
		service.addFlight();
		boolean flag=true;
		while(flag) {
		try {
			System.out.println(" 1. Create  User :");
			System.out.println(" 2. Search Flights :");
			System.out.println(" 3. Book Ticket :");
			System.out.println(" 4. View Booking :");
			System.out.println(" 5. Cancel Booking :");
			
			
			
			
			int option=sc.nextInt();
			sc.nextLine();
			switch(option) {
			case 1:{
				System.out.print("Enter the ID :");
				int id=sc.nextInt();
				System.out.print("Enter the the Name :");
				String name=sc.next();
				System.out.print("Enter the the Contact No :");
				String phoneNo=sc.next();
				User user=new User(id,name,phoneNo);
				service.registerUser(user);
				break;
				}
			
			case 2:{
				System.out.print("Enter the origin :");
				String origin=sc.next();
				System.out.print("Enter the destination :");
				String destination=sc.next();
				Flight flight=service.searchFlight(origin, destination);
				System.out.println(flight.toString());
				break;
				}
			
			case 3:{
				
				System.out.print("Enter the user id :");
				int userId=sc.nextInt();
				System.out.print("Enter the Flight Name  :");
				String flightName=sc.next();
				System.out.print("Enter 1 for Economy & 2 for Business Class  :");
				int id=sc.nextInt();
				service.bookFlight(userId,flightName,id);
				
				break;
			}
			
			case 4:{
				System.out.print("Enter the user id :");
				int userId=sc.nextInt();
				service.viewBookings(userId);
				break;
			}
			
			case 5:{
				System.out.print("Enter the Booking Id  :");
				int bookingId=sc.nextInt();
				service.cancelBooking(bookingId);
				break;
			}
			case 0:{
				flag=false;
				break;
			}
			
			}
			
		
		}catch(FlightNotAvailableException e) {
			System.out.println(e.getMessage());
		}
		}
	}
}
