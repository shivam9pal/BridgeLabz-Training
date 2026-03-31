package week02.scenario.vehiclerentalsystem;

class Bike extends Vehicle implements Rentable{
	private int engineCc;

	
	Bike(int vehicleId, String brand, String model, double dailyRate,int engineCc){
		super(vehicleId, brand, model, dailyRate);
        this.engineCc = engineCc;
	}


	public void displayInfo() {
        System.out.println(" Bike - ID: " + vehicleId + ", " + brand + " " + model + 
                          ", CC: " + engineCc + ", Rate: $" + dailyRate + "/day, Available: " + isAvailable);
    }


	@Override
	public double calculateRent(int days) {
		
		return dailyRate*days;
	}
	
	
}
