package com.ss.arbeit.employee.services;

import com.ss.arbeit.employee.domain.Employee;
import com.ss.arbeit.employee.domain.Experience;
import com.ss.arbeit.employee.domain.Skill;
import com.ss.arbeit.employee.dtos.*;
import com.ss.arbeit.employee.exceptions.EmployeeNotFoundException;
import com.ss.arbeit.employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper modelMapper;

    public EmployeeDTO createEmployee(EmployeeRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        Random random = new Random();
        employee.setId(random.nextLong(1, 10));
        repository.save(employee);

        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO fetchEmployee(Long id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("employee not found with id : " + id);
        }
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO deleteEmployee(Long id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("employee not found with id : " + id);
        }
        Employee employee = employeeOptional.get();
        repository.deleteById(employee.getId());
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public SkillDTO addSkill(Long id, SkillRequest request) {
        Optional<Employee> employeeOptional = repository.findById(id);
        Skill skill = modelMapper.map(request, Skill.class);

        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("employee not found with id : " + id);
        }

        Employee employee = employeeOptional.get();
        Random random = new Random();
        skill.setId(random.nextLong(1, 10));
        employee.getSkills().add(skill);
        repository.save(employee);
        return modelMapper.map(skill, SkillDTO.class);
    }
    public ExperienceDTO addExperience(Long id, ExperienceRequest request) {
        Optional<Employee> employeeOptional = repository.findById(id);
        Experience experience = modelMapper.map(request, Experience.class);

        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("employee not found with id : " + id);
        }

        Employee employee = employeeOptional.get();

        Random random = new Random();
        experience.setId(random.nextLong(1, 10));

        employee.getExperiences().add(experience);
        repository.save(employee);
        return modelMapper.map(experience, ExperienceDTO.class);
    }

    public void deleteExperience(Long employeeId, Long experienceId) {
        Optional<Employee> employeeOptional = repository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("employee not found with employeeId : " + employeeId);
        }
        Employee employee = employeeOptional.get();
        employee.getExperiences().removeIf(experience -> Objects.equals(experience.getId(), experienceId));
        repository.save(employee);
    }

    public void deleteSkill(Long employeeId, Long skillId) {
        Optional<Employee> employeeOptional = repository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("employee not found with employeeId : " + employeeId);
        }
        Employee employee = employeeOptional.get();
        employee.getSkills().removeIf(skill -> Objects.equals(skill.getId(), skillId));
        repository.save(employee);
    }
}
