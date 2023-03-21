package com.ss.arbeit.customer.domain;

import com.ss.arbeit.Job.domain.Job;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
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
