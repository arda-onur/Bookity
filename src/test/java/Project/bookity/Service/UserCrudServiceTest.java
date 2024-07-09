package Project.bookity.Service;
import com.bookity.project.candidate.arda.onur.persistence.repository.UserRepository;
import Project.bookity.Response.UserResponse;
import Project.bookity.Utility.Utility;
import com.bookity.project.candidate.arda.onur.service.UserCrudService;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import java.io.UnsupportedEncodingException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserCrudServiceTest {
@InjectMocks
private UserCrudService userCrudService;
@Mock
private UserRepository UserRepository;
@Mock
private HttpServletRequest request;
    @Mock
    private JavaMailSender mailSender;


    @Test
void createUser() throws UnsupportedEncodingException, MessagingException {
    UserResponse userResponse = new UserResponse("ardam", "12", "test123132@gmail.com");

    when(request.getScheme()).thenReturn("http");
    when(request.getServerName()).thenReturn("localhost");
    when(request.getServerPort()).thenReturn(8080);
    when(request.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080"));
    when(request.getServletPath()).thenReturn("/register");
    when(mailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
    //ResponseEntity response = userCrudService.createUser(userResponse);
    //assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), response);

}

        @Test
        void login() {

            UserResponse userResponse = new UserResponse("ardaonur", "1", "ard");
            String expectedPassword = "1";
            boolean isVerified = true;

            //when(UserRepository.getPassword(userResponse.getUsername())).thenReturn(expectedPassword);
            //when(UserRepository.isVerified(userResponse.getUsername())).thenReturn(isVerified);
            //ResponseEntity response = userCrudService.login(userResponse);

            //assertEquals(ResponseEntity.status(HttpStatus.OK).build(), response);

        }

    @Test
    void verifyUser() {
        //ResponseEntity  response = userCrudService.verifyUser("ardaonur");
        //assertEquals(ResponseEntity.status(HttpStatus.OK).build().getStatusCode(),response.getStatusCode());
    }
}
