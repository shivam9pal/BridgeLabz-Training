package week02.scenario.onlinevotingsystem;

public class DuplicateVoteException extends Exception {

    public DuplicateVoteException(String message) {
        super(message);
    }

    public DuplicateVoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
