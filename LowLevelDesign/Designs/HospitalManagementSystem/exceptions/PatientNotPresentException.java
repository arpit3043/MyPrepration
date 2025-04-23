package Designs.HospitalManagementSystem.exceptions;
public class PatientNotPresentException extends RuntimeException{
    public PatientNotPresentException() {
        super("Patient not present in the system.");
    }
    public PatientNotPresentException(String message) {
        super(message);
    }
    public PatientNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
    public PatientNotPresentException(Throwable cause) {
        super(cause);
    }
    public PatientNotPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public PatientNotPresentException(String message, boolean enableSuppression, boolean writableStackTrace) {
        super(message, null, enableSuppression, writableStackTrace);
    }
}
