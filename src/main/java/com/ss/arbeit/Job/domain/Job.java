package com.ss.arbeit.Job.domain;

import com.ss.arbeit.customer.domain.Customer;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private Long customerId;
    private String mainCategory;
    private String subCategory;
    private String description;
}
