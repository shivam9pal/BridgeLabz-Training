package week03.scenariobased.trafficmanager;

import java.util.LinkedList;
import java.util.Queue;

class VehicleQueue {
	private Queue<String> queue = new LinkedList<>();
    private int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
    }

    boolean enqueue(String v) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow: " + v + " cannot enter.");
            return false;
        }
        queue.add(v);
        return true;
    }

    String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow: No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }
}
