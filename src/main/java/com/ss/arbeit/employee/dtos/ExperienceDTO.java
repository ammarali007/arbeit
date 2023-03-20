package com.ss.arbeit.employee.dtos;

import lombok.Data;

@Data
public class ExperienceDTO {
    private Long id;
    private String companyName;
    private String location;
    private String startDate;
    private String endDate;
}
