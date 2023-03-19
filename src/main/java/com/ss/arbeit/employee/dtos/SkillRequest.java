package com.ss.arbeit.employee.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SkillRequest {
    @NotEmpty(message = "Skill Name is required")
    private String name;
    private Integer rating;
    private Float experience;

}
