package review.flighbookingsystem;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
	 List<User> users=new ArrayList<>();
	 List<Flight> flights=new ArrayList<>();
	 List<Booking> bookings=new ArrayList<>();
	 
	 
	public void addFlight() {
		flights.add(new BuisinessFlight("A101","Mumbai","Delhi",20000,20));
		flights.add(new BuisinessFlight("A102","Delhi","Mumbai",20000,20));
		flights.add(new BuisinessFlight("A103","Lucknow","Delhi",20000,20));
		flights.add(new BuisinessFlight("A104","Kanpur","Delhi",20000,20));
		
		
	}
	 
	 
	public void addFlight(Flight flight) {
		flights.add(flight);
		System.out.println("Flight added successfully   ...");
		System.out.println(flight.toString());
	} 
	
	
	public  void registerUser(User user) {
		users.add(user);
		System.out.println("User added Successfully  ");
		System.out.println(user.toString());
	}
	
	public void displayFlight() {
		for(Flight f:flights) {
			System.out.println(f.toString());
		}
	}
	
	public Flight searchFlight(String origin, String destination) throws FlightNotAvailableException {
		if(flights.size()<=0) {
			throw new FlightNotAvailableException("Fligts are Not Available !!!");
		}
		for(Flight f: flights) {
			if(f.getOrigin().equalsIgnoreCase(origin) && f.getDestination().equalsIgnoreCase(destination)) {
				return f;
			}
		}
		throw new FlightNotAvailableException("Fligts are Not Available !!! "+ origin +" "+destination); 
	}
	
	
	
	public void bookFlight(int userId,String flightName,int option) throws FlightNotAvailableException {
		User user=getUserById(userId);
		Flight flight= getFlightByName(flightName);
		if(option==1) {
			String classs="Economy";
			Booking booking =new Booking(userId*2,user,flight,classs);
			bookings.add(booking);
			System.out.println("Flight Booked Successfully.....");
			System.out.println(booking.toString());
		}else if(option==2) {
			String classs="Business";
			Booking booking =new Booking(userId*2,user,flight,classs);
			bookings.add(booking);
			System.out.println("Flight Booked Successfully.....");
			System.out.println(booking.toString());
		}else {
			throw new FlightNotAvailableException("Enter the valdi Option");
		}
		
	}
	
	
	
	//cancel bookings
	public void cancelBooking(int bookingId) throws FlightNotAvailableException {
		Booking booking=getBookingById(bookingId);
		System.out.println(booking.toString());
		bookings.remove(booking);
		System.out.println("Booking Deleted Successfully....");
		
	}
	
	public void viewBookings(int userId) {
		List<Booking> userBookings=new ArrayList<>();
		userBookings=getBookingsById(userId);
		for(Booking b:userBookings) {
			System.out.println(b.toString());
		}
	}
	
	
	
	public User getUserById(int userId) throws FlightNotAvailableException {
		for(User u:users) {
			if(u.getId()==userId) {
				return u;
			}
		}
		throw new FlightNotAvailableException("User not Exists !!!!");
	}
	
	public Flight getFlightByName(String flightName) throws FlightNotAvailableException {
		for(Flight f:flights) {
			if(f.getName().equalsIgnoreCase(flightName)) {
				return f;
			}
		}
		throw new FlightNotAvailableException("Flight does Not Exists !!!!");
	}
	
	public Booking getBookingById(int id) throws FlightNotAvailableException {
		for(Booking b:bookings) {
			if(b.getBookingId()==id) {
				return b;
			}
		}
		
		throw new FlightNotAvailableException("Booking Id doesnt NOT exists in history !!!");
	}
	
	
	public List<Booking> getBookingsById(int userId){
		List<Booking> userBooking=new ArrayList<>();
		for(Booking  b:bookings) {
			if(b.getBookingId()==userId*2) {
				userBooking.add(b);
			}
		}
		return userBooking;
	}
	
	
}
