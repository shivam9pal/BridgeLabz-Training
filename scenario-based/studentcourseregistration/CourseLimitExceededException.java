package week02.scenario.studentcourseregistration;

public class CourseLimitExceededException extends Exception {

    public CourseLimitExceededException(String message) {
        super(message);
    }

    public CourseLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
