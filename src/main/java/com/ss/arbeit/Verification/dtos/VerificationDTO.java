package com.ss.arbeit.Verification.dtos;

import lombok.Data;

@Data
public class VerificationDTO {
    private Long id;
    private boolean valid;
    private int code;
}
