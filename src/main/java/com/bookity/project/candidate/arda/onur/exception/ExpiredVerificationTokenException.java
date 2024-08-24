package com.bookity.project.candidate.arda.onur.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason ="verificationToken.expired.message")
public class ExpiredVerificationTokenException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -824284968791541707L;

    private final String verificationToken;

    public ExpiredVerificationTokenException(String message, String verificationToken) {
        super(message);
        this.verificationToken = verificationToken;
    }
}
