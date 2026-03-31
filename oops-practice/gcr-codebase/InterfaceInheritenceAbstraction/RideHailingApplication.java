package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
abstract class Vehicle {

    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // constructor
    Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // encapsulated getters & setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    protected void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    // abstract method
    public abstract double calculateFare(double distance);

    // concrete method
    public void getVehicleDetails() {
        System.out.printf("Vehicle ID  : %s%n", vehicleId);
        System.out.printf("Driver Name : %s%n", driverName);
        System.out.printf("Rate / Km   : %.2f%n", ratePerKm);
    }
}

class Car extends Vehicle implements GPS {

    private String location;

    Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();   // base fare
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
class Bike extends Vehicle implements GPS {

    private String location;

    Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8; // cheaper fare
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
class Auto extends Vehicle implements GPS {

    private String location;

    Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return (distance * getRatePerKm()) + 20; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}


public class RideHailingApplication {

	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();

        Vehicle v1 = new Car("CAR101", "Shivam", 15);
        Vehicle v2 = new Bike("BIKE202", "Rahul", 10);
        Vehicle v3 = new Auto("AUTO303", "Amit", 12);

        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        double distance = 10; // km

        for (Vehicle v : vehicles) {

            v.getVehicleDetails();

            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                gps.updateLocation("MG Road");
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }

            System.out.printf("Fare for %.1f km : %.2f%n",
                    distance, v.calculateFare(distance));
            System.out.println("--");
        }

	}

}
