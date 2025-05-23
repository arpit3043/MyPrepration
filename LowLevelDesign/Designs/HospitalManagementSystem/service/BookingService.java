package Designs.HospitalManagementSystem.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterator.OfInt;
import java.util.Spliterators;
import java.util.function.Consumer;
import Designs.HospitalManagementSystem.Mode.Print;
import Designs.HospitalManagementSystem.database.DoctorsRepository;
import Designs.HospitalManagementSystem.database.PatientsRepository;
import Designs.HospitalManagementSystem.exceptions.BookingNotPresentException;
import Designs.HospitalManagementSystem.exceptions.DoctorNotPresentException;
import Designs.HospitalManagementSystem.exceptions.PatientAlreadyOccupiedException;
import Designs.HospitalManagementSystem.exceptions.PatientNotPresentException;
import Designs.HospitalManagementSystem.model.Booking;
import Designs.HospitalManagementSystem.model.Doctor;
import Designs.HospitalManagementSystem.model.Patient;
import Designs.HospitalManagementSystem.model.TimeSlot;

public class BookingService {
    DoctorsRepository doctorsRepository;
    PatientsRepository patientsRepository;
    Print print;
    HashMap<Integer, BookingService> bookings = new HashMap<>();
    Map<Integer, List<TimeSlot>> patientSlots = new HashMap<>();
    Queue<Booking> waitListQueue = new LinkedList<>();

    static int index = 1;

    public BookingService(Print print, DoctorsRepository doctorsRepository, PatientsRepository patientsRepository){
        this.print = print;
        this.doctorsRepository = doctorsRepository;
        this.patientsRepository =patientsRepository;
    }


    // bookAppointment: (PatientA, Dr.Curious, 12:30)

    public void bookAppointment(Patient patient, Doctor doctor, String fromSlot){
        // Check Patient Exists
        if(!patientsRepository.isPatientRegistered(patient.getPatientId()))
            throw new PatientNotPresentException();
        if(!doctorsRepository.isDoctorRegistered(doctor.getDoctorId()))
            throw new DoctorNotPresentException();
        //Check is Patient Already booked For that Slot
        if(patientSlots.containsKey(patient.getPatientId())){
            for(TimeSlot slot:patientSlots.get(patient.getPatientId())){
                if(slot.getStart().equals(fromSlot)){
                    throw new PatientAlreadyOccupiedException();
                }
            }
        }else{
            patientSlots.put(patient.getPatientId(), new ArrayList<>());
        }
        // Check is doctor Available for That Slot

        Doctor doctorDetails = doctorsRepository.getDoctorDetails(doctor.getDoctorId());
        HashMap<TimeSlot, Boolean> slots = doctorDetails.getSlots();
        for(Map.Entry<TimeSlot,Boolean> slot: slots.entrySet()){
            if(slot.getKey().getStart().equals(fromSlot) && slot.getValue()){
                slots.put(slot.getKey(),false);
                patientSlots.get(patient.getPatientId()).add(slot.getKey());
                Booking booking = new Booking(index++, doctor, patient, slot.getKey());
                bookings.put(booking.getBookingId(), booking);
                print.printData("Appointment Booked Successfully Booking id "+ booking.getBookingId());
                return;
            }
        }
        print.printData("No available Slots");
        Booking booking = new Booking(
                index++, doctor, patient, new TimeSlot(fromSlot, fromSlot)
        );
        booking.setWaitList(true);
        print.printData("Added to the waitlist. Booking id: "+booking.getBookingId());
        waitListQueue.add(booking);
    }

    public void cancelBooking(Integer bookingId){
        if(!bookings.containsKey(bookingId)){
            throw new BookingNotPresentException();
        }
        Booking booking = bookings.get(bookingId);
        doctorsRepository.freeSlot(booking.getDoctor().getDoctorId(), booking.getSlot());
        bookings.remove(bookingId);
        print.printData("Booking Cancelled");
        patientSlots.get(booking.getPatient().getPatientId()).remove(booking.getSlot());
        checkForFreeSlot(booking);
    }

    public void ShowBookedAppointments(){
        for(Map.Entry<Integer, Booking> bookingEntry: bookings.entrySet()){
            Booking booking = bookingEntry.getValue();
            print.printData(
                            booking.getBookingId()+" "+
                            booking.getDoctor().getDoctorName() + " "+
                            booking.getPatient().getPatientName()+ " "+
                            booking.getSlot().getStart()+" - "+ booking.getSlot().getEnd()
            );
        }
    }

    private void checkForFreeSlot(Booking booking){
        for(Booking waitListBooking: waitListQueue) {
            if(waitListBooking.getSlot().getStart().equals(booking.getSlot().getStart())){
                   waitListBooking.getSlot().setEnd(booking.getSlot().getEnd());
                   waitListBooking.setWaitList(false);
                Doctor doctorDetails = doctorsRepository.getDoctorDetails(waitListBooking.getDoctor().getDoctorId());
                HashMap<TimeSlot, Boolean> slots = doctorDetails.getSlots();
                for(Map.Entry<TimeSlot, Boolean> slot: slots.entrySet()){
                    if(slot.getKey().getStart().equals(booking.getSlot().getStart())){
                        slots.put(slot.getKey(),false);
                        break;
                    }
                }
                bookings.put(waitListBooking.getBookingId(), waitListBooking);
                waitListQueue.remove(waitListBooking);
                return;
            }
        }
    }

}
