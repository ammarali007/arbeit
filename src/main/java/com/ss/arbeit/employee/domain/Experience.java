package com.ss.arbeit.employee.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String companyName;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Employee employee;
}