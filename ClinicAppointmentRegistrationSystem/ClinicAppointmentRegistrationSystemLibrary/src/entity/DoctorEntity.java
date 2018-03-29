/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class DoctorEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String registration;
    private String qualifications;
    
    @OneToMany
    private List<ConsultationEntity> consultationEntities;
    
    @OneToMany
    private List<AppointmentEntity> appointmentEntities;
    
    public DoctorEntity() {
        
        appointmentEntities =  new ArrayList<>();
        consultationEntities =  new ArrayList<>();
    }

    public DoctorEntity(String firstName, String lastName, String registration) {
        this();
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
    }

    public DoctorEntity(Long doctorId, String firstName, String lastName, String registration, String qualifications) {
        this();
        
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.qualifications = qualifications;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.doctorId != null ? this.doctorId.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DoctorEntity)) 
        {
            return false;
        }
        
        DoctorEntity other = (DoctorEntity) object;
        
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) 
        {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return "entity.DoctorEntity[ doctorId=" + this.doctorId + " ]";
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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

    public String getRegistration() {
        return registration;
    }

    public void setUserName(String registration) {
        this.registration = registration;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
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
           // throw new ConsultationEntityInstanceExistsInListException("Consultation already exist");
        }
    }
    
    
    
    public void removeConsultationEntity(ConsultationEntity consultationEntity) // throws ConsultationEntityInstanceMissingInListException
    {
        if(this.consultationEntities.contains(consultationEntity))
        {
            this.consultationEntities.remove(consultationEntity);
        }
        else
        {
            // throw new ConsultationEntityInstanceMissingInListException("Consultation missing");
        }
    }
    
        public List<AppointmentEntity> getAppointmentEntities() {
        return appointmentEntities;
    }

    public void setAppointmentEntities(List<AppointmentEntity> appointmentEntities) {
        this.appointmentEntities = appointmentEntities;
    }
    
    public void addAppointmentEntity(AppointmentEntity appointmentEntity)// throws AppointmentEntityInstanceExistsInListException
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
    
    
    
    public void removeAppointmentEntity(AppointmentEntity appointmentEntity)// throws AppointmentEntityInstanceMissingInListException
    {
        if(this.appointmentEntities.contains(appointmentEntity))
        {
            this.appointmentEntities.remove(appointmentEntity);
        }
        else
        {
           // throw new AppointmentEntityInstanceMissingInListException("Appointment missing");
        }
    }
}
