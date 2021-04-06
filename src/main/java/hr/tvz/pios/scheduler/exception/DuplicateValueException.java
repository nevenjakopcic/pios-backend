package hr.tvz.pios.scheduler.exception;

public class DuplicateValueException extends RuntimeException {

    public DuplicateValueException(final String message) {
        super(message);
    }

    public DuplicateValueException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DuplicateValueException(final Throwable cause) {
        super(cause);
    }
}
