package ejb.session.stateless;

import entity.StaffEntity;
import util.exception.InvalidLoginException;
import util.exception.StaffNotFoundException;

public interface StaffEntityControllerRemote {

    StaffEntity createNewStaff(StaffEntity newStaffEntity);

    StaffEntity staffLogin(String username, String password) throws InvalidLoginException;

    StaffEntity retrieveStaffByUsername(String username) throws StaffNotFoundException;

}
