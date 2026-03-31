package week04.gcrcodebase.collections.queue;

import java.util.*;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {

    public static void main(String[] args) {

        // priorityqueue with custom rule 
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            (p1, p2) -> p2.severity - p1.severity
        );

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!queue.isEmpty()) {
            Patient p = queue.remove();
            System.out.println(p.name);
        }
    }
}

