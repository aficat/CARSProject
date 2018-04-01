/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.ConsultationEntity;
import java.util.Date;
import java.util.List;
import util.exception.DoctorAddConsultationException;
import util.exception.PatientAddConsultationException;

/**
 *
 * @author Afiqah Rashid
 */
public interface ConsultationEntityControllerLocal {
    void createConsultation(ConsultationEntity newConsultationEntity, String identityNumber, Long doctorId); //throws PatientAddConsultationException;
List<ConsultationEntity> retrieveAllConsultations();
// void createConsultationInDoctor(ConsultationEntity newConsultationEntity, Long doctorId); // throws DoctorAddConsultationException;
}
