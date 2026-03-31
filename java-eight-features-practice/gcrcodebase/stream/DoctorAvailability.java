package week06.gcrcodebase.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    @Override
    public String toString() {
        return name + " | Specialty: " + specialty +
               " | Weekend Available: " + availableOnWeekend;
    }
}
class DoctorAvailability {
	
	public static void main(String[] args) {
		List<Doctor> doctors = Arrays.asList(
	            new Doctor("Dr. Smith", "Cardiology", true),
	            new Doctor("Dr. John", "Neurology", false),
	            new Doctor("Dr. Emma", "Orthopedics", true),
	            new Doctor("Dr. David", "Dermatology", true),
	            new Doctor("Dr. Sophia", "Pediatrics", false)
	    );
		
		doctors.stream().filter((d)->d.availableOnWeekend)
						.sorted(Comparator.comparing((d)->d.specialty)).forEach(System.out::println);
	}
}
