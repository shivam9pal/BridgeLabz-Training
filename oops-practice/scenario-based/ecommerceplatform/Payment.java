package week02.scenario.ecommerceplatform;

public interface Payment {

    boolean processPayment(double amount) throws PaymentFailedException;

    String getPaymentMethod();
}
