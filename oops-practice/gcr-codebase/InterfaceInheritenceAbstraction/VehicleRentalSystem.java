package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

interface Insurable {
	//abstract method
    double calculateInsurance();
    String getInsuranceDetails();
}


abstract class Vehicle {
	//attributes
    private String vehicleNumber;
    private String type;
    private double rentalRate; 

    // constructor
    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    // getters and setters 
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    protected double getRentalRatePerDay() {
        return rentalRate;
    }

    // abstract method
    public abstract double calculateRentalCost(int days);

    // concrete method
    public void displayDetails() {
        System.out.printf("Vehicle No    : %s%n", vehicleNumber);
        System.out.printf("Vehicle Type  : %s%n", type);
        System.out.printf("Rate / Day    : %.2f%n", rentalRate);
    }
}

//car 
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber; 

    Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRatePerDay() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (Policy Hidden)";
    }
}

//bike
class Bike extends Vehicle implements Insurable {

    private String insurancePolicyNumber;

    Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRatePerDay() * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override//making insurance hiiden
    public String getInsuranceDetails() {
        return "Bike Insurance (Policy Hidden)";
    }
}


class Truck extends Vehicle implements Insurable {

    private String insurancePolicyNumber;

    Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRatePerDay() * days) + 1000; 
    }

    @Override
    public double calculateInsurance() {
        return 1500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (Policy Hidden)";
    }
}

public class VehicleRentalSystem {
	public static void main(String[] args) {
	List<Vehicle> vehicles = new ArrayList<>();

    vehicles.add(new Car("CAR101", 2000, "CAR-POL-11"));
    vehicles.add(new Bike("BIKE202", 500, "BIKE-POL-22"));
    vehicles.add(new Truck("TRUCK303", 5000, "TRUCK-POL-33"));

    int rentalDays = 3;

    for (Vehicle v : vehicles) {

        v.displayDetails();

        double rentalCost = v.calculateRentalCost(rentalDays);
        double insuranceCost = 0;

        if (v instanceof Insurable) {
            Insurable i = (Insurable) v;
            insuranceCost = i.calculateInsurance();
            System.out.println("Insurance     : " + i.getInsuranceDetails());
        }

        System.out.printf("Rental Days   : %d%n", rentalDays);
        System.out.printf("Rental Cost  : %.2f%n", rentalCost);
        System.out.printf("Insurance Fee: %.2f%n", insuranceCost);
        System.out.printf("Total Cost   : %.2f%n",
                rentalCost + insuranceCost);

        System.out.println();
    	}
    }
}

