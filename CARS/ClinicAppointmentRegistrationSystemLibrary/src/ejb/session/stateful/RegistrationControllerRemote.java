/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package ejb.session.stateful;

import entity.StaffEntity;
import java.util.List;
import util.exception.InvalidLoginException;

// void queue at the end of the day
public interface RegistrationControllerRemote {

            
    void clearQueue();
    void addQueue();
    Integer getQueue();
    void setQueue(Integer queue);
}
