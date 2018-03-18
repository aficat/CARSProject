package ejb.session.singleton;

import ejb.session.stateless.StaffEntityControllerLocal;
import entity.StaffEntity;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import util.exception.StaffNotFoundException;


@Singleton
@LocalBean
@Startup

public class DataInitializationSessionBean {

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;
    
     @EJB
    private StaffEntityControllerLocal staffEntityControllerLocal;
     
     
     
     public DataInitializationSessionBean()
    {
    }
    
      @PostConstruct
    public void postConstruct()
    {
        try
        {
            staffEntityControllerLocal.retrieveStaffByUsername("manager");
        }
        catch(StaffNotFoundException ex)
        {
            initializeData();
        }
    }
    
    private void initializeData()
    {
        staffEntityControllerLocal.createNewStaff(new StaffEntity(1l, "Linda", "Chua", "manager", "password"));
        staffEntityControllerLocal.createNewStaff(new StaffEntity(2l, "Barbara", "Durham", "nurse", "password"));

    }
}

