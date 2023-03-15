package com.ss.arbeit.employee.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Employee {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String phone;

    private LocalDate createdOn;

    private LocalDate modifiedOn;

    private String password;

    private String salt;
}
