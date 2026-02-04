package week06.gcrcodebase.functionalinterface;


interface Vehicle {
    void rent();
    void returnVehicle();
}
class Car implements Vehicle {

    @Override
    public void rent() {
        System.out.println("Car has been rented.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car has been returned.");
    }
}
class Bike implements Vehicle {

    @Override
    public void rent() {
        System.out.println("Bike has been rented.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike has been returned.");
    }
}
class Bus implements Vehicle {

    @Override
    public void rent() {
        System.out.println("Bus has been rented.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus has been returned.");
    }
}

class VehicleRental {
	public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        System.out.println();

        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}
