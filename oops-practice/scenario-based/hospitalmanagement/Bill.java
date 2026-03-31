package week02.scenario.hospitalmanagement;

public class Bill implements Payment{
	private int billId;
	private Patient patient;
	private double billAmount;
	private Doctor doctor;
	
	//bed charges 
	private static final int ROOM_CHARGES_PERDAY=500;
	
	public Bill(int billId, Patient patient, Doctor doctor) {
        this.billId = billId;
        this.patient = patient;
        this.doctor = doctor;
        this.billAmount = 0;
    }
	
	@Override
	public void totalAmount(Doctor doctor,Patient patient) {
		this.doctor=doctor;
		this.patient=patient;
		//checking the patient 
		//for in patient billing 
		if(patient instanceof InPatient) {
			billAmount+=patient.getDoctor().getDoctorFees();
			//now no of days stays 
			InPatient inPatient=(InPatient)patient;
			int days=inPatient.getDaysAdmitted();
			
			//bill increment
			billAmount+=ROOM_CHARGES_PERDAY*days;
			//for medication 
			billAmount+=200;
			System.out.println("InPatient Bill: Doctor Fee + Room(" + 
                    inPatient.getDaysAdmitted() + " days × " + ROOM_CHARGES_PERDAY + 
                    ") + Medication");
		}else if (patient instanceof OutPatient) {
            // OutPatient billing
            this.billAmount += 100.0; // Consultation charge
            System.out.println("OutPatient Bill: Doctor Fee + Consultation Fee");
        }
        
        System.out.println("Total Bill Amount: " + this.billAmount);
    
		
	}

	public int getBillId() {
		return billId;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public Patient getPatient() {
		return patient;
	}
	
	
}
