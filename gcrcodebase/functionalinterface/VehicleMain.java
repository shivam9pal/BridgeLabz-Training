package week06.gcrcodebase.functionalinterface;


interface Vehicle {

    void displaySpeed();

    // New feature added later
    default void displayBattery() {
        System.out.println("Battery info not available for this vehicle.");
    }
}

class Car implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }
}

class Bike implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Bike speed: 60 km/h");
    }
}

class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Electric Car speed: 70 km/h");
    }

    @Override
    public void displayBattery() {
        System.out.println("Battery at 85%");
    }
}


class VehicleMain {
	public static void main(String[] args) {
		Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle eCar = new ElectricCar();

        car.displaySpeed();
        car.displayBattery();   // default

        bike.displaySpeed();
        bike.displayBattery();  // default

        eCar.displaySpeed();
        eCar.displayBattery();  // overridden
	}
}
