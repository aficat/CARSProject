/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package ejb.session.stateless;

import entity.ConsultationEntity;
import java.util.Date;
import java.util.List;
import util.exception.DoctorAddConsultationException;
import util.exception.PatientAddConsultationException;

public interface ConsultationEntityControllerRemote {
    
    void createConsultation(ConsultationEntity newConsultationEntity, String identityNumber, Long doctorId); //throws PatientAddConsultationException;
List<ConsultationEntity> retrieveAllConsultations();
// void createConsultationInDoctor(ConsultationEntity newConsultationEntity, Long doctorId); // throws DoctorAddConsultationException;
}
