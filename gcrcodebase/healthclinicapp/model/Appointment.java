package week09.gcrcodebase.healthclinicapp.model;

import java.sql.Time;
import java.time.LocalDate;

public class Appointment {
	private int patientId;
	private int doctorId;
	private LocalDate date;
	private Time time;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
