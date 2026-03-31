package week02.scenario.ridemanagementsystem;

import java.security.Provider.Service;

class RideManagementSystem {

	public static void main(String[] args) {
		
		// now first we need here ride service 
		RideService service=new RideService();
		
		//creating user
		User user1=new User(101,"shivam");
		User user2=new User(102,"Harsishyam");
		User user3=new User(103,"Harsishyam");
		
		//book ride 
		service.bookRide(user1, 78, false);
		service.bookRide(user2, 80, true);
		service.bookRide(user3, 80, true);
		
		service.rideHistory();
		
	}

}
