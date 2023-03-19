package com.ss.arbeit.employee.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Skill {
    @Id
    private Long id;
    private String name;
    private Integer rating;
    private Float experience;
    @ManyToOne
    private Employee employee;
}
