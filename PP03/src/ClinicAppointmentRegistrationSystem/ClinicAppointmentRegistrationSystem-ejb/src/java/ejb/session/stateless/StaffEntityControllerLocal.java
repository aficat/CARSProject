package ejb.session.stateless;

import entity.StaffEntity;
import util.exception.InvalidLoginException;
import util.exception.StaffNotFoundException;

public interface StaffEntityControllerLocal {

    StaffEntity createNewStaff(StaffEntity newStaffEntity);

    StaffEntity retrieveStaffByUsername(String username) throws StaffNotFoundException;

    StaffEntity staffLogin(String username, String password) throws InvalidLoginException;

}

