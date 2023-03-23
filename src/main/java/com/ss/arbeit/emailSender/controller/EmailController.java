package com.ss.arbeit.emailSender.controller;

import com.ss.arbeit.emailSender.dtos.EmailRequest;
import com.ss.arbeit.emailSender.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailRequest email) {
        emailService.sendEmail(email);
        return ResponseEntity.ok("Success");
    }
}
