package week02.scenario.hospitalmanagement;

import java.util.ArrayList;
import java.util.List;

public class HospitalService {
		//list of doctors
		List<Doctor> doctorsList=new ArrayList<>();
		List<Patient> patientList=new ArrayList<>();
		
	
	public void patientList() {
			for(Patient patient:patientList) {
				System.out.println(patient.toString());
		}
	}
	public void availableDoctors() {
		for(Doctor doc:doctorsList) {
			System.out.println(doc.toString());
		}
	}
	
	//add doctor
	public void addDoctor(Doctor doctor) {
			 doctorsList.add(doctor);
	}
	
	// Add patient
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
    
    // CRUD operations
    public Patient getPatient(int patientId) {
        for (Patient p : patientList) {
            if (p.getPatientId() == patientId) return p;
        }
        return null;
    }
    
    public void updatePatient(Patient patient) {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getPatientId() == patient.getPatientId()) {
                patientList.set(i, patient);
                break;
            }
        }
    }

    public void deletePatient(int patientId) {
        patientList.removeIf(p -> p.getPatientId() == patientId);
    }
    
    
    
    public void generateBill(int patientId) {
        Patient patient = getPatient(patientId);
        if (patient != null && patient.getDoctor() != null) {
            Bill bill = new Bill(patientId, patient, patient.getDoctor());
            bill.totalAmount(patient.getDoctor(), patient);
            patient.displayInfo();
            
        }
    }
    public void assignDoctorToPatient(int patientId, int doctorId) {
        Patient patient = getPatient(patientId);
        for (Doctor doc : doctorsList) {
            if (doc.getDoctorId() == doctorId) {
                patient.setDoctor(doc);
                break;
            }
        }
    }

}
