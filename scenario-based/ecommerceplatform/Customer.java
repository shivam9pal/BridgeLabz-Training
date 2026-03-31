package week02.scenario.ecommerceplatform;

public class Customer {

    private int customerId;
    private String customerName;
    private String email;
    private String phone;
    private String address;

    public Customer(int customerId, String customerName, String email, String phone, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId
                + " | Name: " + customerName
                + " | Email: " + email
                + " | Phone: " + phone
                + " | Address: " + address;
    }
}
