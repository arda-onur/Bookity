package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.annotation.MatchPasswords;
import com.bookity.project.candidate.arda.onur.utility.RegisterNewUserRegexPatterns;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
@MatchPasswords
public record CreateUserRequest(
    @NotBlank(message = "{create.user.request.firstName.not.blank.message}")
    @Size(message = "{create.user.request.firstName.size.message}", min = 3, max = 255)
    String firstName,

    @NotBlank(message = "{create.user.request.lastName.not.blank.message}")
    @Size(message = "{create.user.request.lastName.size.message}", min = 3, max = 255)
    String lastName,

    @NotBlank(message = "{create.user.request.password.not.blank.message}")
    @Size(message = "{create.user.request.password.size.message}", min = 8, max = 255)
    String password,

    @NotBlank(message = "{create.user.request.confirmPassword.not.blank.message}")
    @Size(message = "{create.user.request.confirmPassword.size.message}", min = 8, max = 20)
    String confirmPassword,

    @NotBlank(message = "{create.user.request.email.not.blank.message}")
    @Email(regexp = RegisterNewUserRegexPatterns.EMAIL_PATTERN)
    String email) implements Serializable {

}
