package ma.youcode.aftasclubapiv2.exceptions;

public class TimeExpiredException extends RuntimeException{
    public TimeExpiredException(String message) {
        super(message);
    }
}