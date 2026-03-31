package week02.gcrcodebase.inheritence;

// Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + ", Fuel Type: " + fuelType);
                           
    }
}
// Car subclass
class Car extends Vehicles {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    void displayInfo() {
        System.out.println("Car -> Max Speed: " + maxSpeed + ", Fuel Type: " + fuelType +", Seat Capacity: " + seatCapacity);                      
    }
}

// Truck subclass
class Truck extends Vehicles {
    int loadCapacity; 
    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    void displayInfo() {
        System.out.println("Truck -> Max Speed: " + maxSpeed +", Fuel Type: " + fuelType + ", Load Capacity: " + loadCapacity + " tons");                     
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicles {
    boolean hasGear;
    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    void displayInfo() {
        System.out.println("Motorcycle -> Max Speed: " + maxSpeed + ", Fuel Type: " + fuelType +  ", Has Gear: " + hasGear);
               
                           
    }
}


public class VehicleHierarchy {

    public static void main(String[] args) {

    	Vehicles[] vehicles=new Vehicles[3];
        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        for (Vehicles v : vehicles) {
            v.displayInfo();  
        }
    }
}
