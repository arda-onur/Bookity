package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.model.User;
import com.bookity.project.candidate.arda.onur.service.ConfirmationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirmations")
@AllArgsConstructor
public class ConfirmationController {

    private  ConfirmationService confirmationService;

    @GetMapping
    public ResponseEntity<User> confirmVerificationToken(@RequestParam String token) {
        return ResponseEntity.ok(this.confirmationService.confirmRegistration(token));
    }
}
