package week02.gcrcodebase.staticfinal;

class Vehicle{
	private static double registrationFee = 150.0;

    // Final variable
    private final String registrationNumber;

    private String ownerName;
    private String vehicleType;
    
    // Constructor
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
 // Static method
    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
    // Display details
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
}

public class VehicleRegistrationSystem extends Vehicle{

	public VehicleRegistrationSystem(String ownerName, String vehicleType, String registrationNumber) {
		super(ownerName, vehicleType, registrationNumber);
	}
	
	public static void main(String[] args) {
		VehicleRegistrationSystem v1 = new VehicleRegistrationSystem("Honest raj", "Sedan", "ABC123");
		v1.displayVehicleDetails();
	}

}
