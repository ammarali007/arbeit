package com.ss.arbeit.Job.dtos;


import lombok.Data;

@Data
public class JobDTO {
    private Long id;
    private Long customerId;
    private String mainCategory;
    private String subCategory;
    private String description;
}
