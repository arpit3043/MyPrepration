package Designs.HospitalManagementSystem.exceptions;
public class NoSpecializationPresentException extends RuntimeException{
    public NoSpecializationPresentException() {
        super("No specialization present in the system.");
    }
    public NoSpecializationPresentException(String message) {
        super(message);
    }
    public NoSpecializationPresentException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoSpecializationPresentException(Throwable cause) {
        super(cause);
    }
    public NoSpecializationPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
