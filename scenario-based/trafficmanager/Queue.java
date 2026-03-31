package week02.scenario.trafficmanager;

import java.util.*;

public class Queue {

    private java.util.Queue<Vehicle> waitingVehicles;
    private int maxCapacity;

    public Queue(int maxCapacity) {
        this.waitingVehicles = new LinkedList<>();
        this.maxCapacity = maxCapacity;
    }

    public boolean isFull() {
        return waitingVehicles.size() >= maxCapacity;
    }

    public boolean isEmpty() {
        return waitingVehicles.isEmpty();
    }

    public int getSize() {
        return waitingVehicles.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void enqueue(Vehicle vehicle) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Queue is at maximum capacity (" + maxCapacity + ")");
        }
        waitingVehicles.add(vehicle);
    }

    public Vehicle dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return waitingVehicles.poll();
    }

    public Vehicle peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return waitingVehicles.peek();
    }

    public void displayQueueState() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("WAITING QUEUE (Total Vehicles: " + getSize() + "/" + maxCapacity + ")");
        System.out.println("=".repeat(120));

        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            int position = 1;
            for (Vehicle vehicle : waitingVehicles) {
                String marker = (position == 1) ? " >>> (WILL ENTER NEXT)" : "";
                System.out.println(position + ". " + vehicle + marker);
                position++;
            }
        }
        System.out.println("=".repeat(120));
    }

    public Vehicle findVehicleById(int vehicleId) {
        for (Vehicle vehicle : waitingVehicles) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

    public void clearQueue() {
        waitingVehicles.clear();
    }
}
