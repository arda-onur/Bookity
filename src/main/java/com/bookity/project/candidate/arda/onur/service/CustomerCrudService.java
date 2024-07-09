package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.persistence.model.Customer;
import com.bookity.project.candidate.arda.onur.persistence.repository.CustomerRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.angus.mail.smtp.SMTPAddressFailedException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerCrudService implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            Optional<Customer> validCustomer = this.customerRepository.findByEmail(email);
              if (validCustomer.isPresent() && validCustomer.get().isVerified()) {
                   var customer = User
                           .withUsername(validCustomer.get().getEmail())
                           .password(this.passwordEncoder.encode(validCustomer.get().getPassword()))
                           .build();
                   log.info("Log in Customer {}, ",validCustomer.get().getEmail());
                   return customer;
              }
              return null;
        }

        public void register(Customer customer, String siteUrl) throws MessagingException, UnsupportedEncodingException {
        try {
            Optional<Customer> customerOptional = this.customerRepository.findByEmail(customer.getEmail());
            if (customerOptional.isPresent()) {
                log.info("Email already in use. Skipping registration {} ",customer.getEmail());
                throw new MessagingException("Email already in use");
            }
            log.info("Register Customer : {}", customer.getEmail());
            String verificationCode = generateVerificationCode();
            customer.setVerified(false);
            customer.setVerificationCode(verificationCode);
            sendVerification(customer,siteUrl, verificationCode);
            this.customerRepository.save(customer);
        }catch (SMTPAddressFailedException smtpAddressFailedException){
            throw new MessagingException("Invalid email address");
        }

        }
    private void sendVerification(Customer customer, String siteUrl, String generatedVerificationCode) throws MessagingException, UnsupportedEncodingException {
        String subject = "Verify your registration";
        String from = "Bookity Team";
        String VerifyUrl = siteUrl +"/verify?code="+ generatedVerificationCode;
        String content = "<p> Please click the link below to verify email adress </p>"
                             + "<H2><a href=\""+VerifyUrl+"\"> VERIFY </a></H2>"
                             +"<p> Thank You <br> Bookity Team </p> ";
        sendMessage(content,subject,from,customer);
    }
   private void sendMessage(String content,String subject,String from,Customer customer) throws MessagingException, UnsupportedEncodingException {
       MimeMessage mimeMessage = this.mailSender.createMimeMessage();
       MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
       mimeMessageHelper.setFrom("ardaonur1111@gmail.com", from);
       mimeMessageHelper.setTo(customer.getEmail());
       mimeMessageHelper.setSubject(subject);
       mimeMessageHelper.setText(content, true);
       mailSender.send(mimeMessage);
   }
    private String generateVerificationCode(){
        return RandomStringUtils.randomAlphanumeric(15);    }

    public void verifyUser(String verificationCode){
        Optional<Customer> customer = this.customerRepository.findByVerificationCode(verificationCode);
        customer.get().setVerified(true);
        this.customerRepository.save(customer.get());
        log.info("Verifying Customer {} and verification code:{}",customer.get().getEmail(), verificationCode);
    }

}

