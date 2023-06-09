package com.ss.arbeit.customer.controllers;

import com.ss.arbeit.customer.dtos.CustomerDTO;
import com.ss.arbeit.customer.dtos.CustomerRequest;
import com.ss.arbeit.customer.services.CustomerService;
import com.ss.arbeit.employee.dtos.ErrorDTO;
import com.ss.arbeit.employee.exceptions.EmployeeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody @Validated CustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping("customers/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id) {
        return customerService.fetchCustomer(id);
    }


    @ExceptionHandler({EmployeeNotFoundException.class,})
    public ResponseEntity<ErrorDTO> handleException(EmployeeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(exception.getMessage()));
    }
}
