/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */

@Entity
public class ConsultationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(unique = true, nullable = false)
    private String identityNumber;
    @Column(nullable = false)
    private Long doctorId;
    
    public ConsultationEntity() {
    }

    public ConsultationEntity(String identityNumber, Long doctorId) {
        this();

        this.identityNumber = identityNumber;
        this.doctorId = doctorId;
       
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
}
