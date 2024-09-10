package com.bookity.project.candidate.arda.onur.annotation;

import com.bookity.project.candidate.arda.onur.controller.CreateUserRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MatchPasswordsValidator implements ConstraintValidator<MatchPasswords, CreateUserRequest> {


    @Override
    public boolean isValid(CreateUserRequest createUserRequest, ConstraintValidatorContext constraintValidatorContext) {
        return createUserRequest.password().equals(createUserRequest.confirmPassword());
    }
}
