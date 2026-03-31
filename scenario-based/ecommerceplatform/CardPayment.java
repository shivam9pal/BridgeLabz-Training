package week02.scenario.ecommerceplatform;

public class CardPayment implements Payment {

    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;

    public CardPayment(String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(double amount) throws PaymentFailedException {
        // Validate card details
        if (cardNumber == null || cardNumber.length() < 13) {
            throw new PaymentFailedException("Invalid card number!");
        }
        if (cvv == null || cvv.length() < 3) {
            throw new PaymentFailedException("Invalid CVV!");
        }

        // Simulate payment processing
        System.out.println("Processing card payment of Rs." + String.format("%.2f", amount) + " from " + cardHolder);

        // 80% success rate for demo
        if (Math.random() > 0.2) {
            System.out.println("✓ Card payment successful!");
            return true;
        } else {
            throw new PaymentFailedException("Card payment declined by bank!");
        }
    }

    @Override
    public String getPaymentMethod() {
        return "Credit/Debit Card";
    }
}
