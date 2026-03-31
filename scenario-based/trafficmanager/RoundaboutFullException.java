package week02.scenario.trafficmanager;

public class RoundaboutFullException extends Exception {

    public RoundaboutFullException(String message) {
        super(message);
    }

    public RoundaboutFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
