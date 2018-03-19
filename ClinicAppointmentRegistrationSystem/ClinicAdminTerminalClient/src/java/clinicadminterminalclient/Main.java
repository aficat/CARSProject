/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateless.StaffEntityControllerRemote;
import javax.ejb.EJB;

public class Main {
    
    @EJB
    private static StaffEntityControllerRemote staffEntityControllerRemote;
  
    public static void main(String[] args) {
        
        MainApp mainApp = new MainApp(staffEntityControllerRemote);
        mainApp.runApp();
    }
}
