package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {

    private String patientId;
    private String name;
    private int age;

    // sensitive data 
    private String diagnosis;
    private String medicalHistory;

    // constructor
    Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // getters controlled access
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // protected methods for subclasses only
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }

    // abstract method
    public abstract double calculateBill();

    // concrete method
    public void getPatientDetails() {
        System.out.printf("Patient ID : %s%n", patientId);
        System.out.printf("Name       : %s%n", name);
        System.out.printf("Age        : %d%n", age);
    }
}

class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    InPatient(String patientId, String name, int age,
              int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        setMedicalHistory(record);
        System.out.println("In-Patient medical record added.");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + getMedicalHistory());
    }
}

class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        setDiagnosis(record);
        System.out.println("Out-Patient diagnosis added.");
    }

    @Override
    public void viewRecords() {
        System.out.println("Diagnosis: " + getDiagnosis());
    }
}

public class HospitalManagement {

	public static void main(String[] args) {
		List<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient("P101", "Shivam", 25, 5, 3000);
        Patient p2 = new OutPatient("P202", "Rahul", 30, 800);

        patients.add(p1);
        patients.add(p2);

        for (Patient p : patients) {

            p.getPatientDetails();

            if (p instanceof MedicalRecord) {
                MedicalRecord m = (MedicalRecord) p;
                m.addRecord("General Checkup Completed");
                m.viewRecords();
            }

            System.out.printf("Total Bill : %.2f%n",
                    p.calculateBill());
            System.out.println("");
        }

	}

}
