package week02.scenario.vehiclerentalsystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleManagementService {
	private List<Vehicle> vehicles;
    private List<Customer> customers;
    
    private int nextVehicleId = 6;
    private int nextCustomerId = 104;

    
    public VehicleManagementService() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
    }
    //add vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getBrand() + " " + vehicle.getModel());
    }
    
    //add customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer.getName());
    }
    //vehicle
    public void displayAvailableVehicles() {
        System.out.println("\n=== AVAILABLE VEHICLES ===");
        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                v.displayInfo();
            }
        }
    }
    //getcustomer
    public Customer findCustomer(int customerId) {
        for (Customer c : customers) {
            if (c.getCustomerId() == customerId) return c;
        }
        return null;
    }
    
 // UPDATE Operations
    public void rentVehicle(int vehicleId, int customerId, int days) {
        Customer customer = findCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle != null && vehicle.isAvailable()) {
            double rent = vehicle.getDailyRate(); 
            vehicle.setAvailable(false);
            System.out.println("\n✅ RENTAL CONFIRMED");
            System.out.println(customer);
            vehicle.displayInfo();
            System.out.println("Rental Days: " + days + ", Total Rent: $" + rent);
        } else {
            System.out.println("Vehicle not available or not found!");
        }
    }
    
    
    public void returnVehicle(int vehicleId) {
        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle != null) {
            vehicle.setAvailable(true);
            System.out.println("Vehicle returned: " + vehicle.getBrand() + " " + vehicle.getModel());
        }
    }
    
    private Vehicle findVehicle(int vehicleId) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == vehicleId) return v;
        }
        return null;
    }
    
    
    public int getNextVehicleId() {
        return nextVehicleId++;
    }

    public int getNextCustomerId() {
        return nextCustomerId++;
    }

    public void displayAllVehicles() {
        System.out.println("\n ALL VEHICLES ");
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}
