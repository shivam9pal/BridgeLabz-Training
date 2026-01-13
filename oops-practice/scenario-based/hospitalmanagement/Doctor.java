package week02.scenario.hospitalmanagement;

public class Doctor {
	private int doctorId;
	private String doctorName;
	private int doctorFees;
//	private String specilization;
	
	Doctor(int doctorId,String doctorName,int doctorFees){
		this.doctorId=doctorId;
		this.doctorName=doctorName;
		this.doctorFees=doctorFees;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorFees=" + doctorFees + "]";
	}

	public int getDoctorFees() {
		return doctorFees;
	}

	public void setDoctorFees(int doctorFees) {
		this.doctorFees = doctorFees;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
}
