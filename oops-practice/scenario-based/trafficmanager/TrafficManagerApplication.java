package week02.scenario.trafficmanager;

import java.util.*;

public class TrafficManagerApplication {

    private TrafficManagerService trafficManager;
    private Scanner scanner;
    private boolean isRunning = true;

    public TrafficManagerApplication() {
        this.trafficManager = new TrafficManagerService(5, 8); // 5 slots in roundabout, 8 in queue
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("SMART CITY ROUNDABOUT TRAFFIC MANAGEMENT SYSTEM");
        System.out.println("=".repeat(120));
        System.out.println("Real-time vehicle flow management using Circular Linked List and Queue");
        System.out.println("=".repeat(120));

        while (isRunning) {
            mainMenu();
        }
    }

    private void mainMenu() {
        System.out.println("\n" + "-".repeat(120));
        System.out.println("MAIN MENU");
        System.out.println("-".repeat(120));
        System.out.println("1. View Roundabout State");
        System.out.println("2. View Waiting Queue");
        System.out.println("3. Add Vehicle to Roundabout");
        System.out.println("4. Add Vehicle to Waiting Queue");
        System.out.println("5. Vehicle Exit from Roundabout");
        System.out.println("6. Rotate Vehicles in Roundabout");
        System.out.println("7. Search Vehicle");
        System.out.println("8. Traffic Status Report");
        System.out.println("9. Admin Panel");
        System.out.println("10. Exit System");
        System.out.println("-".repeat(120));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                trafficManager.displayRoundaboutState();
                break;
            case 2:
                trafficManager.displayQueueState();
                break;
            case 3:
                addVehicleToRoundabout();
                break;
            case 4:
                addVehicleToQueue();
                break;
            case 5:
                vehicleExit();
                break;
            case 6:
                rotateVehicles();
                break;
            case 7:
                searchVehicle();
                break;
            case 8:
                trafficManager.displayTrafficStatus();
                break;
            case 9:
                adminPanel();
                break;
            case 10:
                exitSystem();
                break;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
    }

    private void addVehicleToRoundabout() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("ADD VEHICLE TO ROUNDABOUT");
        System.out.println("-".repeat(100));

        if (trafficManager.isRoundaboutFull()) {
            System.out.println("✗ Roundabout is at maximum capacity!");
            System.out.println("  Please wait for a vehicle to exit or use the waiting queue.");
            return;
        }

        System.out.print("Enter License Plate (e.g., KA-01-AB-1234): ");
        String licensePlate = scanner.nextLine().trim();

        System.out.print("Enter Vehicle Type (Car/Bus/Truck/Motorcycle): ");
        String vehicleType = scanner.nextLine().trim();

        System.out.print("Enter Driver Name: ");
        String driverName = scanner.nextLine().trim();

        System.out.print("Enter Destination (North/South/East/West): ");
        String destination = scanner.nextLine().trim();

        try {
            trafficManager.addVehicleToRoundabout(licensePlate, vehicleType, driverName, destination);
        } catch (RoundaboutFullException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void addVehicleToQueue() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("ADD VEHICLE TO WAITING QUEUE");
        System.out.println("-".repeat(100));

        if (trafficManager.isQueueFull()) {
            System.out.println("✗ Waiting queue is at maximum capacity!");
            return;
        }

        System.out.print("Enter License Plate (e.g., KA-01-AB-1234): ");
        String licensePlate = scanner.nextLine().trim();

        System.out.print("Enter Vehicle Type (Car/Bus/Truck/Motorcycle): ");
        String vehicleType = scanner.nextLine().trim();

        System.out.print("Enter Driver Name: ");
        String driverName = scanner.nextLine().trim();

        System.out.print("Enter Destination (North/South/East/West): ");
        String destination = scanner.nextLine().trim();

        try {
            trafficManager.addVehicleToQueue(licensePlate, vehicleType, driverName, destination);
        } catch (QueueOverflowException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void vehicleExit() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("VEHICLE EXIT");
        System.out.println("-".repeat(100));

        if (trafficManager.isRoundaboutEmpty()) {
            System.out.println("✗ Roundabout is empty! No vehicles to exit.");
            return;
        }

        try {
            trafficManager.removeVehicleFromRoundabout();
        } catch (RoundaboutEmptyException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void rotateVehicles() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("ROTATE VEHICLES IN ROUNDABOUT");
        System.out.println("-".repeat(100));

        if (trafficManager.isRoundaboutEmpty()) {
            System.out.println("✗ Roundabout is empty! No vehicles to rotate.");
            return;
        }

        try {
            trafficManager.moveVehicleInRoundabout();
        } catch (RoundaboutEmptyException e) {
            System.out.println("✗ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void searchVehicle() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("SEARCH VEHICLE");
        System.out.println("-".repeat(100));
        System.out.println("1. Search by License Plate");
        System.out.println("2. Search by Vehicle ID");
        System.out.print("Enter search option: ");

        int option = getIntInput();

        if (option == 1) {
            System.out.print("Enter License Plate: ");
            String licensePlate = scanner.nextLine().trim();
            trafficManager.displayDetailedVehicleInfo(licensePlate);
        } else if (option == 2) {
            System.out.print("Enter Vehicle ID: ");
            int vehicleId = getIntInput();
            Vehicle vehicle = trafficManager.findVehicleInRoundabout(vehicleId);
            if (vehicle != null) {
                System.out.println("\n✓ Vehicle found in roundabout:");
                System.out.println(vehicle);
            } else {
                vehicle = trafficManager.findVehicleInQueue(vehicleId);
                if (vehicle != null) {
                    System.out.println("\n✓ Vehicle found in waiting queue:");
                    System.out.println(vehicle);
                } else {
                    System.out.println("✗ Vehicle not found!");
                }
            }
        } else {
            System.out.println("✗ Invalid option!");
        }
    }

    private void adminPanel() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("ADMIN PANEL - AUTHENTICATION");
        System.out.println("-".repeat(100));
        System.out.print("Enter Admin Password: ");

        String password = scanner.nextLine().trim();

        if (!password.equals("admin123")) {
            System.out.println("✗ Incorrect password!");
            return;
        }

        boolean adminActive = true;
        while (adminActive) {
            System.out.println("\n" + "-".repeat(100));
            System.out.println("ADMIN PANEL");
            System.out.println("-".repeat(100));
            System.out.println("1. View Roundabout Details");
            System.out.println("2. View Queue Details");
            System.out.println("3. System Statistics");
            System.out.println("4. Simulate Multiple Vehicles");
            System.out.println("5. Clear All Data");
            System.out.println("6. Exit Admin Panel");
            System.out.println("-".repeat(100));
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    trafficManager.displayRoundaboutState();
                    break;
                case 2:
                    trafficManager.displayQueueState();
                    break;
                case 3:
                    trafficManager.displayTrafficStatus();
                    break;
                case 4:
                    simulateMultipleVehicles();
                    break;
                case 5:
                    clearAllData();
                    break;
                case 6:
                    adminActive = false;
                    System.out.println("✓ Exited Admin Panel");
                    break;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        }
    }

    private void simulateMultipleVehicles() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("SIMULATE VEHICLE FLOW");
        System.out.println("-".repeat(100));
        System.out.print("Enter number of vehicles to simulate: ");

        int count = getIntInput();

        String[] vehicleTypes = {"Car", "Bus", "Truck", "Motorcycle"};
        String[] destinations = {"North Exit", "South Exit", "East Exit", "West Exit"};
        String[] driverNames = {"Rajesh", "Priya", "Arjun", "Neha", "Vikram", "Sneha", "Amit", "Deepak"};

        for (int i = 0; i < count; i++) {
            String licensePlate = "KA-" + String.format("%02d", (i % 99) + 1) + "-XY-" + String.format("%04d", i + 1000);
            String type = vehicleTypes[i % vehicleTypes.length];
            String driver = driverNames[i % driverNames.length];
            String destination = destinations[i % destinations.length];

            try {
                if (!trafficManager.isRoundaboutFull()) {
                    trafficManager.addVehicleToRoundabout(licensePlate, type, driver, destination);
                } else if (!trafficManager.isQueueFull()) {
                    trafficManager.addVehicleToQueue(licensePlate, type, driver, destination);
                    System.out.println("  (Roundabout full, added to queue)");
                } else {
                    System.out.println("✗ Both roundabout and queue are full!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("✗ Error adding vehicle: " + e.getMessage());
            }

            try {
                Thread.sleep(200); // Small delay for simulation effect
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n✓ Simulation completed!");
        trafficManager.displayTrafficStatus();
    }

    private void clearAllData() {
        System.out.println("\n" + "-".repeat(100));
        System.out.println("CLEAR ALL DATA");
        System.out.println("-".repeat(100));
        System.out.print("Are you sure you want to clear all data? (yes/no): ");

        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            trafficManager = new TrafficManagerService(5, 8);
            System.out.println("✓ All data cleared. System reinitialized with sample data.");
        } else {
            System.out.println("✗ Operation cancelled.");
        }
    }

    private void exitSystem() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("Thank you for using Traffic Manager System!");
        System.out.println("=".repeat(120));
        isRunning = false;
        System.exit(0);
    }

    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("✗ Please enter a valid integer!");
            return -1;
        }
    }

    public static void main(String[] args) {
        TrafficManagerApplication app = new TrafficManagerApplication();
        app.start();
    }
}
