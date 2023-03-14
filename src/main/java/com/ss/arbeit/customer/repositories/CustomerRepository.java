package com.ss.arbeit.customer.repositories;

import com.ss.arbeit.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
