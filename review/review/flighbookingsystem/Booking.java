package review.flighbookingsystem;

public class Booking {
	private int bookingId;
	private User user;
	private Flight flight;
	private String classs;
	
	
	public Booking(int bookingId, User user, Flight flight,String classs) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.flight = flight;
		this.classs=classs;
	}
	int getBookingId() {
		return bookingId;
	}
	User getUser() {
		return user;
	}
	Flight getFlight() {
		return flight;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", flight=" + flight + ", classs=" + classs + "]";
	}
	String getClasss() {
		return classs;
	}
	
	
	

}
