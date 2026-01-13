package week02.scenario.trafficmanager;

public class CircularLinkedList {

    private Vehicle head;
    private int size;
    private int maxCapacity;

    public CircularLinkedList(int maxCapacity) {
        this.head = null;
        this.size = 0;
        this.maxCapacity = maxCapacity;
    }

    public boolean isFull() {
        return size >= maxCapacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void addVehicle(Vehicle vehicle) throws RoundaboutFullException {
        if (isFull()) {
            throw new RoundaboutFullException("Roundabout is at maximum capacity (" + maxCapacity + ")");
        }

        if (isEmpty()) {
            head = vehicle;
            head.setNext(head);
        } else {
            Vehicle current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(vehicle);
            vehicle.setNext(head);
        }
        size++;
    }

    public Vehicle removeVehicle() throws RoundaboutEmptyException {
        if (isEmpty()) {
            throw new RoundaboutEmptyException("Roundabout is empty");
        }

        Vehicle removedVehicle = head;

        if (size == 1) {
            head = null;
        } else {
            Vehicle current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head.getNext());
            head = head.getNext();
        }
        size--;
        return removedVehicle;
    }

    public Vehicle moveToNextVehicle() throws RoundaboutEmptyException {
        if (isEmpty()) {
            throw new RoundaboutEmptyException("Roundabout is empty");
        }

        Vehicle currentVehicle = head;
        head = head.getNext();
        return currentVehicle;
    }

    public Vehicle getCurrentVehicle() {
        return head;
    }

    public void displayRoundaboutState() {
        if (isEmpty()) {
            System.out.println("Roundabout is empty!");
            return;
        }

        System.out.println("\n" + "=".repeat(120));
        System.out.println("ROUNDABOUT STATE (Total Vehicles: " + size + "/" + maxCapacity + ")");
        System.out.println("=".repeat(120));

        Vehicle current = head;
        int position = 1;

        do {
            String marker = (current == head) ? " >>> (CURRENT EXIT POINT)" : "";
            System.out.println(position + ". " + current + marker);
            current = current.getNext();
            position++;
        } while (current != head);

        System.out.println("=".repeat(120));
    }

    public Vehicle findVehicleById(int vehicleId) {
        if (isEmpty()) {
            return null;
        }

        Vehicle current = head;
        do {
            if (current.getVehicleId() == vehicleId) {
                return current;
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }

    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        if (isEmpty()) {
            return null;
        }

        Vehicle current = head;
        do {
            if (current.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return current;
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }
}
