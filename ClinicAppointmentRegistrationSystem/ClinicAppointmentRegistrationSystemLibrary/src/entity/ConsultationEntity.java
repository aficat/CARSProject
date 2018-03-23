/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */

public class ConsultationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String identityNumber;
    private Long doctorId;
    private Integer queueNumber;
    
    public ConsultationEntity() {
    }

    public ConsultationEntity(String identityNumber, Long doctorId, Integer queueNumber) {
        this();

        this.identityNumber = identityNumber;
        this.doctorId = doctorId;
        this.queueNumber = queueNumber;
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

    public Integer getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(Integer queueNumber) {
        this.queueNumber = queueNumber;
    }
    
    // return patient name
    // return doctor name
}
