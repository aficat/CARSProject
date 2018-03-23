/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
import entity.StaffEntity;
import entity.PatientEntity;
import entity.DoctorEntity;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */

public class RegistrationModule {

    private RegistrationControllerRemote registrationControllerRemote;
    private StaffEntity currentStaffEntity;
    private PatientEntity currentPatientEntity;
    private DoctorEntity currentDoctorEntity;
    private int queue = 0;
    
    public RegistrationModule(RegistrationControllerRemote registrationControllerRemote) {
    	//this();

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
        
        System.out.println("*** CARS :: Registration Operation :: Register Patient ***\n");
        
        System.out.print("Enter Identity Number> ");
        String identityNumber = scanner.nextLine().trim();
        System.out.print("Enter Security Code> ");
        String securityCode = scanner.nextLine().trim();
        System.out.print("Enter First Name> ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter Last Name> ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter Gender> ");
        String gender = scanner.nextLine().trim();
        System.out.print("Enter Age> ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone> ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter Address> ");
        String address = scanner.nextLine().trim();
        
        // if no other patient has same IDENTITY NUMBER, add patient
        // check last id then add to next patient
        System.out.println("Patient has been registered successfully!\n");
        
    }
    
    private void consultWalkIn() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Registration Operation :: Register Walk-In Consultation ***\n");
        System.out.println("Doctor:\n");
        // list all doctor in database (id, firstname lastname)
        System.out.println("Availability:\n");
        // list all slots available to book
        
        System.out.print("Enter Doctor Id> ");
        Long doctorId = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Patient Identity Number> ");
        String identityNumber = scanner.nextLine().trim();
        
        // search doctor
        // search patient
        
        System.out.println("patientfirstname lastname is going to see doctorfirstname lastname at time. Queue Number is: number.\n");
    }
    
    private void consultAppointment() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Registration Operation :: Register Consultation By Appointment ***\n");
        
        System.out.print("Enter Patient Identity Number> ");
        String identityNumber = scanner.nextLine().trim();
        // search appointment set by patient

        System.out.println("Appointments:\n");
        // list appointment
        
        System.out.print("Enter Appointment Id> ");
        int appointmentId = scanner.nextInt();
        
        System.out.println("patientfirstname lastname is going to see doctorfirstname lastname at time. Queue Number is: number.\n");
    }
    
    public void menuAppointment() {
        
    }
    
    public void menuAdministration() {
        
        
    }
}