/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
import entity.StaffEntity;
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
            System.out.println("*** CRS :: Registration Operation ***\n");
            System.out.println("1: Register Patient");
            System.out.println("2: Get Queue Number");
            System.out.println("3: Back\n");
            response = 0;
            
            while(response < 1 || response > 3) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    registerPatient();
                } else if(response == 2) {
                    getConsultation();
                } else if(response == 3) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 3)
            {
                break;
            }
        }
    }
    
    // get details and register patient into database
    private void registerPatient()
    {
        Scanner scanner = new Scanner(System.in);
        
        // System.out.println(patientEntities.size());
        
        System.out.println("*** CRS :: Registration Operation :: Register Patient ***\n");
        
        System.out.print("Enter First Name> ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter Last Name> ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter Gender> ");
        String gender = scanner.nextLine().trim();
        System.out.print("Enter Age> ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Identity Number> ");
        String identityNumber = scanner.nextLine().trim();
        System.out.print("Enter Phone> ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter Address> ");
        String address = scanner.nextLine().trim();
        
        // patientEntities.add(new PatientEntity((long) (patientEntities.size()+1), firstName, lastName, gender, age, identityNumber, phone, address));
        System.out.println("Patient has been registered successfully!\n");
        
    }
    
    private void getConsultation() {
        Scanner scanner = new Scanner(System.in);        
        String identityNumber = "";
        Long doctorId;
        
        // System.out.println(doctorEntities.size());
        //System.out.println(queue);
        
        System.out.println("*** CRS :: Registration Operation :: Get Queue Number ***\n");
        System.out.print("Enter Doctor Id> ");
        doctorId = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Patient Identity Number> ");
        identityNumber = scanner.nextLine().trim();
        
        queue++;
        //System.out.println(currentPatient.getFirstName() + " " + currentPatient.getLastName() +" is going to see " + currentDoctor.getFirstName() + " " + currentDoctor.getLastName() + ". Queue Number is: " + queue + "\n");

    }
}