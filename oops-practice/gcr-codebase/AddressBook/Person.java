package week02.addressbook;

import java.security.KeyStore.PrivateKeyEntry;

class Person {
	private int uniqueCode;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private String contactNo;
	private String email;
	
	
	
	public Person( String firstName, String lastName, String address, String city,String state, int zipCode,
			String contactNo, String email) {

		this.uniqueCode = getUniqueCode(firstName);
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state=state;
		this.zipCode = zipCode;
		this.contactNo = contactNo;
		this.email = email;
	}
	int getUniqueCode(String str) {
		int code=str.hashCode()%5;
		return code;
	}
	
	String getFirstName() {
		return firstName;
	}
	String getLastName() {
		return lastName;
	}
	String getAddress() {
		return address;
	}
	String getCity() {
		return city;
	}
	int getZipCode() {
		return zipCode;
	}
	String getContactNo() {
		return contactNo;
	}
	String getEmail() {
		return email;
	}
	String getState() {
		return state;
	}
	
	void setAddress(String address) {
		this.address = address;
	}
	void setCity(String city) {
		this.city = city;
	}
	void setZipCode(int zipCode) {
		zipCode = zipCode;
	}
	void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	void setEmail(String email) {
		this.email = email;
	}
	void setState(String state) {
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return "Person \n Person Code : " + uniqueCode + "\n First name= " + firstName + "\n Last Name= " + lastName + "\n address= "
				+ address + "\n city=" + city + "\n Zip Code= " + zipCode + "\n Contact No=" + contactNo + "\n Email=" + email
				+ "]";
	}
	
	
	
	
	
}
