package ejb.session.stateless;

import entity.PatientEntity;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.PatientNotFoundException;

@Stateless
@Local(PatientEntityControllerLocal.class)
@Remote(PatientEntityControllerRemote.class)

public class PatientEntityController implements PatientEntityControllerLocal, PatientEntityControllerRemote {

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;

    
    
    public PatientEntityController() {
    }

    
    @Override
    public PatientEntity createNewPatient(PatientEntity newPatientEntity)
    {
        entityManager.persist(newPatientEntity);
        entityManager.flush();
        
        return newPatientEntity;
    }
    
    
    
    @Override
    public PatientEntity retrievePatientByIdentityNumber(String identityNumber) throws PatientNotFoundException
    {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.identitynumber = :inIdentitynumber");
        query.setParameter("inIdentitynumber", identityNumber);
        
        try
        {
            return (PatientEntity)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new PatientNotFoundException("Patient Identity Number " + identityNumber + " does not exist!");
        }
    }
}
