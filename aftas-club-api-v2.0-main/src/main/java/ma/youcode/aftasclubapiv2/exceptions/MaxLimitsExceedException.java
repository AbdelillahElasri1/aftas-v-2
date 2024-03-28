package ma.youcode.aftasclubapiv2.exceptions;

public class MaxLimitsExceedException extends RuntimeException{
    public MaxLimitsExceedException(String message) {
        super(message);
    }
}