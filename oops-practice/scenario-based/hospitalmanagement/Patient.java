package week02.scenario.hospitalmanagement;

abstract class Patient {
	private int patientId;
	private String patientName;
	private String symptom;
	private Doctor doctor;
	
	
	
	Patient(int patientId,String patientName,String symptom,Doctor doctor){
		this.doctor=doctor;
		this.patientId=patientId;
		this.patientName=patientName;
		this.symptom=symptom;
	}



	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", symptom=" + symptom + ", doctor="
				+ doctor + "]";
	}



	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public String getSymptom() {
		return symptom;
	}



	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}



	public Doctor getDoctor() {
		return doctor;
	}



	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	abstract void displayInfo();
	
}
