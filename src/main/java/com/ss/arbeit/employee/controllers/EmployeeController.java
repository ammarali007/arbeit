package com.ss.arbeit.employee.controllers;


import com.ss.arbeit.employee.dtos.EmployeeDTO;
import com.ss.arbeit.employee.dtos.EmployeeRequest;
import com.ss.arbeit.employee.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody @Validated EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long id){
        return employeeService.fetchEmployee(id);
    }
    @PostMapping("/employees/skills/{id}")
    public EmployeeDTO setSkills(@PathVariable("id") Long id, @RequestBody @Validated EmployeeRequest request){
        return employeeService.setSkills(id, request);
    }
    @PostMapping("/employees/skills/{id}")
    public EmployeeDTO setExperience(@PathVariable("id") Long id, @RequestBody @Validated EmployeeRequest request){
        return employeeService.setSkills(id, request);
    }
}
