package com.ss.arbeit.employee.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String name;
    private Integer rating;
    private Float experience;
    @ManyToOne
    private Employee employee;
}
