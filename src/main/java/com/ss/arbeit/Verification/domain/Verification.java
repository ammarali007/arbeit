package com.ss.arbeit.Verification.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Verification {
    @Id
    private Long id;
    private boolean valid;
    private int code;
}
