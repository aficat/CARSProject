/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package ejb.session.stateful;


import ejb.session.stateless.ConsultationEntityControllerLocal;
import ejb.session.stateless.DoctorEntityControllerLocal;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;

@Stateful
@Local(RegistrationControllerLocal.class)
@Remote(RegistrationControllerRemote.class)

//consultation controller
public class RegistrationController implements RegistrationControllerLocal, RegistrationControllerRemote {

    private EntityManager entityManager;
    public Integer queue;

    public RegistrationController() {
        // entityManager = new EntityManager();
        initialiseState();
    }
    
    
    private void initialiseState() {
        // reset queue number and consultation list
        queue = 1;
    }
    
    
    // clear patient contents/ consultation contents
    @Override
    public void clearQueue() {
        initialiseState();
    }
    
    public void addQueue() {
        this.queue++;
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