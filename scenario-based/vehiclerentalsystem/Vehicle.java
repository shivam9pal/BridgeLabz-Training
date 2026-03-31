package week02.scenario.vehiclerentalsystem;

abstract class Vehicle {

	protected int vehicleId;
    protected String brand;
    protected String model;
    protected double dailyRate;
    protected boolean isAvailable;
    
    public Vehicle(int vehicleId, String brand, String model, double dailyRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }
    
    // Abstract method 
    public abstract void displayInfo();

	public int getVehicleId() {
		return vehicleId;
	}


	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean available) {
		this.isAvailable = available;
		}
	
}
