package ma.youcode.aftasclubapiv2.handler;

import ma.youcode.aftasclubapiv2.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionsHandler {

    /**
     * Handle MethodArgumentNotValidException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle MethodArgumentNotValidException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle MethodArgumentNotValidException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ResourceNotCreatedException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotCreatedException(ResourceNotCreatedException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.CONFLICT, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /**
     *
     * @param exception {@link TimeExpiredException}
     * @return
     */
    @ExceptionHandler(TimeExpiredException.class)
    public ResponseEntity<ErrorResponse> handleTimeExpiredException(TimeExpiredException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, "Time Expired: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @param exception {@link MaxLimitsExceedException}
     * @return
     */
    @ExceptionHandler(MaxLimitsExceedException.class)
    public ResponseEntity<ErrorResponse> handleMaxLimitsException(MaxLimitsExceedException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, "Max Limits Exceed: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    /**
     *
     * @param exception {@link UnsupportedActionException}
     * @return
     */
    @ExceptionHandler(UnsupportedActionException.class)
    public ResponseEntity<ErrorResponse> handleUnsupportedActionException(UnsupportedActionException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, "Unsupported Action: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
