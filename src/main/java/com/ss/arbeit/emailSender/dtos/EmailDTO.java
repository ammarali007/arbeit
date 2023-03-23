package com.ss.arbeit.emailSender.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmailDTO {
    private Long id;
    private String sendTo;
    private String subject;
    private String message;
    private int code;
}
