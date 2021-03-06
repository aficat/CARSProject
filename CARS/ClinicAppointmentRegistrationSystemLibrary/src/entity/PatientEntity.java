/*
 * Group 3 IS2103 Assignment 2
 * Group members:
 * - Loon Hai Qi , A0160483H
 * - Madeline Tooh Weiping , A0160349E
 * - Nurul Afiqah Binte Rashid , A0160361R
 * 
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import util.exception.PatientAddAppointmentException;
import util.exception.PatientAddConsultationException;
import util.exception.PatientRemoveAppointmentException;
import util.exception.PatientRemoveConsultationException;

@Entity
public class PatientEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(unique = true, nullable = false)
    private String identityNumber;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long patientId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String gender;
    private String securityCode;
    private Integer age;
    private String phone;
    private String address;
    
    @OneToMany (mappedBy = "patientC")
    private List<ConsultationEntity> consultationEntities;
    
    @OneToMany (mappedBy = "patientA")
    private List<AppointmentEntity> appointmentEntities;
    
    public PatientEntity(){
                  
        this.appointmentEntities =  new ArrayList<>();
        this.consultationEntities =  new ArrayList<>();
    }
    
    public PatientEntity(String firstName, String lastName, String identityNumber, String securityCode) {
        this();
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.securityCode = securityCode;
    }

    
    
    public PatientEntity(Long patientId, String firstName, String lastName, String gender, String securityCode, Integer age, String identityNumber, String phone, String address) 
    {
        this();
        
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.securityCode = securityCode;
        this.age = age;
        this.identityNumber = identityNumber;
        this.phone = phone;
        this.address = address; 
    }
    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.patientId != null ? this.patientId.hashCode() : 0);
        
        return hash;
    }

    
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof PatientEntity)) 
        {
            return false;
        }
        
        PatientEntity other = (PatientEntity) object;
        
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) 
        {
            return false;
        }
        
        return true;
    }

    
    
    @Override
    public String toString() 
    {
        return "entity.PatientEntity[ patientId=" + this.patientId + " ]";
    }

    
    
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;        
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getSecurityCode() {
        return securityCode;        
    }

    public void setSecurityCode(String ecurityCode) {
        this.securityCode = ecurityCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public List<ConsultationEntity> getConsultationEntities() {
        return consultationEntities;
    }

    public void setConsultationEntities(List<ConsultationEntity> consultationEntities) {
        this.consultationEntities = consultationEntities;
    }
    
    public void addConsultation(ConsultationEntity consultation) throws PatientAddConsultationException
    {
        if(consultation != null && !this.getConsultationEntities().contains(consultation))
        {
            this.getConsultationEntities().add(consultation);
        }
        else 
        {
            throw new PatientAddConsultationException("Consultation already added to Patient");
        }
    }
    
    
    /*
    public void removeConsultation(ConsultationEntity consultation) throws PatientRemoveConsultationException
    {
        if(consultation != null && this.consultationEntities.contains(consultation))
        {
            this.getConsultationEntities().remove(consultation);
        }
        else
        {
            throw new PatientRemoveConsultationException("Consultation has not been added to Patient");
        }
    }*/
    
    public List<AppointmentEntity> getAppointmentEntities() {
        return appointmentEntities;
    }

    public void setAppointmentEntities(List<AppointmentEntity> appointmentEntities) {
        this.appointmentEntities = appointmentEntities;
    }
    
    public void addAppointment(AppointmentEntity appointment) throws PatientAddAppointmentException
    {
        if(appointment != null && !this.getAppointmentEntities().contains(appointment))
        {
            this.getAppointmentEntities().add(appointment);
        }
        else 
        {
            throw new PatientAddAppointmentException("Appointment already added to Patient");
        }
    }
    
    
    
    public void removeAppointment(AppointmentEntity appointment) throws PatientRemoveAppointmentException 
    {
        if(appointment != null && this.appointmentEntities.contains(appointment))
        {
            this.getAppointmentEntities().remove(appointment);
        }
        else
        {
            throw new PatientRemoveAppointmentException("Appointment has not been added to Patient");
        }
    }
}
