package Project.bookity.Service;
import Project.bookity.Repository.UserRepository;
import Project.bookity.Response.UserResponse;
import Project.bookity.Utility.Utility;
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
class UserServiceTest {
@InjectMocks
private UserService userService;
@Mock
private UserRepository UserRepository;
@Mock
private HttpServletRequest request;
    @Mock
    private JavaMailSender mailSender;


    @Test
void register() throws UnsupportedEncodingException, MessagingException {
    UserResponse userResponse = new UserResponse("ardam", "12", "test123132@gmail.com");

    when(request.getScheme()).thenReturn("http");
    when(request.getServerName()).thenReturn("localhost");
    when(request.getServerPort()).thenReturn(8080);
    when(request.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080"));
    when(request.getServletPath()).thenReturn("/register");
    when(mailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
    ResponseEntity response = userService.register(userResponse, Utility.getSiteUrl(request));
    assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), response);

}

        @Test
        void login() {

            UserResponse userResponse = new UserResponse("ardaonur", "1", "ard");
            String expectedPassword = "1";
            boolean isVerified = true;

            when(UserRepository.getPassword(userResponse.getUsername())).thenReturn(expectedPassword);
            when(UserRepository.isVerified(userResponse.getUsername())).thenReturn(isVerified);
            ResponseEntity response = userService.login(userResponse);

            assertEquals(ResponseEntity.status(HttpStatus.OK).build(), response);

        }

    @Test
    void verifyUser() {
        ResponseEntity  response = userService.verifyUser("ardaonur");
        assertEquals(ResponseEntity.status(HttpStatus.OK).build().getStatusCode(),response.getStatusCode());
    }
}