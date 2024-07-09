package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.config.web.WebConfiguration;
import com.bookity.project.candidate.arda.onur.persistence.dto.CustomerDto;
import com.bookity.project.candidate.arda.onur.persistence.mapper.CustomerMapper;
import com.bookity.project.candidate.arda.onur.persistence.model.Customer;
import com.bookity.project.candidate.arda.onur.service.CustomerCrudService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


    @Controller
    @RequiredArgsConstructor
    public class CustomerCrudController {
        private final CustomerCrudService customerCrudService;
        private final CustomerMapper customerMapper;
        @PostMapping("/register")
        public String register(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, Model model, BindingResult result,HttpServletRequest servletRequest) throws UnsupportedEncodingException {
            try {
                this.customerCrudService.register(this.customerMapper.map(customerDto),
                                                  WebConfiguration.getSiteUrl(servletRequest));
                return "redirect:/login";
            } catch (MessagingException e) {
                result.addError(new FieldError("customer", "email", e.getMessage()));
                model.addAttribute("errors", result.getAllErrors());
                return "signup";
            }


        }
    @GetMapping("/verify")
    public String verifyUser(@RequestParam("code") String validationCode){
      this.customerCrudService.verifyUser(validationCode);
      return  "redirect:/login";
    }

}
