package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.exception.ExpiredVerificationTokenException;
import com.bookity.project.candidate.arda.onur.exception.InvalidVerificationTokenException;
import com.bookity.project.candidate.arda.onur.model.User;
import com.bookity.project.candidate.arda.onur.model.VerificationToken;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ConfirmationService {
    UserCrudService userCrudService;
    VerificationTokenService verificationTokenService;

    public User confirmRegistration(String token){
        Optional<VerificationToken> verificationToken = verificationTokenService.getUserByVerificationToken(token);
        if(verificationToken.isEmpty()){
            throw new InvalidVerificationTokenException("verificationToken.not.valid.message",token);
        }
        User user = verificationToken.get().getUser();

        Calendar calendar = Calendar.getInstance();

        if ((verificationToken.get().getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0) {
            throw  new ExpiredVerificationTokenException("verificationToken.expired.message",token);
        }

        log.info("User confirmed with token by : {}", token);

        user.setEnabled(true);

        return userCrudService.updateUser(user);
    }


}
