package hr.tvz.pios.scheduler.advice;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.exception.EmailAlreadyTakenException;
import hr.tvz.pios.scheduler.exception.UsernameAlreadyTakenException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(new ApiResponse(errors, "Validation failed."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UsernameAlreadyTakenException.class,
                        EmailAlreadyTakenException.class})
    public ResponseEntity<ApiResponse> handleBadRequestException(RuntimeException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<ApiResponse> handleBadCredentialsException(BadCredentialsException e) {
        return new ResponseEntity<>(new ApiResponse("Incorrect username and/or password."), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException e) {
        return new ResponseEntity<>(new ApiResponse("Access denied."), HttpStatus.FORBIDDEN);
    }
}
