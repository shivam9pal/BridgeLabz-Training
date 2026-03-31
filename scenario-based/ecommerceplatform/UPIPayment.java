package week02.scenario.ecommerceplatform;

public class UPIPayment implements Payment {

    private String upiId;
    private String phoneNumber;

    public UPIPayment(String upiId, String phoneNumber) {
        this.upiId = upiId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean processPayment(double amount) throws PaymentFailedException {
        // Validate UPI details
        if (upiId == null || !upiId.contains("@")) {
            throw new PaymentFailedException("Invalid UPI ID format!");
        }
        if (phoneNumber == null || phoneNumber.length() < 10) {
            throw new PaymentFailedException("Invalid phone number!");
        }

        // Simulate payment processing
        System.out.println("Processing UPI payment of Rs." + String.format("%.2f", amount) + " from " + upiId);

        // 90% success rate for demo
        if (Math.random() > 0.1) {
            System.out.println("✓ UPI payment successful!");
            return true;
        } else {
            throw new PaymentFailedException("UPI transaction timeout!");
        }
    }

    @Override
    public String getPaymentMethod() {
        return "UPI";
    }
}
