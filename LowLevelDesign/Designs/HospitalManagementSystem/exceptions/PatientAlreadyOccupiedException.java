package Designs.HospitalManagementSystem.exceptions;
public class PatientAlreadyOccupiedException extends RuntimeException{
    public PatientAlreadyOccupiedException() {
        super("Patient already occupied in the system.");
    }
    public PatientAlreadyOccupiedException(String message) {
        super(message);
    }
    public PatientAlreadyOccupiedException(String message, Throwable cause) {
        super(message, cause);
    }
    public PatientAlreadyOccupiedException(Throwable cause) {
        super(cause);
    }
    public PatientAlreadyOccupiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public PatientAlreadyOccupiedException(String message, boolean enableSuppression, boolean writableStackTrace) {
        super(message, null, enableSuppression, writableStackTrace);
    }
}
