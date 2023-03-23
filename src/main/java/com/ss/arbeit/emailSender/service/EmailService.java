package com.ss.arbeit.emailSender.service;

import com.ss.arbeit.emailSender.domain.Email;
import com.ss.arbeit.emailSender.dtos.EmailDTO;
import com.ss.arbeit.emailSender.dtos.EmailRequest;
import com.ss.arbeit.emailSender.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

@AllArgsConstructor
public class EmailService {
	private final JavaMailSender mailSender;
	private EmailRepository repository;
	private final ModelMapper modelMapper;

	public void sendEmail(EmailRequest request) {
		Email email = modelMapper.map(request, Email.class);
		Random random = new Random();
		email.setCode(random.nextInt(1000, 9999));

		repository.save(email);
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("utktradingllc@gmail.com");
		simpleMailMessage.setTo(email.getSendTo());
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setText(email.getMessage() + email.getCode());

		this.mailSender.send(simpleMailMessage);
	}
}
