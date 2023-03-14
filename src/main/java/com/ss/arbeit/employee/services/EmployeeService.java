package com.ss.arbeit.employee.services;

import com.ss.arbeit.employee.domain.Employee;
import com.ss.arbeit.employee.dtos.EmployeeDTO;
import com.ss.arbeit.employee.dtos.EmployeeRequest;
import com.ss.arbeit.employee.exceptions.EmployeeNotFoundException;
import com.ss.arbeit.employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper modelMapper;

    public EmployeeDTO createEmployee(EmployeeRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        //send email
        //send sms
        //send cnic to nadra
        // send data for address varification
        Random random = new Random();
        employee.setId(random.nextLong(1, 100000));
        repository.save(employee);

        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO fetchEmployee(Long id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()){
            return modelMapper.map(employee, EmployeeDTO.class);
        } else {
            throw new EmployeeNotFoundException("employee not found with id : "+id);
        }
    }
}
