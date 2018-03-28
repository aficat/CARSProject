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
import util.exception.StaffNotFoundException;
/**
 *
 * @author Afiqah Rashid
 */
public class AdministrationModule {
    
    private StaffEntityControllerRemote staffEntityControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private RegistrationControllerRemote registrationControllerRemote;
    private StaffEntity currentStaffEntity;
    private PatientEntity currentPatientEntity;
    private DoctorEntity currentDoctorEntity;
    
    public AdministrationModule (StaffEntityControllerRemote staffEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, RegistrationControllerRemote registrationControllerRemote) {
        this.staffEntityControllerRemote = staffEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.registrationControllerRemote = registrationControllerRemote;
 }
    
    public void menuAdministration() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true) {
            System.out.println("*** CARS :: Administration Operation ***\n");
            System.out.println("1: Patient Management");
            System.out.println("2: Doctor Management");
            System.out.println("3: Staff Management");
            System.out.println("4: Back\n");
            response = 0;
            
            while(response < 1 || response > 4) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    patientManagement();
                } else if(response == 2) {
                    doctorManagement();
                } else if(response == 3) {
                    staffManagement();
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
    
    private void patientManagement() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true) {
            System.out.println("*** CARS :: Administration Operation :: Patient Management ***\n");
            System.out.println("1: Add Patient");
            System.out.println("2: View Patient Details");
            System.out.println("3: Update Patient");
            System.out.println("4: Delete Patient");
            System.out.println("5: View All Patient");
            System.out.println("6: Back\n");
            response = 0;
            
            while(response < 1 || response > 6) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    
                } else if(response == 2) {
                    
                } else if(response == 3) {
                    
                } else if(response == 4) {
                    
                } else if(response == 5) {
                    
                } else if(response == 6) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 6)
            {
                break;
            }
        }
    }
    
    private void doctorManagement() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true) {
            System.out.println("*** CARS :: Administration Operation :: Doctor Management ***\n");
            System.out.println("1: Add Doctor");
            System.out.println("2: View Doctor Details");
            System.out.println("3: Update Doctor");
            System.out.println("4: Delete Doctor");
            System.out.println("5: View All Doctor");
            System.out.println("6: Back\n");
            response = 0;
            
            while(response < 1 || response > 6) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    
                } else if(response == 2) {
                    
                } else if(response == 3) {
                    
                } else if(response == 4) {
                    
                } else if(response == 5) {
                    
                } else if(response == 6) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 6)
            {
                break;
            }
        }
    }
    
    private void staffManagement() {
        
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true) {
            System.out.println("*** CARS :: Administration Operation :: Staff Management ***\n");
            System.out.println("1: Add Staff");
            System.out.println("2: View Staff Details");
            System.out.println("3: Update Staff");
            System.out.println("4: Delete Staff");
            System.out.println("5: View All Staff");
            System.out.println("6: Back\n");
            response = 0;
            
            while(response < 1 || response > 6) {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1) {
                    addStaff();
                } else if(response == 2) {
                    viewStaffDetails();
                } else if(response == 3) {
                    updateStaff();
                } else if(response == 4) {
                    deleteStaff();
                } else if(response == 5) {
                    viewAllStaffs();
                } else if(response == 6) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 6)
            {
                break;
            }
        }
    }
    
    private void addStaff() {
        Scanner scanner = new Scanner(System.in);
        StaffEntity newStaffEntity = new StaffEntity();
        
        System.out.println("*** CARS :: Administration Operation :: Add Staff ***\n");
        System.out.print("Enter First Name> ");
        newStaffEntity.setFirstName(scanner.nextLine().trim());
        System.out.print("Enter Last Name> ");
        newStaffEntity.setLastName(scanner.nextLine().trim());
        System.out.print("Enter Username> ");
        newStaffEntity.setUsername(scanner.nextLine().trim());
        System.out.print("Enter Password> ");
        newStaffEntity.setPassword(scanner.nextLine().trim());
        
        // newStaffEntity.setStaffId(3l);
        
        newStaffEntity = staffEntityControllerRemote.createNewStaff(newStaffEntity);
        System.out.println("New staff created successfully!: " + newStaffEntity.getStaffId() + "\n");
    }
    
    private void viewStaffDetails() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: View Staff Details ***\n");
        System.out.print("Enter Staff ID> ");
        Long staffId = scanner.nextLong();
        
        try
        {
            StaffEntity staffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);
            System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");
            System.out.printf("%8s%20s%20s%20s%20s\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());         
        }
        catch(StaffNotFoundException ex)
        {
            System.out.println("An error has occurred while retrieving staff: " + ex.getMessage() + "\n");
        }
        
        System.out.print("Press any key to continue...> ");
        scanner.nextLine();
    }
    
    private void updateStaff() {
        Scanner scanner = new Scanner(System.in);
        String input;
        StaffEntity staffEntity = null;
        
        System.out.println("*** CARS :: Administration Operation :: Update Staff ***\n");
        System.out.print("Enter Staff ID> ");
        Long staffId = scanner.nextLong();
        
        try
        {
            staffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);
            System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");
            System.out.printf("%8s%20s%20s%20s%20s\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());         
        }
        catch(StaffNotFoundException ex)
        {
            System.out.println("An error has occurred while retrieving staff: " + ex.getMessage() + "\n");
        }
        
        scanner.nextLine();

        System.out.print("Enter First Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setFirstName(input);
        }
                
        System.out.print("Enter Last Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setLastName(input);
        }
       
        System.out.print("Enter Username (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setUsername(input);
        }
        
        System.out.print("Enter Password (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setPassword(input);
        }
        
        staffEntityControllerRemote.updateStaff(staffEntity);
        System.out.println("Staff updated successfully!\n");
    }

    private void deleteStaff() {
        Scanner scanner = new Scanner(System.in);
        String input;
        StaffEntity staffEntity = null;
        
        System.out.println("*** CARS :: Administration Operation :: Delete Staff ***\n");
        System.out.print("Enter Staff ID> ");
        Long staffId = scanner.nextLong();
        
        try
        {
            staffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);
            System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");
            System.out.printf("%8s%20s%20s%20s%20s\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());         
        }
        catch(StaffNotFoundException ex)
        {
            System.out.println("An error has occurred while retrieving staff: " + ex.getMessage() + "\n");
        }
        
        scanner.nextLine();

        System.out.printf("Confirm Delete Staff %s %s (Staff ID: %d) (Enter 'Y' to Delete)> ", staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getStaffId());

        input = scanner.nextLine().trim();
        
        if(input.equals("Y"))
        {
            try 
            {
                staffEntityControllerRemote.deleteStaff(staffEntity.getStaffId());
                System.out.println("Staff deleted successfully!\n");
            } 
            catch (StaffNotFoundException ex) 
            {
                System.out.println("An error has occurred while deleting staff: " + ex.getMessage() + "\n");
            }            
        }
        else
        {
            System.out.println("Staff NOT deleted!\n");
        }
    }
    
    private void viewAllStaffs() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: View All Staffs ***\n");
        
        List<StaffEntity> staffEntities = staffEntityControllerRemote.retrieveAllStaffs();
        System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");

        for(StaffEntity staffEntity:staffEntities)
        {
            System.out.printf("%8s%20s%20s%20s%20s\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());
        }
        
        System.out.print("Press any key to continue...> ");
        scanner.nextLine();
    }
}
