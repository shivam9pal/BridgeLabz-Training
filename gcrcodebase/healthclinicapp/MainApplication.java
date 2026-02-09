package week09.gcrcodebase.healthclinicapp;

import java.time.LocalDate;

import week09.gcrcodebase.healthclinicapp.dao.PatientDAO;
import week09.gcrcodebase.healthclinicapp.model.Patient;

public class MainApplication {
	public static void main(String[] args) throws Exception {

        Patient patient = new Patient();
        patient.setName("Shiva");
        patient.setDob(LocalDate.of(1998, 5, 12));
        patient.setPhone("9999999999");
        patient.setEmail("shiva@gmail.com");
        patient.setAddress("Hyderabad");
        patient.setBloodGroup("O+");
        
        PatientDAO dao=new PatientDAO();
        dao.insertPatient(patient);	

//        PatientService service = new PatientService();
//        service.registerPatient(patient);
	}
}
