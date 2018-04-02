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
import java.util.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ConsultationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consultationId;
    @ManyToOne
    private PatientEntity patientC;
    // private String identityNumber;
    @ManyToOne
    private DoctorEntity doctorC;
    @Temporal(TemporalType.TIME)
    private Date time; //HH:MM
    
    public ConsultationEntity() {
        
    }

    public ConsultationEntity(Long consultationId, Date time) {
        this();
        
         this.consultationId = consultationId;
         this.time = time;
    }
    
    public Long getConsultationId() {
          return consultationId;
      }

      public void setConsultationId(Long consultationId) {
          this.consultationId = consultationId;
      }

    public PatientEntity getPatient() {
        return patientC;
    }

    public void setPatient(PatientEntity patient) {
        this.patientC = patient;
    }

    public DoctorEntity getDoctor() {
        return doctorC;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctorC = doctor;
    }
    
    public Date getTime() {
          return time;
      }

      public void setTime(Date time) {
          this.time = time;
      }
}
