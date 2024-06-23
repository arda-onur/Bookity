package Project.bookity.Service;

import Project.bookity.Entity.UserEntity;
import Project.bookity.Repository.UserRepository;
import Project.bookity.Response.UserResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;

@Service
@Slf4j
public class UserService {
@Autowired
private UserRepository userRepository;
@Autowired
private JavaMailSender mailSender;
private final static Logger logger = LoggerFactory.getLogger(UserService.class);

public ResponseEntity register(UserResponse userResponse,String siteUrl) throws MessagingException, UnsupportedEncodingException {
    boolean isUsernameExisted = userRepository.existsById(userResponse.getUsername());
    if(isUsernameExisted){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    logger.info("Registering new user {}", userResponse.getUsername());
    String generatedVerificationCode = GenerateVerificationCode();
    userRepository.save(new UserEntity(userResponse.getUsername(), userResponse.getPassword(),userResponse.getMail(),generatedVerificationCode,false));
    sendVerification(userResponse,siteUrl,generatedVerificationCode);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}
public ResponseEntity login(UserResponse userResponse){
    try {
        String password = userRepository.getPassword(userResponse.getUsername());
        boolean isVerified = userRepository.isVerified(userResponse.getUsername());
        if(userResponse.getPassword().equals(password) && isVerified){
            logger.info("Logging user {}", userResponse.getUsername());
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }catch (Exception e){
        logger.error(e.getMessage());
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
public ResponseEntity verifyUser(String verificationCode){
            logger.info("Verifying verification code {}", verificationCode);
           Resource htmlFile = new ClassPathResource("static/verifiedPage.html");
           userRepository.updateVerificationStatus(verificationCode);
           return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlFile);
}
      private void sendVerification(UserResponse userResponse,String siteUrl,String generatedVerificationCode) throws MessagingException, UnsupportedEncodingException {

        String subject = "Verify your registration";
        String from = "Bookity Team";
        String VerifyUrl = siteUrl +"/user/verify?code="+ generatedVerificationCode;
        String content = "<p>Hello "+userResponse.getUsername()+", </p>"
                +"<p> Please click the link below to verify email adress </p>"
                + "<H2><a href=\""+VerifyUrl+"\"> VERIFY </a></H2>"
                +"<p> Thank You <br> Bookity Team </p> ";

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom("ardaonur1111@gmail.com",from);
        mimeMessageHelper.setTo(userResponse.getMail());
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);
        mailSender.send(mimeMessage);
     }


   private String GenerateVerificationCode(){
    return RandomStringUtils.randomAlphanumeric(15);    }
}
