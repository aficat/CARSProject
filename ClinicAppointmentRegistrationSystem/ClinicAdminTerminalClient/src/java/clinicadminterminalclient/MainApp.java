
package clinicadminterminalclient;

import ejb.session.stateless.StaffEntityControllerRemote;
import ejb.session.stateful.RegistrationControllerRemote;
import entity.StaffEntity;
import java.util.Scanner;
import util.exception.InvalidLoginException;

public class MainApp {

    private StaffEntityControllerRemote staffEntityControllerRemote;
    private RegistrationControllerRemote registrationControllerRemote;
    private RegistrationModule registrationModule;
    private StaffEntity currentStaffEntity;

    public MainApp() {
    }

    MainApp(StaffEntityControllerRemote staffEntityControllerRemote) {
        this.staffEntityControllerRemote = staffEntityControllerRemote;
    }

    public void runApp() {

        Scanner scanner = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** Welcome to Clinic Appointment Registration System ***\n");
            System.out.println("1: Login");
            System.out.println("2: Exit\n");
            response = 0;

            while (response < 1 || response > 2) {
                System.out.print("> ");

                response = scanner.nextInt();

                if (response == 1) {

                    try {
                        doLogin();
                        registrationModule = new RegistrationModule(registrationControllerRemote);
                        menuMain();
                    } 
                    catch (InvalidLoginException ex) {
                    }
                } else if (response == 2) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");
                }
            }

            if (response == 2) {
                break;
            }
        }
    }

    private void doLogin() throws InvalidLoginException {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";

        System.out.println("*** CARS :: Login ***\n");
        System.out.print("Enter username> ");
        username = scanner.nextLine().trim();
        System.out.print("Enter password> ");
        password = scanner.nextLine().trim();

        if (username.length() > 0 && password.length() > 0) {
            try {
                currentStaffEntity = staffEntityControllerRemote.staffLogin(username, password);
                System.out.println("Login successful!\n");
            } catch (InvalidLoginException ex) {
                System.out.println("Invalid login credential: " + ex.getMessage() + "\n");

                throw new InvalidLoginException();

            }
        }
         else
        {
            System.out.println("Invalid login credential!");
        }
    }
    private void menuMain() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true)
        {
            System.out.println("*** Clinic Registration System (CRS) ***\n");    
            System.out.println("You are login as " + currentStaffEntity.getFirstName() + " " + currentStaffEntity.getLastName() + "\n");
            System.out.println("1: Registration Operation");
            System.out.println("2: Appointment Operation");
            System.out.println("3: Administration Operation");
            System.out.println("4: Logout\n");
            response = 0;
            
            while(response < 1 || response > 3) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    registrationModule.menuRegistration();
                } else if(response == 2) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");                
                }
            } if(response == 2) {
                break;
            }
        }
    }
}
