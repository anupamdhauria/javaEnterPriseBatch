package com.email.writer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.writer.dto.EmailRequest;
import com.email.writer.service.EmailGeneratorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin("*")
public class EmailGeneratorController {

	private EmailGeneratorService emailService;
	
	@PostMapping("/generate")
	public ResponseEntity<String>generateEmail(@RequestBody EmailRequest emailRequest){
		String reply = emailService.generateReply(emailRequest);
		return ResponseEntity.ok(reply);
	}
}
