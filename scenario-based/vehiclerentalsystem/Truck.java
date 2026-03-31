package week02.scenario.vehiclerentalsystem;

public class Truck extends Vehicle implements Rentable{
	private double loadCapacity;
	
	public Truck(int vehicleId, String brand, String model, double dailyRate, double capacity) {
		super(vehicleId, brand, model, dailyRate);
		// TODO Auto-generated constructor stub
	}

	@Override
    public double calculateRent(int days) {
        return dailyRate * days ; 
    }

	@Override
    public void displayInfo() {
        System.out.println("🚚 Truck - ID: " + vehicleId + ", " + brand + " " + model + 
                          ", Capacity: " + loadCapacity + " tons, Rate: $" + dailyRate + "/day, Available: " + isAvailable);
    }

}
