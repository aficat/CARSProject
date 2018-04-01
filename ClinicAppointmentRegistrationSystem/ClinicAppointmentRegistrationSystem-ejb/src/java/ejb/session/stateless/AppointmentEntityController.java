/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AppointmentEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.DoctorAddAppointmentException;
import util.exception.PatientAddAppointmentException;

@Stateless
@Local(AppointmentEntityControllerLocal.class)
@Remote(AppointmentEntityControllerRemote.class)

public class AppointmentEntityController implements AppointmentEntityControllerLocal, AppointmentEntityControllerRemote{
    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;
    
    public AppointmentEntityController()
    {
    }

   @Override
    public void createAppointment(AppointmentEntity newAppointmentEntity, String identityNumber, Long doctorId)
    {
        entityManager.persist(newAppointmentEntity);
        PatientEntity patient = entityManager.find(PatientEntity.class, identityNumber);
        
        if(patient != null)
        {
            newAppointmentEntity.setPatient(patient);
            try {
                patient.addAppointment(newAppointmentEntity);
            } catch (PatientAddAppointmentException ex) {
                Logger.getLogger(AppointmentEntityController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        
        if(doctor != null)
        {
            newAppointmentEntity.setDoctor(doctor);
            try {
                doctor.addAppointment(newAppointmentEntity);
            } catch (DoctorAddAppointmentException ex) {
                Logger.getLogger(AppointmentEntityController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public List<AppointmentEntity> retrieveAllAppointments()
    {
        Query query = entityManager.createQuery("SELECT a FROM AppointmentEntity a");
        return query.getResultList();
    }   
}
