package com.bookity.project.candidate.arda.onur.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy =  MatchPasswordsValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MatchPasswords {
    String message() default "user.password.mismatch.message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
