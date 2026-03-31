package week02.scenario.FlightBookingSystem;

public class Booking {
	private User user;
	private Flight flight;
	
	public Booking(User user,Flight flight) {
		this.flight=flight;
		this.user=user;
	}
}
