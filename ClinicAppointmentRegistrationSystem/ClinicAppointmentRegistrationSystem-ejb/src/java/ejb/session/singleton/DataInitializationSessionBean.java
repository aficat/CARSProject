package ejb.session.singleton;

import ejb.session.stateless.DoctorEntityControllerLocal;
import ejb.session.stateless.PatientEntityControllerLocal;
import ejb.session.stateless.StaffEntityControllerLocal;
import entity.DoctorEntity;
import entity.PatientEntity;
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
     
    @EJB
    private PatientEntityControllerLocal patientEntityControllerLocal;
    
    @EJB
    private DoctorEntityControllerLocal doctorEntityControllerLocal;
     
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
        
        patientEntityControllerLocal.createNewPatient(new PatientEntity(1l, "Tony", "Teo", "Male", 44, "S7483027A", "87297373", "11 Tampines Ave 3"));
        patientEntityControllerLocal.createNewPatient(new PatientEntity(2l, "Wendy", "Tan", "Female", 35, "S8381028X", "97502837", "15 Computing Drive"));
        
        doctorEntityControllerLocal.createNewDoctor(new DoctorEntity(1l, "Peter", "Lee", "S18018", "MBBS"));
        doctorEntityControllerLocal.createNewDoctor(new DoctorEntity(2l, "Cindy", "Leong", "S64921", "BMedSc"));
        doctorEntityControllerLocal.createNewDoctor(new DoctorEntity(3l, "Matthew", "Liu", "S38101", "MBBS"));
    }
}

