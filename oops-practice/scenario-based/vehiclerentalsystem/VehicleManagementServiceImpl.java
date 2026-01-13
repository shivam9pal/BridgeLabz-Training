package week02.scenario.vehiclerentalsystem;

import java.util.Scanner;

public class VehicleManagementServiceImpl {
	private static void initializeSampleData(VehicleManagementService service) {
        service.addVehicle(new Bike(1, "Yamaha", "R15", 50, 150));
        service.addVehicle(new Car(2, "Toyota", "Corolla", 100, 5));
        service.addVehicle(new Truck(3, "Tata", "407", 200, 5.0));
        service.addVehicle(new Bike(4, "Hero", "Splendor", 30, 100));
        service.addVehicle(new Car(5, "Honda", "City", 120, 5));
        
  
        service.addCustomer(new Customer(101, "harry ", "9876543210", "DL123456"));
        service.addCustomer(new Customer(102, "Sumit", "9876543211", "MH654321"));
        service.addCustomer(new Customer(103, "Mike Paul", "9876543212", "KA987654"));
	}
	
	public static void main(String[] args) {
		VehicleManagementService service = new VehicleManagementService();
        Scanner scanner = new Scanner(System.in);
        
        //with sample data for simulation
        initializeSampleData(service);
        
        System.out.println("=== VEHICLE RENTAL SYSTEM ===");
        int choice;
        
        while (true) {
            showMenu();
            System.out.print("Enter your choice (0 to exit): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    addNewVehicle(scanner, service);
                    break;
                case 2:
                    service.displayAvailableVehicles();
                    break;
                case 3:
                    addNewCustomer(scanner, service);
                    break;
                case 4:
                    rentVehicle(scanner, service);
                    break;
                case 5:
                    returnVehicle(scanner, service);
                    break;
                case 6:
                    service.displayAllVehicles();
                    break;
                case 0:
                    System.out.println(" Thank you for using Vehicle Rental System!");
                    return;
                default:
                    System.out.println(" Invalid choice! Try again.");
            }
            System.out.println("\n" + "=".repeat(40) + "\n");
        }
    }
    
    private static void showMenu() {
        System.out.println("\n MENU OPTIONS:");
        System.out.println("1. Add New Vehicle");
        System.out.println("2. View Available Vehicles");
        System.out.println("3. Register New Customer");
        System.out.println("4. Rent a Vehicle");
        System.out.println("5. Return a Vehicle");
        System.out.println("6. View All Vehicles");
        System.out.println("7. Run Simulation");
        System.out.println("0. Exit");
    }
    
    private static void addNewVehicle(Scanner scanner, VehicleManagementService service) {
        System.out.print("Vehicle Type (1-Bike, 2-Car, 3-Truck): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Daily Rate : ");
        double rate = scanner.nextDouble();
        
        switch (type) {
            case 1:
                System.out.print("Engine CC: ");
                int cc = scanner.nextInt();
                service.addVehicle(new Bike(service.getNextVehicleId(), brand, model, rate, cc));
                break;
            case 2:
                System.out.print("Number of Seats: ");
                int seats = scanner.nextInt();
                service.addVehicle(new Car(service.getNextVehicleId(), brand, model, rate, seats));
                break;
            case 3:
                System.out.print("Load Capacity (tons): ");
                double capacity = scanner.nextDouble();
                service.addVehicle(new Truck(service.getNextVehicleId(), brand, model, rate, capacity));
                break;
        }
    }
    
    private static void addNewCustomer(Scanner scanner, VehicleManagementService service) {
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("License Number: ");
        String license = scanner.nextLine();
        service.addCustomer(new Customer(service.getNextCustomerId(), name, phone, license));
    }
    
    private static void rentVehicle(Scanner scanner, VehicleManagementService service) {
        System.out.print("Enter Vehicle ID: ");
        int vehicleId = scanner.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Rental Days: ");
        int days = scanner.nextInt();
        service.rentVehicle(vehicleId, customerId, days);
    }
    
    
    private static void returnVehicle(Scanner scanner, VehicleManagementService service) {
        System.out.print("Enter Vehicle ID to return: ");
        int vehicleId = scanner.nextInt();
        service.returnVehicle(vehicleId);
    }
    
    
}
