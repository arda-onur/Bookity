package com.bookity.project.candidate.arda.onur.persistence.repository;

import com.bookity.project.candidate.arda.onur.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
Customer findByEmail (String email);

}
