/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfservicekioskterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import ejb.session.stateless.StaffEntityControllerRemote;
import entity.StaffEntity;
import entity.PatientEntity;
import entity.DoctorEntity;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import util.exception.DoctorNotFoundException;
import util.exception.PatientNotFoundException;
import util.exception.StaffNotFoundException;

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
    private int queue = 0;
    
    public RegistrationModule(StaffEntityControllerRemote staffEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, RegistrationControllerRemote registrationControllerRemote) {
        this.staffEntityControllerRemote = staffEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.registrationControllerRemote = registrationControllerRemote;
    }
    
    public RegistrationModule(PatientEntity currentPatientEntity, RegistrationControllerRemote registrationControllerRemote) {
    	//this();
    	
    	this.currentPatientEntity = currentPatientEntity;
    	this.registrationControllerRemote = registrationControllerRemote;
	}

    public void consultWalkIn() {
        
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
    
    public void consultAppointment() {
        
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