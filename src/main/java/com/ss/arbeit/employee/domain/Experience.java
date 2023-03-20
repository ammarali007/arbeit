package com.ss.arbeit.employee.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Experience {
    @Id
    private Long id;
    private String companyName;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Employee employee;
}