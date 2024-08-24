package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.model.User;
import com.bookity.project.candidate.arda.onur.model.VerificationToken;
import com.bookity.project.candidate.arda.onur.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class VerificationTokenService {
    private final VerificationTokenRepository tokenRepository;

    public VerificationToken createVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        log.info("Creating verification token for user: {}", user.getEmail());
        VerificationToken verificationToken = new VerificationToken(token, user);

        tokenRepository.save(verificationToken);

        return verificationToken;
    }

    public Optional<VerificationToken> getUserByVerificationToken(String token) {
        log.info("Getting user by verification token: {}", token);
        return tokenRepository.findByToken(token);
    }
}
