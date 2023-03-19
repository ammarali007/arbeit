package com.ss.arbeit.employee.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Skill {
    @Id
    private int id;
    private String name;
    private Integer rating;
    private Float experience;
}
