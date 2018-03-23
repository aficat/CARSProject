/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.DoctorEntity;
import util.exception.DoctorNotFoundException;

public interface DoctorEntityControllerRemote {

    DoctorEntity createNewDoctor(DoctorEntity newDoctorEntity);

    DoctorEntity retrieveDoctorById(String id) throws DoctorNotFoundException;

}
