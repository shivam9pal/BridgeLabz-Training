package week02.gcrcodebase.inheritence;

// Interface
interface Refuelable {
    void refuel();
}

// Superclass
class Vehicles {
    int maxSpeed;
    String model;

    Vehicles(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed);
    }
}

// Electric Vehicle subclass
class ElectricVehicle extends Vehicles {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println("Electric Vehicle -> Model: " + model + ", Charging in progress");
    }
}

// Petrol Vehicle subclass implementing interface
class PetrolVehicle extends Vehicles implements Refuelable {
    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println("Petrol Vehicle -> Model: " + model + ", Refueling petrol");
    }
}

// Main class
public class VehicleSystemHybrid {

    public static void main(String[] args) {
        Vehicles v1 = new ElectricVehicle(160, "Tesla Model 3");
        Vehicles v2 = new PetrolVehicle(180, "Honda City");
        v1.displayInfo();
        ((ElectricVehicle) v1).charge();
        v2.displayInfo();
        ((PetrolVehicle) v2).refuel();
    }
}
