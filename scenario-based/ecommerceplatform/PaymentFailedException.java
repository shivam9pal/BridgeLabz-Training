package week02.scenario.ecommerceplatform;

public class PaymentFailedException extends Exception {

    public PaymentFailedException(String message) {
        super(message);
    }

    public PaymentFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
