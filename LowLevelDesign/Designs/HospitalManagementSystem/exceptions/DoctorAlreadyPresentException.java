package Designs.HospitalManagementSystem.exceptions;
public class DoctorAlreadyPresentException extends RuntimeException{
    public DoctorAlreadyPresentException() {
        super("Doctor already present in the system.");
    }
    public DoctorAlreadyPresentException(String message) {
        super(message);
    }
    public DoctorAlreadyPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
