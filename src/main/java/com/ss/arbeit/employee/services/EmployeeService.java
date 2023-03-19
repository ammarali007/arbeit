package com.ss.arbeit.employee.services;

import com.ss.arbeit.employee.domain.Employee;
import com.ss.arbeit.employee.domain.Skill;
import com.ss.arbeit.employee.dtos.EmployeeDTO;
import com.ss.arbeit.employee.dtos.EmployeeRequest;
import com.ss.arbeit.employee.dtos.SkillDTO;
import com.ss.arbeit.employee.dtos.SkillRequest;
import com.ss.arbeit.employee.exceptions.EmployeeNotFoundException;
import com.ss.arbeit.employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("employee not found with id : "+id);
        }

        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);


        return employeeDTO;
    }
    public SkillDTO addSkill(Long id, SkillRequest request){
        Optional<Employee> employeeOptional = repository.findById(id);
        Skill skill = modelMapper.map(request, Skill.class);

        if(employeeOptional.isEmpty()){
            throw new EmployeeNotFoundException("employee not found with id : "+id);
        }

        Employee employee = employeeOptional.get();
        Random random = new Random();
        skill.setId(random.nextLong(1, 100000));
        employee.getSkills().add(skill);
        repository.save(employee);
        return modelMapper.map(skill,SkillDTO.class);
    }
    public List<EmployeeDTO> addExperience(Long id){
        return null;
    }
    public SkillDTO deleteSkill(Long id, SkillRequest request) {
        return null;
    }
}
