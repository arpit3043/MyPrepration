package Designs.HospitalManagementSystem.exceptions;
public class DoctorNotPresentException extends RuntimeException{
    public DoctorNotPresentException() {
        super("Doctor not present in the system.");
    }
    public DoctorNotPresentException(String message) {
        super(message);
    }
    public DoctorNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
    public DoctorNotPresentException(Throwable cause) {
        super(cause);
    }
}
