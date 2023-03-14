package com.ss.arbeit.customer.dtos;

import lombok.Data;
import java.time.LocalDate;
@Data
public class CustomerRequest {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String phone;
}
