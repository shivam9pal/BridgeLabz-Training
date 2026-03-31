package week02.scenario.onlineexaminationsystem;

public class ExamTimeExpiredException extends Exception {

    public ExamTimeExpiredException(String message) {
        super(message);
    }

    public ExamTimeExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
