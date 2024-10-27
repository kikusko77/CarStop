package org.but.eloryksauthorization.newbackend.exceptions;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String messege) {
        super(messege);
    }
}


