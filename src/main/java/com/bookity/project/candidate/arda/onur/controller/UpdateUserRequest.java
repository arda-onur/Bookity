package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.utility.RegisterNewUserRegexPatterns;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record UpdateUserRequest(
    @NotBlank(message = "{update.user.request.firstName.not.blank.message}")
    @Size(message = "{update.user.request.firstName.size.message}", min = 3, max = 255)
    String firstName,

    @NotBlank(message = "{update.user.request.lastName.not.blank.message}")
    @Size(message = "{update.user.request.lastName.size.message}", min = 3, max = 255)
    String lastName,

    @NotBlank(message = "{update.user.request.email.not.blank.message}")
    @Email(regexp = RegisterNewUserRegexPatterns.EMAIL_PATTERN)
    String email,
    boolean enabled,
    boolean accountNonExpired,
    boolean accountNonLocked,
    boolean credentialsNonExpired) implements Serializable {
}
