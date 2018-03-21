/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateful;

import entity.StaffEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import util.exception.InvalidLoginException;
import util.exception.StaffNotFoundException;

@Stateful
@Local(RegistrationControllerLocal.class)
@Remote(RegistrationControllerRemote.class)

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */

public class RegistrationController implements RegistrationControllerLocal, RegistrationControllerRemote {
   
    private String identityNumber;
    private Long doctorId;
    private Integer queue;

    public RegistrationController() {
        // entityManager = new EntityManager();
        initialiseState();
    }
    
    
    private void initialiseState() {
        // reset queue number and consultation list
    }
    
    
    // clear patient contents/ consultation contents
    @Override
    public void clearQueue() {
        initialiseState();
    }
    
    @Override
    public Integer getQueue() {
        return queue;
    }

    @Override
    public void setQueue(Integer queue) {
        this.queue = queue;
    }
}