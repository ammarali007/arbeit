package com.ss.arbeit.employee.repositories;

import com.ss.arbeit.employee.domain.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
