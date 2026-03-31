package week06.gcrcodebase.lambda;
import java.util.ArrayList;
import java.util.List;

class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

public class HospitalAlert {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        patients.add(new Patient(101, "John"));
        patients.add(new Patient(102, "Emma"));
        patients.add(new Patient(103, "David"));

        System.out.println("=== Patient IDs ===");

        patients.stream()
                .map(Patient::getId)      // Method Reference
                .forEach(System.out::println); // Method Reference
    }
}
