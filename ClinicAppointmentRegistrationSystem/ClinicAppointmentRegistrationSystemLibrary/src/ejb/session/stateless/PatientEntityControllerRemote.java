/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.PatientEntity;
import util.exception.PatientNotFoundException;

public interface PatientEntityControllerRemote {

    PatientEntity createNewPatient(PatientEntity newPatientEntity);

    PatientEntity retrievePatientByIdentityNumber(String identityNumber) throws PatientNotFoundException;

}