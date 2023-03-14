package com.ss.arbeit.customer.services;

import com.ss.arbeit.customer.domain.Customer;
import com.ss.arbeit.customer.dtos.CustomerDTO;
import com.ss.arbeit.customer.dtos.CustomerRequest;
import com.ss.arbeit.customer.exceptions.CustomerNotFoundException;
import com.ss.arbeit.customer.repositories.CustomerRepository;
import com.ss.arbeit.employee.domain.Employee;
import com.ss.arbeit.employee.dtos.EmployeeDTO;
import com.ss.arbeit.employee.dtos.EmployeeRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper modelMapper;

    public CustomerDTO createCustomer(CustomerRequest request){
        Customer customer = modelMapper.map(request, Customer.class);

        Random random = new Random();
        customer.setId(random.nextLong(1, 100000));
        repository.save(customer);

        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO fetchCustomer(Long id){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            return modelMapper.map(customer,CustomerDTO.class);
        }else {
            throw new CustomerNotFoundException("Customer not found against this id : +id");
        }
    }

}
