package Project.bookity.Controller;

import Project.bookity.Response.UserResponse;
import Project.bookity.Service.UserService;
import Project.bookity.Utility.Utility;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
@RestController
@RequestMapping("user")
public class UserController {
 @Autowired
 UserService userService;
 @PostMapping("/register")
 public ResponseEntity registerUser(@RequestBody UserResponse userResponse, HttpServletRequest request) throws MessagingException,UnsupportedEncodingException {
   return userService.register(userResponse,Utility.getSiteUrl(request));
 }
@GetMapping("/verify")
 public ResponseEntity verifyUser(@RequestParam("code") String validationCode){
  return userService.verifyUser(validationCode);
 }
 @PostMapping("/login")
 public ResponseEntity login(@RequestBody UserResponse userResponse){
  return userService.login(userResponse);
 }
}
