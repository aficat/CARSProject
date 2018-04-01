/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package clinicadminterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
import ejb.session.stateless.AppointmentEntityControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import ejb.session.stateless.StaffEntityControllerRemote;
import entity.StaffEntity;
import entity.PatientEntity;
import entity.DoctorEntity;
import java.util.List;
import java.util.Scanner;
import util.exception.DoctorNotFoundException;
import util.exception.PatientNotFoundException;

public class AppointmentModule {
    
    private StaffEntityControllerRemote staffEntityControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private RegistrationControllerRemote registrationControllerRemote;
    private AppointmentEntityControllerRemote appointmentEntityControllerRemote;
    private StaffEntity currentStaffEntity;
    private PatientEntity currentPatientEntity;
    private DoctorEntity currentDoctorEntity;
    
    public AppointmentModule (StaffEntityControllerRemote staffEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, RegistrationControllerRemote registrationControllerRemote, AppointmentEntityControllerRemote appointmentEntityControllerRemote){ 
        this.staffEntityControllerRemote = staffEntityControllerRemote;    
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.registrationControllerRemote = registrationControllerRemote;
        this.appointmentEntityControllerRemote = appointmentEntityControllerRemote;
    }
    
    public void menuAppointment() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true) {
            System.out.println("*** CARS :: Appointment Operation ***\n");
            System.out.println("1: View Patient Appointments");
            System.out.println("2: Add Appointment");
            System.out.println("3: Cancel Appointment");
            System.out.println("4: Back\n");
            response = 0;
            
            while(response < 1 || response > 4) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    viewPatientAppointments();
                } else if(response == 2) {
                    addAppointment();
                } else if(response == 3) {
                    cancelAppointment();
                } else if(response == 4) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 4)
            {
                break;
            }
        }
    }
    
    private void viewPatientAppointments() {
        
    }
    
    private void addAppointment() {
        
    }
    
    private void cancelAppointment() {
        
    }
}
