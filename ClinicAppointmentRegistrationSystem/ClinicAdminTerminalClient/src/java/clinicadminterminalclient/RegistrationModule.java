/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
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

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */

public class RegistrationModule {

    private StaffEntityControllerRemote staffEntityControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private RegistrationControllerRemote registrationControllerRemote;
    private StaffEntity currentStaffEntity;
    private PatientEntity currentPatientEntity;
    private DoctorEntity currentDoctorEntity;
    
    public RegistrationModule(StaffEntityControllerRemote staffEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, RegistrationControllerRemote registrationControllerRemote) {
        this.staffEntityControllerRemote = staffEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.registrationControllerRemote = registrationControllerRemote;
 }
    
    public RegistrationModule(StaffEntity currentStaffEntity, RegistrationControllerRemote registrationControllerRemote) {
     //this();
     
     this.currentStaffEntity = currentStaffEntity;
     this.registrationControllerRemote = registrationControllerRemote;
 }
    
    public void menuRegistration() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true) {
            System.out.println("*** CARS :: Registration Operation ***\n");
            System.out.println("1: Register New Patient");
            System.out.println("2: Register Walk-In Consultation");
            System.out.println("3: Register Consultation By Appointment");
            System.out.println("4: Back\n");
            response = 0;
            
            while(response < 1 || response > 4) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    registerPatient();
                } else if(response == 2) {
                    consultWalkIn();
                } else if(response == 3) {
                    consultAppointment();
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
    
    // get details and register patient into database
    private void registerPatient()
    {
        Scanner scanner = new Scanner(System.in);
        PatientEntity newPatient = new PatientEntity();
        
        System.out.println("*** CARS :: Registration Operation :: Register Patient ***\n");
        
        System.out.print("Enter Identity Number> ");
        newPatient.setIdentityNumber(scanner.nextLine().trim());
        System.out.print("Enter Security Code> ");
        newPatient.setSecurityCode(scanner.nextLine().trim());
        System.out.print("Enter First Name> ");
        newPatient.setFirstName(scanner.nextLine().trim());
        System.out.print("Enter Last Name> ");
        newPatient.setLastName(scanner.nextLine().trim());
        System.out.print("Enter Gender> ");
        newPatient.setGender(scanner.nextLine().trim());
        System.out.print("Enter Age> ");
        newPatient.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter Phone> ");
        newPatient.setPhone(scanner.nextLine().trim());
        System.out.print("Enter Address> ");
        newPatient.setAddress(scanner.nextLine().trim());
        
        // newPatient.setPatientId(3l);
        
        // if no other patient has same IDENTITY NUMBER, add patient
        // check last id then add to next patient
        newPatient = patientEntityControllerRemote.createNewPatient(newPatient);
        System.out.println("Patient has been registered successfully!\n");
        
    }
    
    private void consultWalkIn() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Registration Operation :: Register Walk-In Consultation ***\n");
        System.out.println("Doctor:\n");
        // list all doctor in database (id, firstname lastname)
        List<DoctorEntity> doctorEntities = doctorEntityControllerRemote.retrieveAllDoctors();
        System.out.printf("%8s%20s\n", "Id", "| Name");

        for (DoctorEntity doctorEntity:doctorEntities)
        {
            System.out.printf("%8s%20s\n", doctorEntity.getDoctorId().toString(), "| " + doctorEntity.getFirstName() + " " + doctorEntity.getLastName());
        }
        
        scanner.nextLine();
        System.out.println("Availability:\n");
        // list all slots available to book
        
        System.out.print("Enter Doctor Id> ");
        Long doctorId = scanner.nextLong();
        
        // search doctor
        try {
            currentDoctorEntity = doctorEntityControllerRemote.retrieveDoctorById(doctorId);      
        } catch(DoctorNotFoundException ex) {
            System.out.println("An error has occurred while retrieving doctor: " + ex.getMessage() + "\n");
        }
        
        scanner.nextLine();
        System.out.print("Enter Patient Identity Number> ");
        String identityNumber = scanner.nextLine().trim();
        
        // search patient
        try {
            currentPatientEntity = patientEntityControllerRemote.retrievePatientByIdentityNumber(identityNumber);      
        } catch(PatientNotFoundException ex) {
            System.out.println("An error has occurred while retrieving patient: " + ex.getMessage() + "\n");
        }
        
        System.out.println(currentPatientEntity.getFirstName() + " " + currentPatientEntity.getLastName() + " is going to see " + currentDoctorEntity.getFirstName() + " " + currentDoctorEntity.getLastName() + " at time. Queue Number is: number.\n");
    }
    
    private void consultAppointment() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Registration Operation :: Register Consultation By Appointment ***\n");
        
        System.out.print("Enter Patient Identity Number> ");
        String identityNumber = scanner.nextLine().trim();
        // search appointment set by patient
        // search patient
        try {
            currentPatientEntity = patientEntityControllerRemote.retrievePatientByIdentityNumber(identityNumber);      
        } catch(PatientNotFoundException ex) {
            System.out.println("An error has occurred while retrieving patient: " + ex.getMessage() + "\n");
        }

        System.out.println("Appointments:\n");
        // list appointment
        
        System.out.print("Enter Appointment Id> ");
        int appointmentId = scanner.nextInt();
        
        System.out.println(currentPatientEntity.getFirstName() + " " + currentPatientEntity.getLastName() + " is going to see doctorfirstname lastname at time. Queue Number is: number.\n");
    }
    
}