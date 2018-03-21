/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateful;

import entity.StaffEntity;
import java.util.List;
import util.exception.InvalidLoginException;

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */

// void queue at the end of the day
public interface RegistrationControllerRemote {

            
    void clearQueue();
    Integer getQueue();
    void setQueue(Integer queue);
}
