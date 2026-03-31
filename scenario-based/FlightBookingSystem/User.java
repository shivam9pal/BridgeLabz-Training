package week02.scenario.FlightBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String mobileNo;
	private List<Booking> bookingHistory;
	
	public User(int id,String name, String mobileNo) {
		this.id=id;
		this.name=name;
		this.mobileNo=mobileNo;
		bookingHistory=new ArrayList<>();
	}

	public void setBookingHistory(List<Booking> bookingHistory) {
		this.bookingHistory = bookingHistory;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public List<Booking> getBookingHistory() {
		return bookingHistory;
	}
	
	public void addBooking(Booking booking) {
		bookingHistory.add(booking);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", bookingHistory=" + bookingHistory
				+ "]";
	}
}
