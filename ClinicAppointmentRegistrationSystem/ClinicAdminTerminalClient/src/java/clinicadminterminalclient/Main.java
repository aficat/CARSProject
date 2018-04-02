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
import ejb.session.stateless.ConsultationEntityControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import ejb.session.stateless.StaffEntityControllerRemote;
import java.text.ParseException;
import javax.ejb.EJB;
import util.exception.AppointmentNotFoundException;

public class Main {
    
    @EJB
    private static StaffEntityControllerRemote staffEntityControllerRemote;
    
    @EJB
    private static DoctorEntityControllerRemote doctorEntityControllerRemote;
    
    @EJB
    private static PatientEntityControllerRemote patientEntityControllerRemote;
    
    @EJB
    private static RegistrationControllerRemote registrationControllerRemote;
    
    @EJB
    private static ConsultationEntityControllerRemote consultationEntityControllerRemote;
    
    @EJB 
    private static AppointmentEntityControllerRemote appointmentEntityControllerRemote;
  
    public static void main(String[] args) throws ParseException, AppointmentNotFoundException {
        
        MainApp mainApp = new MainApp(staffEntityControllerRemote, doctorEntityControllerRemote, patientEntityControllerRemote, registrationControllerRemote, consultationEntityControllerRemote, appointmentEntityControllerRemote);
        mainApp.runApp();
    }
}
