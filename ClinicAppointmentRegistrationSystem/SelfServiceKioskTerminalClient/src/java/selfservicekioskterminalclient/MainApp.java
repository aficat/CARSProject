
package selfservicekioskterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
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
    private RegistrationControllerRemote registrationControllerRemote;

    private PatientEntity currentPatientEntity;
    private StaffEntity currentStaffEntity;
    private RegistrationModule registrationModule;

    public MainApp() {
    }

    MainApp(StaffEntityControllerRemote staffEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, RegistrationControllerRemote registrationControllerRemote) {
        this.staffEntityControllerRemote = staffEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.registrationControllerRemote = registrationControllerRemote;
    }

    public void runApp() {

        Scanner scanner = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** Welcome to Self-Service Kiosk ***\n");
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
                        registrationModule = new RegistrationModule(staffEntityControllerRemote, doctorEntityControllerRemote, patientEntityControllerRemote, registrationControllerRemote);
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

        System.out.println("*** Self-Service Kiosk :: Login ***\n");
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
        
        System.out.println("*** Self-Service Kiosk :: Register ***\n");
        
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
            System.out.println("*** Self-Service Kiosk :: Main ***\n");    
            System.out.println("You are login as " + currentPatientEntity.getFirstName() + " " + currentPatientEntity.getLastName() + "\n");
            System.out.println("1: Register Walk-In Consultation");
            System.out.println("2: Register Consultation By Appointment");
            System.out.println("3: View Appointments");
            System.out.println("4: Add Appointment");
            System.out.println("5: Cancel Appointment");
            System.out.println("6: Logout\n");
            response = 0;
            
            while(response < 1 || response > 6) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) { //Register Walk-In Consultation
                    registrationModule.consultWalkIn();
                } else if(response == 2) { //Register Consultation By Appointment
                    registrationModule.consultAppointment();
                } else if(response == 3) { //View Appointments
                    
                } else if(response == 4) { //Register Consultation By Appointment
                    
                } else if(response == 5) { //View Appointments
                   
                } else if(response == 6) { // Logout
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");                
                }
            } if(response == 6) {
                break;
            }
        }
    }
}