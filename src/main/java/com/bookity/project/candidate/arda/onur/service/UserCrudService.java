package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.exception.UserAlreadyExistsException;
import com.bookity.project.candidate.arda.onur.exception.UserNotFoundException;
import com.bookity.project.candidate.arda.onur.persistence.model.User;
import com.bookity.project.candidate.arda.onur.persistence.repository.UserRepository;
import com.bookity.project.candidate.arda.onur.utility.ArgumentPreconditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserCrudService {
    private final UserRepository userRepository;

    //@Autowired
    //private JavaMailSender mailSender;

    public User getUserByUserId(String userId) {
        ArgumentPreconditions.requireNotBlank("Argument 'userId' can not be blank!", userId);
        log.info("Getting a user with userId ({}).", userId);

        return this.userRepository.findUserByUserId(userId)
            .orElseThrow(() -> new UserNotFoundException("user.not.found.message", userId));
    }

    public User createUser(User newUser) {
        Objects.requireNonNull(newUser, "Argument 'newUser' can not be null!");
        log.info("Creating new user with email ({}).", newUser.getEmail());

        this.userRepository.findUserByEmail(newUser.getEmail())
            .ifPresent(user -> {
                throw new UserAlreadyExistsException("user.already.exists.message", user.getEmail());
            });

        return this.userRepository.save(newUser);

        /*
        boolean isUsernameExisted = userRepository.existsById(userResponse.getUsername());
        if (isUsernameExisted) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        logger.info("Registering new user {}", userResponse.getUsername());
        String generatedVerificationCode = GenerateVerificationCode();
        userRepository.save(new UserEntity(userResponse.getUsername(), userResponse.getPassword(), userResponse.getMail(), generatedVerificationCode, false));
        sendVerification(userResponse, siteUrl, generatedVerificationCode);
        return ResponseEntity.status(HttpStatus.CREATED).build();
        */
    }

    public void deleteUserByUserId(String userId) {
        ArgumentPreconditions.requireNotBlank("Argument 'userId' can not be blank!", userId);

        log.info("Deleting a user with userId ({}).", userId);
        this.userRepository.delete(getUserByUserId(userId));
    }

    public User updateUser(User userToBeUpdated) {
        Objects.requireNonNull(userToBeUpdated, "Argument 'userToBeUpdated' can not be null!");
        log.info("Updating a user with userId ({}).", userToBeUpdated.getUserId());
        return this.userRepository.save(userToBeUpdated);
    }

    /*
    public ResponseEntity login(UserResponse userResponse) {
        try {
            String password = userRepository.getPassword(userResponse.getUsername());
            boolean isVerified = userRepository.isVerified(userResponse.getUsername());
            if (userResponse.getPassword().equals(password) && isVerified) {
                log.info("Logging user {}", userResponse.getUsername());
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity verifyUser(String verificationCode) {
        log.info("Verifying verification code {}", verificationCode);
        Resource htmlFile = new ClassPathResource("static/verifiedPage.html");
        userRepository.updateVerificationStatus(verificationCode);
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlFile);
    }
    */
/*
    private void sendVerification(UserResponse userResponse, String siteUrl, String generatedVerificationCode) throws MessagingException, UnsupportedEncodingException {

        String subject = "Verify your registration";
        String from = "Bookity Team";
        String VerifyUrl = siteUrl + "/user/verify?code=" + generatedVerificationCode;
        String content = "<p>Hello " + userResponse.getUsername() + ", </p>"
            + "<p> Please click the link below to verify email adress </p>"
            + "<H2><a href=\"" + VerifyUrl + "\"> VERIFY </a></H2>"
            + "<p> Thank You <br> Bookity Team </p> ";

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom("ardaonur1111@gmail.com", from);
        mimeMessageHelper.setTo(userResponse.getMail());
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);
        mailSender.send(mimeMessage);
    }
*/

    private String GenerateVerificationCode() {
        return RandomStringUtils.randomAlphanumeric(15);
    }
}
