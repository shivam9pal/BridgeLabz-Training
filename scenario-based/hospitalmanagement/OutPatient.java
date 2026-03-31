package week02.scenario.hospitalmanagement;

public class OutPatient extends Patient {
	private String appointmentDate;

	OutPatient(int patientId, String patientName, String symptom, Doctor doctor,String appointmentDate) {
		super(patientId, patientName, symptom, doctor);
		this.appointmentDate=appointmentDate;
	}

	 @Override
	    void displayInfo() {
	        System.out.println("OutPatient - ID: " + getPatientId() + ", Name: " + getPatientName() + 
	                          ", Appointment: " + appointmentDate);
	    }
	 
	 
	 

}
