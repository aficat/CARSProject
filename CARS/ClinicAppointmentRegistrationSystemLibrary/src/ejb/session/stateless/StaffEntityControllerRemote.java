/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package ejb.session.stateless;

import entity.StaffEntity;
import java.util.List;
import util.exception.InvalidLoginException;
import util.exception.StaffNotFoundException;

public interface StaffEntityControllerRemote {

    StaffEntity createNewStaff(StaffEntity newStaffEntity);
    
    List<StaffEntity> retrieveAllStaffs();
    
    StaffEntity retrieveStaffByStaffId(Long staffId) throws StaffNotFoundException;
    
    StaffEntity retrieveStaffByUsername(String username) throws StaffNotFoundException;

    StaffEntity staffLogin(String username, String password) throws InvalidLoginException;

    void updateStaff(StaffEntity staffEntity);
    
    void deleteStaff(Long staffId) throws StaffNotFoundException;
}
