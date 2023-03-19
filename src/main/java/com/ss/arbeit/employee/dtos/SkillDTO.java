package com.ss.arbeit.employee.dtos;

import jakarta.persistence.Id;
import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;

@Data
public class SkillDTO {
    private Long id;
    private String name;
    private Integer rating;
    private Float experience;
}
