package Designs.HospitalManagementSystem.service;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import Designs.HospitalManagementSystem.Mode.AvailableDoctor;
import Designs.HospitalManagementSystem.Mode.Print;
import Designs.HospitalManagementSystem.database.DoctorsRepository;
import Designs.HospitalManagementSystem.model.Doctor;
import Designs.HospitalManagementSystem.model.Specialization;
import Designs.HospitalManagementSystem.model.TimeSlot;
import Designs.HospitalManagementSystem.utils.Utils;

public class DoctorService {

    DoctorsRepository doctorsRepository;
    Print print;

    public DoctorService(Print print, DoctorsRepository doctorsRepository){
        this.print = print;
        this.doctorsRepository = doctorsRepository;
    }

    public void registerDoctor(Doctor doctor){
        doctorsRepository.registerDoctor(doctor);
        print.printData("Welcome "+doctor.getDoctorName());
    }
    public void addAvailability(Integer doctorId, TimeSlot timeSlot){
        // Check Slot 30 mins
        LocalTime start = Utils.convertStringToTime(timeSlot.getStart());
        LocalTime end = Utils.convertStringToTime(timeSlot.getEnd());

        if(ChronoUnit.MINUTES.between(start,end)%60 == 30){
            doctorsRepository.addAvailability(doctorId,timeSlot);
            print.printData("Done Doc!");
        } else {
            print.printData( "Sorry"+doctorsRepository.getDoctorDetails(doctorId).getDoctorName() +" slots are 30 mins");
//            throw new SlotException(
//                    "Sorry"+doctorsRepository.getDoctorDetails(doctorId).getDoctorName() +" slots are 30 mins only"
//            );
        }

    }

    public void showAvailableSlotsBySpeciality(Specialization specialization) throws CloneNotSupportedException {
        List<Doctor> doctorsBySpeciality = doctorsRepository.getDoctorsBySpeciality(specialization);
        List<AvailableDoctor> availableTimeSlots = doctorsRepository.getAvailableTimeSlotsForAllDoctorsForSpecialization(doctorsBySpeciality);
        if(availableTimeSlots.size() > 0){
            print.printData("Available Doctors With time Slots");
            for(AvailableDoctor doctor: availableTimeSlots){
                for(TimeSlot slot: doctor.getSlotList()){
                    print.printData(doctor.getDoctor().getDoctorName()+" "+slot.getStart()+" - "+slot.getEnd());
                }
            }
        } else {
            print.printData("No slots available");
        }
    }

}
