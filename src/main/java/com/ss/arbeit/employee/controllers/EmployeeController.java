package com.ss.arbeit.employee.controllers;


import com.ss.arbeit.employee.dtos.*;
import com.ss.arbeit.employee.exceptions.EmployeeNotFoundException;
import com.ss.arbeit.employee.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee(@RequestBody @Validated EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long id) {
        return employeeService.fetchEmployee(id);
    }

    @DeleteMapping("/employees/delete/{id}")
    public EmployeeDTO deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("/employees/{id}/skills")
    @ResponseStatus(HttpStatus.CREATED)
    public SkillDTO addSkill(@PathVariable("id") Long id, @RequestBody @Validated SkillRequest request) {
        return employeeService.addSkill(id, request);
    }

    @DeleteMapping("/employees/{employeeId}/skills/{skillId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable("employeeId") Long id, @PathVariable("skillId") Long skillId) {
        employeeService.deleteSkill(id, skillId);
    }

    @PostMapping("/employees/{id}/experiences")
    @ResponseStatus(HttpStatus.CREATED)
    public ExperienceDTO addExperience(@PathVariable("id") Long id, @RequestBody @Validated ExperienceRequest request) {
        return employeeService.addExperience(id, request);
    }

    @DeleteMapping("/employees/{employeeId}/experiences/{experienceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(@PathVariable("employeeId") Long id, @PathVariable("experienceId") Long experienceId) {
        employeeService.deleteExperience(id, experienceId);
    }

    @ExceptionHandler({EmployeeNotFoundException.class,})
    public ResponseEntity<ErrorDTO> handleException(EmployeeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(exception.getMessage()));
    }
}
