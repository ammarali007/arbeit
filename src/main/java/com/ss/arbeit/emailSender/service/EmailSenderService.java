package com.ss.arbeit.emailSender.service;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}
