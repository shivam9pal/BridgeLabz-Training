package week02.gcrcodebase.staticfinal;

class Patient{
	private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    // Final variable
    private final String patientID;

    private String name;
    private int age;
    private String ailment;
    
 // Constructor
    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
 // Static method
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    
 // Display details
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
}

public class HospitalManagSystem extends Patient{

	public HospitalManagSystem(String name, int age, String ailment, String patientID) {
		super(name, age, ailment, patientID);
	}
	public static void main(String[] args) {
		HospitalManagSystem p1 = new HospitalManagSystem("Lathika", 30, "Flu", "P001");
		Patient.getTotalPatients();
        p1.displayPatientDetails();
	}

}
