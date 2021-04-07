package hr.tvz.pios.scheduler.exception;

public class UserAlreadyAssignedException extends RuntimeException {

    public UserAlreadyAssignedException(final String message) {
        super(message);
    }

    public UserAlreadyAssignedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyAssignedException(final Throwable cause) {
        super(cause);
    }
}
