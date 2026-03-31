package week02.scenario.hospitalmanagement;

public class InPatient extends Patient{
	private int roomNumber;
	private int daysAdmitted;

	InPatient(int patientId, String patientName, String symptom, Doctor doctor, int roomNumber, int daysAdmitted) {
        super(patientId, patientName, symptom, doctor);
        this.roomNumber = roomNumber;
        this.daysAdmitted = daysAdmitted;
    }

	@Override
    void displayInfo() {
        System.out.println("InPatient - ID: " + getPatientId() + ", Name: " + getPatientName() + 
                          ", Room: " + roomNumber + ", Days: " + daysAdmitted);
    }

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getDaysAdmitted() {
		return daysAdmitted;
	}

	public void setDaysAdmitted(int daysAdmitted) {
		this.daysAdmitted = daysAdmitted;
	}

}
