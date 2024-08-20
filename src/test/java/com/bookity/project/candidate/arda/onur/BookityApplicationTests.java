package com.bookity.project.candidate.arda.onur;

import com.bookity.project.candidate.arda.onur.exception.UserAlreadyExistsException;
import com.bookity.project.candidate.arda.onur.exception.UserNotFoundException;
import com.bookity.project.candidate.arda.onur.persistence.model.Book;
import com.bookity.project.candidate.arda.onur.persistence.model.User;
import com.bookity.project.candidate.arda.onur.persistence.repository.UserRepository;
import com.bookity.project.candidate.arda.onur.service.UserCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookityApplicationTests {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    UserCrudService userCrudService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setFirstName("Test");
        testUser.setLastName("User");
        testUser.setEmail("test@test.com");
        testUser.setPassword("password");
        testUser.setUserId("1");
    }

    @Test
    void shouldCreateNewUser_WhenUserDoesNotExist() {
        when(this.userRepository.findUserByEmail(anyString())).thenReturn(Optional.empty());
        when(this.userRepository.save(any(User.class))).thenReturn(testUser);

        User savedUser = this.userCrudService.createUser(testUser);

        verify(this.userRepository).save(testUser);
        assertEquals(testUser.getEmail(), savedUser.getEmail());
    }
    @Test
    void shouldThrowException_WhenUserExist() {
        when(this.userRepository.findUserByEmail(anyString())).thenReturn(Optional.of(testUser));
        when(this.userRepository.save(any(User.class))).thenReturn(testUser);

        verify(this.userRepository,never()).save(any(User.class));
        assertThrows(UserAlreadyExistsException.class, () -> this.userCrudService.createUser(testUser));
    }
    @Test
    void shouldGetUserById_WhenUserExist() {
        when(this.userRepository.findUserByUserId(anyString())).thenReturn(Optional.of(testUser));

        User result = this.userCrudService.getUserByUserId(testUser.getUserId());

        verify(this.userRepository).findUserByUserId(anyString());
        assertEquals(testUser.getUserId(), result.getUserId());
    }
    @Test
    void shouldThrowException_When_SystemDoesNotFindUser() {
         when(this.userRepository.findUserByUserId(anyString())).thenReturn(Optional.empty());

         assertThrows(UserNotFoundException.class, () -> this.userCrudService.getUserByUserId(testUser.getUserId()));
    }
    @Test
    void shouldDeleteUser_WhenUserExist() {
        when(this.userRepository.findUserByUserId(anyString())).thenReturn(Optional.of(testUser));

        this.userCrudService.deleteUserByUserId(testUser.getUserId());

        verify(this.userRepository).delete(testUser);
    }

}
