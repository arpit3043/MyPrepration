package Designs.HospitalManagementSystem.database;
import java.util.HashMap;
import java.util.Map;

import Designs.HospitalManagementSystem.exceptions.PatientNotPresentException;
import Designs.HospitalManagementSystem.model.Patient;

public class PatientsRepository {
    Map<Integer, Patient> patients = new HashMap<>();

    public void registerPatient(Patient patient){
        if(patients.containsKey(patient.getPatientId())){
            throw new PatientNotPresentException();
        }
        patients.put(patient.getPatientId(), patient);
    }

    public boolean isPatientRegistered(Integer patientId){
        return patients.containsKey(patientId);
    }

}
