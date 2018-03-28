    package entity;

  import java.io.Serializable;
  import java.sql.Time;
  import javax.persistence.Column;
  import javax.persistence.Entity;
  import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

  /**
   *
   * @author Afiqah Rashid
   * A0160361R
   */

  @Entity
  public class AppointmentEntity implements Serializable {
      private static final long serialVersionUID = 1L;

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long appointmentId;
      @Column(unique = true, nullable = false)
      private String identityNumber;
      @Column(nullable = false)
      private Long doctorId;
      private Date date; //YYYY-MM-DD
      private Time time; //HH:MM

      public AppointmentEntity() {
      }

      public AppointmentEntity (Long appointmentId, String identityNumber, Long doctorId, Date date, Time time) {
          this();

          this.appointmentId = appointmentId;
          this.identityNumber = identityNumber;
          this.doctorId = doctorId;
          this.date = date;
          this.time = time;
      }
      
      public Long getAppointmentId() {
          return appointmentId;
      }

      public void setAppointmentId(Long appointmentId) {
          this.appointmentId = appointmentId;
      }

      public String getIdentityNumber() {
          return identityNumber;
      }

      public void setIdentityNumber(String identityNumber) {
          this.identityNumber = identityNumber;
      }

      public Long getDoctorId() {
          return doctorId;
      }

      public void setDoctorId(Long doctorId) {
          this.doctorId = doctorId;
      }
      
      public Time getTime() {
          return time;
      }

      public void setTime(Time time) {
          this.time = time;
      }
      
      public Date getDate() {
          return date;
      }

      public void setDate(Date date) {
          this.date = date;
      }
  }
