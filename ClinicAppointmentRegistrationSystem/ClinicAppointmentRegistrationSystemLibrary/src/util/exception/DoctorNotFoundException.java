/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.exception;

/**
 *
 * @author Afiqah Rashid
 * A0160361R
 */
public class DoctorNotFoundException extends Exception {
    public DoctorNotFoundException() {
    }

    public DoctorNotFoundException(String msg) {
        super(msg);
    }
}
