package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.persistence.model.Customer;
import com.bookity.project.candidate.arda.onur.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerCrudService implements UserDetailsService {
   private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            Optional<Customer> validCustomer = Optional.ofNullable(this.customerRepository.findByEmail(email));
              if (validCustomer.isPresent()) {
                   var customer = User.withUsername(validCustomer.get().getEmail())
                           .password(passwordEncoder.encode(validCustomer.get().getPassword()))
                           .build();
                   return customer;
              }
           return null;
        }

}

