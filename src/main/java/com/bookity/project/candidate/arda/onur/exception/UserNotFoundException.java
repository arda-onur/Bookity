package com.bookity.project.candidate.arda.onur.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "user.not.found.message")
public class UserNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7391755587063149384L;

    private final String userId;

    public UserNotFoundException(String message, String userId) {
        super(message);
        this.userId = userId;
    }
}
