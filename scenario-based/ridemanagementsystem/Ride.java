package week02.scenario.ridemanagementsystem;

class Ride {
	//calling all attributes 
	User user;
	Driver driver;
	double distance;
	double fare;
	
	public Ride(User user, Driver driver, double distance, double fare) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }
	//display ride 
	public void displayRide() {
        System.out.println(
            "User: " + user.name +
            ", Driver: " + driver.name +
            ", Distance: " + distance +
            " km, Fare: ₹" + fare
        );
    }
}
