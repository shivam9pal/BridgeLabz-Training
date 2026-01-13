package week02.scenario.vehiclerentalsystem;

class Car extends Vehicle implements Rentable{
	private int seats;
	
	public Car(int vehicleId, String brand, String model, double dailyRate, int seats) {
        super(vehicleId,brand,model,dailyRate);
        this.seats = seats;
    }

	@Override
    public void displayInfo() {
        System.out.println(" Car - ID: " + vehicleId + ", " + brand + " " + model + 
                          ", Seats: " + seats + ", Rate: $" + dailyRate + "/day, Available: " + isAvailable);
    }

	@Override
    public double calculateRent(int days) {
        return dailyRate * days;
    }	
}
