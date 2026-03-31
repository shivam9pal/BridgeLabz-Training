package week02.scenario.trafficmanager;

public class RoundaboutEmptyException extends Exception {

    public RoundaboutEmptyException(String message) {
        super(message);
    }

    public RoundaboutEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
