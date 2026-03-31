package week02.scenario.trafficmanager;

public class TrafficManagerService {

    private CircularLinkedList roundabout;
    private Queue waitingQueue;
    private int vehicleIdCounter = 1001;
    private int totalVehiclesProcessed = 0;
    private long totalTimeInRoundabout = 0;

    public TrafficManagerService(int roundaboutCapacity, int queueCapacity) {
        this.roundabout = new CircularLinkedList(roundaboutCapacity);
        this.waitingQueue = new Queue(queueCapacity);
        initializeData();
    }

    private void initializeData() {
        // Initialize with sample vehicles in roundabout
        try {
            addVehicleToRoundabout("KA-01-AB-1234", "Car", "Rajesh Kumar", "North Exit");
            addVehicleToRoundabout("KA-02-CD-5678", "Bus", "Priya Singh", "South Exit");
            addVehicleToRoundabout("KA-03-EF-9012", "Motorcycle", "Arjun Desai", "East Exit");

            // Add vehicles to waiting queue
            addVehicleToQueue("KA-04-GH-3456", "Car", "Neha Sharma", "West Exit");
            addVehicleToQueue("KA-05-IJ-7890", "Truck", "Vikram Mehta", "North Exit");
        } catch (Exception e) {
            System.out.println("Error initializing data: " + e.getMessage());
        }
    }

    // ====== ROUNDABOUT OPERATIONS ======
    public void addVehicleToRoundabout(String licensePlate, String vehicleType, String driverName, String destination)
            throws RoundaboutFullException, QueueUnderflowException {
        Vehicle vehicle = new Vehicle(vehicleIdCounter++, licensePlate, vehicleType, driverName, destination);
        roundabout.addVehicle(vehicle);
        System.out.println("✓ Vehicle " + licensePlate + " entered roundabout");
    }

    public void removeVehicleFromRoundabout() throws RoundaboutEmptyException {
        Vehicle exitingVehicle = roundabout.removeVehicle();
        totalVehiclesProcessed++;
        totalTimeInRoundabout += exitingVehicle.getTimeInRoundabout();

        System.out.println("✓ Vehicle " + exitingVehicle.getLicensePlate() + " exited roundabout");
        System.out.println("  Destination: " + exitingVehicle.getDestination());
        System.out.println("  Time in roundabout: " + (exitingVehicle.getTimeInRoundabout() / 1000) + " seconds");

        // Try to add waiting vehicle to roundabout
        if (!waitingQueue.isEmpty() && !roundabout.isFull()) {
            try {
                Vehicle waitingVehicle = waitingQueue.dequeue();
                roundabout.addVehicle(waitingVehicle);
                System.out.println("✓ Vehicle " + waitingVehicle.getLicensePlate() + " from queue entered roundabout");
            } catch (Exception e) {
                System.out.println("  Could not add waiting vehicle: " + e.getMessage());
            }
        }
    }

    public void moveVehicleInRoundabout() throws RoundaboutEmptyException {
        Vehicle movedVehicle = roundabout.moveToNextVehicle();
        System.out.println("✓ Vehicles rotated. Current exit point vehicle: " + movedVehicle.getLicensePlate());
    }

    public void displayRoundaboutState() {
        roundabout.displayRoundaboutState();
    }

    public CircularLinkedList getRoundabout() {
        return roundabout;
    }

    // ====== QUEUE OPERATIONS ======
    public void addVehicleToQueue(String licensePlate, String vehicleType, String driverName, String destination)
            throws QueueOverflowException {
        Vehicle vehicle = new Vehicle(vehicleIdCounter++, licensePlate, vehicleType, driverName, destination);
        waitingQueue.enqueue(vehicle);
        System.out.println("✓ Vehicle " + licensePlate + " added to waiting queue");
    }

    public void displayQueueState() {
        waitingQueue.displayQueueState();
    }

    public Queue getWaitingQueue() {
        return waitingQueue;
    }

    // ====== SEARCH OPERATIONS ======
    public Vehicle findVehicleInRoundabout(int vehicleId) {
        return roundabout.findVehicleById(vehicleId);
    }

    public Vehicle findVehicleInQueue(int vehicleId) {
        return waitingQueue.findVehicleById(vehicleId);
    }

    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        Vehicle vehicle = roundabout.findVehicleByLicensePlate(licensePlate);
        if (vehicle != null) {
            return vehicle;
        }
        return waitingQueue.findVehicleById(-1); // Placeholder for queue search
    }

    // ====== STATUS AND STATISTICS ======
    public void displayTrafficStatus() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("TRAFFIC MANAGER STATUS");
        System.out.println("=".repeat(120));
        System.out.println("Roundabout: " + roundabout.getSize() + "/" + roundabout.getMaxCapacity() + " vehicles");
        System.out.println("Waiting Queue: " + waitingQueue.getSize() + "/" + waitingQueue.getMaxCapacity() + " vehicles");
        System.out.println("Total Vehicles Processed: " + totalVehiclesProcessed);

        if (totalVehiclesProcessed > 0) {
            double avgTime = (double) totalTimeInRoundabout / (totalVehiclesProcessed * 1000);
            System.out.println("Average Time in Roundabout: " + String.format("%.2f", avgTime) + " seconds");
        }

        double occupancyRate = (double) roundabout.getSize() / roundabout.getMaxCapacity() * 100;
        System.out.println("Roundabout Occupancy Rate: " + String.format("%.2f", occupancyRate) + "%");

        double queueUtilization = (double) waitingQueue.getSize() / waitingQueue.getMaxCapacity() * 100;
        System.out.println("Queue Utilization Rate: " + String.format("%.2f", queueUtilization) + "%");

        System.out.println("=".repeat(120));
    }

    public void displayDetailedVehicleInfo(String licensePlate) {
        Vehicle vehicle = roundabout.findVehicleByLicensePlate(licensePlate);

        if (vehicle != null) {
            System.out.println("\n" + "=".repeat(100));
            System.out.println("VEHICLE DETAILS (In Roundabout)");
            System.out.println("=".repeat(100));
            System.out.println("Vehicle ID: " + vehicle.getVehicleId());
            System.out.println("License Plate: " + vehicle.getLicensePlate());
            System.out.println("Vehicle Type: " + vehicle.getVehicleType());
            System.out.println("Driver Name: " + vehicle.getDriverName());
            System.out.println("Destination: " + vehicle.getDestination());
            System.out.println("Time in Roundabout: " + (vehicle.getTimeInRoundabout() / 1000) + " seconds");
            System.out.println("=".repeat(100));
        } else {
            System.out.println("✗ Vehicle with license plate " + licensePlate + " not found in roundabout");
        }
    }

    public boolean isRoundaboutFull() {
        return roundabout.isFull();
    }

    public boolean isRoundaboutEmpty() {
        return roundabout.isEmpty();
    }

    public boolean isQueueFull() {
        return waitingQueue.isFull();
    }

    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }
}
