package ejb.session.ws;

import ejb.session.stateless.PatientEntityControllerLocal;
import entity.PatientEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import util.exception.InvalidLoginException;
/**
 *
 * @author Afiqah Rashid
 */

@WebService(serviceName = "AMSWebService")
@Stateless
public class AMSWebService {
    
    @EJB
    private PatientEntityControllerLocal patientEntityControllerLocal;

    @WebMethod(operationName = "retrieveAllPatients")
    public List<PatientEntity> retrieveAllPatient(@WebParam(name = "identityNumber") String identityNumber, 
                                                    @WebParam(name = "securityCode") String securityCode) 
                                                    throws InvalidLoginException
    {
        PatientEntity patientEntity = patientEntityControllerLocal.patientLogin(identityNumber, securityCode);
        System.out.println("********** AMSWebService.retrieveAllPatients(): Patient " + patientEntity.getIdentityNumber() + " login remotely via web service");
        
        return patientEntityControllerLocal.retrieveAllPatients();
    }
}