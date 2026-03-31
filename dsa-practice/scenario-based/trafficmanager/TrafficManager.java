package week03.scenariobased.trafficmanager;

class TrafficManager {
	public static void main(String[] args) {
		
		 // Traffic Manager
        VehicleQueue queue = new VehicleQueue(3);
        RoundAbout roundabout = new RoundAbout();

        queue.enqueue("CAR-101");
        queue.enqueue("CAR-102");
        queue.enqueue("CAR-103");
        queue.enqueue("CAR-104"); 
        // Overflow

        while (!queue.isEmpty()) {
            roundabout.addVehicle(queue.dequeue());
        }

        roundabout.printState();
        roundabout.removeVehicle("CAR-102");
        roundabout.printState();
	}
}
