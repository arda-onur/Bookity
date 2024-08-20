package com.bookity.project.candidate.arda.onur.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "user.already.exists.message")
public class UserAlreadyExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2496725754077184538L;

    private final String email;

    public UserAlreadyExistsException(String message, String email) {
        super(message);
        this.email = email;
    }
}
