/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AppointmentEntity;
import java.util.List;

/**
 *
 * @author Afiqah Rashid
 */
public interface AppointmentEntityControllerLocal {
    void createAppointment(AppointmentEntity newAppointmentEntity, String identityNumber, Long doctorId);
    List<AppointmentEntity> retrieveAllAppointments();
}
