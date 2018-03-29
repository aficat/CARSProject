/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import util.exception.AppointmentEntityInstanceExistsInListException;
//import util.exception.AppointmentEntityInstanceMissingInListException;
//import util.exception.ConsultationEntityInstanceExistsInListException;
//import util.exception.ConsultationEntityInstanceMissingInListException;

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */
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
    
    @OneToMany
    private List<ConsultationEntity> consultationEntities;
    
    @OneToMany
    private List<AppointmentEntity> appointmentEntities;
    
    public PatientEntity(){
                  
        appointmentEntities =  new ArrayList<>();
        consultationEntities =  new ArrayList<>();
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
    
    public void addConsultationEntity(ConsultationEntity consultationEntity)// throws ConsultationEntityInstanceExistsInListException
    {
        if(!this.consultationEntities.contains(consultationEntity))
        {
            this.consultationEntities.add(consultationEntity);
        }
        else
        {
          //  throw new ConsultationEntityInstanceExistsInListException("Consultation already exist");
        }
    }
    
    
    
    public void removeConsultationEntity(ConsultationEntity consultationEntity)// throws ConsultationEntityInstanceMissingInListException
    {
        if(this.consultationEntities.contains(consultationEntity))
        {
            this.consultationEntities.remove(consultationEntity);
        }
        else
        {
          //  throw new ConsultationEntityInstanceMissingInListException("Consultation missing");
        }
    }
    
    public List<AppointmentEntity> getAppointmentEntities() {
        return appointmentEntities;
    }

    public void setAppointmentEntities(List<AppointmentEntity> appointmentEntities) {
        this.appointmentEntities = appointmentEntities;
    }
    
    public void addAppointmentEntity(AppointmentEntity appointmentEntity)//throws AppointmentEntityInstanceExistsInListException
    {
        if(!this.appointmentEntities.contains(appointmentEntity))
        {
            this.appointmentEntities.add(appointmentEntity);
        }
        else
        {
           // throw new AppointmentEntityInstanceExistsInListException("Appointment already exist");
        }
    }
    
    
    
    public void removeAppointmentEntity(AppointmentEntity appointmentEntity) //throws AppointmentEntityInstanceMissingInListException
    {
        if(this.appointmentEntities.contains(appointmentEntity))
        {
            this.appointmentEntities.remove(appointmentEntity);
        }
        else
        {
          //  throw new AppointmentEntityInstanceMissingInListException("Appointment missing");
        }
    }
}
