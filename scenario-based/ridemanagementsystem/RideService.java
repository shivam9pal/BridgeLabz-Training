package week02.scenario.ridemanagementsystem;

import java.util.*;

//here we gonna write the core logic for booking management
class RideService {

	List<Driver> drivers=new ArrayList<>();
	List<Ride> rideHistory=new ArrayList<>();
	
	//now driver details 
	public RideService() {
		 drivers.add(new Driver(1, "Ramesh"));
	     drivers.add(new Driver(2, "Suresh"));
	}
	
	
	//now assigning driver
	public Driver assignDriver()throws NoDriverAvailableException {
		for(Driver driver:drivers) {
			if(driver.available) {
				driver.available=false;
				return driver;
			}
		}
		// throwing no driver exception intentionally
		throw new NoDriverAvailableException("No Driver Available Right Now");
	}
	
	//Booking ride logic 
	
	public void bookRide(User user,double distance,boolean isPeakHour){
		
		//driver can throw exception
		try {
		//first we need available driver 
		Driver driver=assignDriver();
		// here we gonna use polymorphism to choose the fare for peak hour or normal
		FareCalculator calculator;
		//checking hour 
		if(isPeakHour) {
			calculator=new PeakHourPricing();
		}else {
			calculator=new NormalHourPricing();
		}
		
		//calculating fare
		double fare=calculator.calculateFare(distance);
		
		//now book ride 
		Ride ride=new Ride(user,driver,distance,fare);
		
		//adding to history
		rideHistory.add(ride);
		
		System.out.println("Ride Booked Successfully");
		ride.displayRide();
		}catch(NoDriverAvailableException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//for ride history
	public void rideHistory() {
		System.out.println("All Ride History");
		for(Ride h:rideHistory) {
			h.displayRide();
		}
	}
}
