/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package ejb.session.stateless;

import entity.DoctorEntity;
import java.util.List;
import util.exception.DoctorNotFoundException;

public interface DoctorEntityControllerLocal {

    DoctorEntity createNewDoctor(DoctorEntity newDoctorEntity);

    DoctorEntity retrieveDoctorById(Long id) throws DoctorNotFoundException;
    
    List<DoctorEntity> retrieveAllDoctors();
    
    void updateDoctor(DoctorEntity doctorEntity);
    
    void deleteDoctor(Long doctorId) throws DoctorNotFoundException;

}
