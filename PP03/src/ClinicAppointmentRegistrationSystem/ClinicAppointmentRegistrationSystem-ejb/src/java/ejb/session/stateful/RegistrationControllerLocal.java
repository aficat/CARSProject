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
import java.math.BigDecimal;
import java.util.List;
import util.exception.InvalidLoginException;

public interface RegistrationControllerLocal {
    
    void clearQueue();
    void addQueue();
    Integer getQueue();
    void setQueue(Integer queue);
}
