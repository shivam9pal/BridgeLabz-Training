package week02.scenario.vehiclerentalsystem;

class Customer {
	private int customerId;
    private String name;
    private String phone;
    private String licenseNumber;
    
    public Customer(int customerId, String name, String phone, String licenseNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
    }
    
    @Override
    public String toString() {
        return "Customer [ID=" + customerId + ", Name=" + name + ", Phone=" + phone + ", License=" + licenseNumber + "]";
    }
    
    public int getCustomerId() {
    	return customerId;
    	}
    public String getName() {
    	return name;
    	}
    public String getPhone() {
    	return phone; 
    	}
    public String getLicenseNumber() {
    	return licenseNumber;
    	}
}
