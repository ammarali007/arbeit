package com.ss.arbeit.Job.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class JobRequest {
    private Long customerId;
    @NotEmpty(message = "mainCategory is required")
    private String mainCategory;
    private String subCategory;
    private String description;
}
