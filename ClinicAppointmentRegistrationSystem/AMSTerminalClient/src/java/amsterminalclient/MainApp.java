/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package amsterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
import ejb.session.stateless.AppointmentEntityControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import ejb.session.stateless.StaffEntityControllerRemote;
import entity.PatientEntity;
import entity.StaffEntity;
import java.util.Scanner;
import util.exception.InvalidLoginException;

public class MainApp {

    private StaffEntityControllerRemote staffEntityControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private AppointmentEntityControllerRemote appointmentEntityControllerRemote;

    private PatientEntity currentPatientEntity;
    private StaffEntity currentStaffEntity;

    public MainApp() {
    }

    MainApp(StaffEntityControllerRemote staffEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, AppointmentEntityControllerRemote appointmentEntityControllerRemote) {
        this.staffEntityControllerRemote = staffEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.appointmentEntityControllerRemote = appointmentEntityControllerRemote;
    }

    public void runApp() {

        Scanner scanner = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** Welcome to AMS Client ***\n");
            System.out.println("1: Register");
            System.out.println("2: Login");
            System.out.println("3: Exit\n");
            response = 0;

            while (response < 1 || response > 3) {
                System.out.print("> ");

                response = scanner.nextInt();

            if (response == 1){
                registerPatient();
            } else if (response == 2) {

                    try {
                        doLogin();
                        menuMain();
                    } 
                    catch (InvalidLoginException ex) {
                    }
                } else if (response == 3) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");
                }
            }

            if (response == 3) {
                break;
            }
        }
    }

    private void doLogin() throws InvalidLoginException {
        Scanner scanner = new Scanner(System.in);
        String identityNumber = "";
        String securityCode = "";

        System.out.println("*** AMS Client :: Login ***\n");
        System.out.print("Enter Identity Number> ");
        identityNumber = scanner.nextLine().trim();
        System.out.print("Enter Security Code> ");
        securityCode = scanner.nextLine().trim();

        if (identityNumber.length() > 0 && securityCode.length() > 0) {
            try {
                currentPatientEntity = patientEntityControllerRemote.patientLogin(identityNumber, securityCode);
                System.out.println("Login successful!\n");
            } catch (InvalidLoginException ex) {
                System.out.println("Invalid login: " + ex.getMessage() + "\n");

                throw new InvalidLoginException();

            }
        }
         else
        {
            System.out.println("Invalid login!");
        }
    }
    
    // get details and register patient into database
    private void registerPatient()
    {
        Scanner scanner = new Scanner(System.in);
        PatientEntity newPatient = new PatientEntity();
        
        System.out.println("*** AMS Client :: Register ***\n");
        
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
    
    private void menuMain() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true)
        {
            System.out.println("*** AMS Client :: Main ***\n");    
            System.out.println("You are login as " + currentPatientEntity.getFirstName() + " " + currentPatientEntity.getLastName() + "\n");
            System.out.println("1: View Appointments");
            System.out.println("2: Add Appointment");
            System.out.println("3: Cancel Appointment");
            System.out.println("4: Logout\n");
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
            } if(response == 4) {
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