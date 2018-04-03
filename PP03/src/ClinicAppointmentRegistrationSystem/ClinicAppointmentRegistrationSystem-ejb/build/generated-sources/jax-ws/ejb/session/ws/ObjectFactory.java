
package ejb.session.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ejb.session.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InvalidLoginException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginException");
    private final static QName _RetrieveAllPatients_QNAME = new QName("http://ws.session.ejb/", "retrieveAllPatients");
    private final static QName _RetrieveAllPatientsResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAllPatientsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ejb.session.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InvalidLoginException }
     * 
     */
    public InvalidLoginException createInvalidLoginException() {
        return new InvalidLoginException();
    }

    /**
     * Create an instance of {@link RetrieveAllPatients }
     * 
     */
    public RetrieveAllPatients createRetrieveAllPatients() {
        return new RetrieveAllPatients();
    }

    /**
     * Create an instance of {@link RetrieveAllPatientsResponse }
     * 
     */
    public RetrieveAllPatientsResponse createRetrieveAllPatientsResponse() {
        return new RetrieveAllPatientsResponse();
    }

    /**
     * Create an instance of {@link PatientEntity }
     * 
     */
    public PatientEntity createPatientEntity() {
        return new PatientEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidLoginException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "InvalidLoginException")
    public JAXBElement<InvalidLoginException> createInvalidLoginException(InvalidLoginException value) {
        return new JAXBElement<InvalidLoginException>(_InvalidLoginException_QNAME, InvalidLoginException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllPatients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllPatients")
    public JAXBElement<RetrieveAllPatients> createRetrieveAllPatients(RetrieveAllPatients value) {
        return new JAXBElement<RetrieveAllPatients>(_RetrieveAllPatients_QNAME, RetrieveAllPatients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllPatientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllPatientsResponse")
    public JAXBElement<RetrieveAllPatientsResponse> createRetrieveAllPatientsResponse(RetrieveAllPatientsResponse value) {
        return new JAXBElement<RetrieveAllPatientsResponse>(_RetrieveAllPatientsResponse_QNAME, RetrieveAllPatientsResponse.class, null, value);
    }

}
