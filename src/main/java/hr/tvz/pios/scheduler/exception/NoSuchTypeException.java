package hr.tvz.pios.scheduler.exception;

public class NoSuchTypeException extends RuntimeException {

    public NoSuchTypeException(final String message) {
        super(message);
    }

    public NoSuchTypeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoSuchTypeException(final Throwable cause) {
        super(cause);
    }
}
