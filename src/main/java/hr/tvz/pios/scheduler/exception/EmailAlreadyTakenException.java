package hr.tvz.pios.scheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyTakenException extends RuntimeException {

    public EmailAlreadyTakenException(final String message) {
        super(message);
    }

    public EmailAlreadyTakenException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyTakenException(final Throwable cause) {
        super(cause);
    }
}
