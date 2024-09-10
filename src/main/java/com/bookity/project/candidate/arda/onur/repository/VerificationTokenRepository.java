package com.bookity.project.candidate.arda.onur.repository;

import com.bookity.project.candidate.arda.onur.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
     Optional<VerificationToken>  findByToken(String token);
}
