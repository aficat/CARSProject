/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package ejb.session.stateless;

import entity.PatientEntity;
import java.util.List;
import util.exception.InvalidLoginException;
import util.exception.PatientNotFoundException;

public interface PatientEntityControllerLocal {

    PatientEntity createNewPatient(PatientEntity newPatientEntity);
    
    PatientEntity patientLogin(String identityNumber, String securityCode) throws InvalidLoginException;

    List<PatientEntity> retrieveAllPatients();
    
    PatientEntity retrievePatientByIdentityNumber(String identityNumber) throws PatientNotFoundException;
    
    void updatePatient(PatientEntity patientEntity);
    
    void deletePatient(String identityNumber) throws PatientNotFoundException;

}