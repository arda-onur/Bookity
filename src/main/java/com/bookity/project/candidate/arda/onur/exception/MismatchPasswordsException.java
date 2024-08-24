package com.bookity.project.candidate.arda.onur.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason ="verificationToken.expired.message")
public class MismatchPasswordsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7729146371354316125L;
    public MismatchPasswordsException(String message) {
        super(message);
    }
}
