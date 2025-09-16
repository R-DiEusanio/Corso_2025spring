package com.example.demo.controller;


import com.example.demo.data.dto.EmailDTO;
import com.example.demo.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailRestController {

    private final EmailService emailService;

    public EmailRestController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO.getTo(), emailDTO.getText(),emailDTO.getSubject() );
        return ResponseEntity.ok("Email inviate" + emailDTO.getTo());
    }
}
