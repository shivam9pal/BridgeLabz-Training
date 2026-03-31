package week02.scenario.trafficmanager;

public class QueueUnderflowException extends Exception {

    public QueueUnderflowException(String message) {
        super(message);
    }

    public QueueUnderflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
