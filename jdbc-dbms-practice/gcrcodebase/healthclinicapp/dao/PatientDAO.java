package week09.gcrcodebase.healthclinicapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import week09.gcrcodebase.healthclinicapp.config.DBConnection;
import week09.gcrcodebase.healthclinicapp.model.Patient;

public class PatientDAO {
	public void insertPatient(Patient patient)throws SQLException {
		String sql="Insert into patients (name, dob, phone, email, address, blood_group) values (?,?,?,?,?,?)";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement st=con.prepareStatement(sql)){
			
			
			st.setString(1, patient.getName());
			st.setDate(2, Date.valueOf(patient.getDob()));
			st.setString(3, patient.getPhone());
			st.setString(4, patient.getEmail());
			st.setString(5, patient.getAddress());
			st.setString(6, patient.getBloodGroup());
			
			st.executeUpdate();
		}
				
	}
	
	//get patient by id 
	public Patient getPatientById(int id)throws SQLException {
		String sql="Select * from patients where patientId=?";
		Patient patient=null;
		try(Connection con=DBConnection.getConnection();
				PreparedStatement st=con.prepareStatement(sql)){
			
			
			st.setInt(1, id);
			ResultSet result=st.executeQuery();
			if(result.next()) {
				patient =new Patient();
				patient.setPatientId(result.getInt("patientId"));
				patient.setName(result.getString("name"));
				patient.setDob(result.getDate("dob").toLocalDate());
				patient.setPhone(result.getString("phone"));
				patient.setEmail(result.getString("email"));
				patient.setAddress(result.getString("address"));
				patient.setBloodGroup(result.getString("blood_group"));
				
				
			}
			
		}
		return patient;
				
	}
	
	// Update Patient
    public void updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE patients SET name=?, phone=?, email=?, address=?, blood_group=? WHERE patient_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getPhone());
            ps.setString(3, patient.getEmail());
            ps.setString(4, patient.getAddress());
            ps.setString(5, patient.getBloodGroup());
            ps.setInt(6, patient.getPatientId());

            ps.executeUpdate();
        }
    
    }
    
 // Search by Name (LIKE)
    public List<Patient> searchByName(String keyword) throws SQLException {
        String sql = "SELECT * FROM patients WHERE name ILIKE ?";
        List<Patient> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                list.add(p);
            }
        }
        return list;
    }
}