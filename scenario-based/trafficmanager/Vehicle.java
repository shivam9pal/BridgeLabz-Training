package week02.scenario.trafficmanager;

public class Vehicle {

    private int vehicleId;
    private String licensePlate;
    private String vehicleType; // Car, Bus, Truck, Motorcycle
    private String driverName;
    private String destination;
    private long entryTime;
    private Vehicle next;

    public Vehicle(int vehicleId, String licensePlate, String vehicleType, String driverName, String destination) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.destination = destination;
        this.entryTime = System.currentTimeMillis();
        this.next = null;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDestination() {
        return destination;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getNext() {
        return next;
    }

    public void setNext(Vehicle next) {
        this.next = next;
    }

    public long getTimeInRoundabout() {
        return System.currentTimeMillis() - entryTime;
    }

    @Override
    public String toString() {
        return "ID: " + vehicleId
                + " | License: " + licensePlate
                + " | Type: " + vehicleType
                + " | Driver: " + driverName
                + " | Destination: " + destination
                + " | Time: " + (getTimeInRoundabout() / 1000) + "s";
    }
}
