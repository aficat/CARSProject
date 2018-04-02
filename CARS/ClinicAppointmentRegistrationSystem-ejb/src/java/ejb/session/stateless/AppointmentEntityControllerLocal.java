/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package ejb.session.stateless;

import entity.AppointmentEntity;
import java.util.List;
import util.exception.AppointmentNotFoundException;

public interface AppointmentEntityControllerLocal {
    void createAppointment(AppointmentEntity newAppointmentEntity, String identityNumber, Long doctorId);
    List<AppointmentEntity> retrieveAllAppointments();
    void cancelAppointment(Long appointmentId) throws AppointmentNotFoundException;
    AppointmentEntity retrieveAppointmentByAppointmentId(Long appointmentId) throws AppointmentNotFoundException;
}
