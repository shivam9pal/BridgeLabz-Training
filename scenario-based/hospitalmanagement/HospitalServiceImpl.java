package week02.scenario.hospitalmanagement;

public class HospitalServiceImpl {

	public static void main(String[] args) {
		HospitalService reception=new HospitalService();
		
		
		//addd doctors to the list 
		Doctor doc1 = new Doctor(1, "Dr. Sumit", 1000);
        Doctor doc2 = new Doctor(2, "Dr. S.chandra", 1200);
        reception.addDoctor(doc1);
        reception.addDoctor(doc2);
        
        
        //new Patient 
        InPatient inPatient = new InPatient(101, "Hariom", "Fever", doc1, 101, 3);
        reception.addPatient(inPatient);
        
        OutPatient outPatient = new OutPatient(102, "shilpa", "Checkup", doc2, "2026-01-10");
        reception.addPatient(outPatient);
        
        System.out.println(" INPATIENT BILL ");
        reception.generateBill(101);  
        
        System.out.println(" OUTPATIENT BILL ");
        reception.generateBill(102);
        
        reception.availableDoctors();
        reception.patientList();
	}
}
