/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.PatientEntity;
import java.util.List;
import util.exception.InvalidLoginException;
import util.exception.PatientNotFoundException;

public interface PatientEntityControllerRemote {

    PatientEntity createNewPatient(PatientEntity newPatientEntity);
    
    PatientEntity patientLogin(String identityNumber, String securityCode) throws InvalidLoginException;

    List<PatientEntity> retrieveAllPatients();
    
    PatientEntity retrievePatientByIdentityNumber(String identityNumber) throws PatientNotFoundException;
    
    void updatePatient(PatientEntity patientEntity);
    
    void deletePatient(String identityNumber) throws PatientNotFoundException;

}