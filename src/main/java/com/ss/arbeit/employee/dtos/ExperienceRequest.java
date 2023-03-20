package com.ss.arbeit.employee.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class ExperienceRequest {
    @NotEmpty(message = "company is required")
    private String companyName;
    private String location;
    @NotNull(message = "start date is required")
    private LocalDate startDate;
    private LocalDate endDate;

}
