package com.ss.arbeit.Job.services;

import com.ss.arbeit.Job.domain.Job;
import com.ss.arbeit.Job.dtos.JobDTO;
import com.ss.arbeit.Job.dtos.JobRequest;
import com.ss.arbeit.Job.repositories.JobRepository;
import com.ss.arbeit.customer.exceptions.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class JobService {

    private final JobRepository repository;
    private final ModelMapper modelMapper;

    public JobDTO createJob(JobRequest request) {
        Job job = modelMapper.map(request, Job.class);
        repository.save(job);

        return modelMapper.map(job, JobDTO.class);
    }

    public JobDTO fetchCustomer(Long id) {
        Optional<Job> job = repository.findById(id);

        if (job.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found against this id : +id");
        }
        return modelMapper.map(job, JobDTO.class);
    }

}
