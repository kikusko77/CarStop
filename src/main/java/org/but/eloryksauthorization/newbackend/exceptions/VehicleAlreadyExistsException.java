package org.but.eloryksauthorization.newbackend.exceptions;

public class VehicleAlreadyExistsException extends RuntimeException {

    public VehicleAlreadyExistsException(String messege) {
        super(messege);
    }
}
