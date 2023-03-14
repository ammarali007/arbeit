package com.ss.arbeit.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String phone;
    private LocalDate createOn;
    private LocalDate modifiedOn;
    private String password;
    private String salt;
}
