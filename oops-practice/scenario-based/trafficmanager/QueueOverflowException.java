package week02.scenario.trafficmanager;

public class QueueOverflowException extends Exception {

    public QueueOverflowException(String message) {
        super(message);
    }

    public QueueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
