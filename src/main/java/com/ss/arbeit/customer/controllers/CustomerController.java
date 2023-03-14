package com.ss.arbeit.customer.controllers;

import com.ss.arbeit.customer.dtos.CustomerDTO;
import com.ss.arbeit.customer.dtos.CustomerRequest;
import com.ss.arbeit.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public CustomerDTO createCustomer(@RequestBody @Validated CustomerRequest request){
        return customerService.createCustomer(request);
    }
    @GetMapping("customer/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id){
        return customerService.fetchCustomer(id);
    }
}
