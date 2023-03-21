package com.ss.arbeit.Job.repositories;

import com.ss.arbeit.Job.domain.Job;
import com.ss.arbeit.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
