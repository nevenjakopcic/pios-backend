package hr.tvz.pios.scheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(final String message) {
        super(message);
    }

    public NoSuchUserException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoSuchUserException(final Throwable cause) {
        super(cause);
    }
}
