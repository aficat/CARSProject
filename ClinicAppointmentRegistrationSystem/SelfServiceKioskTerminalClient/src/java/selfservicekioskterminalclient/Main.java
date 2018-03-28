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
import javax.ejb.EJB;

public class Main {
    
    @EJB
    private static StaffEntityControllerRemote staffEntityControllerRemote;
    
    @EJB
    private static DoctorEntityControllerRemote doctorEntityControllerRemote;
    
    @EJB
    private static PatientEntityControllerRemote patientEntityControllerRemote;
    
    @EJB
    private static RegistrationControllerRemote registrationControllerRemote;
  
    public static void main(String[] args) {
        
        MainApp mainApp = new MainApp(staffEntityControllerRemote, doctorEntityControllerRemote, patientEntityControllerRemote, registrationControllerRemote);
        mainApp.runApp();
    }
}
