package com.ss.arbeit.Verification.dtos;

import jakarta.validation.constraints.NotNull;

public class VerificationRequest {

    @NotNull(message = "code is required for verification")
    private int code;
}
