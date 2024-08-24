package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.model.User;
import com.bookity.project.candidate.arda.onur.model.VerificationToken;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EmailService {

    private VerificationTokenService verificationTokenService;

    private JavaMailSender mailSender;

    public void sendVerificationEmail(User user) {
        VerificationToken token = this.verificationTokenService.createVerificationToken(user);

        String recipientAddress = user.getEmail();
        String subject = "Email Verification";
        String confirmationUrl = "http://localhost:8080/confirmations?token=" + token.getToken();
        String message = "Please confirm your email by clicking the link below:";

        log.info("Sending email including verification token: {}", user.getEmail());

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\r\n" + confirmationUrl);
        this.mailSender.send(email);
    }
}
