/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package amsterminalclient;

import ejb.session.stateless.AppointmentEntityControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import ejb.session.stateless.StaffEntityControllerRemote;
import java.text.ParseException;
import javax.ejb.EJB;

public class Main {

    @EJB
    private static StaffEntityControllerRemote staffEntityControllerRemote;

    @EJB
    private static DoctorEntityControllerRemote doctorEntityControllerRemote;

    @EJB
    private static PatientEntityControllerRemote patientEntityControllerRemote;

    @EJB
    private static AppointmentEntityControllerRemote appointmentEntityControllerRemote;

    public static void main(String[] args) throws ParseException {

        MainApp mainApp = new MainApp(staffEntityControllerRemote, doctorEntityControllerRemote, patientEntityControllerRemote, appointmentEntityControllerRemote);
        mainApp.runApp();
    }
}
