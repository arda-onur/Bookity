package com.bookity.project.candidate.arda.onur.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "verificationToken.not.valid.message")
public class InvalidVerificationTokenException extends RuntimeException {
 @Serial
 private static final long serialVersionUID = -2091050886248543090L;

 private final String verificationToken;

 public InvalidVerificationTokenException(String message, String verificationToken) {
     super(message);
     this.verificationToken = verificationToken;
 }
}
