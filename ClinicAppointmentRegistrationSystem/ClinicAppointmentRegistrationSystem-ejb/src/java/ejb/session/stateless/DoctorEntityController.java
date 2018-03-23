package ejb.session.stateless;

import entity.DoctorEntity;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.DoctorNotFoundException;

@Stateless
@Local(DoctorEntityControllerLocal.class)
@Remote(DoctorEntityControllerRemote.class)

public class DoctorEntityController implements DoctorEntityControllerLocal, DoctorEntityControllerRemote {

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationSystem-ejbPU")
    private EntityManager entityManager;

    
    
    public DoctorEntityController() {
    }

    
    @Override
    public DoctorEntity createNewDoctor(DoctorEntity newDoctorEntity)
    {
        entityManager.persist(newDoctorEntity);
        entityManager.flush();
        
        return newDoctorEntity;
    }
    
    
    
    @Override
    public DoctorEntity retrieveDoctorById(String id) throws DoctorNotFoundException
    {
        Query query = entityManager.createQuery("SELECT d FROM DoctorEntity d WHERE d.doctorid = :inDoctorid");
        query.setParameter("inDoctorid", id);
        
        try
        {
            return (DoctorEntity)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new DoctorNotFoundException("Doctor Id " + id + " does not exist!");
        }
    }
}
