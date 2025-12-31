package week02.gcrCodebase.constructor;

public class Vehicle {
	// Instance variable
    String ownerName;     
    String vehicleType;   

    // Class variable
    static double registrationFee = 5000; 
    //constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(6500);
        Vehicle v1 = new Vehicle("Amit", "Car");
        Vehicle v2 = new Vehicle("Ravi", "Bike");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}

