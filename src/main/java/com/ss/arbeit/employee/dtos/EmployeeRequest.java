package com.ss.arbeit.employee.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeRequest {

    @NotEmpty(message = "first name is required")
    private String firstName;

    private String lastName;


    @NotNull(message = "data of birth is required")
    private LocalDate dob;

    private String phone;
}
