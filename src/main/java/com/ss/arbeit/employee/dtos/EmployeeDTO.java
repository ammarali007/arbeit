package com.ss.arbeit.employee.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String phone;
    private List<SkillDTO> skills;
    private List<ExperienceDTO> experiences;
}
