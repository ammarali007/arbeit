package com.ss.arbeit.employee.repositories;

import com.ss.arbeit.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Optional<Employee> findByFirstName(String firstName);
}
