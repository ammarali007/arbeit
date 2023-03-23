package com.ss.arbeit.emailSender.exceptions;


public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String message) {
        super(message);
    }
}
