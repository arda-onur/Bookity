package com.bookity.project.candidate.arda.onur.persistence.repository;

import com.bookity.project.candidate.arda.onur.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByVerificationCode(String verificationCode);
}