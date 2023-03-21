package com.ss.arbeit.Job.controllers;

import com.ss.arbeit.Job.dtos.JobDTO;
import com.ss.arbeit.Job.dtos.JobRequest;
import com.ss.arbeit.Job.services.JobService;
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
public class JobController {

    private final JobService jobService;

    @PostMapping("/jobs")
    @ResponseStatus(HttpStatus.CREATED)
    public JobDTO createCustomer(@RequestBody @Validated JobRequest request) {
        return jobService.createJob(request);
    }

    @GetMapping("jobs/{id}")
    public JobDTO getCustomer(@PathVariable("id") Long id) {
        return jobService.fetchCustomer(id);
    }

    @ExceptionHandler({EmployeeNotFoundException.class,})
    public ResponseEntity<ErrorDTO> handleException(EmployeeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(exception.getMessage()));
    }
}
