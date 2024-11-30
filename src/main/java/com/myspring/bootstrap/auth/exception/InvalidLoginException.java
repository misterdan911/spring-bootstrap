package com.myspring.bootstrap.auth.exception;

public class InvalidLoginException extends RuntimeException {

    public InvalidLoginException() {
        super("Invalid Username, E-Mail, or Password");
    }
}
