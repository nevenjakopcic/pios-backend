package hr.tvz.pios.scheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameAlreadyTakenException extends RuntimeException {

    public UsernameAlreadyTakenException(final String message) {
        super(message);
    }

    public UsernameAlreadyTakenException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UsernameAlreadyTakenException(final Throwable cause) {
        super(cause);
    }
}
