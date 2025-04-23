package Designs.HospitalManagementSystem.service;

import Designs.HospitalManagementSystem.Mode.Print;
import Designs.HospitalManagementSystem.database.PatientsRepository;
import Designs.HospitalManagementSystem.model.Patient;

public class PatientService {
    PatientsRepository patientsRepository;
    Print print;

    public PatientService(Print print, PatientsRepository patientsRepository){
        this.print = print;
        this.patientsRepository = patientsRepository;
    }

    public void registerPatient(Patient patient){
        patientsRepository.registerPatient(patient);
        print.printData(patient.getPatientName()+ " registered successfully.");
    }
}
