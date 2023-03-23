package com.ss.arbeit.emailSender.repository;

import com.ss.arbeit.emailSender.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
